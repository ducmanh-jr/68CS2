public class binaryTreeArray {
    public static void main(String[] args) {
        // Khởi tạo mảng để lưu trữ cây nhị phân
        Character[] binaryTreeArray = {
                'R', 'A', 'B', 'C', 'D', 'E', 'F', null, null, null, null, null, null, 'G'
        };

        // Tính chỉ số của nút con phải của nút gốc
        int rightChild = rightChildIndex(0);
        // Tính chỉ số của nút con trái của nút con phải
        int leftChildOfRightChild = leftChildIndex(rightChild);
        // Lấy dữ liệu của nút tại chỉ số đó
        Character data = getData(binaryTreeArray, leftChildOfRightChild);

        // In ra kết quả
        System.out.println("root.right.left.data: " + data);
    }

    // Phương thức để tính chỉ số của nút con trái
    public static int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Phương thức để tính chỉ số của nút con phải
    public static int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Phương thức để lấy dữ liệu của nút tại chỉ số cho trước
    public static Character getData(Character[] binaryTreeArray, int index) {
        if (index >= 0 && index < binaryTreeArray.length) {
            return binaryTreeArray[index];
        }
        return null; // Trả về null nếu chỉ số không hợp lệ
    }
}