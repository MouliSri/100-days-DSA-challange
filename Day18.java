package DSA100Days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day18 {
    public static void main(String[] args) {


//        46) Repeat And Missing Number Array

//        missingAndRepeating(new ArrayList<>(Arrays.asList(5,2,1,3,5)),5);


//        47) Four sum problem   \\ Find Four Elements That Sums To A Given Value

//        System.out.println(  fourSum(new int[]{81, 96, -51, 30, -85, -42 , -79, -40, 90, 7, -57, 49, -29, -85, 12, 44, -55, -27, 29 },-60,19));


//        48) count sub array  equal to target sum
//
//        System.out.println(findAllSubarraysWithGivenSum(new int[]{1,2,4,5,6},5));



    }

    public static String fourSum(int[] arr, int target, int n) {
        int count=0,sum=0;
        for (int i = 0; i < n; i++) {
            sum=arr[i];
            count=1;

            for (int j = 0; j < n; j++) {

                if(i==j) {
                    continue;
                }


                while(count<=4 && count+j-1<n)
                {
                    sum+=arr[count+j-1];
                    count++;
                }

                System.out.println(sum);

                if(sum==target && count==5){
                    return "Yes";
                }
                sum=arr[i];
                count=1;
            }


        }


        return "No";
    }


    public static int findAllSubarraysWithGivenSumMy(int arr[], int s) {
        int n = arr.length;
        int res = 0;

        // Calculate all subarrays.
        for (int i = 0; i < n; i++) {
            int summ = 0;

            for (int j = i; j < n; j++) {

                // Calculate required sum.
                summ += arr[j];

                // Check if sum is equal to required sum.
                if (summ == s) {
                    res += 1;
                }
            }
        }

        return res;
    }




    //hashing method
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {

        // Used to store number of subarrays starting from index zero having particular value of sum.
        HashMap < Integer, Integer > prevSum = new HashMap<Integer , Integer>();
        int n = arr.length;
        int res = 0;

        // To keep track of sum of elements so far.
        int currsum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currsum += arr[i];

            // If current sum is equal to desired sum, then a new subarray is found. So, increase count of subarrays.
            if (currsum == s) {
                res += 1;
            }

            /*
                If current sum exceeds given sum by current sum  - sum.
                Find number of subarrays having this sum in our map and exclude these subarrays.
            */
            if (prevSum.containsKey(currsum - s)) {

                res += prevSum.get(currsum - s);
            }

            // Add current sum value to count of different values of sum.
            if(prevSum.containsKey(currsum)) {
                prevSum.put(currsum, prevSum.get(currsum) + 1);
            } else {
                prevSum.put(currsum, 1);
            }
        }

        return res;

    }
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] count=new int[n+1];
        int[] result=new int[2];


        int total=n*(n+1)/2;


        for (int i = 0; i < arr.size(); i++) {


            count[arr.get(i)]++;

            if (count[arr.get(i)]==2) {
                result[1]= arr.get(i);
            }
            else {
                total-=arr.get(i);
            }
        }


            result[0]=total;






        return result;
    }
}
