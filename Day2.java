package DSA100Days;

import java.util.Arrays;

public class Day2 {

    public static void main(String[] args) {


        // 4)  Equilibrium index sum of left array = sum of right array  need to return the index or else return -1; do not consider the equilibrium to add

        int[] arr={-1,7,8,9,10};
//         arr= Arrays.stream(arr).filter(x->x>0).toArray();
//         Arrays.stream(arr).forEach(System.out::println);
         int n=arr.length;
//        System.out.println(n);

        System.out.println(leastPositive(arr,n));





//
//        System.out.println( Arrays.stream(arr).anyMatch(x-> x==1));

        //0,0,0,0,0,0,0,0,0,0
//        System.out.println(arrayEquilibriumIndex(arr));
//
//        System.out.println(mymethod(arr));
//

//        System.out.println(reduceCom(arr));


//       * System.out.println(originalMethod(arr));



        // 5) to find the least positive integer


    }

    private static int leastPositive(int[] arr, int n) {
//        for (int i = 1; i <= n; i++) {
//
//            if(arr[i-1]!=i){
//                return i;
//            }
//        }
//
//        return n+1;
        Arrays.sort(arr);
        //  arr= Arrays.stream(arr).filter(x->x>0).toArray();


        int count=1;
        if(n==0){
            return 1;
        }

        for (int i = 0; i < n; i++) {

            if(arr[i]<=0){

            }
            else if(arr[i]==count){
                count++;
            }
            else if(arr[i]!=count){
                return count;
            }



        }

        return count;
    }


    private static int originalMethod(int[] arr) {
        int total= Arrays.stream(arr).sum();
        int left=0;
        for (int i = 0; i < arr.length; i++) {

            if(left==total-arr[i]-left){
                return i;
            }
            left+=arr[i];

        }

        return -1;
    }

    private static int reduceCom(int[] arr) {
         int left=0,right=0;
         int count=0,index=-1;
        for (int i = arr.length/2; i >=0 ; i--) {
            left=Arrays.stream(Arrays.copyOfRange(arr,0,i)).sum();
            right=Arrays.stream(Arrays.copyOfRange(arr,i+1,arr.length)).sum();

            if(left==right){
                count++;
                index=i;
            }
        }
        if(count==arr.length/2){
            return 0;
        } else if (count==1) {
            return index;
        }
        return index;
    }

    public static  int mymethod(int[] arr){
        int left=0,right=0;

        for (int i = 0; i < arr.length-1; i++) {
            left=Arrays.stream(Arrays.copyOfRange(arr,0,i)).sum();
            right=Arrays.stream(Arrays.copyOfRange(arr,i+1,arr.length)).sum();

            if(left==right){
                return i;
            }


        }

        return -1;
    }

    public static int arrayEquilibriumIndex(int[] arr){

        int leftSum=0;
        int rightSum=0;




        for (int i = 0; i < arr.length; i++) {


            for (int j = arr.length-1; j >i; j--) {
                rightSum+=arr[j];

            }
            if (leftSum==rightSum) {
                return i;
            }
            leftSum+=arr[i];
            rightSum=0;


        }

        return -1;

    }
}
