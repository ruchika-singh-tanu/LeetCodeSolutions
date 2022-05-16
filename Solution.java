import java.util.ArrayList;
import java.util.List;

class Solution {
   List<List<Integer>> res = new ArrayList<>();
    public int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        //corner case
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return res;
        int m=matrix.length;
        int n=matrix[0].length;
        
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(matrix,i,0,pacific,matrix[i][0]);
            dfs(matrix,i,n-1,atlantic,matrix[i][n-1]);
        }
        for(int j=0;j<n;j++){
            dfs(matrix,0,j,pacific,matrix[0][j]);
            dfs(matrix,m-1,j,atlantic,matrix[m-1][j]);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]==true && atlantic[i][j]==true){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] matrix,int r,int c,boolean[][] isTrue,int val){
        int m=matrix.length;
        int n=matrix[0].length;
        
        if(r<0 || r>=m || c<0 || c>=n || matrix[r][c]<val) return;
        if(isTrue[r][c]) return;
        
        isTrue[r][c]=true;
        
        for(int i=0;i<direction.length;i++){
            dfs(matrix,r+direction[i][0],c+direction[i][1],isTrue,matrix[r][c]);
        }
        
    }
}
