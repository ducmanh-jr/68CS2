public class BinarySearchTree {

    // Định nghĩa lớp TreeNode, đại diện cho một nút trong cây nhị phân
    public static class TreeNode {
        int data; // Giá trị của nút
        TreeNode left; // Con trỏ đến nút con bên trái
        TreeNode right; // Con trỏ đến nút con bên phải

        // Constructor để khởi tạo nút với giá trị data
        TreeNode(int data) {
            this.data = data; // Gán giá trị cho nút
            this.left = null; // Khởi tạo con trỏ trái là null
            this.right = null; // Khởi tạo con trỏ phải là null
        }
    }

    // Phương thức duyệt cây theo thứ tự in-order
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) { // Nếu nút là null thì không làm gì cả
            return;
        }
        inOrderTraversal(node.left); // Duyệt cây con bên trái
        System.out.print(node.data + ", "); // In giá trị của nút hiện tại
        inOrderTraversal(node.right); // Duyệt cây con bên phải
    }

    // Phương thức tìm nút có giá trị nhỏ nhất trong cây
    public static TreeNode minValueNode(TreeNode node) {
        TreeNode current = node; // Khởi tạo biến current với nút đầu vào
        while (current.left != null) { // Tiếp tục đi sang trái cho đến khi không còn nút trái
            current = current.left; // Cập nhật current sang nút trái
        }
        return current; // Trả về nút có giá trị nhỏ nhất
    }

    // Phương thức xóa một nút trong cây
    public static TreeNode delete(TreeNode node, int data) {
        if (node == null) { // Nếu nút là null, trả về null
            return null;
        }

        if (data < node.data) { // Nếu giá trị cần xóa nhỏ hơn giá trị nút hiện tại
            node.left = delete(node.left, data); // Tiếp tục tìm và xóa trong cây con bên trái
        } else if (data > node.data) { // Nếu giá trị cần xóa lớn hơn giá trị nút hiện tại
            node.right = delete(node.right, data); // Tiếp tục tìm và xóa trong cây con bên phải
        } else {
            // Nếu nút cần xóa có một hoặc không có con
            if (node.left == null) { // Nếu không có con bên trái
                return node.right; // Trả về con bên phải
            } else if (node.right == null) { // Nếu không có con bên phải
                return node.left; // Trả về con bên trái
            }

            // Nếu nút cần xóa có hai con: Lấy giá trị của nút kế tiếp theo thứ tự
            node.data = minValueNode(node.right).data; // Gán giá trị của nút kế tiếp vào nút hiện tại
            node.right = delete(node.right, node.data); // Xóa nút kế tiếp
        }
        return node; // Trả về nút đã được cập nhật
    }

    public static void main(String[] args) {
        // Tạo cây nhị phân với các nút
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(19);
        root.right.right.left = new TreeNode(18);

        // Duyệt cây và in ra các giá trị
        inOrderTraversal(root);
        System.out.println(); // Tạo một dòng mới

        // Xóa nút có giá trị 15
        delete(root, 15);

        // Duyệt cây và in ra các giá trị sau khi xóa
        inOrderTraversal(root);
    }
}