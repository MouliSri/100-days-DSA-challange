package DSA100Days;

import java.util.ArrayList;
import java.util.HashMap;

public class Day15 {
    public static void main(String[] args) {



//      39)  //Minimum operation to make string Equal

//        System.out.println( MakeStringEqual("abcaaab","abcaaab"));




//        38) Triplets

//        int[] arr={10,5,5,6,2};
//
//        System.out.println(findTriplets(arr, arr.length));



//        37) Move Zeros To End
//        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(-12, 0 ,0 ,0 ,12, 13, 0, 14, 11, 10, 12));
//
//
//        Indexing(list);
//
//
//        System.out.println(list);

    }

    private static int MakeStringEqual(String a, String b) {

        if(a.length()!=b.length()){
            return -1;
        }


        // Length of the given string.
        int n = a.length();

        // To store the required answer.
        int count = 0;

        char c1, c2, c3, c4;

        // Run a loop upto 'n'/2.
        for (int i = 0; i < n / 2; i++) {

            c1 = a.charAt(i);
            c2 = a.charAt(n - i - 1);
            c3 = b.charAt(i);
            c4 = b.charAt(n - i - 1);

            // Cases that doesn't require any preprocessing move.
            if ((c1 == c2 && c3 == c4) || (c1 == c3 && c2 == c4) || (c1 == c4 && c2 == c3)) {
                continue;
            }

            // Cases that require only one preprocessing move.
            else if (c1 == c3 || c1 == c4 || c2 == c3 || c2 == c4 || c3 == c4) {
                count++;
            }

            // All remaining cases require 2 changes.
            else {
                count += 2;
            }
        }

        // If 'n' is odd.
        if (n % 2 == 1 && a.charAt(n / 2) != b.charAt(n / 2)) {
            count++;
        }

        return count;
    }

    public static ArrayList<Integer> findTriplets(int[] arr, int n)
    {
        ArrayList<Integer>ans=new ArrayList<Integer>();
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.put(arr[i],0);
            for(int j=i+1;j<n;j++)
            {
                int sum=arr[i]+arr[j];
                if(map.containsKey(sum))
                {
                    ans.add(arr[i]);
                    ans.add(arr[j]);
                    ans.add(sum);
                    return ans;
                }
                else
                {
                    map.put(arr[j],0);
                }

            }

        }
        return ans;
    }

    static  void Indexing(ArrayList<Integer> list){

        int size =list.size();
        int count=0;
        for (int i = 0; i < size && count<size; i++) {

            if(list.get(i)==0){
                list.remove(i);
                list.add(0);
                i--;
            }
            count++;
        }
    }

  static  void IndexingArray(ArrayList<Integer> list) {
      int index = 0;
      for (int i = 0; i < list.size(); i++) {

          if (list.get(i) != 0) {
              list.set(index++, list.get(i));
          }
      }


      for (int i = index; i < list.size(); i++) {
          list.set(i, 0);
      }

  }



}
