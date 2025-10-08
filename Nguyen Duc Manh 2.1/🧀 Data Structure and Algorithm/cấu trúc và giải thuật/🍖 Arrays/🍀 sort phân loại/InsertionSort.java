// Sắp xếp chèn
// Thuật toán này lấy một giá trị tại một thời điểm từ phần chưa được 
//   sắp xếp của mảng và đặt nó vào đúng vị trí trong phần đã được sắp xếp của mảng, cho đến khi mảng được sắp xếp.

public class InsertionSort {
    public static void main(String[] args) {
        int[] myArray = { 64, 34, 25, 12, 22, 11, 90, 5 };

        int n = myArray.length;
        for (int i = 1; i < n; i++) {
            int insertIndex = i;
            int currentValue = myArray[i];
            int j = i - 1;

            while (j >= 0 && myArray[j] > currentValue) {
                myArray[j + 1] = myArray[j];
                insertIndex = j;
                j--;
            }
            myArray[insertIndex] = currentValue;
        }

        System.out.print("Sorted array: ");
        for (int value : myArray) {
            System.out.print(value + " ");
        }
    }
}

/*
 * Trường hợp tốt nhất (Best case):
 * 
 * Khi danh sách đã được sắp xếp sẵn (tức là mỗi phần tử đã ở vị trí đúng của
 * nó).
 * Trong trường hợp này, thuật toán chỉ cần so sánh mỗi phần tử với phần tử liền
 * kề và không cần thực hiện thao tác dịch chuyển.
 * Độ phức tạp là O(n), trong đó
 * 𝑛
 * n là số lượng phần tử.
 * Trường hợp trung bình (Average case):
 * 
 * Khi các phần tử trong danh sách không được sắp xếp hoàn hảo nhưng không quá
 * hỗn loạn.
 * Trong trường hợp này, thuật toán sẽ thực hiện một số thao tác dịch chuyển và
 * so sánh, nhưng không quá nhiều.
 * Độ phức tạp là O(n²), trong đó
 * 𝑛
 * n là số lượng phần tử.
 * Trường hợp xấu nhất (Worst case):
 * 
 * Khi danh sách được sắp xếp ngược lại hoàn toàn, tức là các phần tử phải được
 * dịch chuyển hết về đầu danh sách.
 * Trong trường hợp này, thuật toán sẽ phải so sánh và dịch chuyển mỗi phần tử
 * đến vị trí thích hợp của nó.
 * Độ phức tạp là O(n²).
 */