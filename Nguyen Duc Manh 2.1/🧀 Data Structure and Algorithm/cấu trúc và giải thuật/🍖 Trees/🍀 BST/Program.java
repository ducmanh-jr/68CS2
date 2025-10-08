public class Program {
    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.insertNode(5);
        bst.insertNode(3);
        bst.insertNode(7);
        bst.insertNode(2);
        bst.insertNode(4);
        bst.insertNode(6);
        bst.insertNode(8);
        ///
        ///
        ///
        ///
        // chen nut moi
        bst.insertNode(12);
        System.out.print("Chen 12 vao cay: ");
        bst.inOrderTraversal(); // In ra cây theo thứ tự in-order
        ///
        ///
        ///
        ///
        // xoa nut cu
        bst.deleteNode(2);
        System.out.print("Xoa 2 khoi cay: ");
        bst.inOrderTraversal(); // In ra cây theo thứ tự in-order
        ///
        ///
        ///
        ///
        // Chèn một nút mới vào gốc
        bst.insertAtRoot(10);
        System.out.print("Chen 10 vao goc:");
        bst.inOrderTraversal(); // In ra cây theo thứ tự in-order
        ///
        ///
        ///
        ///
        // duyet theo thu tu in-order
        System.out.print("Duyet cay theo in-order:");
        bst.inOrderTraversal(); // In ra cây theo thứ tự in-order
        ///
        ///
        ///
        ///
        // Duyet cay theo pre-order
        System.out.print("Duyet cay theo pre-order: ");
        bst.preOrderTraversal(); // Kết quả sẽ là: 5 3 2 4 7 6 8
        ///
        ///
        ///
        ///
        // Duyet cay theo post-order
        System.out.print("Duyet cay theo post-order: ");
        bst.postOrderTraversal(); // Kết quả sẽ là: 2 4 3 6 8 7 5
        // Tìm kiếm các giá trị trong cây
        int searchValue = 4;
        System.out.println("Tim kiem gia tri " + searchValue + ": " + bst.search(searchValue));
        searchValue = 9;
        System.out.println("Tim kiem gia tri " + searchValue + ": " + bst.search(searchValue));

        ///
        ///
        ///
        ///
        // tim nut nho nhat
        MyNode minNode = bst.findMin();
        if (minNode != null) {
            System.out.println("Nut nho nhat trong cay là: " + minNode.value); // Kết quả sẽ là: 2
        } else {
            System.out.println("");
        }
        ///
        ///
        ///
        ///
        // do sau
        int maxDepth = bst.getMaxDepth();
        System.out.println("Do sau toi da cua cay : " + maxDepth); // Kết quả sẽ là: 3 (nếu cây có chiều cao 3)
    }
}
