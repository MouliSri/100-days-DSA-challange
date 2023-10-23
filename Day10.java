package DSA100Days;

public class Day10 {
    public static void main(String[] args) {

        int[] heights={1,2,3,4,5};
//        23)Max area in the container
        System.out.println(maxArea(heights));

//        24) Check the isSubsequence()

//        System.out.println( isSubsequence("ABBACD","ACSBBSACD"));

    }

    public static int maxArea(int[] height) {


        int i = 0;

        int j = height.length - 1;

        int area = 0;

        while (i < j) {

            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));

            if (height[i] > height[j]) {

                j--;

            } else {

                i++;

            }

        }
        return area;

    }

    public static int myMaxAreaMethod(int[] height) {

        int area=0,max=0,count=1;

        for (int i = 0; i < height.length; i++) {
            count=1;
            for (int j = i+1; j < height.length; j++) {

                area=Math.min(height[i], height[j])*count++;
                if(area>max){
                    max=area;
                }

            }

        }
        return max;

    }

    public static String isSubsequence(String str1, String str2) {
        int index=0;
        int count=0;
        for (int i = 0; i < str1.length() && index<str2.length()  ; i++) {



            if(str1.charAt(i)==str2.charAt(index)){
                count++;
                index++;
            }
            else{

                index++;
                i--;
            }

            if(count==str1.length())	{
                return "True";
            }
        }



        return "False";
    }
}
