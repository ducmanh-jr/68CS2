// Thuật toán sắp xếp lựa chọn tìm giá trị thấp nhất trong mảng và di chuyển nó lên đầu mảng.
// The Selection Sort algorithm finds the lowest value in an array and moves it to the front of the array.

public class SelectionSort {
    public static void main(String[] args) {
        int[] myArray = { 4, 0, 1, 4, 2, 3, 7, 8, 10 };
        int n = myArray.length;
        for (int i = 0; i < n; i++) { // duyệt từng giá trị chạy từ 0 đến 8
            int min = i; // các giá trị tăng dần
            for (int j = i + 1; j < n; j++) { // j là phần từ lần lượt tăng 1 lần sau mỗi vòng for
                if (myArray[j] < myArray[min]) { // nếu giá trị tại vị trí j nh�� hơn giá trị tại vị trí min
                    min = j; // cập nhật giá trị min
                }
            }
            int a = myArray[i]; // a
            myArray[i] = myArray[min]; // di chuyển giá trị thấp nhất đến vị trí i
            myArray[min] = a; // di chuyển giá trị thấp nhất về vị trí min
        }
        // In ra mảng đã được sắp xếp
        for (int i = 0; i < n; i++) {
            System.out.print(myArray[i] + " ");

        }
        System.out.println();

    }
}
// Cách thức hoạt động: How it works:
//
// Duyệt qua mảng để tìm giá trị thấp nhất. Go through the array to find the
// lowest value.
// Di chuyển giá trị thấp nhất lên phía trước phần chưa được sắp xếp của mảng.
// Move the lowest value to the front of the unsorted part of the array.
// Duyệt lại mảng một lần nữa theo số lần có giá trị trong mảng. Go through the
// array again as many times as there are values in the array.

// độ phức tạp của thuật toán selection sort
/*
 * Thuật toán Selection Sort có thời gian phức tạp là:
 * 
 * O(n x2)
 * Trong đó, n là số lượng tử trong mảng cần sắp xếp.
 * 
 * Nguyên nhân chính dẫn đến mức độ phức tạp này là thuật toán phải lặp qua mảng
 * để tìm phần tử nhỏ nhất (hoặc lớn nhất) trong mỗi vòng lặp
 * và điều này được thực hiện lần, dẫn đến phép so sánh tổng số được phép
 * n(n-1)/2, tương thích với O(n^2).
 * 
 * Độ phức tạp của vùng lựa chọn Sắp xếp là O(1) vì thuật toán này thực hiện sắp
 * xếp tại chỗ (tại chỗ) và không cần thêm bộ nhớ để lưu trữ các
 * phần tử khác ngoài biến tạm thời để thay đổi.
 * 
 * Sắp xếp lựa chọn thường không được sử dụng trong thực tế cho các mảng lớn có
 * hiệu suất thấp hơn so với các cách sắp xếp thuật toán khác như
 * Sắp xếp nhanh hoặc Sắp xếp hợp nhất. Tuy nhiên, nó có thể hữu ích trong các
 * vấn đề mà bộ nhớ có giới hạn hoặc khi mảng nhỏ.
 */