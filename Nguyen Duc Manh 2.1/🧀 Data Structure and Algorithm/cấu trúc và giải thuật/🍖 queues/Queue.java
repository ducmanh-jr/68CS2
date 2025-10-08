/*
Các hoạt động cơ bản của hàng đợi
Hàng đợi là một đối tượng (cấu trúc dữ liệu trừu tượng - ADT) cho phép các thao tác sau:
Enqueue: Thêm phần tử vào cuối hàng đợi
Dequeue: Xóa một phần tử khỏi phía trước hàng đợi
IsEmpty: Kiểm tra xem hàng đợi có trống không
IsFull: Kiểm tra xem hàng đợi đã đầy chưa
Xem nhanh: Lấy giá trị của mặt trước của hàng đợi mà không cần xóa nó 

Hoạt động của hàng đợi
Các thao tác hàng đợi hoạt động như sau:
hai con trỏ và FRONTREAR
FRONT Theo dõi phần tử đầu tiên của hàng đợi
REAR Theo dõi phần tử cuối cùng của hàng đợi
Ban đầu, đặt giá trị của và thành -1FRONTREAR

Hoạt động hàng đợi
Kiểm tra xem hàng đợi đã đầy chưa
Đối với phần tử đầu tiên, đặt giá trị của thành 0FRONT
tăng chỉ số lên 1REAR
Thêm phần tử mới vào vị trí được trỏ đến bởi REAR

Hoạt động hàng đợi
Kiểm tra xem hàng đợi có trống không
Trả về giá trị được chỉ bởi FRONT
tăng chỉ số lên 1FRONT
Đối với phần tử cuối cùng, đặt lại các giá trị của và thành -1FRONTREAR

Các ứng dụng của Queue
Lập lịch CPU, Lập lịch đĩa
Khi dữ liệu được truyền không đồng bộ giữa hai quá trình. Hàng đợi được sử dụng để đồng bộ hóa. Ví dụ: IO Buffers, pipes, file IO, v.v
Xử lý các ngắt trong hệ thống thời gian thực.
Hệ thống điện thoại Call Center sử dụng Queues để giữ mọi người gọi cho họ theo thứ tự.
*/
// Queue implementation in Java

// Trien khai hang doi trong Java

public class Queue {
    int SIZE = 5;
    int items[] = new int[SIZE];
    int front, rear;

    Queue() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        if (rear == SIZE - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Hang doi day");
        } else {
            if (front == -1)
                front = 0;
            rear++;
            items[rear] = element;
            System.out.println("Da them " + element);
        }
    }

    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Hang doi rong");
            return (-1);
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } /* Q chi co mot phan tu, do do ta reset hang doi sau khi xoa. */
            else {
                front++;
            }
            System.out.println("Da xoa -> " + element);
            return (element);
        }
    }

    void display() {
        /* Ham de hien thi cac phan tu trong Hang doi */
        int i;
        if (isEmpty()) {
            System.out.println("Hang doi rong");
        } else {
            System.out.println("\nChi so Front-> " + front);
            System.out.println("Cac phan tu -> ");
            for (i = front; i <= rear; i++)
                System.out.print(items[i] + "  ");

            System.out.println("\nChi so Rear-> " + rear);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        // deQueue khong the thuc hien tren hang doi rong
        q.deQueue();

        // enQueue 5 phan tu
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // Phan tu thu 6 khong the duoc them vi hang doi da day
        q.enQueue(6);

        q.display();

        // deQueue xoa phan tu duoc nhap dau tien i.e. 1
        q.deQueue();

        // Bay gio ta chi co 4 phan tu
        q.display();
    }
}
