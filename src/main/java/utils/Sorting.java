package utils;

import uy.edu.um.prog2.adt.exceptions.IllegalIndexException;
import uy.edu.um.prog2.adt.linkedlist.LinkedList;

public class Sorting {

    //quicksort para array de comparables
    public static void quickSort(Comparable[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(Comparable[] array, int low, int high) {
        Comparable pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                Comparable temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Comparable temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i+1);
    }


        public static void quickSort(LinkedList<Integer> list, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(list, low, high);
                quickSort(list, low, pivotIndex - 1);
                quickSort(list, pivotIndex + 1, high);
            }
        }

        public static int partition(LinkedList<Integer> list, int low, int high) {
            int pivot = list.get(high);
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (list.get(j) < pivot) {
                    i++;
                    swap(list, i, j);
                }
            }

            swap(list, i + 1, high);
            return i + 1;
        }

        public static void swap(LinkedList<Integer> list, int i, int j) {
            int temp = list.get(i);
            try {
                list.addByIndex(i, list.get(j));
                list.addByIndex(j, temp);
            } catch (IllegalIndexException e) {
                throw new RuntimeException(e);
            }
        }

        //heapsort para array de comparables
        public static void heapSort(Comparable[] array) {
            int n = array.length;
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(array, n, i);
            for (int i = n - 1; i >= 0; i--) {
                Comparable temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                heapify(array, i, 0);
            }
        }

        private static void heapify(Comparable[] array, int n, int i) {
            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < n && array[l].compareTo(array[largest]) > 0)
                largest = l;
            if (r < n && array[r].compareTo(array[largest]) > 0)
                largest = r;
            if (largest != i) {
                Comparable swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;
                heapify(array, n, largest);
            }
        }


}
