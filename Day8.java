package DSA100Days;

import java.util.*;


public class Day8 {
    public static void main(String[] args) {

        ArrayList<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(0);
        list.add(2);
        list.add(2);
        list.add(3);

//        19) Count all sub-arrays having sum divisible by k
//        System.out.println( subArrayCount(list,5));

//
//        extra-Two Sum

//        int[] arr={9,2,7,3,5};
//
//        for (int i : TwoSum(arr, 5)) {
//            System.out.println(i);
//        }






//        20)Group Anagrams

//         ArrayList<String> arr=new ArrayList<>();
//         arr.add("eat");
//        arr.add("tea");
//        arr.add("tan");
//        arr.add("ate");
//        arr.add("nat");
//        arr.add("bat");
//
//        getGroupedAnagrams(arr,arr.size()).stream().forEach(System.out::println);
    }

    public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> arr, int n) {


       Map<String,ArrayList<String>> map=new HashMap<>();
        ArrayList<ArrayList<String>> result=new ArrayList<>();


        for (String string:arr
             ) {

            String Word=sortString(string);

            if (!map.containsKey(Word)) {
                map.put(Word,new ArrayList<>());
            }
            map.get(Word).add(string);


        }

        result.addAll(map.values());

        return result;

        }

    private static String sortString(String string) {

        char[] chars=string.toCharArray();
        Arrays.sort(chars);

        return String.valueOf(chars);
    }

    private static int[] TwoSum(int[] arr,int k) {

        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;

        for (int index = 0; index < arr.length; index++) {

            if(map.containsKey(k-arr[index])){

                return new int[]{map.get(k-arr[index]),index};
            }
            map.put(arr[index],index);

        }


        return new int[]{};
    }

    public static int subArrayCount(ArrayList < Integer > arr, int k) {

        // HashMap to store frequency.
        HashMap< Integer, Integer > remMap = new HashMap < > ();

        // Add base case in hashmap.
        remMap.put(0, 1);

        int count = 0;
        long summ = 0;
        for (int i = 0; i < arr.size(); i++) {
            summ += arr.get(i);
            int rem = (int)(((summ % k) + k) % k);

            // If rem already in 'remMap'.
            if (remMap.containsKey(rem)) {
                count += remMap.get(rem);
                remMap.put(rem, remMap.get(rem) + 1);
            } else {
                remMap.put(rem, 1);
            }
        }

        return count;
    }




}
