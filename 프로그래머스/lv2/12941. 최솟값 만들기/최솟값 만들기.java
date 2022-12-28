import java.util.Arrays;

class Solution {
   static public int solution(int[] A, int[] B) {
        int answer = 0;
        quickSort(A, 0, A.length - 1);
        quickSort(B, 0, B.length - 1);
        for (int i = 0; i < A.length; i++) answer += A[i] * B[B.length - i - 1];
        return answer;
    }

    static public void quickSort(int[] list, int left, int right) {
        if (left >= right) return;
        int pivot = list[right];
        int sortedIndex = left;
        for (int i = left; i < right; i++) {
            if (list[i] <= pivot) {
                swap(list, i, sortedIndex);
                sortedIndex++;
            }
        }
        swap(list, sortedIndex, right);
        quickSort(list, left, sortedIndex - 1);
        quickSort(list, sortedIndex + 1, right);
    }

    static public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}