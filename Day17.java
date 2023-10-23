package DSA100Days;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Day17 {
    public static void main(String[] args) {


        // 43)  Maximum product count  pairs with the frequency  to find the higher frequency if both frequency is same find the min product key
//        Arrays.stream(maxProductCount(new int[]{3,4,6,2,1},5)).forEach(System.out::println);


//        44) Product of two String

//        System.out.println(multiplyStrings("123","456"));



//        45 ) find all sub square of k in the matrix
//
//        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
//
//        arr.add(new ArrayList<>(Arrays.asList(1,2,3)));
//        arr.add(new ArrayList<>(Arrays.asList(4,5,6)));
//        arr.add(new ArrayList<>(Arrays.asList(7,8,9)));
//
//
//
//        sumOfKxKMatrices(arr,2).forEach(System.out::println);



    }

    public static ArrayList<ArrayList<Integer>> sumOfKxKMatrices(ArrayList<ArrayList<Integer>> arr, int k) {


        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        boolean flag=false;

        if(k<=1){
            return arr;
        }

        for (int i = 0; i <=arr.size()-k; i++) {

            for (int j = 0; j <=arr.get(i).size()-k; j++) {
                int down=0;
                int sum=0;
                int right=0;

                while(down<k){

                    right=0;
                    while(right<k ){
                        sum+=arr.get(down+i).get(right+j);
                        right++;

                    }
                    down++;
                }



                if(down+right==k*2){

                    flag=true;
                    if (!map.containsKey(i)) {
                        map.put(i,new ArrayList<>());
                    }

                    map.get(i).add(sum);

                }

            }

            if (flag) {
                result.add(map.get(i));
            }
            flag=false;

        }


        return result;

    }

    public static String multiplyStrings(String a, String b) {
        int n = a.length();
        int m = b.length();

        // Initialising the answer array.
        int[] answer = new int[m + n];

        // Below two indexes are used to find positions in answer.
        int p = 0;
        int q = 0;

        // Traversing first number "a" from right to left
        for (int i = n - 1; i >= 0; i--) {
            int carry = 0;

            // Taking current digit of first number "a"
            int a1 = a.charAt(i) - '0';

            // Initialising q to zero to denote right end.
            q = 0;

            // Go from right to left in second number "b"
            for (int j = m - 1; j >= 0; j--) {

                // Taking current digit of second number
                int a2 = b.charAt(j) - '0';

                // Multiply with digit of first number and adding carry to it
                int sum = a1 * a2 + answer[p + q] + carry;

                // Carry for next iteration
                carry = sum / 10;

                // Storing the answer
                answer[p + q] = sum % 10;

                // Shifting q by 1
                q++;
            }

            // Store carry in the next cell if it exists
            if (carry > 0) {
                answer[p + q] += carry;
            }

            // Left shifting p by 1 unit
            p++;
        }

        // Moving to first non-zero digit from left
        int i = answer.length - 1;
        while (i >= 0 && answer[i] == 0) {
            i--;
        }

        // Generate the final answer as a string
        StringBuilder result = new StringBuilder();

        while (i >= 0) {
            result.append(answer[i--]);
        }

        // Checking the case of 0
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();


    }

    public static long[] maxProductCount(int arr[], int n) {


        long[] result=new long[2];

        if (n<4) {
            return  result;
        }

        Map<Long,Integer> map=new TreeMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {

                long pair= (long) arr[i] *arr[j];

                map.putIfAbsent(pair, 0);

                map.put(pair, map.get(pair)+1);

            }
        }




        long maxProd = 0;

        // To store frequency of max product.
        int freq = 1;


        for (Long key:
                map.keySet()) {

            if (map.get(key)>freq) {
                maxProd=key;
                freq=map.get(key);
            }
        }

        if(freq==1 && maxProd==0){


            return result;
        }

        result[0]=maxProd;

        freq=freq*(freq-1)/2;


        result[1]=freq;




        return result;


    }
}
