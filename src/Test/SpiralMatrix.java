package Test;

public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];

        int rowstart =0;
        int colstart = 0;
        int rowEnd = n-1;
        int colEnd = n-1;
        int num = 1;
        while(num <= n*n){
            //Top Row
            for(int i=colstart;i<=colEnd && num <= n*n;i++){
                mat[rowstart][i] = num++;
            }
            rowstart++;
            //Right Col
            if(rowstart<rowEnd){
                for(int i=rowstart;i<=rowEnd && num <= n*n ;i++){
                    mat[i][colEnd] = num++;
                }
                colEnd--;
            }
            //Bottom Row
            if(rowEnd>=rowstart && num <= n*n){
                for(int i=colEnd;i>=colstart;i--){
                    mat[rowEnd][i] = num++;
                }
            }
            rowEnd--;
            //Left col
            if(colstart<=colEnd && num <= n*n){
                for(int i=rowEnd;i>=rowstart;i--){
                    mat[i][colstart] = num++;
                }
            }
            colstart++;
        }

        if(n%2 == 0){

        }
        else{
            //mat[n/2][n/2] = n*n;
        }
        return mat;
    }

    public static void main(String args[]){
       int[][] mat = generateMatrix(5);

       for(int i=0;i<mat.length;i++){
           for(int j=0;j<mat[0].length;j++){
               System.out.print(mat[i][j]+" ");
           }
           System.out.println();
       }
    }
}
