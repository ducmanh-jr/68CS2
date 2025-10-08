// hello đang là 1 buổi tối nghe nhạc ăn cháo và ch bị xem bóng ( tối thứ bảy của tôi)

// bubble sort là 1 thuật toán sắp sếp một mảng từ giá trị thấp đến giá trị cao 
// thuật toán này hoạt động bằng cách so sánh các phần tử trong mảng và hoán đổi
// Từ 'Bong bóng' xuất phát từ cách thức hoạt động của thuật toán này, nó làm cho các giá trị cao nhất 'nổi lên'.

// Cách thức hoạt động:
// - Duyệt qua mảng, từng giá trị một.
// - Với mỗi giá trị, hãy so sánh giá trị đó với giá trị tiếp theo.
// - Nếu giá trị này cao hơn giá trị tiếp theo, hãy hoán đổi các giá trị sao cho giá trị cao nhất sẽ đứng cuối cùng.
// - Duyệt qua mảng nhiều lần bằng số giá trị có trong mảng.

public class BubbleSort {

    public static void main(String[] args) {
        // Khởi tạo mảng cần sắp xếp
        int[] my_array = { 7, 3, 9, 12, 11 };
        int n = my_array.length; // Lấy độ dài của mảng

        // Vòng lặp bên ngoài để kiểm soát số lần duyệt qua mảng
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Biến để kiểm tra xem có hoán đổi nào xảy ra trong vòng lặp này không

            // Vòng lặp bên trong để so sánh các phần tử
            for (int j = 0; j < n - i - 1; j++) {
                // So sánh phần tử hiện tại với phần tử tiếp theo
                if (my_array[j] > my_array[j + 1]) {
                    // Nếu phần tử hiện tại lớn hơn phần tử tiếp theo, hoán đổi chúng
                    int temp = my_array[j]; // Lưu giá trị của phần tử hiện tại vào biến tạm
                    my_array[j] = my_array[j + 1]; // Gán giá trị của phần tử tiếp theo cho phần tử hiện tại
                    my_array[j + 1] = temp; // Gán giá trị tạm vào phần tử tiếp theo
                    swapped = true; // Đánh dấu rằng đã có hoán đổi xảy ra
                }
            }

            // Nếu không có hoán đổi nào xảy ra, mảng đã được sắp xếp, có thể dừng lại
            if (!swapped) {
                break; // Thoát khỏi vòng lặp nếu không còn hoán đổi nào
            }
        }

        // In ra mảng đã được sắp xếp
        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(my_array[i] + " "); // In từng phần tử của mảng
        }
        System.out.println(); // Xuống dòng sau khi in xong
    }
}
// Độ phức tạp trong thời gian :
// - Trường hợp tốt nhất : O(n) - Khi danh sách đã được sắp xếp, thuật toán chỉ
// cần một lần duyệt qua danh sách để xác định rằng không có bất kỳ thay đổi
// nào.
// - Trường hợp trung bình : O(n^2) - Trong hầu hết các trường hợp, thuật toán
// sẽ phải thực hiện nhiều lần so sánh và thay đổi.
// - Trường hợp xấu nhất : O(n^2) - Khi danh sách được sắp xếp ngược, thuật toán
// sẽ phải thực hiện tối đa số lần so sánh và thay đổi.
// Độ phức tạp không gian :
// - O(1) - Bubble Sort là thuật toán sắp xếp tại chỗ, nghĩa là nó không yêu cầu
// thêm bộ nhớ để lưu trữ dữ liệu, chỉ cần một biến tạm thời để thay đổi.

// Độ phức tạp thời gian của Bubble Sort
// Thuật toán sắp xếp bong bóng đi qua một mảng N giá trị N - 1 lần trong
// trườnghợp xấu nhất.
// Lần đầu tiên thuật toán chạy qua mảng, mọi giá trị được so sánh với giá trị
// tiếp theo và hoán đổi các giá trị
// nếu giá trị bên trái lớn hơn giá trị bên phải. Điều này có nghĩa là giá trị
// cao nhất nổi lên và phần chưa sắp xếp của mảng trở nên ngắn hơn cho đến khi
// việc sắp xếp hoàn tất.
