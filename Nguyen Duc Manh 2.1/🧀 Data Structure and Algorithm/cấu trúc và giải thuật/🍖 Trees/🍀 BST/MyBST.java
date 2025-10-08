
public class MyBST {
    private MyNode root;

    public MyBST() {
        this.root = null;
    }

    // Chèn một nút mới vào cây BST
    public void insertNode(int value) {
        root = insertNodeRecursively(root, value);
    }

    private MyNode insertNodeRecursively(MyNode node, int value) {
        if (node == null) {
            return new MyNode(value);
        }

        if (value < node.value) {
            // Chèn vào cây con bên trái
            node.left = insertNodeRecursively(node.left, value);
        } else if (value > node.value) {
            // Chèn vào cây con bên phải
            node.right = insertNodeRecursively(node.right, value);
        }
        // Nếu giá trị đã tồn tại, không làm gì (không cho phép trùng lặp)
        return node;
    }

    ///
    ///
    ///
    ///
    // Chèn một nút mới vào gốc của cây
    public void insertAtRoot(int value) {
        MyNode newRoot = new MyNode(value);
        if (root != null) {
            // Chèn lại cây cũ vào cây mới
            newRoot.left = root;
        }
        root = newRoot; // Cập nhật gốc mới
    }

    ///
    ///
    ///
    ///
    ///
    // Phương thức để in cây (duyệt in-order)
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println(); // Xuống dòng sau khi in xong
    }

    private void inOrderTraversal(MyNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(" '(" + node.value + ")' ");
            inOrderTraversal(node.right);
        }
    }

    ///
    ///
    ///
    ///
    ///
    // Phương thức để in cây (duyệt pre-order)
    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println(); // Xuống dòng sau khi in xong
    }

    private void preOrderTraversal(MyNode node) {
        if (node != null) {
            System.out.print(" '(" + node.value + ")' ");
            preOrderTraversal(node.left); // Duyệt cây con bên trái
            preOrderTraversal(node.right); // Duyệt cây con bên phải
        }
    }

    ///
    ///
    ///
    ///
    // Phương thức để in cây (duyệt post-order)
    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println(); // Xuống dòng sau khi in xong
    }

    private void postOrderTraversal(MyNode node) {
        if (node != null) {
            postOrderTraversal(node.left); // Duyệt cây con bên trái
            postOrderTraversal(node.right); // Duyệt cây con bên phải
            System.out.print(" '(" + node.value + ")' ");
        }
    }

    // Tìm kiếm xem một nút nào đó có tồn tại trong cây hay không
    public boolean search(int value) {
        return searchRecursively(root, value);
    }

    private boolean searchRecursively(MyNode node, int value) {
        if (node == null) {
            return false; // Giá trị không tồn tại
        }
        if (value == node.value) {
            return true; // Giá trị đã tìm thấy
        }
        if (value < node.value) {
            return searchRecursively(node.left, value); // Tìm trong cây con bên trái
        } else {
            return searchRecursively(node.right, value); // Tìm trong cây con bên phải
        }
    }

    ///
    ///
    ///
    ///
    // Xóa một nút trong cây BST
    public void deleteNode(int value) {
        root = deleteNodeRecursively(root, value);
    }

    private MyNode deleteNodeRecursively(MyNode node, int value) {
        if (node == null) {
            return null; // Giá trị không tồn tại trong cây
        }

        if (value < node.value) {
            // Nếu giá trị cần xóa nhỏ hơn giá trị của nút hiện tại, tìm ở cây con bên trái
            node.left = deleteNodeRecursively(node.left, value);
        } else if (value > node.value) {
            // Nếu giá trị cần xóa lớn hơn giá trị của nút hiện tại, tìm ở cây con bên phải
            node.right = deleteNodeRecursively(node.right, value);
        } else {
            // Nút cần xóa đã được tìm thấy
            // Trường hợp 1: Nút không có con
            if (node.left == null && node.right == null) {
                return null; // Xóa nút
            }
            // Trường hợp 2: Nút có một con
            if (node.left == null) {
                return node.right; // Thay thế bằng con bên phải
            }
            if (node.right == null) {
                return node.left; // Thay thế bằng con bên trái
            }
            // Trường hợp 3: Nút có hai con
            // Tìm nút nhỏ nhất trong cây con bên phải
            MyNode smallestNode = findMin(node.right);
            node.value = smallestNode.value; // Sao chép giá trị của nút nhỏ nhất vào nút hiện tại
            node.right = deleteNodeRecursively(node.right, smallestNode.value); // Xóa nút nhỏ nhất
        }
        return node; // Trả về nút hiện tại
    }

    ///
    ///
    ///
    ///
    // Tìm nút nhỏ nhất trong cây
    public MyNode findMin() {
        if (root == null) {
            return null; // Nếu cây rỗng, trả về null
        }
        return findMin(root);
    }

    private MyNode findMin(MyNode node) {
        while (node.left != null) {
            node = node.left; // Đi đến nút bên trái cùng
        }
        return node; // Trả về nút nhỏ nhất
    }

    ///
    ///
    ///
    ///
    // Tính độ sâu tối đa của cây
    public int getMaxDepth() {
        return getMaxDepth(root);
    }

    private int getMaxDepth(MyNode node) {
        if (node == null) {
            return 0; // Nếu nút là null, độ sâu là 0
        }

        // Tính độ sâu của cây con bên trái và bên phải
        int leftDepth = getMaxDepth(node.left);
        int rightDepth = getMaxDepth(node.right);

        // Độ sâu tối đa là 1 (cho nút hiện tại) cộng với độ sâu lớn hơn giữa hai cây
        // con
        return Math.max(leftDepth, rightDepth) + 1;
    }
    ///
    ///
    ///
    ///

}