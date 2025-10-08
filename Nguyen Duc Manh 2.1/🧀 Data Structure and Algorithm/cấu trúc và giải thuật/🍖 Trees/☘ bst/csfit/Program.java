package csfit;
public class Program {
    public static void main(String[] args) {
        MyBST myBST = new MyBST();
        myBST.insertNode(8);
        myBST.insertNode(3);
        myBST.insertNode(10);
        myBST.insertNode(1);
        myBST.insertNode(6);
        myBST.insertNode(4);
        myBST.insertNode(7);
        myBST.insertNode(14);
        myBST.insertNode(13);

        // System.out.println("Tim so 13: " + myBST.searchNode(13));
        // System.out.println("Cay truoc khi xoa");
        // myBST.inOrder();
        // myBST.deleteNode(3);
        // System.out.println();
        // System.out.println("Cay sau khi xoa node 4");
        // myBST.inOrder();
        // myBST.traversalBreadthFirst();
        // System.out.println("Max depth of the tree: "+ myBST.maxDepth());
        // System.out.println("Traversal tree using Breadth first search:");
        // myBST.breadthFirstSearch();
        // System.out.println("Max depth: " + myBST.maxDepth());

        /*
         * // chèn 1 nút mới vào cây
         * myBST.insertNode(9);
         * // in ra cây
         * myBST.inOrder();
         * 
         * // chèn 1 nút mới vào gốc của cây
         * myBST.insertNodeAtRoot(5);
         * // in ra cây
         * myBST.inOrder();
         * 
         * // xóa 1 nút từ cây
         * myBST.deleteNode(10);
         * // in ra cây
         * myBST.inOrder();
         * 
         * // tìm nút có giá trị nh�� nhất
         * myBST.findMin();
         */
        myBST.breadthFirstSearch(); // in ra cây theo BFS
        myBST.deleteNode(1); // delete
        myBST.equals(myBST); // equals
        myBST.inOrder(); // in ra cây theo inOrder

    }

}
