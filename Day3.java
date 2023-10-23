package DSA100Days;

import java.util.Arrays;

public class Day3 {
    public static void main(String[] args) {
//        int count=4;
//        String letter= String.valueOf(count);
//        System.out.println(letter);
        // 6) Reverse the String Word Wise
//        String input="Mouli loves Sri";
//        System.out.println(reverseStringWordWise(input));


        // 7) String Encoding

//        first wee need to find the nearby frequency of character and encode the character with frequency count

        // 8) minimum parenthesis

        // in this it does not have high close para compare to open para it like there is a missing open para
        // first wee need open then only closing
        // atlas wee need sub open-close  and add to missing count

//        System.out.println(minimumParentheses("()(())("));

//       fill minimum para own question
//        System.out.println(fillMinimumParentheses(")))((("));

        int[] arr={1,2,3,4,5};  // 4 5 1 2 3

        rotateAnArray(arr,3);
    }


    //not correct
    private static void rotateAnArray(int[] arr,int k) {

        for (int i = 0; i < k; i++) {

          if(k+i<arr.length) {

              int temp = arr[i];
              int temp2= arr[k-1+i];
              arr[i] = arr[k + i];
              arr[k-1+i] = temp;
              arr[k+i]=temp2;
          }

        }


        Arrays.stream(arr).forEach(System.out::println);

    }


    public static  String fillMinimumParentheses(String pattern) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(pattern);
        int open=0;
        int close=0;
        int index=0;
        for (int i = 0; i < pattern.length(); i++) {

            if (pattern.charAt(i)=='(') {
                open++;
            }
            else{
                close++;
            }

            if(open==close){
                index=i+1;
            }

            if(close>open){
                stringBuilder.insert(index,"(");
                System.out.println(stringBuilder.length());
                close=0;
                open=0;
                index=i+1;
            }
        }

        while(open-close>0){
            stringBuilder.append(")");
            open--;
        }

        return String.valueOf(stringBuilder);



    }

    public static int minimumParentheses(String pattern) {

        int open=0;
        int close=0;
        int count=0;
        for (int i = 0; i < pattern.length(); i++) {

            if (pattern.charAt(i)=='(') {
                open++;
            }
            else{
                close++;
            }

            if(close>open){
                count+=close-open;
                close=0;
                open=0;
            }
        }

        count+=open-close;

        return count;



    }

   public static String reverseStringWordWise(String input) {


        String[] words=input.split(" ");

        if(words.length==1){
            return input;
        }
        input="";
        for(int i=words.length-1;i>=0;i--){
            input+=words[i]+ " ";
        }
        return input;
    }

    public static String encode(String message) {
        String result="";
        int count=1;

        for (int i = 0; i < message.length(); i++) {

            if(i+1!=message.length() && message.charAt(i)==message.charAt(i+1)){
                count++;
                continue;
            }

            result+=message.charAt(i)+String.valueOf(count);
            count=1;

        }

        return result;
    }

    public static String encodeWithBuilder(String message) {
        StringBuilder encodedMessage = new StringBuilder();
        int count=1;

        for (int i = 0; i < message.length(); i++) {

            if(i+1!=message.length() && message.charAt(i)==message.charAt(i+1)){
                count++;
                continue;
            }

            encodedMessage.append(message.charAt(i));
            encodedMessage.append("" + count);
            count=1;

        }

        return encodedMessage.toString();
    }
}
