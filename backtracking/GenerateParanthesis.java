class Solution {
    public void backtrack(List<String> res, String str, int opening, int closing) {
        if(opening == 0 && closing == 0) {
            res.add(str);
            return;
        }
        if (opening > 0) {
            backtrack(res, str+'(', opening-1, closing);
        }
        if(opening < closing) {
            backtrack(res, str+')', opening, closing-1);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> res =  new ArrayList<String>();
        backtrack(res, "", n, n);
        return res;
    }
}