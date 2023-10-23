package DSA100Days;

import java.util.Arrays;

public class Day6 {
    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3,4},
                {14,15,16,5},
                {13 ,20,17,6},
                {12 ,19,18,7},
                {11,10,9,8}
        };


        spiralPrint(matrix);



//        setZeros(matrix);
//        mymethod(matrix);


    }

    public static void spiralPrint(int matrix[][]){

        if(matrix.length==0){
            System.out.println();

        }



        else{
            int left=0,right=matrix[0].length-1;

            int top=0,bottom= matrix.length-1;

            while(left<=right && top<=bottom){


                for (int i = left; i <=right; i++) {
                    System.out.print(matrix[top][i] + " ");
                }
                top++;

                for (int i = top; i <=bottom; i++) {
                    System.out.print(matrix[i][right] + " ");
                }
                right--;

                if (top<=bottom) {

                    for (int i = right; i >=left; i--) {
                        System.out.print(matrix[bottom][i] + " ");
                    }
                    bottom--;
                }

                if(left<=right){
                    for (int i = bottom; i >=top ; i--) {
                        System.out.print(matrix[i][left] + " ");
                    }
                    left++;
                }
            }
        }



    }




    public static void mymethod(int[][] arr){
        int row=arr.length;
        int col=arr[0].length;
        int count=0;
        int[][] matrix= new int[row][col];


          for (int i = 0; i < row ; i++) {
              System.arraycopy(arr[i], 0, matrix[i], 0, col);

          }

          for (int i = 0; i < row; i++) {

              for (int j = 0; j < col ; j++) {

                  count=0;

                  if(arr[i][j]==0 ){

                      while (count<row  ){
                          matrix[count][j]=0;
                          count++;
                      }
                      count=0;

                      while(count<col){
                          matrix[i][count]=0;
                          count++;
                      }

                  }

              }


          }

          for (int[] r:
               matrix) {
              System.out.println(Arrays.toString(r));
          }



      }

    public static void setZeros(int matrix[][]) {

        // Storing dimensions of matrix in n and m.
        int n = matrix.length;
        int m = matrix[0].length;

        // Declaring two boolean arrays colZero and rowZero.
        Boolean[] colZero = new Boolean[m];
        Boolean[] rowZero = new Boolean[n];
        for (int i = 0; i < m; i++) {
            colZero[i] = false;
        }
        for (int i = 0; i < n; i++) {
            rowZero[i] = false;
        }

        // Traversing the original matrix and filling values for rowZero and calZero.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    colZero[j] = rowZero[i] = true;
                }
            }
        }

        // Traversing the original matrix and changing values of matrix according to
        // rowZero and colZero.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}






