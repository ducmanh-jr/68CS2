
class AVLTree {
    // Lớp Node đại diện cho một nút trong cây AVL
    class Node {
        int key; // Giá trị của nút
        Node left, right; // Con trỏ đến các nút con bên trái và bên phải
        int height; // Chiều cao của nút

        public Node(int item) {
            key = item;
            left = right = null;
            height = 1; // Chiều cao ban đầu là 1
        }
    }

    Node root; // Gốc của cây

    // Constructor khởi tạo cây AVL
    AVLTree() {
        root = null;
    }

    // Hàm chèn tự động cân bằng
    void insert(int key) { // chèn
        root = insertNode(root, key);
    }

    Node insertNode(Node node, int key) {
        // Bước 1: Thực hiện chèn như một cây tìm kiếm nhị phân bình thường
        if (node == null) {
            return new Node(key); // Nếu cây rỗng, tạo một nút mới
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else {
            return node; // Nếu đã tồn tại, không chèn nữa
        }

        // Bước 2: Cập nhật chiều cao của nút hiện tại
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Bước 3: Kiểm tra sự mất cân bằng và thực hiện quay nếu cần
        int balance = getBalance(node);

        // Cây bị mất cân bằng, có thể có 4 trường hợp

        // Trường hợp 1: Cây bị mất cân bằng bên trái - Trái trái
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        // Trường hợp 2: Cây bị mất cân bằng bên phải - Phải phải
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        // Trường hợp 3: Cây bị mất cân bằng bên trái - Phải trái
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Trường hợp 4: Cây bị mất cân bằng bên phải - Trái phải
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Trả về nút đã được cân bằng
    }

    // Hàm quay sang phải
    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Thực hiện quay
        x.right = y;
        y.left = T2;

        // Cập nhật chiều cao
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // Trả về nút mới là gốc sau khi quay
    }

    // Hàm quay sang trái
    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Thực hiện quay
        y.left = x;
        x.right = T2;

        // Cập nhật chiều cao
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // Trả về nút mới là gốc sau khi quay
    }

    // Hàm lấy chiều cao của cây
    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Hàm lấy độ lệch của một nút
    int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Hàm xóa
    void delete(int key) {
        root = deleteNode(root, key);
    }

    Node deleteNode(Node node, int key) {
        // Bước 1: Thực hiện xóa như trong cây tìm kiếm nhị phân
        if (node == null) {
            return node;
        }

        // Tìm nút cần xóa
        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            // Nút cần xóa tìm thấy

            // Trường hợp 1: Nút chỉ có một con (hoặc không có con)
            if (node.left == null) {
                return node.right; // Nếu không có con trái, thì thay bằng con phải
            } else if (node.right == null) {
                return node.left; // Nếu không có con phải, thì thay bằng con trái
            }

            // Trường hợp 2: Nút có hai con
            // Tìm giá trị nhỏ nhất trong cây con bên phải
            node.key = minValue(node.right);

            // Xóa giá trị nhỏ nhất trong cây con bên phải
            node.right = deleteNode(node.right, node.key);
        }

        // Bước 2: Cập nhật chiều cao của nút hiện tại
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Bước 3: Kiểm tra sự mất cân bằng và thực hiện quay nếu cần
        int balance = getBalance(node);

        // Cây bị mất cân bằng, có thể có 4 trường hợp

        // Trường hợp 1: Cây bị mất cân bằng bên trái - Trái trái
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Trường hợp 2: Cây bị mất cân bằng bên phải - Phải phải
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Trường hợp 3: Cây bị mất cân bằng bên trái - Phải trái
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Trường hợp 4: Cây bị mất cân bằng bên phải - Trái phải
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Trả về nút đã được cân bằng
    }

    // Hàm tìm giá trị nhỏ nhất trong cây
    int minValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    // Hàm hỗ trợ duyệt cây theo thứ tự inorder và in mỗi 5 giá trị xuống dòng
    void inorder() {
        inorderRec(root, 0);
    }

    void inorderRec(Node node, int count) {
        if (node != null) {
            inorderRec(node.left, count);
            System.out.print(" '" + node.key + "' ");
            count++;
            if (count % 5 == 0) {
                System.out.println(); // Xuống dòng sau mỗi 5 giá trị
            }
            inorderRec(node.right, count);
        }
    }

    // Hàm in cây theo cấu trúc dạng cây nhị phân (in ngang)
    void printTree(Node root, String prefix, boolean isRight) {
        if (root != null) {
            printTree(root.right, prefix + (isRight ? "       " : " |      "), true); // In bên phải
            System.out.println(prefix + (isRight ? " /--_ " : " \\--_ ") + root.key); // In nút
            printTree(root.left, prefix + (isRight ? " |      " : "        "), false); // In bên trái
        }
    }

    // Phương thức in cây
    void printTree() {
        printTree(root, "", false);
    }

    // Chương trình chính để thử nghiệm các phương thức trên
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Thêm các giá trị vào cây
        tree.insert(47);
        tree.insert(8);
        tree.insert(1);
        tree.insert(14);
        tree.insert(45);
        tree.insert(3);
        tree.insert(19);
        tree.insert(6);
        tree.insert(9);
        tree.insert(13);
        tree.insert(12);
        tree.insert(16);
        tree.insert(14);
        tree.insert(40);
        tree.insert(7);
        tree.insert(43);
        tree.insert(15);
        tree.insert(17);
        tree.insert(20);
        tree.insert(18);
        tree.insert(10);
        tree.insert(7);
        tree.insert(11);
        tree.insert(8);
        /*
         * System.out.println("warning...");
         * System.out.print("in-order: ");
         * tree.inorder();
         * System.out.println();
         */
        System.out.println("loading...");
        System.out.println("initiating hack...");
        tree.printTree();
        /*
         * 
         * System.out.println("warning...");
         * tree.insert(10);
         * System.out.println("\n\nSau khi them 10:");
         * System.out.print("in-order: ");
         * tree.inorder();
         * System.out.println();
         * System.out.println("loading...");
         * tree.printTree();
         */
        /*
         * System.out.println("warning...");
         * tree.delete(11);
         * System.out.println("Sau khi xoa 11:");
         * System.out.print("in-order: ");
         * tree.inorder();
         * System.out.println();
         * System.out.println("loading...");
         * tree.printTree();
         */
    }
}
