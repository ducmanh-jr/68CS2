
// cây tương tự danh sách liên kết ở chỗ nút có thể chúa dữ liệu và liết kết với
// phần tử tiếp theo
// cây khác với các kiểu sếp trc là nó có thẻ có nhiều nút con

// Cây là một cấu trúc dữ liệu cơ bản trong khoa học máy tính, được sử dụng để
// biểu diễn các mối quan hệ phân cấp

// Cây nhị phân: Mỗi nút có tối đa hai nút con, nút con trái và nút con phải.
// Cấu trúc này là nền tảng cho các loại cây phức tạp hơn như Cây tìm kiếm Binay
// và Cây AVL.

// Cây tìm kiếm nhị phân (BST): Một loại cây nhị phân trong đó đối với mỗi nút,
// nút con bên trái có giá trị thấp hơn và nút con bên phải có giá trị cao hơn.

// Cây AVL: Một loại cây tìm kiếm nhị phân tự cân bằng sao cho đối với mỗi nút,
// sự khác biệt về chiều cao giữa các cây con bên trái và bên phải không quá
// một. Sự cân bằng này được duy trì thông qua các phép quay khi các nút được
// chèn hoặc xóa.

///
// Lợi ích của cây nhị phân so với mảng và danh sách liên kết:
//
// Mảng nhanh khi bạn muốn truy cập trực tiếp vào một phần tử, chẳng hạn như
// phần tử số 700 trong mảng 1000 phần tử. Nhưng việc chèn và xóa các phần tử
// yêu cầu các phần tử khác phải dịch chuyển trong bộ nhớ để nhường chỗ cho phần
// tử mới hoặc thay thế các phần tử đã xóa và điều đó tốn thời gian.

// Danh sách liên kết nhanh khi chèn hoặc xóa các nút, không cần thay đổi bộ
// nhớ, nhưng để truy cập một phần tử bên trong danh sách, phải duyệt qua danh
// sách và điều đó mất thời gian.

// Cây nhị phân , chẳng hạn như Cây tìm kiếm nhị phân và Cây AVL, tuyệt vời hơn
// so với Mảng và Danh sách liên kết vì chúng ĐỀU nhanh khi truy cập vào một nút
// VÀ nhanh khi xóa hoặc chèn một nút, không cần thay đổi bộ nhớ.
///

// Ví dụ về cây nhị phân

public class trees {
    public static class Tree { // là lớp con của lớp Trees
        char data; // là dữ liệu của nút
        Tree left, right; // là các thành phần con của nút

        public Tree(char data) { // constructor
            this.data = data;
            left = right = null;
        }
    }

    public static Tree createTree(char data) { // phương thức tạo cây
        return new Tree(data); //
    }

    public static void main(String[] args) {
        Tree root = createTree('A'); // tạo cây
        root.left = createTree('B');
        root.right = createTree('C');
        root.left.left = createTree('D');
        root.left.right = createTree('E');
        root.right.left = createTree('F');
        root.right.right = createTree('G');

        // In cây theo thứ tự in-order
        System.out.println("In-order traversal:");
        printInOrder(root);
        System.out.println();

        // In cây theo thứ tự post-order
        System.out.println("Post-order traversal:");
        printPostOrder(root);
        System.out.println();
    }

    // in cây
    public static void printTree(Tree root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    // duyệt cây theo thứ tự in-order
    public static void printInOrder(Tree root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    // duyệt cây theo thứ tự post-order
    public static void printPostOrder(Tree root) {
        if (root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + " "); // sửa đổi ở đây
        }
    }
}