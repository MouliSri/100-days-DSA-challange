package DSA100Days;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Day20 {
    public static void main(String[] args) {

//         51) Test Question

//        return the max  count value with same value in array;
//        System.out.println( findX(new int[]{3 ,8 ,2 ,3 ,3 ,2}));

//
//        52) Test

//        System.out.println(maxRoomBooked(new ArrayList<>(Arrays.asList("+2A" ,"+3A", "-2A", "+4Z", "+2A")),5));


//        53) Test
//
//         find the divided array have equal value
        System.out.println(totalIndexes(new int[]{1 ,4 ,2 ,-2 ,5 },new int[]{7 ,-2 ,-2 ,2 ,5  }));




    }

    public static int totalIndexes(int[] A, int[] B)
    {

        int sumA=0;
        int sumB=0;
        int minusA=0;
        int minusB=0;
        int result=0;

        for (int i = 0; i < B.length; i++) {
            sumA+=A[i];
            sumB+=B[i];
        }

        for (int index = 0; index < A.length-1; index++) {

            minusA+=A[index];
            minusB+=B[index];


            int secondPart=sumA-minusA;

            int fourthPart=sumB-minusB;

            if(minusA==secondPart && minusB==fourthPart && secondPart==fourthPart && minusA==minusB){
                result++;
            }



        }



        return result;
    }

    static String maxRoomBooked(ArrayList<String> arr, int n) {

        Map<String,Integer> map=new HashMap<>();
        int max=0;
        String result="";

        for (int index = 0; index < n; index++) {

            if(!map.containsKey(arr.get(index))){
                map.put(arr.get(index),1);

            }
            else {
                map.put(arr.get(index), map.get(arr.get(index))+1);

            }



            if( (int)map.get(arr.get(index))>max){

                    result=arr.get(index);
                    max=(int)map.get(arr.get(index));

            }
            else if(max==(int)map.get(arr.get(index))){

                if (Integer.parseInt(result.substring(1,2))> Integer.parseInt(arr.get(index).substring(1,2)) ) {

                    result=arr.get(index);
                }
                else if(Integer.parseInt(result.substring(1,2))== Integer.parseInt(arr.get(index).substring(1,2)) && result.charAt(2) >  arr.get(index).charAt(2))
                {
                    result=arr.get(index);
                }

            }


        }




        return result.substring(1);

    }


    public static int findX(int[] arr) {

        Map<Integer,Integer> map=new HashMap<>();
        int max=0;


        for (int i = 0; i < arr.length; i++) {

            if(!map.containsKey(arr[i])){

                map.put(arr[i], 1);
            }
            else
            {
                map.put(arr[i], map.get(arr[i])+1);
            }


              if( map.get(arr[i])==arr[i] && arr[i]>max ){
                  max=arr[i];
              }

        }




        return max;
    }
}
