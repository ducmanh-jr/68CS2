public class array {
    public static void main(String[] args) {
        int[] my_array = { 7, 12, 3, 9, 4, 1, 11 };// khai báo 1 mảng gồm 5 phần tử
        int minVal = my_array[0]; // truy cập phần tử đầu tiên

        for (int i : my_array) { // vòng lặp for-each chạy tất cả các giá trị trong mảng
            if (i < minVal) { // tìm giá trị nào nhỏ hơn phần tử đầu tiên tìm thấy thì lấy
                minVal = i;
            }
        }

        System.out.println("Lowest value: " + minVal);
    }
}

// mảng là 1 cấu trúc dữ liệu được sử dụng nhiều nhất
// mảng được sử dụng trong nhiều thuật toán
// Mảng được lập chỉ mục, nghĩa là mỗi phần tử trong mảng có một chỉ mục, một
// con số cho biết vị trí của phần tử trong mảng

/*
 * Dưới đây là thuật toán tìm số nhỏ nhất trong một mảng.
 * 
 * Cách thức hoạt động:
 * -Duyệt qua các giá trị trong mảng từng cái một.
 * -Kiểm tra xem giá trị hiện tại có phải là giá trị thấp nhất từ ​​trước đến
 * nay hay không và nếu có thì lưu lại.
 * -Sau khi xem xét tất cả các giá trị, giá trị được lưu trữ sẽ là giá trị thấp
 * nhất trong mảng.
 */
/**
 * Thực hiện
 * Trước khi triển khai thuật toán bằng ngôn ngữ lập trình thực tế, thường thì
 * nên viết thuật toán theo trình tự từng bước.
 * 
 * Nếu bạn có thể viết thuật toán bằng ngôn ngữ nằm giữa ngôn ngữ con người và
 * ngôn ngữ lập trình, thuật toán sẽ dễ triển khai hơn sau này vì chúng ta tránh
 * được việc chìm đắm trong các chi tiết của cú pháp ngôn ngữ lập trình.
 * 
 * Tạo một biến 'minVal' và đặt nó bằng giá trị đầu tiên của mảng.
 * Duyệt qua mọi phần tử trong mảng.
 * Nếu phần tử hiện tại có giá trị thấp hơn 'minVal', hãy cập nhật 'minVal'
 * thành giá trị này.
 * Sau khi xem xét tất cả các phần tử trong mảng, biến 'minVal' hiện chứa giá
 * trị thấp nhất.
 * Bạn cũng có thể viết thuật toán theo cách trông giống ngôn ngữ lập trình hơn
 * 
 * nếu muốn, như thế này:
 * Variable 'minVal' = array[0]
 * For each element in the array
 * If current element < minVal
 * minVal = current element
 */
/*
 * Độ phức tạp thời gian của thuật toán values(n)
 * Thời gian chạy
 * Khi tìm hiểu các thuật toán, chúng ta thường xem xét thời gian chạy của một
 * thuật toán so với kích thước của tập dữ liệu.
 * 
 * Trong ví dụ trên, thời gian thuật toán cần chạy tỷ lệ thuận hoặc tuyến tính
 * với kích thước của tập dữ liệu. Điều này là do thuật toán phải truy cập mọi
 * phần tử mảng một lần để tìm giá trị thấp nhất. Vòng lặp phải chạy 5 lần vì có
 * 5 giá trị trong mảng. Và nếu mảng có 1000 giá trị, vòng lặp sẽ phải chạy 1000
 * lần.
 * 
 * Hãy thử mô phỏng bên dưới để xem mối quan hệ giữa số phép so sánh cần thiết
 * để tìm giá trị thấp nhất và kích thước của mảng.
 * 
 * Xem trang này để biết giải thích chi tiết hơn về độ phức tạp của thời gian.
 * 
 * Mỗi thuật toán trong hướng dẫn này sẽ được trình bày cùng với độ phức tạp về
 * thời gian của thuật toán đó.
 */