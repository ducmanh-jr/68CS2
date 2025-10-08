import java.util.*;

// Định nghĩa lớp Graph
class Graph {
    private Map<Integer, List<Integer>> adjList; // Danh sách kề của các đỉnh
    private Map<String, Integer> edgeWeights; // Trọng số của các cạnh

    // Constructor của lớp Graph
    public Graph() {
        adjList = new HashMap<>();
        edgeWeights = new HashMap<>();
    }

    // Phương thức thêm một đỉnh vào đồ thị
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Phương thức thêm một cạnh vào đồ thị (với trọng số)
    public void addEdge(int vertex1, int vertex2, int weight) {
        adjList.putIfAbsent(vertex1, new ArrayList<>());
        adjList.putIfAbsent(vertex2, new ArrayList<>());
        adjList.get(vertex1).add(vertex2);
        edgeWeights.put(vertex1 + "-" + vertex2, weight); // Lưu trọng số của cạnh
    }

    // Phương thức xóa một đỉnh khỏi đồ thị
    public void removeVertex(int vertex) {
        adjList.values().forEach(e -> e.remove(Integer.valueOf(vertex)));
        adjList.remove(vertex);
    }

    // Phương thức xóa một cạnh khỏi đồ thị
    public void removeEdge(int vertex1, int vertex2) {
        List<Integer> vertex1Neighbors = adjList.get(vertex1);
        List<Integer> vertex2Neighbors = adjList.get(vertex2);

        if (vertex1Neighbors != null)
            vertex1Neighbors.remove(Integer.valueOf(vertex2));
        if (vertex2Neighbors != null)
            vertex2Neighbors.remove(Integer.valueOf(vertex1));
        edgeWeights.remove(vertex1 + "-" + vertex2);
    }

