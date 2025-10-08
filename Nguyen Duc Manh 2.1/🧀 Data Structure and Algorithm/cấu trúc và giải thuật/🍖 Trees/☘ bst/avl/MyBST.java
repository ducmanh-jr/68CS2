package avl;

public class MyBST {
    public MyNode root;

    public MyBST() {
        root = null;
    }

    // Hàm trả về chiều cao của nút
    private int height(MyNode node) {
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

    // Cập nhật chiều cao của nút
    private void updateHeight(MyNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    // Lấy độ cân bằng của nút
    private int getBalance(MyNode node) {
        if (node == null) {
            return 0;
        } else {
            return height(node.right) - height(node.left);
        }
    }

    // Chèn nút mới vào cây BST
    public void insertNode(int value) {
        root = _insertNode(root, value);
    }

    private MyNode _insertNode(MyNode root, int value) {
        if (root == null) {
            return new MyNode(value);
        }
        // Cây đã tồn tại nút root
        if (value < root.value) {
            // Chèn nút mới vào cây con bên trái
            root.left = _insertNode(root.left, value);
        }
        if (value > root.value) {
            root.right = _insertNode(root.right, value);
        }
        return reBalance(root);
    }

    private MyNode reBalance(MyNode node) {
        updateHeight(node);
        // Lấy hệ số cân bằng
        int balance = getBalance(node);
        if (balance > 1) { // Lệch phải
            // Xác định xem cây lệch về bên phải
            // Nếu lệch hoàn toàn bên phải -> xoay trái cây
            if (height(node.right.right) > height(node.right.left)) {
                // Hoàn toàn lệch phải
                // Xoay trái.
                node = _rotateLeft(node);
            } else {
                // Xoay phải
                node.right = _rotateRight(node.right);
                // Xoay trái
                node = _rotateLeft(node);
            }
        } else if (balance < -1) { // Lệch trái
            if (height(node.left.left) > height(node.left.right)) {
                // Xoay phải
                node = _rotateRight(node);
            } else {
                // Xoay trái (cho nút 50 theo ví dụ)
                node.left = _rotateLeft(node.left);
                // Xoay phải.
                node = _rotateRight(node);
            }
        }
        return node;
    }

    // Xoay trái
    private MyNode _rotateLeft(MyNode y) {
        MyNode x = y.right;
        MyNode z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    // Xoay phải
    private MyNode _rotateRight(MyNode y) {
        MyNode x = y.left;
        MyNode z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    // Duyệt cây theo thứ tự in-order
    public void inOrder() {
        _inOrder(root);
    }

    private void _inOrder(MyNode current) {
        if (current != null) {
            _inOrder(current.left);
            System.out.print(current.value + " ");
            _inOrder(current.right);
        }
    }
}