package DSA100Days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day9 {
    public static void main(String[] args) {


//        21)Pair Sum
        int[] arr={1,-4,-2,5,-3};

//        System.out.println(pairSum(arr,arr.length,6));
//        System.out.println(otherMethod(arr,arr.length,6));
//
//        22) separateNegativeAndPositive
        for (int e:
        separateNegativeAndPositive(arr)) {
            System.out.println(e);
        };



    }

    public static int[] separateNegativeAndPositive(int a[]) {

        int start=0,end=a.length-1;
        int temp=0;
        while(start<end){

            if (a[start]>0 && a[end]<0 ) {
                temp=a[start];
                a[start]=a[end];
                a[end]=temp;
                start++;
                end--;
            }
            else if (a[start]<0) {
                start++;
            }
            else{
                end--;
            }
        }



//        Arrays.sort(a);
        return a;


    }

    private static int otherMethod(int[] arr, int length, int target) {
        int i=0,j=length-1;
        int count=0;
        while(i<j){
            if (arr[i]+arr[j] == target) {
                count++;
                i++;
                j--;
            } else if (arr[i]+arr[j] <target) {
                i++;
            } else  {
                j--;

            }

        }
        return count;
    }




    public static int pairSum(int arr[], int n, int target) {

        int count=0;

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){

            if (map.containsKey(target-arr[i])) {

                count++;

            }
            map.put(arr[i], i);

        }
        if(count==0){
            return -1;
        }
        return count;
    }
}
