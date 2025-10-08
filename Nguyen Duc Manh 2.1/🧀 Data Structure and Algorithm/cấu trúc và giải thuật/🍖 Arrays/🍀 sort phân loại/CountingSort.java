/*
 * Đếm Sắp xếp
Thuật toán sắp xếp đếm sẽ sắp xếp một mảng bằng cách đếm số lần xuất hiện của mỗi giá trị.
 */

public class CountingSort {
    public static void countingSort(int[] arr) {
        int max_val = arr[0];
        for (int num : arr) {
            if (num > max_val) {
                max_val = num;
            }
        }

        int[] count = new int[max_val + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max_val; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 3, 3, 1, 6, 5, 2, 3 };
        countingSort(arr);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
/*
 * O(n + k), trong đó:
 * 𝑛
 * n là số lượng phần tử trong danh sách cần sắp xếp.
 * 𝑘
 * k là giá trị lớn nhất trong dãy (hoặc phạm vi giá trị của các phần tử).
 * Vì thuật toán chỉ cần đếm số lần xuất hiện của từng giá trị và sử dụng các
 * giá trị đó để tái tạo lại dãy sắp xếp, độ phức tạp chủ yếu bị chi phối bởi
 * 𝑛
 * n và
 * 𝑘
 * k. Nếu
 * 𝑘
 * k là một hằng số nhỏ so với
 * 𝑛
 * n, độ phức tạp có thể coi là O(n).
 * 
 * Trường hợp tốt nhất, trung bình và xấu nhất:
 * 
 * O(n + k) cho tất cả các trường hợp, vì thuật toán không phụ thuộc vào thứ tự
 * của các phần tử trong dãy đầu vào. Thuật toán sẽ luôn thực hiện các bước như
 * đếm tần suất và tái tạo mảng sắp xếp, không bị ảnh hưởng bởi cách sắp xếp ban
 * đầu của dữ liệu.
 */