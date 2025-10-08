
package csfit;
public class MyBST {
    public MyNode root;

    public MyBST() {
        root = null;
    }

    // chèn nút mới vào cây BST
    public void insertNode(int value) {
        root = _insertNodeUsingLoop(root, value);
    }

    private MyNode _insertNode(MyNode root, int value) {
        if (root == null) {
            return new MyNode(value);
        }
        // cây đã tồn tại nút root
        if (value < root.value) {
            // chèn nút mới vào cây con bên trái
            root.left = _insertNode(root.left, value);
        }
        if (value > root.value) {
            root.right = _insertNode(root.right, value);
        }
        return root;
    }

    // chèn một nút mới vào gốc của cây
    private MyNode _insertNodeUsingLoop(MyNode root, int value) {
        MyNode newNode = new MyNode(value);
        if (root == null) {
            return newNode;
        } else {
            MyNode temp = root;
            while (true) {
                if (value < temp.value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = newNode;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
        return root;
    }

    public boolean searchNode(int value) {
        // Tìm kiếm xem một nút nào đó có tồn tại trong cây hay không
        return _searchNode(root, value);
    }

    private boolean _searchNode(MyNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        } else if (value < current.value) {
            return _searchNode(current.left, value);
        } else {
            return _searchNode(current.right, value);
        }
    }

    // duyệt cây theo thứ tự in-order
    public void inOrder() {
        _inOrderWithoutRecursion(root);
    }

    private void _inOrder(MyNode current) {
        if (current != null) {
            _inOrder(current.left);
            System.out.print(current.value + " ");
            _inOrder(current.right);
        }
    }

    private void _inOrderWithoutRecursion(MyNode root) {
        // khai báo stack để lưu các nút đã duyệt qua
        Stack<MyNode> stack = new Stack<>();
        MyNode current = root;
        while (current != null || !stack.isEmpty()) {
            // code here
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            MyNode top = stack.pop();
            System.out.print(top.value + " ");
            current = top.right;
        }
    }

    // BTVN
    // duyệt theo pre-order
    public void preOrder() {
        _preOrder(root);
    }

    private void _preOrder(MyNode current) {
        if (current != null) {
            System.out.print(current.value + " ");
            _preOrder(current.left);
            _preOrder(current.right);
        }
    }

    // duyệt theo post-order
    public void postOrder() {
        _postOrder(root);
    }

    private void _postOrder(MyNode current) {
        if (current != null) {
            _postOrder(current.left);
            _postOrder(current.right);
            System.out.print(current.value + " ");
        }
    }

    // xóa một nút
    public void deleteNode(int value) {
        root = _deleteNode(root, value);
    }

    private MyNode _deleteNode(MyNode current, int value) {
        // code
        if (current == null) {
            return null;
        }
        if (value < current.value) {
            current.left = _deleteNode(current.left, value);
            return current;
        } else if (value > current.value) {
            current.right = _deleteNode(current.right, value);
            return current;
        } else {
            // tìm được nút cần xóa
            // value == current.value
            // TH1. Nút cần xóa là chính nút này
            if (current.left == null && current.right == null) {
                return null;
            }
            // TH2: Nút cần xóa có cây con trái hoặc cây con phải.
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // TH3. Nút cần xóa có cả cây con trái và phải
            // B1. Tìm nút trái cùng cây con phải
            MyNode smallestNode = _findSmallestNode(current.right);
            // B2. Thay nút cần xóa bằng nút trái cùng
            current.value = smallestNode.value;
            // B3. Xóa nút trái cùng đi.
            current.right = _deleteNode(current.right, smallestNode.value);
            return current;
        }
    }

    private MyNode _findSmallestNode(MyNode node) {
        if (node.left == null) {
            return node;
        } else {
            return _findSmallestNode(node.left);
        }
    }

    // duyệt theo breadth first search
    public void breadthFirstSearch() {
        if (root != null) {
            // khai báo hàng đợi
            Queue<MyNode> listNodes = new LinkedList<>();
            listNodes.add(root);
            while (!listNodes.isEmpty()) {
                MyNode current = listNodes.remove();
                System.out.print(current.value + " ");
                if (current.left != null) {
                    listNodes.add(current.left);
                }
                if (current.right != null) {
                    listNodes.add(current.right);
                }
            }
        }
    }

    // lấy độ sâu tối đa
    public int maxDepth() {
        return _maxDepth(root);
    }

    private int _maxDepth(MyNode current) {
        if (current == null) {
            return -1;
        } else {
            int leftDepth = _maxDepth(current.left);
            int rightDepth = _maxDepth(current.right);
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
    }
}
