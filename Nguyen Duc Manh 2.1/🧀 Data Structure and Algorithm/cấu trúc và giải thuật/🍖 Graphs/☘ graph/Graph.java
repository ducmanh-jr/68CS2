import java.util.*; // Nhập khẩu thư viện java.util cho các cấu trúc dữ liệu như List, Queue, v.v.

public class Graph {
    private int numVertices; // Biến lưu số lượng các đỉnh trong đồ thị
    private List<List<Integer>> adjacencyList; // Danh sách kề, lưu trữ các đỉnh và các cạnh nối giữa chúng

    // Constructor để khởi tạo đồ thị
    public Graph(int numVertices) {
        this.numVertices = numVertices; // Khởi tạo số lượng đỉnh trong đồ thị
        adjacencyList = new ArrayList<>(numVertices); // Khởi tạo danh sách kề với kích thước ban đầu là số lượng đỉnh

        // Khởi tạo danh sách kề cho mỗi đỉnh trong đồ thị
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new LinkedList<>()); // Mỗi đỉnh sẽ có một danh sách kề trống
        }
    }

    // Phương thức thêm một cạnh nối giữa hai đỉnh
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination); // Thêm đỉnh đích vào danh sách kề của đỉnh nguồn
        adjacencyList.get(destination).add(source); // Đối với đồ thị vô hướng, thêm đỉnh nguồn vào danh sách kề của
                                                    // đỉnh đích
    }

    // Phương thức tìm kiếm theo chiều rộng (BFS) bắt đầu từ một đỉnh nguồn
    public void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[numVertices]; // Mảng boolean lưu trữ trạng thái của các đỉnh (đã thăm hay chưa)

        Queue<Integer> queue = new LinkedList<>(); // Khởi tạo một hàng đợi (Queue) để lưu trữ các đỉnh cần thăm

        visited[startVertex] = true; // Đánh dấu đỉnh nguồn là đã thăm
        queue.add(startVertex); // Đưa đỉnh nguồn vào hàng đợi

        System.out.print("BFS Traversal starting from vertex " + startVertex + ": "); // In ra thông báo bắt đầu BFS

        // Lặp qua tất cả các đỉnh trong hàng đợi
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll(); // Lấy đỉnh đầu tiên trong hàng đợi ra để thăm
            System.out.print(currentVertex + " "); // In ra đỉnh hiện tại

            // Duyệt qua tất cả các đỉnh kề của đỉnh hiện tại
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) { // Nếu đỉnh kề chưa được thăm
                    visited[neighbor] = true; // Đánh dấu đỉnh kề là đã thăm
                    queue.add(neighbor); // Đưa đỉnh kề vào hàng đợi để thăm tiếp
                }
            }
        }
        System.out.println(); // Xuống dòng sau khi kết thúc việc in ra tất cả các đỉnh
    }

    // Phương thức để hiển thị đồ thị
    public void printGraph() {
        // Duyệt qua tất cả các đỉnh trong đồ thị
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " is connected to: "); // In ra đỉnh i và danh sách các đỉnh mà nó kết nối
            // Duyệt qua danh sách kề của đỉnh i
            for (Integer v : adjacencyList.get(i)) {
                System.out.print(v + " "); // In ra các đỉnh kề với đỉnh i
            }
            System.out.println(); // Xuống dòng sau khi in xong danh sách các đỉnh kề
        }
    }

    public static void main(String[] args) {
        // Mô tả mạng xã hội gồm 5 người dùng (tức là 5 đỉnh trong đồ thị)
        Graph graph = new Graph(5); // Khởi tạo đồ thị với 5 đỉnh

        // Thêm các cạnh vào đồ thị, tương ứng với các mối quan hệ bạn bè trong mạng xã
        // hội
        graph.addEdge(0, 1); // Người 0 kết bạn với người 1
        graph.addEdge(0, 4); // Người 0 kết bạn với người 4
        graph.addEdge(1, 2); // Người 1 kết bạn với người 2
        graph.addEdge(1, 3); // Người 1 kết bạn với người 3
        graph.addEdge(1, 4); // Người 1 kết bạn với người 4
        graph.addEdge(2, 3); // Người 2 kết bạn với người 3
        graph.addEdge(3, 4); // Người 3 kết bạn với người 4

        // Hiển thị đồ thị
        graph.printGraph(); // In ra danh sách kề của đồ thị

        // Thực hiện tìm kiếm theo chiều rộng (BFS) bắt đầu từ đỉnh 0
        // graph.breadthFirstSearch(0); // Gọi phương thức BFS (đã được comment lại)
    }
}
