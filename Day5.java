package DSA100Days;

import java.util.ArrayList;
import java.util.Arrays;

public class Day5 {
    public static void main(String[] args) {


//        //  11) To find the immediate right,left,top,down count of 1s from the index 0s
//        ArrayList<ArrayList<Integer>> array=new ArrayList<>();
//
//        array.add(new ArrayList<>(Arrays.asList(0,1)));
//        array.add(new ArrayList<>(Arrays.asList(1,1)));
//        array.add(new ArrayList<>(Arrays.asList(0,1)));
//
//        System.out.println(coverageOfMatrix(array));


//         12)  To Find the Transpose of Matrix is equal to the original matrix

        int[][] matrix={
                {1 ,2 , 3 , 4},
                { 5  ,6  ,7  ,8},
                { 9 ,10, 11 ,12},
                {13 ,14 ,15 ,16}
        };


//
//        System.out.println( isMatrixSymmetric(matrix));


        inplaceRotate(matrix,matrix.length);


    }

    public static void inplaceRotate(int[][] arr, int n) {

        int swap=0;
        int count=0;

        while(count<arr.length/2){

            for (int i = 0; i < arr.length; i++) {


                swap=arr[i][count];
                arr[i][count]=arr[i][n-1-count];
                arr[i][n-1-count]=swap;

            }
            count++;
        }


        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {


                 if(j>i) {

                     swap = arr[i][j];
                     arr[i][j] = arr[j][i];
                     arr[j][i] = swap;
                 }



//                System.out.print(arr[i][j] + " ");
            }
//            System.out.println();
        }

        for (int[] row : arr)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));


    }

    public static boolean isMatrixSymmetric(int[][] matrix) {

        if(matrix.length==1)
        {
            return true;
        }

        int count=0;

        for (int i = 0; i < matrix.length ; i++) {
            count=0;

            for (int k = i; k < matrix[0].length; k++) {


                if(count < matrix[0].length-i && i!=k && matrix[i+count][k-count]!=matrix[i][k])
                {
                    return false;
                }


                count++;
            }


        }

        return true;
    }


    public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> array) {

        int row=array.size();
        int col=array.get(0).size();


        int count=0;
        int up=0,left=0;

        for (int i = 0; i <row ; i++) {
            left=0;
            for (int j = 0; j < col; j++) {

                //Right Check
                if (j+1<col && array.get(i).get(j)==0 && array.get(i).get(j+1)==1){

                    count++;
                }

                //Left Check
                if(left>0  && array.get(i).get(j)==0 && array.get(i).get(j-1)==1){

                    count++;

                }

                //down check
                if (i+1<row && array.get(i).get(j)==0 && array.get(i+1).get(j)==1 ) {

                    count++;
                }


                //up check
                if (up>0 && array.get(i).get(j)==0 && array.get(i-1).get(j)==1 ) {

                    count++;
                }



                left++;

            }
            up++;

        }


        return count;
    }
}
