package leetcode;
//重塑矩阵
public class Q566 {
    //5ms 95%
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length * nums[0].length != r*c) return nums;
        int row = 0;
        int column = 0;
        int[][] newNums = new int[r][c];

        for(int i=0 ; i<nums.length ; i++){
            for(int j=0 ; j<nums[0].length ; j++){
                if(column==c){
                    column=0;
                    row++;
                    newNums[row][column] = nums[i][j];
                    column++;
                } else {
                    newNums[row][column] = nums[i][j];
                    column++;
                }
            }
        }
        return newNums;
    }
}
