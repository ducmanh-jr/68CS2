// Trien khai ngan xep trong Java

public class Stack {
    private int arr[];
    private int top;
    private int capacity;

    // Tao mot ngan xep
    Stack(int size) {
        arr = new int[size];

        capacity = size;
        top = -1;
    }

    // Them phan tu vao ngan xep
    public void push(int x) {
        if (isFull()) {
            System.out.println("Tran ngan xep\nChuong trinh ket thuc\n");
            System.exit(1);
        }

        System.out.println("Dang them " + x);
        arr[++top] = x;
    }

    // Xoa phan tu tu ngan xep
    public int pop() {
        if (isEmpty()) {
            System.out.println("NGAN XEP RONG");
            System.exit(1);
        }
        return arr[top--];
    }

    // Ham tien ich de tra ve kich thuoc cua ngan xep
    public int size() {
        return top + 1;
    }

    // Kiem tra xem ngan xep co rong khong
    public Boolean isEmpty() {
        return top == -1;
    }

    // Kiem tra xem ngan xep co day khong
    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("\nSau khi xoa");

        stack.printStack();
    }
}