    // Phương thức in đồ thị ra màn hình
    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (int neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Phương thức tìm kiếm theo chiều sâu (DFS)
    public void DFS(int start) {
        Set<Integer> visited = new HashSet<>();
        DFSUtil(start, visited);
    }

    private void DFSUtil(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // Phương thức tìm kiếm theo chiều rộng (BFS)
    public void BFS(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Kiểm tra vòng trong đồ thị (Cycle Detection)
    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (int vertex : adjList.keySet()) {
            if (!visited.contains(vertex)) {
                if (hasCycleUtil(vertex, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int vertex, Set<Integer> visited, Set<Integer> recursionStack) {
        visited.add(vertex);
        recursionStack.add(vertex);

        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor) && hasCycleUtil(neighbor, visited, recursionStack)) {
                return true;
            } else if (recursionStack.contains(neighbor)) {
                return true;
            }
        }

        recursionStack.remove(vertex);
        return false;
    }

    // Tìm đường đi giữa hai đỉnh (Sử dụng BFS để tìm đường đi)
    public List<Integer> findPath(int start, int end) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (vertex == end) {
                List<Integer> path = new ArrayList<>();
                while (vertex != start) {
                    path.add(vertex);
                    vertex = parentMap.get(vertex);
                }
                path.add(start);
                Collections.reverse(path); // Đảo ngược lại để có đường đi từ start đến end
                return path;
            }

            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, vertex);
                    queue.add(neighbor);
                }
            }
        }
        return null; // Trả về null nếu không tìm thấy đường đi
    }

    // Tìm đỉnh có bậc cao nhất
    public int findVertexWithHighestDegree() {
        int maxDegree = -1;
        int vertexWithHighestDegree = -1;

        for (int vertex : adjList.keySet()) {
            int degree = adjList.get(vertex).size();
            if (degree > maxDegree) {
                maxDegree = degree;
                vertexWithHighestDegree = vertex;
            }
        }
        return vertexWithHighestDegree;
    }

    // Tìm các thành phần liên thông trong đồ thị
    public List<List<Integer>> getConnectedComponents() {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> components = new ArrayList<>();

        for (int vertex : adjList.keySet()) {
            if (!visited.contains(vertex)) {
                List<Integer> component = new ArrayList<>();
                DFSForComponent(vertex, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private void DFSForComponent(int vertex, Set<Integer> visited, List<Integer> component) {
        visited.add(vertex);
        component.add(vertex);

        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                DFSForComponent(neighbor, visited, component);
            }
        }
    }

    // Tính tổng trọng số của các cạnh
    public int totalWeightOfEdges() {
        int totalWeight = 0;

        for (String edge : edgeWeights.keySet()) {
            totalWeight += edgeWeights.get(edge);
        }

        return totalWeight;
    }

    // Kiểm tra xem đồ thị có đối xứng không
    public boolean isSymmetric() {
        for (int vertex : adjList.keySet()) {
            for (int neighbor : adjList.get(vertex)) {
                // Kiểm tra xem có cạnh ngược lại hay không
                if (!adjList.getOrDefault(neighbor, new ArrayList<>()).contains(vertex)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Đếm số lượng đỉnh trong đồ thị
    public int countVertices() {
        return adjList.size();
    }

    // Đếm số lượng cạnh trong đồ thị
    public int countEdges() {
        int count = 0;
        for (List<Integer> neighbors : adjList.values()) {
            count += neighbors.size();
        }
        return count;
    }

    // Lấy tất cả các đỉnh lân cận của một đỉnh
    public List<Integer> getNeighbors(int vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }

    // Tính đoạn đường dài nhất (DFS)
    public List<Integer> longestPath(int start) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> longestPath = new ArrayList<>();
        longestPathUtil(start, visited, new ArrayList<>(), longestPath);
        return longestPath;
    }

    private void longestPathUtil(int vertex, Set<Integer> visited, List<Integer> currentPath,
            List<Integer> longestPath) {
        visited.add(vertex);
        currentPath.add(vertex);

        if (currentPath.size() > longestPath.size()) {
            longestPath.clear();
            longestPath.addAll(currentPath);
        }

        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                longestPathUtil(neighbor, visited, currentPath, longestPath);
            }
        }

        visited.remove(vertex);
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Thêm các đỉnh và cạnh vào đồ thị
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 5, 1);

        // In đồ thị
        System.out.println("do thi :");
        graph.printGraph();

        // Thực hiện BFS từ đỉnh 1
        System.out.println("\nBFS bat dau dinh 1:");
        graph.BFS(1);

        // Kiểm tra vòng trong đồ thị
        System.out.println("\nĐồ thị có vòng không: " + graph.hasCycle());

        // Tìm đường đi giữa hai đỉnh (1 và 5)
        System.out.println("\nĐường đi từ đỉnh 1 đến đỉnh 5:");
        List<Integer> path = graph.findPath(1, 5);
        if (path != null) {
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("Không có đường đi.");
        }

        // Tìm đỉnh có bậc cao nhất
        System.out.println("\nĐỉnh có bậc cao nhất: " + graph.findVertexWithHighestDegree());

        // Tìm các thành phần liên thông
        System.out.println("\nCác thành phần liên thông:");
        List<List<Integer>> components = graph.getConnectedComponents();
        for (List<Integer> component : components) {
            System.out.println(component);
        }

        // Tính tổng trọng số của các cạnh
        System.out.println("\nTổng trọng số của các cạnh: " + graph.totalWeightOfEdges());

        // Kiểm tra xem đồ thị có đối xứng không
        System.out.println("\nĐồ thị có đối xứng không: " + graph.isSymmetric());

        // Đếm số đỉnh và cạnh
        System.out.println("\nSố lượng đỉnh: " + graph.countVertices());
        System.out.println("Số lượng cạnh: " + graph.countEdges());

        // Lấy danh sách các đỉnh lân cận của đỉnh 1
        System.out.println("\nDanh sách các đỉnh lân cận của đỉnh 1:");
        List<Integer> neighbors = graph.getNeighbors(1);
        for (int neighbor : neighbors) {
            System.out.print(neighbor + " ");
        }

        // Tìm đoạn đường dài nhất từ đỉnh 1
        System.out.println("\nĐoạn đường dài nhất từ đỉnh 1:");
        List<Integer> longestPath = graph.longestPath(1);
        for (int vertex : longestPath) {
            System.out.print(vertex + " ");
        }
    }
}
