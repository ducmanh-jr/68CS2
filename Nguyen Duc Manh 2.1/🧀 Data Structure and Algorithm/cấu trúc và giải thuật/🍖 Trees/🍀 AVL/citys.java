
class citys {
    // Class Node representing a node in the AVL tree
    class Node {
        String city; // City name
        double tax; // Tax value
        Node left, right; // Pointers to left and right child nodes
        int height; // Height of the node

        public Node(String city, double tax) {
            this.city = city;
            this.tax = tax;
            left = right = null;
            height = 1; // Initial height is 1
        }
    }

    Node root; // Root of the tree

    // Constructor to initialize the AVL tree
    citys() {
        root = null;
    }

    // Function to insert and balance the tree
    void insert(String city, double tax) { // insert
        root = insertNode(root, city, tax);
    }

    Node insertNode(Node node, String city, double tax) {
        // Step 1: Perform normal BST insertion
        if (node == null) {
            return new Node(city, tax); // If tree is empty, create a new node
        }

        if (tax < node.tax) {
            node.left = insertNode(node.left, city, tax);
        } else if (tax > node.tax) {
            node.right = insertNode(node.right, city, tax);
        } else {
            return node; // If it already exists, do not insert
        }

        // Step 2: Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Step 3: Check balance and perform rotations if needed
        int balance = getBalance(node);

        // Tree is unbalanced, there are 4 cases

        // Case 1: Left Left
        if (balance > 1 && tax < node.left.tax) {
            return rotateRight(node);
        }

        // Case 2: Right Right
        if (balance < -1 && tax > node.right.tax) {
            return rotateLeft(node);
        }

        // Case 3: Left Right
        if (balance > 1 && tax > node.left.tax) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Case 4: Right Left
        if (balance < -1 && tax < node.right.tax) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Return the balanced node
    }

    // Function to perform right rotation
    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // Return new root after rotation
    }

    // Function to perform left rotation
    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // Return new root after rotation
    }

    // Function to get the height of the tree
    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Function to get the balance factor of a node
    int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Function to delete a node
    void delete(double tax) {
        root = deleteNode(root, tax);
    }

    Node deleteNode(Node node, double tax) {
        // Step 1: Perform normal BST deletion
        if (node == null) {
            return node;
        }

        // Find the node to be deleted
        if (tax < node.tax) {
            node.left = deleteNode(node.left, tax);
        } else if (tax > node.tax) {
            node.right = deleteNode(node.right, tax);
        } else {
            // Node to be deleted found

            // Case 1: Node with one child (or no child)
            if (node.left == null) {
                return node.right; // If no left child, replace with right child
            } else if (node.right == null) {
                return node.left; // If no right child, replace with left child
            }

            // Case 2: Node with two children
            // Find the smallest value in the right subtree
            node.tax = minValue(node.right);

            // Delete the smallest value in the right subtree
            node.right = deleteNode(node.right, node.tax);
        }

        // Step 2: Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Step 3: Check balance and perform rotations if needed
        int balance = getBalance(node);

        // Tree is unbalanced, there are 4 cases

        // Case 1: Left Left
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Case 2: Right Right
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Case 3: Left Right
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Case 4: Right Left
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Return the balanced node
    }

    // Function to find the minimum value in the tree
    double minValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.tax;
    }

    // Function to traverse the tree in-order
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(" '" + node.city + " + " + node.tax + " billion' ");
            inorderRec(node.right);
        }
    }

    // Function to print the tree structure
    void printTree(Node root, String prefix, boolean isRight) {
        if (root != null) {
            printTree(root.right, prefix + (isRight ? "       " : " |      "), true); // Print right
            System.out.println(prefix + (isRight ? " /--_ " : " \\--_ ") + root.city + " + " + root.tax + " billion"); // Print
                                                                                                                       // node
            printTree(root.left, prefix + (isRight ? " |      " : "        "), false); // Print left
        }
    }

    // Method to print the tree
    void printTree() {
        printTree(root, "", false);
    }

    // Method to calculate the execution time of the search method
    void calculateSearchTime(String city) {
        long startTime = System.nanoTime();
        search(city);
        long endTime = System.nanoTime();
        double durationInSeconds = ((endTime - startTime) / 1_000_000_000.0) * 1_000;
        System.out.println("Search time for " + city + ": " + durationInSeconds + " milliseconds");
    }

    // Method to search for a city
    Node search(String city) {
        return searchNode(root, city);
    }

    Node searchNode(Node node, String city) {
        if (node == null || node.city.equals(city)) {
            return node;
        }
        if (city.compareTo(node.city) < 0) {
            return searchNode(node.left, city);
        }
        return searchNode(node.right, city);
    }

    // Main program to test the above methods
    public static void main(String[] args) {
        citys tree = new citys();

        // Adding cities and their tax values
        tree.insert("Tokyo", 0.99);
        tree.insert("New York", 0.85);
        tree.insert("Los Angeles", 0.75);
        tree.insert("London", 0.65);
        tree.insert("Paris", 0.60);
        tree.insert("Shanghai", 0.55);
        tree.insert("Beijing", 0.50);
        tree.insert("Moscow", 0.45);
        tree.insert("Dubai", 0.40);
        tree.insert("Singapore", 0.35);
        tree.insert("Hong Kong", 0.30);
        tree.insert("Berlin", 0.25);
        tree.insert("Madrid", 0.20);
        tree.insert("Toronto", 0.15);
        tree.insert("São Paulo", 0.10);
        tree.insert("Mexico City", 0.05);
        tree.insert("Istanbul", 0.04);
        tree.insert("Bangkok", 0.03);
        tree.insert("Kuala Lumpur", 0.02);
        tree.insert("Lagos", 0.01);
        tree.insert("Cairo", 0.005);

        System.out.println("Warning...");
        System.out.print("In-order: ");
        tree.inorder();
        System.out.println();
        System.out.println("Loading...");
        tree.printTree();
        tree.calculateSearchTime("Manchester City");
        tree.calculateSearchTime("Manchester City");
        tree.calculateSearchTime("Manchester City");
        tree.calculateSearchTime("Manchester City");
        tree.calculateSearchTime("Manchester City");

    }
}
