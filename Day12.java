package DSA100Days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day12 {
    public static void main(String[] args) {
//        28) Kadane's Algorithm
//        int[] arr={1,2,7,-4,3,2,-10,9,1};
//        System.out.println( maxSubarraySum( arr, arr.length));

////         29) Dutch National Flag Algorithm
           int[] arr={0,1,2,1,1,1,1,2,1};
//           sort012(arr);
//
//        for (int e:
//             arr) {
//            System.out.println(e);
//        }


//        30) Find Majority Element in the array

        System.out.println(moresVoting(arr,arr.length));
        System.out.println( findMajority(arr, arr.length));



    }

    private static int moresVoting(int[] arr, int length) {
        int vote=0;
        int canditate = 0;

//        choosing the canditate with more frequency than the N/2 of sub array
        for (int i = 0; i < length; i++) {

            if(vote==0){
                canditate=arr[i];
                vote++;
            } else if (canditate==arr[i]) {
                vote++;
            }
            else {
                vote--;
            }
        }
        vote=0;

        for (int i = 0; i <  length; i++) {

            if (canditate == arr[i]) {
                vote++;
            }

            if(vote>length/2){
                return canditate;
            }
        }
        return -1;
    }

    public static int findMajority(int[] arr, int n) {
        Map<Integer,Integer> map=new HashMap<>();


        for (int i = 0; i < arr.length; i++) {

            if(!map.containsKey(arr[i])){
                map.put(arr[i],0);
            }
            map.put(arr[i],map.get(arr[i])+1);

            if (map.get(arr[i])>n/2) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void sort012(int[] arr)
    {
        int low=0;
        int mid=0;
        int high=arr.length-1;

        while(mid<=high){

            if(arr[mid]==0){
                swap(low, mid, arr);
                low++;
                mid++;
            }
            else if (arr[mid]==1) {
                mid++;
            }
            else if (arr[mid]==2)
            {
                swap(mid, high, arr);
                high--;
            }
        }
    }

    public static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static long maxSubarraySum2(int[] arr, int n) {
        int sum=0;
        int max= Arrays.stream(arr).max().getAsInt();
        for (int i = 0; i < n; i++) {

            sum+=arr[i];

            if(sum<0){
                sum=0;
            }
            if (sum>=0) {
                max=Math.max(max, sum);
            }

        }
        return max;

    }
    public static long maxSubarraySum(int[] arr, int n) {
        long prev=0;
        long sum=0;
        for (int i = 0; i < n; i++) {
            sum=0;
            for (int j = i; j < n; j++) {
                sum+=arr[j];
                if (prev<sum ) {
                    prev=sum;
                }

            }


        }
        return prev;

    }

}
