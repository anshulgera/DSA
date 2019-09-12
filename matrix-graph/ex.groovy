def notifySuccess(){
    emailext (
        //def mailRecipients = 'kiran.thuthika@jda.com'
        subject: "Platform Nightly Job (Linux): ${env.JOB_NAME} - Build #: ${env.BUILD_NUMBER} - Status : ${currentBuild.currentResult}",
        body: '''${SCRIPT, template="groovy-html.template"}''',
        mimeType: 'text/html',
        from: "kiran.thuthika@jda.com",
        to: "NPDPlatform@jda.com, kiran.thuthika@jda.com, RaviKumar.Gangadharan@jda.com",
        //cc: "NPDPlatform@jda.com, kiran.thuthika@jda.com",
        replyTo: "kiran.thuthika@jda.com",
        recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
   )
}

def notifyFailed() {
    emailext (
        //def mailRecipients = 'kiran.thuthika@jda.com'
        subject: "Platform Nightly Job (Linux): ${env.JOB_NAME} - Build #: ${env.BUILD_NUMBER} - Status : ${currentBuild.currentResult}",
        body: '''${SCRIPT, template="groovy-html.template"}''',
        mimeType: 'text/html',
        from: "kiran.thuthika@jda.com",
        to: "NPDPlatform@jda.com, kiran.thuthika@jda.com, RaviKumar.Gangadharan@jda.com",
        //cc: "NPDPlatform@jda.com, kiran.thuthika@jda.com",
        replyTo: "NPDPlatform@jda.com, kiran.thuthika@jda.com",
        recipientProviders: [[$class: 'CulpritsRecipientProvider']]
        //recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
   )
}

node ('master') {
    try {

        def buildWebworksDir = env.WORKSPACE + '/webworks/build/'
        def techstackImage = docker.image('uno.jda.com:5000/build-stack:2019.1-latest')    

        stage('ENV VARIABLES') {
            techstackImage.inside ('-u root -v /var/run/docker.sock:/var/run/docker.sock' ) {
                sh 'env'
                sh 'docker version'
                sh 'java --version'
            }
        }

        stage('Checkout Webworks'){
            dir('webworks') {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'pbuilds_credentials', url: 'ssh://git@stash.jda.com:7999/plat/webworks.git']]])
            }
        }

        // Webworks Build
        withEnv ([
            'BUILD_DIR=Platform',
            'BUILD_ROOT=${env.WORKSPACE}/webworks',
            'BUILD_PROPS=/opt/webworks_tomcat_install.properties',
            'ABPP_BUILD_DIR=/data/linux_build_artifacts/abpp_2019.1_nightly/LATEST',
            'APPSERVER=tomcat',
            'DATABASE_TYPE=Microsoft SQL Server',
            'DATABASE=sqlsvr',
            'DATABASE_VER=Microsoft SQL Server v17',
            'ANT_OPTS=-Xmx2048m -Xms512m -XX:MaxPermSize=512m -Dfile.encoding=UTF-8',
            'REGISTRY_URL=uno.jda.com:5000',
            'REGISTRY_USER=test',
            'REGISTRY_PASSWORD=password',
            
            ]) {
            stage('Build Webworks') {
                techstackImage.inside ('-u root -v /data/linux_build_artifacts:/data/linux_build_artifacts -v /var/run/docker.sock:/var/run/docker.sock -v /data/webworks_tomcat_install.properties:/opt/webworks_tomcat_install.properties' ) {
                    sh 'ant -f ' + buildWebworksDir + 'build.xml -Dbuild.type=tomcat -DSPOTBUGS_ENABLED=false clean all customize'
                    //sh 'echo "TBD"'
                }
            }
            stage('Build and Publish Docker Images') {
                techstackImage.inside ('-u root -v /var/run/docker.sock:/var/run/docker.sock -v /data/webworks_tomcat_install.properties:/opt/webworks_tomcat_install.properties' ) {
                    sh 'ant -f ' + buildWebworksDir + 'build.xml -Dbuild.type=tomcat docker help-utils-docker'
                }
            }
            stage('Build and Publish Deployment Zips') {
                techstackImage.inside ('-u root -v /data/linux_build_artifacts:/data/linux_build_artifacts -v /var/run/docker.sock:/var/run/docker.sock -v /data/webworks_tomcat_install.properties:/opt/webworks_tomcat_install.properties -v /testshare/installexes/v2019.1/Platform/deployer_zips:/opt/deployer_zips' ) {
                    sh 'ant -f ' + buildWebworksDir + 'build.xml -Dbuild.type=tomcat deploy-zip-tomcat-linux deploy-zip-tomcat-sre-linux'
                    sh 'mkdir -p /opt/deployer_zips/LATEST /opt/deployer_zips/`date +%d-%m-%Y`/${BUILD_NUMBER}/'
                    sh 'chmod 777 /opt/deployer_zips/LATEST /opt/deployer_zips/`date +%d-%m-%Y`/${BUILD_NUMBER}/'
                    sh 'cp -r ' + env.WORKSPACE + '/webworks/install/build/*.zip /opt/deployer_zips/`date +%d-%m-%Y`/${BUILD_NUMBER}/'
                    sh 'cp -r ' + env.WORKSPACE + '/webworks/install/build/*.zip /opt/deployer_zips/LATEST'
                }    
            }
            stage('Static Code Analysis') {
                parallel (
                    "runDependency Check": {
                        stage('runDependency Check'){
                            techstackImage.inside ('-u root -v /var/run/docker.sock:/var/run/docker.sock -v /data/webworks_tomcat_install.properties:/opt/webworks_tomcat_install.properties' ) {
                                dir(env.WORKSPACE + '/webworks') {
                                    sh 'echo "RunDependencyCheck"'
                                    sh 'ant -f ' + buildWebworksDir + 'build.xml -Dbuild.type=tomcat runDependencyCheck'
                                    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
                                    archiveArtifacts allowEmptyArchive: true, artifacts: '**/dependency-check-report.html', onlyIfSuccessful: true
                                }
                            }
                        }
                    },
                    "SpotBugs": {
                        stage('SpotBugs'){
                            techstackImage.inside ('-u root -v /var/run/docker.sock:/var/run/docker.sock -v /data/webworks_tomcat_install.properties:/opt/webworks_tomcat_install.properties' ) {
                                dir(buildWebworksDir) {
                                    sh 'ant -f ' + buildWebworksDir + 'build.xml -Dbuild.type=tomcat spotbugs_fail'
                                    //sh 'echo "TBD"'
                                }
                            }
                        }
                    },
                    "SonarQube": {
                        stage('Sonar'){
                            techstackImage.inside ('-v /var/run/docker.sock:/var/run/docker.sock' ) {
                                sh 'echo "Execute Sonar"'
                            }
                        }
                    }
                )
            }
            stage('Application Deployment') {
                sh 'echo "INFO : Application Deployment"'
            }
        }
        currentBuild.result = 'SUCCESS'
        notifySuccess()
    } catch(Exception e) {
        currentBuild.currentResult = 'FAILED'
        currentBuild.result = 'Failed'
        notifyFailed()
    }
    echo " BUILD RESULT: ${currentBuild.result}" 
 
}