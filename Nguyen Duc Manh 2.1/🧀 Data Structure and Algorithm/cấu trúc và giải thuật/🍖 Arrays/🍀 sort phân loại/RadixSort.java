/*
 * Sắp xếp theo cơ số
 * Thuật toán Radix Sort sắp xếp một mảng theo từng chữ số riêng lẻ, bắt đầu từ
 * chữ số ít quan trọng nhất (chữ số ngoài cùng bên phải).
 */

public class RadixSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void radixSortWithBubbleSort(int[] arr) {
        int maxVal = arr[0];
        for (int num : arr) {
            if (num > maxVal)
                maxVal = num;
        }

        int exp = 1;
        while (maxVal / exp > 0) {
            int[][] radixArray = new int[10][arr.length];
            int[] count = new int[10];

            for (int num : arr) {
                int radixIndex = (num / exp) % 10;
                radixArray[radixIndex][count[radixIndex]++] = num;
            }

            for (int i = 0; i < 10; i++) {
                int[] tempArray = new int[count[i]];
                System.arraycopy(radixArray[i], 0, tempArray, 0, count[i]);
                bubbleSort(tempArray);
                System.arraycopy(tempArray, 0, radixArray[i], 0, count[i]);
            }

            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    arr[index++] = radixArray[i][j];
                }
            }

            exp *= 10;
        }
    }

    public static void main(String[] args) {
        int[] myArray = { 170, 45, 75, 90, 802, 24, 2, 66 };
        System.out.print("Original array: ");
        for (int num : myArray)
            System.out.print(num + " ");
        System.out.println();

        radixSortWithBubbleSort(myArray);

        System.out.print("Sorted array: ");
        for (int num : myArray)
            System.out.print(num + " ");
        System.out.println();
    }
}

/*
 * 
 * 
 * Sắp xếp theo cơ số (Radix Sort) là một thuật toán sắp xếp không so sánh, sử
 * dụng các đặc tính của số học để sắp xếp các phần tử theo từng chữ số của
 * chúng. Thuật toán này hoạt động hiệu quả khi các phần tử có độ dài cố định
 * hoặc không quá lớn, đặc biệt khi các giá trị trong dãy cần sắp xếp là các số
 * nguyên.
 * 
 * Độ phức tạp của Sắp xếp theo cơ số:
 * Sắp xếp theo cơ số sử dụng một thuật toán phụ gọi là sắp xếp đếm (Counting
 * Sort) để sắp xếp các phần tử theo từng chữ số. Vì vậy, độ phức tạp của Radix
 * Sort phụ thuộc vào số lượng chữ số của các phần tử và cách thức sắp xếp các
 * chữ số.
 * 
 * Độ phức tạp thời gian của Radix Sort:
 * Độ phức tạp trong mỗi bước sắp xếp chữ số:
 * 
 * O(n + k), trong đó:
 * 𝑛
 * n là số lượng phần tử cần sắp xếp.
 * 𝑘
 * k là phạm vi giá trị của mỗi chữ số (tức là giá trị lớn nhất có thể có của
 * một chữ số, ví dụ với các số thập phân,
 * 𝑘
 * =
 * 10
 * k=10).
 * Độ phức tạp tổng cộng:
 * 
 * Radix Sort thực hiện d bước (với
 * 𝑑
 * d là số chữ số tối đa của phần tử lớn nhất trong dãy).
 * Độ phức tạp tổng cộng của Radix Sort là O(d \cdot (n + k)).
 * Tổng kết:
 * Độ phức tạp thời gian: O(d \cdot (n + k))
 * 𝑑
 * d là số chữ số tối đa của phần tử (tức là độ dài của các số trong cơ sở số mà
 * bạn đang sử dụng, ví dụ: số thập phân có thể có
 * 𝑑
 * d chữ số).
 * 𝑛
 * n là số lượng phần tử trong dãy.
 * 𝑘
 * k là phạm vi giá trị của mỗi chữ số (thường là 10 cho hệ thập phân, 256 cho
 * các ký tự ASCII, v.v.).
 * Độ phức tạp không gian:
 * O(n + k), vì Radix Sort yêu cầu không gian bộ nhớ để lưu trữ các mảng phụ như
 * mảng đếm (được sử dụng trong Counting Sort).
 */