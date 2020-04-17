// Java program for implementation of QuickSort
import java.util.*;


class QuickSort
{
    public QuickSort(){

    }
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

    // Driver program
    public static void main(String args[])
    {
        QuickSort q = new QuickSort();

        int sizeArray = 5000;
        int[] arr = new int[sizeArray];

        for (int i = 0; i < sizeArray; i++) {
          arr[i] = (getRandomNumberInRange(1,1000));
        }
        System.out.println("Unsorted: ");
        q.printArray(arr);
        double start = System.nanoTime();

        System.out.println("Sorted: ");
        q.sort(arr, 0, arr.length-1);
        q.printArray(arr);

        double finish = System.nanoTime();
        double t = (finish - start) / 1000000000;
        System.out.print(t);
        System.out.println(" seconds");
        }
    }

/*This code is contributed by Rajat Mishra */
