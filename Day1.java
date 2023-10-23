package DSA100Days;

import java.util.*;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) {
        int[] arr={-2,-2,-2,-2,-2};



//    1)    //To find the second largest element

//       int result= findSecondLargest(arr);
//        System.out.println(result);

 //       2)  //To rotate the elements in the array to the k steps
//                List<Integer> givenIntArray1 = Arrays.stream(arr)
//                .boxed()
//                .collect(Collectors.toList());
//
//        ArrayList<Integer> list=new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//
//        rotateElements(list,2).stream().forEach(System.out::println);


//        3) //Non Decreasing Array  we can modify atmost 1 to return true // false



    }

    public static boolean isPossible(int[] arr, int n) {
        int count=0;
        if(arr.length==1){
            return true;
        }
        for (int i = 0; i < n-1; i++) {

            if(!( arr[i]<=arr[i+1])){
                count++;
            }


            if(count>1){
                return false;
            }

        }
        return true;
    }

    private static ArrayList<Integer> rotateElements(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> list=new ArrayList<>();


        for (int i = 0; i < k; i++) {
            list.add(arr.get(0));
            arr.remove(0);
        }

        arr.addAll(list);

        return arr;
    }

    private static int findSecondLargest(int[] arr) {
        if(arr.length<1){
            return -1;
        }


        int[] desArr=Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int max=desArr[0];
        for (int i = 0; i < desArr.length; i++) {

            if(max>desArr[i]){
                return desArr[i];
            }


        }

        return -1;
    }
}


//my approach
//int max=arr[0];
//    int secondMax=arr[0];
//    int count=0;
//// int negativeCount=0;
//
//	     for(int i=0;i<arr.length;i++){
//
//        if(max<arr[i]){
//        secondMax=max;
//        max=arr[i];
//        }
//        else if(max==arr[i]){
//        count++;
//        }
//        else if(secondMax<arr[i]  )
//        {
//        secondMax=arr[i];
//        }
//
//        //  if(arr[i]<0){
//        //    negativeCount++;
//        //  }
//
//        }
//
//        if(count==n){
//        return -1;
//        }




//Notes
//
//1 ->  Sorting the array in descending order int[] arrDesc = Arrays.stream(arr).boxed()
//        .sorted(Collections.reverseOrder())
//        .mapToInt(Integer::intValue)
//        .toArray();
