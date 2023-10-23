package DSA100Days;

public class Day11 {
    public static void main(String[] args) {

        int[] arr={3,2,1,9,5};


////        25) InsertionSorting   sort with the nearest element
//        insertionSort(arr.length,arr);
//        for (int i:
//             arr) {
//            System.out.println(i);
//        }
//
////        26)Selection Sorting->  select the lowest element index and sort it
//       selectionSort(arr, arr.length);


//           27)Bubble Sort

    }


    public static void bubbleSort(int[] arr, int n) {
        int temp=0;

        for (int i = 0; i < arr.length; i++) {
            boolean swap=false;

            for (int j = 0; j < arr.length-i-1; j++) {

                if(arr[j+1]<arr[j]){

                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;

                    swap=true;
                }
            }

            if(!swap){
                break;
            }
        }

    }

    public static void insertionSort(int n , int[] arr) {
        int temp=0;

        for (int i = 0; i < n-1; i++) {

            for (int j = i+1; j >0; j--) {

                if (arr[j]<arr[j-1]) {

                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;

                    continue;

                }

                break;



            }
        }
    }
    public static void selectionSort(int arr[], int n) {
        int temp=0;
        for (int i = 0; i < n-1; i++) {
            int minIndex=i;
            boolean swap=false;
            for (int index = i+1; index < n ; index++) {

                if(arr[index]<arr[minIndex]){
                    swap=true;
                    minIndex=index;
                }
            }
            if(swap){
                temp=arr[minIndex];
                arr[minIndex]=arr[i];
                arr[i]=temp;
            }
        }
    }
}
