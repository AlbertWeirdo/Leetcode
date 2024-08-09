class Solution {
    private int count=0;
    private int ans=0;
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length<3||grid[0].length<3){
            return 0;
        }
        int maxSubMatrix=Math.min(grid.length-3, grid[0].length-3)+2;
        int[][] validSubMatrix=checkMatrix(maxSubMatrix,grid);
        
        for (int i=0;i<count;i++){
            int row=validSubMatrix[i][0];
            int col=validSubMatrix[i][1];
            if (checkSum(grid, row, col)){
                ans++;
            }
        }
        return ans;
    }

    private int[][] checkMatrix(int maxSubMatrix,int[][] grid){
        int[][] validSubMatrix=new int[maxSubMatrix][2];
        
        for (int i=0;i<=grid.length-3;i++){
            for (int j=0;j<=grid[0].length-3;j++){
                int[] checkPoint=new int[9];
                int numCount=0;
                for (int k=0;k<9;k++){
                    int col=k%3;
                    int row=k/3;
                    int num=grid[i+row][j+col];
                    if (num>9||num<1){
                        k=8;
                    }else{
                       if (checkPoint[num-1]==0){
                        checkPoint[num-1]=1;
                        numCount++;
                       }
                    }
                }
                if (numCount==9){
                    validSubMatrix[this.count][0]=i;
                    validSubMatrix[this.count][1]=j;
                    count++;
                }
            }
        }
        return validSubMatrix;
    }

    private boolean checkSum(int[][] grid, int row, int col){
        //check each row has the same sum
        int rowSum=grid[row][col]+grid[row][col+1]+grid[row][col+2];
        for (int i=row+1;i<row+3;i++){
            int sum=grid[i][col]+grid[i][col+1]+grid[i][col+2];
            if (sum!=rowSum){
                return false;
            }
        }
        //check each col has the same sum
        int colSum=grid[row][col]+grid[row+1][col]+grid[row+2][col];
        for (int i=col+1;i<col+3;i++){
            int sum=grid[row][i]+grid[row+1][i]+grid[row+2][i];
            if (sum!=colSum){
                return false;
            }
        }
        //chech each diagonal has the same sum
        int diagonalSum=grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
        if (diagonalSum!=grid[row][col+2]+grid[row+1][col+1]+grid[row+2][col]){
            return false;
        }
        return true;
    }
    
}