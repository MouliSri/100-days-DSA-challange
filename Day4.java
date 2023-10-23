package DSA100Days;

import java.math.BigInteger;

public class Day4 {
    public static void main(String[] args) {






        //9 ) Make a beautiful string

//        System.out.println(makeBeautiful("01011"));  // - 01010 only 1 vale can be changed to make beautiful string minimum changes to make beautiful


//        10) To find the Next Palindrome

//        String num="12462788885278";
//        System.out.println(nextLargestPalindrome(num,num.length()));

    }


    public static String nextLargestPalindrome(String number, int length) {


        BigInteger bigInteger=new BigInteger(number);


        if(length==1){
            return String.valueOf(bigInteger.add(BigInteger.valueOf(1)));
        }
        int mid=length/2;
        int add=1;

        if(length%2!=0){
            mid+=1;
            add+=1;
        }


        BigInteger value=new BigInteger(number.substring(0,mid));

        BigInteger Addedvalue=value.add(BigInteger.valueOf(1));


        StringBuilder Result= new StringBuilder(String.valueOf(value));
        StringBuilder AddedResult= new StringBuilder(String.valueOf(Addedvalue));

        for (int i = Result.length()-add; i >=0 ; i--) {

            Result.append(Result.charAt(i));
            AddedResult.append(AddedResult.charAt(i));
        }

        value= BigInteger.valueOf(Long.valueOf(Result.toString()));

        Addedvalue=BigInteger.valueOf(Long.valueOf(AddedResult.toString()));




        int v=value.compareTo(bigInteger);

        if(v > 0){
             v=Addedvalue.compareTo(value);

             if(v==1){
                 return Result.toString();
             }
        }



        return AddedResult.toString();


    }

    public static int makeBeautiful(String str) {

        int missingCount=0;
        int old=str.length();
        char odd='1';
        char even='0';
        int result=0;


        for (int option = 1; option <= 2; option++) {


            for (int i = 0; i < str.length(); i++) {

                if(i%2==0 && str.charAt(i)!=even){
                    missingCount++;
                }
                else if(i%2!=0 && str.charAt(i)!=odd){
                    missingCount++;
                }

            }

            if (missingCount==0) {
                return 0;
            }



            result=old>=missingCount?missingCount:old;
            old=missingCount;
            odd='0';
            even='1';
            missingCount=0;
        }



        return result;
    }
}
