package DSA100Days;

public class Day14 {

    public static void main(String[] args) {



//        36) Decrepting the string and returning the letter
//        System.out.println(kThCharaterOfDecryptedStringCharacter("dajidas988ksajlkdn908",9000L));

//        System.out.println(kThCharaterOfDecryptedString("ab12c3", 20L));



//        35)Rotate Matrix to Right

//        rotateMatRight()


//        34) Counting Sorting
    }

    public static int[][] rotateMatRight(int[][] mat, int n, int m, int k) {


        if (k%m==0) {
            return mat;
        }

        k=k%m;



        for (int i = 0; i < n; i++) {

            int dummy=k;
            int count=0;

            while(dummy>0){

                for (int j =m-dummy ; j >count; j--) {

                    int temp=mat[i][j];
                    mat[i][j]=mat[i][j-1];
                    mat[i][j-1]=temp;

                }
                dummy--;
                count++;

            }

        }

        return mat;






    }

    public static char kThCharaterOfDecryptedStringCharacter(String s, long k)
    {
        long i, j;

        // Length of the Encrypted String.
        long n = s.length();

        // To store the length of the substring.
        long substringLength;

        // To store the resultant length of the repeated substring.
        long resultantLength;

        // To store the frequency of the substring.
        long freqOfSubstring;

        // 'k'th Character in Decrypted String.
        char kThChar = '$';

        i = 0;

        while (i < n)
        {
            j = i;
            substringLength = 0;
            freqOfSubstring = 0;

            // Find the length of substring by traversing the string until no digit is
            // found.
            while (j < n && Character.isLowerCase(s.charAt((int)j)))
            {
                j++;
                substringLength++;
            }

            // Find the frequency of preceding substring.
            while (j < n && Character.isDigit(s.charAt((int)j)))
            {
                freqOfSubstring = freqOfSubstring * 10 + (s.charAt((int)j) - '0');
                j++;
            }

            // Find length of the resultant length of the repeated substring.
            resultantLength = freqOfSubstring * substringLength;

            if (k > resultantLength)
            {
                /*
                 * If length of the repeated substring is less than 'k' then required character
                 * is present in later substring. Subtract the length of repeated substring from
                 * 'k' to keep account of number of characters required to be visited.
                 */

                k -= resultantLength;
                i = j;
            }
            else
            {
                /*
                 * If length of repeated substring is more or equal to 'k' then required
                 * character lies in current substring.
                 */

                k--;
                k %= substringLength;
                kThChar = s.charAt((int)(i + k));
                break;
            }
        }

        return kThChar;
    }

    public static char kThCharaterOfDecryptedString(String s, Long k)
    {

        StringBuilder  result=new StringBuilder();
        int number=0, sum=0;
        String word="";
        for (int i = 0; i < s.length(); i++) {



            if (s.charAt(i)>=48  && s.charAt(i)<=57) {


                number=number*10+s.charAt(i)-48;


            }
            else if (s.charAt(i)>=97 && s.charAt(i)<=122) {

                if (number>0) {

                    sum+=number*word.length();

                    while(number>0){
                        result.append(word);
                        number--;
                    }
                    word="";

                }


                word+=s.charAt(i);

            }

        }
        if (number>0) {

            sum+=number*word.length();

            while(number>0){
                result.append(word);
                number--;
            }
        }




        if(k>sum){
            k=k%sum;
        }



        return result.charAt(k.intValue()-1);
    }

    public static int[] sort(int n, int arr[]) {
        // Write your code here.
        int max = 0;

        // Initialize a variable 'MIN' to store the minimum element of the input array.
        int min = 0;

        // Iterate 'I' in 0 to 'N':
        for (int i = 0; i < n; i++) {

            // Set 'MAX' as the maximum of 'MAX' and 'ARR[I]'.
            max = Math.max(max, arr[i]);

            // Set 'MIN' as the minimum of 'MAX' and 'ARR[I]'.
            min = Math.min(min, arr[i]);
        }

        // Set 'RANGE' as 'MAX' - 'MIN' + 1.
        int range = max - min + 1;

        // Initialize an array 'COUNT' of size 'RANGE'.
        int count[] = new int[range];

        // Initialize an array 'ANS' of size 'N'.
        int ans[] = new int[n];

        // Iterate 'I' in 0 to 'N':
        for (int i = 0; i < n; i++) {

            // Increment 'COUNT[ARR[I] - MIN]' by 1.
            count[arr[i] - min]++;
        }

        // Iterate 'I' in 1 to 'COUNT.LENGTH':
        for (int i = 1; i < count.length; i++) {

            // Set 'COUNT[I]' as 'COUNT[I]' + 'COUNT[I - 1]'.
            count[i] += count[i - 1];
        }

        // Iterate 'I' in 'N - 1' to 0:
        for (int i = n - 1; i >= 0; i--) {

            // Set 'ANS[COUNT[ARR[I] - MIN] - 1]' as 'ARR[I]'.
            ans[count[arr[i] - min] - 1] = arr[i];

            // Decrement 'COUNT[ARR[I] - MIN]' by 1.
            count[arr[i] - min]--;
        }

        // Finally, return 'ANS'.
        return ans;
    }
}
