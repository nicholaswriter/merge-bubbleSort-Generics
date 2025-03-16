import java.util.Random;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] new_array = createRandomArray(10);
        Integer[] array_clone_1 = new_array.clone();
        Integer[] array_clone_2 = new_array.clone();
        System.out.println("The original array is: " + Arrays.toString(new_array));

        bubbleSort(array_clone_1);
        System.out.println("The bubble sorted array is: " + Arrays.toString(array_clone_1));

        mergeSort(array_clone_2, 0, array_clone_2.length - 1);
        System.out.println("The merge sorted array is: " + Arrays.toString(array_clone_2));
    }

    public static Integer[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        Integer[] my_array = new Integer[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            my_array[i] = rand.nextInt(101);
        }
        return my_array;
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int a = array.length;
        for (int i = 0; i < a-1; i++) {
            for (int j = 0; j < a - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T value = array[j];
                    array[j] = array[j+1];
                    array[j+1] = value;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void merge(T[] array, int p, int q, int r) {
    
        T[] L = Arrays.copyOfRange(array, p, q + 1);
        T[] R = Arrays.copyOfRange(array, q + 1, r + 1);
    
        int i = 0;
        int j = 0;
        int k = p;
    
        while (i < L.length && j < R.length) {
          if (L[i].compareTo(R[j]) <= 0) {
            array[k] = L[i];
            i++;
          } else {
            array[k] = R[j];
            j++;
          }
          k++;
        }
    
        while (i < L.length) {
          array[k] = L[i];
          i++;
          k++;
        }
    
        while (j < R.length) {
          array[k] = R[j];
          j++;
          k++;
        }
      }

    public static <T extends Comparable <T>> void mergeSort (T[] array, int left, int right) {
        if (left< right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right); 
        }
    }
}