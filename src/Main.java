import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void quicksort(int[] arr, int left, int right) {

        if(left < right){
            int p = partition(arr, left, right);
            quicksort(arr, left, p -1);
            quicksort(arr, p + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right){

        int pivot = arr[right];
        int i = left -1;

        for (int j = left; j < right; j++){
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = new int[50];
        Random rand = new Random();

        for (int i = 0; i< arr.length; i++){
            arr[i] = rand.nextInt(100);
        }

        System.out.println("Before sorting: ");
        System.out.println(Arrays.toString(arr));

        quicksort(arr, 0, arr.length - 1);

        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(arr));
    }
}