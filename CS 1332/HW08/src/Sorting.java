import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;
import java.util.PriorityQueue;
/**
 * Your implementation of various sorting algorithms.
 *
 * @author Owen Huggins
 * @version 1.0
 * @userid Ohuggins3
 * @GTID 903591787
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class Sorting {

    /**
     * Implement insertion sort.
     * <p>
     * It should be:
     * in-place
     * stable
     * adaptive
     * <p>
     * Have a worst case running time of:
     * O(n^2)
     * <p>
     * And a best case running time of:
     * O(n)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("The array and the comparator cannot be null");
        } else {
            for (int n = 1; n <= arr.length - 1; n++) {
                int i = n;
                while (!(arr[i].equals(arr[0])) && comparator.compare(arr[i], arr[i - 1]) < 0) {
                    swap(i, i - 1, arr);
                    i--;
                }
            }
        }

    }

    /**
     * A helper method to swap two indexes
     *
     * @param <T>  data type to sort
     * @param arr  the array that must be sorted after the method runs
     * @param idx1 the first data to swap
     * @param idx2 the second data to swap
     */

    private static <T> void swap(int idx1, int idx2, T[] arr) {
        T copy = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = copy;
    }

    /**
     * Implement cocktail sort.
     * <p>
     * It should be:
     * in-place
     * stable
     * adaptive
     * <p>
     * Have a worst case running time of:
     * O(n^2)
     * <p>
     * And a best case running time of:
     * O(n)
     * <p>
     * NOTE: See pdf for last swapped optimization for cocktail sort. You
     * MUST implement cocktail sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("The array and the comparator cannot be null");
        } else {
            boolean swapsMade = true;
            int startIdx = 0;
            int endIdx = arr.length - 1;
            while (swapsMade) {
                swapsMade = false;
                int endReference = arr.length - 1;
                for (int i = startIdx; i < endIdx; i++) {
                    if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                        swap(i, i + 1, arr);
                        swapsMade = true;
                        endReference = i;
                    }
                }
                endIdx = endReference;
                if (swapsMade) {
                    swapsMade = false;
                    int startReference = 0;
                    for (int i = endIdx; i > startIdx; i--) {
                        if (comparator.compare(arr[i - 1], arr[i]) > 0) {
                            swap(i - 1, i, arr);
                            swapsMade = true;
                            startReference = i;
                        }
                    }
                    startIdx = startReference;
                }
            }

        }

    }

    /**
     * Implement merge sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of:
     * O(n log n)
     * <p>
     * And a best case running time of:
     * O(n log n)
     * <p>
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     * <p>
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     * <p>
     * Hint: If two data are equal when merging, think about which subarray
     * you should pull from first
     *
     * @param <T>        data type to sort
     * @param arr        the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("The array and the comparator cannot be null");
        } else {
            if (arr.length > 1) {
                int length = arr.length;
                int midIndex = length / 2;
                T[] left = (T[]) new Object[midIndex];
                T[] right = (T[]) new Object[arr.length - midIndex];
                for (int i = 0; i < left.length; i++) {
                    left[i] = arr[i];
                }
                for (int i = 0; i < right.length; i++) {
                    right[i] = arr[i + left.length];
                }
                mergeSort(left, comparator);
                mergeSort(right, comparator);
                mergeTogether(arr, comparator, left, right);
            }
        }

    }
    /**
     * A helper method to merge two arrays together
     *
     * @param arr the array to be sorted
     * @param comparator comparator used to compare values
     * @param left left array
     * @param right right Array
     * @param <T> data type to sort
     */

    private static <T> void mergeTogether(T[] arr, Comparator<T> comparator, T[] left, T[] right) {
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                arr[i + j] = left[i];
                i++;
            } else {
                arr[i + j] = right[j];
                j++;
            }
        }
        while (i < left.length) {
            arr[i + j] = left[i];
            i++;
        }
        while (j < right.length) {
            arr[i + j] = right[j];
            j++;
        }

    }

    /**
     * Implement quick sort.
     * <p>
     * Use the provided random object to select your pivots. For example if you
     * need a pivot between a (inclusive) and b (exclusive) where b > a, use
     * the following code:
     * <p>
     * int pivotIndex = rand.nextInt(b - a) + a;
     * <p>
     * If your recursion uses an inclusive b instead of an exclusive one,
     * the formula changes by adding 1 to the nextInt() call:
     * <p>
     * int pivotIndex = rand.nextInt(b - a + 1) + a;
     * <p>
     * It should be:
     * in-place
     * unstable
     * not adaptive
     * <p>
     * Have a worst case running time of:
     * O(n^2)
     * <p>
     * And a best case running time of:
     * O(n log n)
     * <p>
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not receive
     * credit if you do not use the one we have taught you!
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand       the Random object used to select pivots
     * @throws java.lang.IllegalArgumentException if the array or comparator or
     *                                            rand is null
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                     Random rand) {
        if (arr == null || comparator == null || rand == null) {
            throw new java.lang.IllegalArgumentException("The array, comparator, and rand cannot be null");
        } else {
            quickSortHelper1(arr, comparator, rand, 0, arr.length - 1);

        }
    }

    /**
     * A helper method for quickSort that allows for the range of the array
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand       the Random object used to select pivots
     * @param startIndex the initial index
     * @param endIndex the finial index
     */

    private static <T> void quickSortHelper1(T[] arr, Comparator<T> comparator,
                                             Random rand, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int pivotIndex = quickSortHelper2(arr, comparator, (rand.nextInt(endIndex - startIndex) + startIndex),
                    startIndex, endIndex);
            quickSortHelper1(arr, comparator, rand, startIndex, pivotIndex - 1);
            quickSortHelper1(arr, comparator, rand, pivotIndex + 1, endIndex);
            if (comparator.compare(arr[0], arr[1]) > 0) {
                swap(0, 1, arr);
            }
        }
    }



    /**
     * A helper method for quickSort that implements the recursion
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param pivotIndex a random index for the quickSort Method
     * @param startIndex the initial index
     * @param endIndex the finial index
     * @return the pivot index in the quick sort method
     */

    private static <T> int quickSortHelper2(T[] arr, Comparator<T> comparator,
                                            int pivotIndex, int startIndex, int endIndex) {

        T pivotVal = arr[pivotIndex];
        swap(startIndex, pivotIndex, arr);

        int i = startIndex + 1;
        int j = endIndex;
        while (i < j) {
            while (i <= j && comparator.compare(arr[i], pivotVal) <= 0) {
                i++;
            }
            while (i <= j && comparator.compare(arr[j], pivotVal) >= 0) {
                j--;
            }
            if (i <= j) {
                swap(i, j, arr);
                i++;
                j--;
            }
        }
        swap(startIndex, j, arr);
        return j;

    }

    /**
     * Implement LSD (least significant digit) radix sort.
     * <p>
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     * <p>
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of:
     * O(kn)
     * <p>
     * And a best case running time of:
     * O(kn)
     * <p>
     * You are allowed to make an initial O(n) passthrough of the array to
     * determine the number of iterations you need. The number of iterations
     * can be determined using the number with the largest magnitude.
     * <p>
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     * <p>
     * Refer to the PDF for more information on LSD Radix Sort.
     * <p>
     * You may use ArrayList or LinkedList if you wish, but it may only be
     * used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with other sorts. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     * <p>
     * Do NOT use anything from the Math class except Math.abs().
     *
     * @param arr the array to be sorted
     * @throws java.lang.IllegalArgumentException if the array is null
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new java.lang.IllegalArgumentException("The array cannot be null");
        }
        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                int copy = arr[0];
                arr[0] = arr[1];
                arr[1] = copy;
            }
        } else {
            LinkedList<Integer>[] buckets = new LinkedList[19];
            for (int i = 0; i < 19; i++) {
                buckets[i] = new LinkedList<>();
            }
            int largestNumber = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                if (largestNumber < Math.abs(arr[i + 1])) {
                    largestNumber = arr[i + 1];
                }
            }
            int k = counterHelper(largestNumber);
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < arr.length; j++) {
                    int digit = calculateDigit(arr[j], i);
                    if (buckets[digit % 10 + 9] == null) {
                        buckets[digit % 10 + 9] = new LinkedList<>();
                    }
                    buckets[digit % 10 + 9].add(arr[j]);
                }
                int idx = 0;
                for (LinkedList<Integer> bucket : buckets) {
                    if (bucket != null) {
                        for (int removed : bucket) {
                            arr[idx++] = removed;
                        }
                        bucket.clear();
                    }
                }
            }

        }
    }

    /**
     * A helper method to calculate the correct mod of the number
     *
     * @param data  the data in the array that we will calculate the digits of
     * @param digit the digit place that we are finding
     * @return the amount of digits in the number
     */
    private static int calculateDigit(int data, int digit) {
        int digitsInNumber = counterHelper(data);
        if (digitsInNumber < digit) {
            return 0;
        } else {
            int data1 = data % 10;
            if (digitsInNumber == digit) {
                data1 = data / 10;
            }
            return data1;
        }
    }

    /**
     * A helper method to calculate the number of digits in a number
     *
     * @param data  the data in the array that we will calculate the digits of
     * @return the amount of digits in the number
     */

    private static int counterHelper(int data) {
        int digits = 0;
        int number = data;
        while (number != 0) {
            number = number / 10;
            digits++;
        }
        return digits;
    }

    /**
     * Implement heap sort.
     * <p>
     * It should be:
     * out-of-place
     * unstable
     * not adaptive
     * <p>
     * Have a worst case running time of:
     * O(n log n)
     * <p>
     * And a best case running time of:
     * O(n log n)
     * <p>
     * Use java.util.PriorityQueue as the heap. Note that in this
     * PriorityQueue implementation, elements are removed from smallest
     * element to largest element.
     * <p>
     * Initialize the PriorityQueue using its build heap constructor (look at
     * the different constructors of java.util.PriorityQueue).
     * <p>
     * Return an int array with a capacity equal to the size of the list. The
     * returned array should have the elements in the list in sorted order.
     *
     * @param data the data to sort
     * @return the array with length equal to the size of the input list that
     * holds the elements from the list is sorted order
     * @throws java.lang.IllegalArgumentException if the data is null
     */
    public static int[] heapSort(List<Integer> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data can't be null!");
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(data);
        int[] sortedList = new int[data.size()];
        int counter = 0;
        while (!(pq.isEmpty())) {
            sortedList[counter] = pq.poll();
            counter++;
        }
        return sortedList;
    }
}


