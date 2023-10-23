package DSA100Days;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class Day16 {
    public static void main(String[] args) {
//
//        40) Maximum Sum Circular Array

//        System.out.println(maxSubarraySum(new int[]{1,-2, 3 ,2, 1, -1},6));

//       41) Length of the Consecutive Sequence in unsorted array Time complexity O(N) space O(N);
//        System.out.println(lengthOfLongestConsecutiveSequence(new int[]{1,6,7 ,8 ,2 ,3 ,4 ,9},8));

 //        42)

        System.out.println(maxSubSumKConcat(new ArrayList<>(Arrays.asList(1,-2,1)),3,2));

    }

    public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {

        if (arr == null || arr.isEmpty() || k <= 0) {
            return 0;
        }

        long sum=0;
        long max=Integer.MIN_VALUE;



        for (int index = 0; index < k-1; index++) {
            arr.addAll(arr.subList(0, n));
        }


        for (Integer integer : arr) {

            if (sum < 0) {
                sum = 0;
            }
            sum += integer;
            max = Math.max(max, sum);
        }



        return max;

        }




    public static int lengthOfLongestConsecutiveSequenceBetter(int[] arr, int N){

        int mx = 0;

        // To store the length of current consecutive Sequence.
        int count = 0;

        // To store all the unique elements of array.
        HashSet<Integer> set = new HashSet<>();

        for (Integer element : arr) {
            set.add(element);
        }

        for (Integer element : arr) {
            int previousConsecutiveElement = element - 1;

            if (!set.contains(previousConsecutiveElement)) {

                // Element is the first value of consecutive sequence.
                int j = element;

                while (set.contains(j)) {
                    // The next consecutive element by will be j + 1.
                    j++;
                }

                // Update maximum length of consecutive sequence.
                mx = Math.max(mx, j - element);
            }

        }

        return mx;

    }

    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N){

        Set<Integer> set=new TreeSet<>();
        int count=0,min=0,max=0;

        for (int i = 0; i < N; i++) {
            set.add(arr[i]);

            if (arr[i]<min) {
                min=arr[i];
            }
        }

        Iterator<Integer> itr= set.iterator();


        int prev=min-1;
        while (itr.hasNext()){

            int value=itr.next();

            if(prev+1== value){
                count++;
            }
            else {
                count=1;
            }

            max=Math.max(max,count);

            prev=value;

        }


        return max;

    }




    public static int lengthOfLongestConsecutiveSequenceAnother(int[] arr, int N) {

        int max=0,min=0;

        int count=0;
        int result=1;

        Set<Integer> set=new HashSet<>();

        for (int i = 0; i < N; i++) {

            if (min>arr[i]) {
                min=arr[i];
            }

            if (max<arr[i]) {
                max=arr[i];
            }

            set.add(arr[i]);

        }


        for (int index = min; index <= max; index++) {

            if (set.contains(index)) {
                count++;

            }
            else{
                count=0;
            }


            result=Math.max(result,count);

        }


        return result;

    }

    public static int maxSubarraySum(int[] arr, int n) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int curr = 0;

        for (int i = 0; i < n; ++i) {
            totalSum = totalSum + arr[i];
            curr = curr + arr[i];

            if (curr > maxSum) {
                maxSum = curr;
            }

            if (curr < 0) {
                curr = 0;
            }
        }

        int minSum = Integer.MAX_VALUE;
        curr = 0;

        for (int i = 0; i < n; ++i) {
            curr = curr + arr[i];

            if (curr < minSum) {
                minSum = curr;
            }

            if (curr > 0) {
                curr = 0;
            }
        }

        if (totalSum == minSum) {
            return maxSum;
        }

        return Math.max(totalSum - minSum, maxSum);
    }

    public static int maxSubarraySumMy(int[] arr, int n) {

        if(n==1){
            return arr[0];
        }

        int max=Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {

            max=Math.max(max,rotateAndFind(arr,i));

        }

        return max;


    }

    public static int rotateAndFind(int[] arr,int value){

        int sum=0,max=Integer.MIN_VALUE;


        for (int i = value; i < arr.length; i++) {

            if(sum<0){
                sum=0;
            }

            sum+=arr[i];

            max=Math.max(max,sum);
        }




        for (int i = 0; i <value; i++) {

            if(sum<0){
                sum=0;
            }

            sum+=arr[i];


        }
        max=Math.max(max,sum);



        return max;
    }
}
