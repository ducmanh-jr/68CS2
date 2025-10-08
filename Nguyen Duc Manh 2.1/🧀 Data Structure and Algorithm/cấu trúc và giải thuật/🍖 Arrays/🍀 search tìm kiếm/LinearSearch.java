// Tim kiem tuyen tinh trong Java
/*
Độ phức tạp của tìm kiếm tuyến tính
Thời gian phức tạp: O(n)
Độ phức tạp của không gian: O(1) */

class LinearSearch {
    public static int linearSearch(int array[], int x) {
        int n = array.length;

        // Duyet mang tuan tu
        for (int i = 0; i < n; i++) {
            if (array[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String args[]) {
        int array[] = { 2, 4, 0, 1, 9 };
        int x = 1;

        int result = linearSearch(array, x);

        if (result == -1)
            System.out.print("Khong tim thay phan tu");
        else
            System.out.print("Tim thay phan tu o chi so: " + result);
    }
}
