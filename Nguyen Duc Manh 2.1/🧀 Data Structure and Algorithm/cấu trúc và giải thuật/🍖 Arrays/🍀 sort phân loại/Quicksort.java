/*
 * Sắp xếp nhanh
 * Đúng như tên gọi, Quicksort là một trong những thuật toán sắp xếp nhanh nhất.
 * 
 * Thuật toán Quicksort lấy một mảng giá trị, chọn một trong các giá trị làm
 * phần tử
 * 'trục' và di chuyển các giá trị khác sao cho các giá trị thấp hơn nằm ở bên
 * trái phần
 * tử trục và các giá trị cao hơn nằm ở bên phải phần tử trục.
 */

public class Quicksort {
    public static void main(String[] args) {
        int[] myArray = { 64, 34, 25, 12, 22, 11, 90, 5 };
        quicksort(myArray, 0, myArray.length - 1);

        System.out.print("Sorted array: ");
        for (int value : myArray) {
            System.out.print(value + " ");
        }
    }

    public static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

/*
 * Trường hợp tốt nhất (Best case):
 * 
 * Trường hợp này xảy ra khi thuật toán luôn chia danh sách thành hai phần bằng
 * nhau hoặc gần bằng nhau (pivot chia đều danh sách thành hai phần).
 * Độ phức tạp trong trường hợp này là O(n log n), trong đó
 * 𝑛
 * n là số phần tử trong danh sách.
 * Trường hợp trung bình (Average case):
 * 
 * Trong trường hợp trung bình, thuật toán cũng chia danh sách thành các phần
 * gần bằng nhau (mặc dù không hoàn toàn đều đặn như trong trường hợp tốt nhất).
 * Độ phức tạp trong trường hợp trung bình vẫn là O(n log n).
 * Trường hợp xấu nhất (Worst case):
 * 
 * Trường hợp này xảy ra khi thuật toán không chia được danh sách thành các phần
 * tương đối đều, ví dụ khi ta chọn pivot luôn là phần tử lớn nhất hoặc nhỏ
 * nhất, dẫn đến một trong các phân đoạn luôn có độ dài bằng
 * 𝑛
 * −
 * 1
 * n−1.
 * Khi đó, thuật toán sẽ phải thực hiện nhiều lần phân tách gần như liền kề với
 * một dãy đã được sắp xếp (hoặc gần như sắp xếp), khiến độ phức tạp trở thành
 * O(n²).
 */