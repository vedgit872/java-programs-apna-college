package imp.graph;

public class floodfill {
        public int[][] helper(int[][] image, int sr, int sc, int color,boolean[][] vis,int orignalcolor) {
            if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc] != orignalcolor){
                return image;
            }
            image[sr][sc]=color;
            vis[sr][sc]=true;
            helper(image, sr, sc - 1, color, vis, orignalcolor);
            helper(image, sr - 1, sc, color, vis, orignalcolor);
            helper(image, sr, sc + 1, color, vis, orignalcolor);
            helper(image, sr + 1, sc, color, vis, orignalcolor);
    
            return image;
        }
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            boolean[][] vis=new boolean[image.length][image[0].length];
            helper(image,sr,sc,color,vis,image[sr][sc]);
            return image;
        }
        public static void main(String[] args) {
            
        }
}
