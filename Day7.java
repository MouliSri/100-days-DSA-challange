package DSA100Days;

import java.util.*;
import java.util.stream.Collectors;

public class Day7 {
    public static void main(String[] args) {


        //16)making unique Array

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(-1);
        arr.add(4);
        arr.add(-4);





//        System.out.println(minElementsToRemove(arr));


//        int value= arr.stream().reduce((sum,i)-> sum+i).get().intValue();


        //17) Print first Non RepeatingCharacter in the string
//        String str="AabAcad";
//        System.out.println(firstNonRepeatingCharacter(str));
//
//        //Efficient Method
//        System.out.println(otherMethodNonRepeatingChar(str));


//        18)  longest sub array is sum is zero return the length

//        System.out.println( LongestSubArray(arr));

        System.out.println(OtherLongestSubArray(arr));


    }

    private static int OtherLongestSubArray(ArrayList<Integer> arr) {

        int max=0,sum=0;

//        arr.stream().mapToInt(Integer::intValue).max().getAsInt();

        for (int i = 0; i < arr.size(); i++) {
            sum=0;
            for (int j = i; j < arr.size() ; j++) {

                sum+=arr.get(j);

                if(sum==0){
                    max=Math.max(max,j-i+1);
                }

            }

        }
        return max;
    }

    private static int LongestSubArray(ArrayList<Integer> arr) {

        int sum=0,count=0,prev=0;


        for (int in = 0; in < arr.size(); in++) {


            for (int i = in; i < arr.size(); i++) {
                sum = 0;
                count = 0;
                for (int j = i; j >= in; j--) {

                    sum += arr.get(j);
                    count++;
                }
                if (sum == 0 && count>prev) {
                    prev=count;
                }


            }

        }

        return prev;
    }

    public static char firstNonRepeatingCharacter(String str) {


        List<Character> list = new ArrayList<>();

        for (Character character : str.toCharArray()) {

            list.add(character);
        }


        for (int i = 0; i < str.length(); i++) {


            int frequency = Collections.frequency(list, list.get(i));

            if (frequency == 1) {
                return list.get(i);
            }
        }


        return str.charAt(0);
    }

    private static char otherMethodNonRepeatingChar(String str) {
        // Map to store frequency of each character
        HashMap<Character, Integer> freqOfCharacters = new HashMap<Character, Integer>();

        // Loop to calculate frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            int number = freqOfCharacters.getOrDefault(ch, 0);
            freqOfCharacters.put(ch, number + 1);

        }

        // Loop to return the first non-repeating character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freqOfCharacters.get(ch).intValue() == 1) {
                return ch;
            }
        }
        // Return first character of string if all are repeating characters
        return str.charAt(0);

    }

    private static int minElementsToRemove(ArrayList<Integer> arr) {

//        Collections.rotate(arr,3);
//        System.out.println(arr);

        Set<Integer> set = new HashSet<>();

        set.addAll(arr);

        System.out.println(set.size());

        int count = (int) arr.stream().distinct().count();

        int size = arr.size();

        return size - count;
    }


}

