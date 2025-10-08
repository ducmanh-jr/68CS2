/*
 * Sắp xếp hợp nhất
 * Thuật toán sắp xếp trộn là thuật toán chia để trị, sắp xếp một mảng bằng cách
 * đầu tiên chia nhỏ mảng thành các mảng nhỏ hơn, sau đó xây dựng lại mảng đó
 * theo đúng cách để có thể sắp xếp.
 */

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        double[] unsortedArr = { 3, 7, 6, -10, 15, 23.5, 55, -13 };
        double[] sortedArr = mergeSort(unsortedArr);
        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
    }

    public static double[] mergeSort(double[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        double[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
        double[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

        double[] sortedLeft = mergeSort(leftHalf);
        double[] sortedRight = mergeSort(rightHalf);

        return merge(sortedLeft, sortedRight);
    }

    public static double[] merge(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}

/*
 * 
 * Độ phức tạp thời gian:
 * 
 * Trường hợp tốt nhất, trung bình và xấu nhất:
 * Độ phức tạp thời gian của thuật toán sắp xếp hợp nhất là O(n log n) trong mọi
 * trường hợp (dù là trường hợp tốt nhất, trung bình hay xấu nhất).
 * Điều này là vì:
 * Thuật toán chia dãy liên tục cho đến khi các phần tử trở thành các danh sách
 * con đơn lẻ, và mỗi lần chia đều có độ phức tạp là O(log n).
 * Sau khi chia, thuật toán thực hiện quá trình hợp nhất (merge) các danh sách
 * nhỏ lại với nhau. Mỗi lần hợp nhất hai danh sách có độ dài tổng cộng
 * 𝑛
 * n, và thực hiện hợp nhất cho tất cả các phần tử có độ phức tạp là O(n).
 * Vì vậy, tổng độ phức tạp sẽ là O(n log n).
 */