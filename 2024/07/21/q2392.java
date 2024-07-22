// 2392. Build a Matrix With Conditions
// https://leetcode.com/problems/build-a-matrix-with-conditions/description/

import java.util.ArrayList;
import java.util.HashMap;

public class q2392{
    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] rowConditions={{1,2},{3,2}};
        int[][] colConditions={{2,1},{3,2}};
        s.buildMatrix(3, rowConditions, colConditions);
    }
}

class Solution {
    private HashMap<Integer,Integer> rowOrder=new HashMap<>();
    private HashMap<Integer,Integer> colOrder=new HashMap<>();
    private ArrayList<Integer> usedRow=new ArrayList<>();
    private ArrayList<Integer> usedCol=new ArrayList<>();
    private int[][] ans={};
    private int k;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.k=k;
        if (rowConditions.length!=k-1||colConditions.length!=k-1){
            return ans;
        }
        ans=new int[k][k];
        for (int i=0;i<k;i++){
            for (int j=0;j<k;j++){
                ans[i][j]=0;
            }
        }
        for (int i=1;i<=k;i++){
            rowOrder.put(i, 0);
            colOrder.put(i,0);
        }
        // store row's and col's order
        for (int i=0;i<k-1;i++){
            int right=rowOrder.get(rowConditions[i][0])+1;
            // if (rowOrder.get(rowConditions[i][1])==right){
            //     right++;
            //     rowOrder.replace(rowConditions[i][0], rowOrder.get(rowConditions[i][0])+1);
            // }
            rowOrder.replace(rowConditions[i][1], right);
            int below=colOrder.get(colConditions[i][0])+1;
            // if (colOrder.get(colConditions[i][1])==below){
            //     below++;
            //     colOrder.replace(colConditions[i][0], colOrder.get(colConditions[i][0])+1);
            // }
            colOrder.replace(colConditions[i][1], below);
        }
        for (int i=1;i<=k;i++){
            int row=rowOrder.get(i);
            if (usedRow.contains(row)){
                row=rowProcessDuplicate(row);
            }
            int col=colOrder.get(i);
            if (usedCol.contains(col)){
                col=colProcessDuplicate(col);
            }
            ans[row][col]=i;
        }
        return ans;
    }
    private int rowProcessDuplicate(int i){
        if (i==k||i==0){
            
        }
        while (usedRow.contains(i)){
            rowProcessDuplicate(++i);
            rowProcessDuplicate(--i);
        }
        return i;
    }
    private int colProcessDuplicate(int i){
        while (usedCol.contains(i)){
            colProcessDuplicate(++i);
            colProcessDuplicate(--i);
        }
        return i;
    }
}