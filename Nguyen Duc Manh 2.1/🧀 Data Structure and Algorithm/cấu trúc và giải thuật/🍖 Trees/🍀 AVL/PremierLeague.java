class PremierLeague {
    // Class Node representing a node in the AVL tree
    class Node {
        String club; // Club name
        double value; // Value of the club
        Node left, right; // Pointers to left and right child nodes
        int height; // Height of the node

        public Node(String club, double value) {
            this.club = club;
            this.value = value;
            left = right = null;
            height = 1; // Initial height is 1
        }
    }

    Node root; // Root of the tree

    // Constructor to initialize the AVL tree
    PremierLeague() {
        root = null;
    }

    // Function to insert and balance the tree
    void insert(String club, double value) { // insert
        root = insertNode(root, club, value);
    }

    Node insertNode(Node node, String club, double value) {
        // Step 1: Perform normal BST insertion
        if (node == null) {
            return new Node(club, value); // If tree is empty, create a new node
        }

        if (value < node.value) {
            node.left = insertNode(node.left, club, value);
        } else if (value > node.value) {
            node.right = insertNode(node.right, club, value);
        } else {
            return node; // If it already exists, do not insert
        }

        // Step 2: Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Step 3: Check balance and perform rotations if needed
        int balance = getBalance(node);

        // Tree is unbalanced, there are 4 cases

        // Case 1: Left Left
        if (balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }

        // Case 2: Right Right
        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }

        // Case 3: Left Right
        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Case 4: Right Left
        if (balance < -1 && value < node.right.value) {
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
    void delete(double value) {
        root = deleteNode(root, value);
    }

    Node deleteNode(Node node, double value) {
        // Step 1: Perform normal BST deletion
        if (node == null) {
            return node;
        }

        // Find the node to be deleted
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
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
            node.value = minValue(node.right);

            // Delete the smallest value in the right subtree
            node.right = deleteNode(node.right, node.value);
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
        return current.value;
    }

    // Function to traverse the tree in-order
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(" '" + node.club + " + " + node.value + " million' ");
            inorderRec(node.right);
        }
    }

    // Function to print the tree structure
    void printTree(Node root, String prefix, boolean isRight) {
        if (root != null) {
            printTree(root.right, prefix + (isRight ? "       " : " |      "), true); // Print right
            System.out.println(prefix + (isRight ? " /--_ " : " \\--_ ") + root.club + " + " + root.value + " million"); // Print
            printTree(root.left, prefix + (isRight ? " |      " : "        "), false); // Print left
        }
    }

    // Method to print the tree
    void printTree() {
        printTree(root, "", false);
    }

    // Main program to test the above methods
    public static void main(String[] args) {
        PremierLeague tree = new PremierLeague();

        // Adding clubs and their values
        tree.insert("Manchester City", 610.0);
        tree.insert("Manchester United", 580.0);
        tree.insert("Liverpool", 540.0);
        tree.insert("Chelsea", 500.0);
        tree.insert("Tottenham Hotspur", 480.0);
        tree.insert("Arsenal", 450.0);
        tree.insert("West Ham United", 400.0);
        tree.insert("Leicester City", 390.0);
        tree.insert("Everton", 370.0);
        tree.insert("Aston Villa", 360.0);
        tree.insert("Newcastle United", 350.0);
        tree.insert("Wolverhampton Wanderers", 340.0);
        tree.insert("Southampton", 330.0);
        tree.insert("Crystal Palace", 320.0);
        tree.insert("Brighton & Hove Albion", 310.0);
        tree.insert("Burnley", 300.0);
        tree.insert("Fulham", 290.0);
        tree.insert("Sheffield United", 280.0);
        tree.insert("Bournemouth", 270.0);
        tree.insert("Nottingham Forest", 260.0);
        tree.insert("Luton Town", 250.0);

        // System.out.println("Loading...");
        // System.out.print("In-order: ");
        // tree.inorder();
        // System.out.println();
        // System.out.println("Warning...");
        System.out.println("Originate...");
        tree.printTree();
    }
}
