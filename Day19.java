package DSA100Days;

public class Day19 {
    public static void main(String[] args) {

//        49) Maximum Sum Rectangle

//        System.out.println( maxSumRectangle(new int[][]{{1, 2, -1, -4, -20},
//                {-8 ,-3, 4, 2, 1},
//        { 3 ,8 ,10 ,1 ,3},
//    { -4 ,-1 ,1 ,7 ,-6}},4,5));


//        50) find the k th element in the spriral form


//        System.out.println(findKthElement(new int[][]{{1, 2, -1, -4, -20},
//                {-8 ,-3, 4, 2, 1},
//                { 3 ,8 ,10 ,1 ,3},
//                { -4 ,-1 ,1 ,7 ,-6}},9));


    }



    public static int kadaneAlgorithm(int[] arr, int n)
    {
        int sum = 0;

        int maxSum = Integer.MIN_VALUE;

        // Traverse the array.
        for (int currIndex = 0; currIndex < n; currIndex++)
        {
            sum += arr[currIndex];

            if (maxSum < sum)
            {
                maxSum = sum;
            }

            if (sum < 0)
            {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static int maxSumRectangle(int[][] arr, int n, int m)
    {
        int maxSum = Integer.MIN_VALUE;

        // Initialize a 1-D array.
        int[] temp = new int[n];

        // heck for all possible left and right boundaries.
        for (int left = 0; left < m; left++)
        {
            for (int i = 0; i < n; i++)
            {
                temp[i] = 0;
            }

            for (int right = left; right < m; right++)
            {
                for (int i = 0; i < n; i++)
                {
                    temp[i] += arr[i][right];
                }

                // Function to find maximum sum of sub array of array 'temp'.
                int sum = kadaneAlgorithm(temp, n);

                // Update 'maxSum'.
                if (sum > maxSum)
                {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }



    public static int findKthElement(int[][] matrix, int k) {

        int left=0,right=matrix[0].length-1;
        int top=0,bottom=matrix.length-1;


        int count=0;


        while (left<=right && top<=bottom) {



            for (int i = left; i <=right; i++) {

                count++;

                if(count==k){
                    return  matrix[top][i];
                }

            }
            top++;


            for (int i = top; i <=bottom; i++) {

                count++;

                if(count==k){
                    return  matrix[i][right];
                }

            }

            right--;



            if(top<=bottom){


                for (int i = right; i>= left; i--) {

                    count++;

                    if(count==k){
                        return  matrix[bottom][i];
                    }



                }

                bottom--;
            }

            if (left<=right) {


                for (int i = bottom; i>= top; i--) {

                    count++;

                    if(count==k){
                        return  matrix[i][left];
                    }



                }

                left++;

            }

        }





        return 0;



    }
}
