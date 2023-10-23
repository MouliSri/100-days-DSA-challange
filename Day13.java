package DSA100Days;

import java.util.*;

public class Day13 {
    public static void main(String[] args) {







//        SortedMap<Integer,String> map=new TreeMap<>();
//
//        map.put(0,"mouli");
//
//        map.put(0,"sri");
//
//
//        System.out.println(map);


////        31) Anagaram
//        System.out.println( areAnagram("mdiivjvuj" ,"sucpldnwh"));

//            32) Array Intersection

//        System.out.println(findArrayIntersection(new ArrayList<>(Arrays.asList(1,2,4,5)),5,new ArrayList<>(Arrays.asList(1,2,3,4,5)),5));


//           33) Majority Element

//        System.out.println( majorityElementII(new ArrayList<>(Arrays.asList(1,2,1,1,2))));

    }

//    public static boolean areAnagram(String str1, String str2){
//
//        if(str1.length()!=str2.length()) return false;
//
//        int sum=0;
//
//        for (int i = 0; i < str1.length(); i++) {
//
//            sum+=(str1.charAt(i)-97)-(str2.charAt(i)-97);
//        }
//
//        return sum == 0;
//    }


    //hashing method
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr)
    {


        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        Integer size = arr.size() / 3;
        for (int i = 0; i < arr.size(); i++) {
            if (!map.containsKey(arr.get(i))) {
                map.put(arr.get(i), 0);
            }
            map.put(arr.get(i), map.get(arr.get(i)) + 1);


            if(map.get(arr.get(i)) > size && !result.contains(arr.get(i))){
                result.add(arr.get(i));
            }

        }



//     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//     Integer k = entry.getKey();
//     Integer v = entry.getValue();
//     if (v > size) {
//         result.add(k);
//     }
//    }



        return result;


    }

    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
    {

        int i=0;

        int j=0;

        ArrayList<Integer> ans= new ArrayList<>();



        while(i<n && j<m){

            if(arr1.get(i)<arr2.get(j)){

                i++;

            }

            else if(arr1.get(i)>arr2.get(j)){

                j++;

            }

            else{

                ans.add(arr1.get(i));

                i++;

                j++;

            }

        }

        return ans;


    }

    public static boolean areAnagram(String str1, String str2){
        if(str1.length()!=str2.length()) return false;

        int[] count=new int[26];

        for (int i = 0; i < str1.length(); i++) {
            count[str2.charAt(i)-97]--;
            count[str1.charAt(i)-97]++;
        }
        for (int i = 0; i < str1.length(); i++) {
            if(count[str1.charAt(i)-97]!=0){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> MooremajorityElementII(ArrayList<Integer> arr)
    {

        int Canditate1=0 ,Canditate2=0;

        int vote1=0,vote2=0;
        int size=arr.size();


        for (int i = 0; i < size; i++) {

            if (vote1==0) {
                Canditate1=arr.get(i);
                vote1++;
            }
            else if(Canditate1==arr.get(i))
            {
                vote1++;
            }
            else if (vote2==0) {
                Canditate2=arr.get(i);
                vote2++;
            }
            else if(Canditate2==arr.get(i)){
                vote2++;
            }
            else
            {
                vote1--;
                vote2--;
            }


        }
        vote1=0;
        vote2=0;

        for (int i = 0; i < size; i++) {

            if (arr.get(i)==Canditate1) {
                vote1++;
            }
            else if (arr.get(i)==Canditate2) {
                vote2++;
            }

        }


        arr.removeAll(arr);

        if (vote1> size/3 ){
            arr.add(Canditate1);
        }

        if(vote2> size/3){
            arr.add(Canditate2);
        }


        return arr;



//         Map<Integer, Integer> map = new HashMap<>();
//         ArrayList<Integer> result = new ArrayList<>();
//         Integer size = arr.size() / 3;

//       for (int i = 0; i < arr.size(); i++) {
//         if (!map.containsKey(arr.get(i))) {
//         map.put(arr.get(i), 1);
//        }
//        else{
//         map.put(arr.get(i), map.get(arr.get(i)) + 1);
//        }


//     //    if(map.get(arr.get(i)) > size && !result.contains(arr.get(i))){
//     //        result.add(arr.get(i));
//     //    }

//       }



//     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//     Integer k = entry.getKey();
//     Integer v = entry.getValue();
//     if (v > size) {
//         result.add(k);
//     }
//    }



//     return result;


    }
}
