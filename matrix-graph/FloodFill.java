class Solution {
    
    public void floodFillUtil(int[][] image, int sr, int sc, int newColor, int currColor) {
        if (sr<0 || sr>=image.length || sc<0 || sc>=image[0].length){
            return;
        }
        if (image[sr][sc] == currColor) {
            image[sr][sc] = newColor;
            floodFillUtil(image, sr-1, sc, newColor, currColor);
            floodFillUtil(image, sr, sc+1, newColor, currColor);
            floodFillUtil(image, sr+1, sc, newColor, currColor);
            floodFillUtil(image, sr, sc-1, newColor, currColor);
        }
        else{
            return;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) return image;
        floodFillUtil(image, sr, sc, newColor, currColor);
        return image;
    }
}