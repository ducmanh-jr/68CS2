/*
Độ phức tạp của tìm kiếm nhị phân
Thời gian phức tạp
Độ phức tạp của trường hợp tốt nhất: O(1)
Độ phức tạp của trường hợp trung bình: O(log n)
Trường hợp xấu nhất phức tạp: O(log n)
Độ phức tạp của không gian
Độ phức tạp không gian của tìm kiếm nhị phân là .O(1)

Ứng dụng tìm kiếm nhị phân
Trong các thư viện của Java, .Net, C ++ STL
Trong khi gỡ lỗi, tìm kiếm nhị phân được sử dụng để xác định nơi xảy ra lỗi. */
// Tim kiem nhi phan trong Java

class BinarySearch {
    int binarySearch(int array[], int x, int low, int high) {

        // Lap lai cho den khi con tro low va high gap nhau
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (x == array[mid])
                return mid;

            if (x > array[mid])
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int n = array.length;
        int x = 4;
        int result = ob.binarySearch(array, x, 0, n - 1);
        if (result == -1)
            System.out.println("Khong tim thay");
        else
            System.out.println("Tim thay phan tu o chi so " + result);
    }
}
