# So sánh đối tượng trong Java: `Comparable` và `Comparator`

Khi làm việc với các đối tượng do người dùng định nghĩa trong Java, nếu bạn muốn sắp xếp chúng (ví dụ trong một `ArrayList` hoặc `TreeSet`), bạn cần cung cấp cho Java một cách để so sánh các đối tượng đó. Có hai cách chính để làm điều này: sử dụng interface `Comparable` hoặc `Comparator`.

## 1. Interface `Comparable`

`Comparable` được sử dụng để định nghĩa **thứ tự sắp xếp tự nhiên** (natural ordering) cho một lớp. Khi bạn implement interface này, bạn đang nói rằng các đối tượng của lớp này có một cách so sánh mặc định.

### Cách triển khai

Bạn cho lớp của mình implement `Comparable<TenLop>` và override phương thức `compareTo()`.

```java
public class TenLop implements Comparable<TenLop> {
    // ... các thuộc tính

    @Override
    public int compareTo(TenLop other) {
        // logic so sánh
    }
}
```

### Quy tắc của `compareTo(T other)`

Phương thức này so sánh đối tượng hiện tại (`this`) với đối tượng `other`.
-   Trả về **số âm** nếu `this` đứng *trước* `other`.
-   Trả về **số không** nếu `this` *bằng* `other` theo tiêu chí sắp xếp.
-   Trả về **số dương** nếu `this` đứng *sau* `other`.

### Ví dụ: Sắp xếp SinhVien theo điểm (tăng dần)

```java
class SinhVien implements Comparable<SinhVien> {
    String ten;
    double diem;

    public SinhVien(String ten, double diem) {
        this.ten = ten;
        this.diem = diem;
    }

    @Override
    public int compareTo(SinhVien other) {
        // Sắp xếp tăng dần theo điểm
        // Để sắp xếp giảm dần, đảo ngược vị trí: other.diem - this.diem
        return Double.compare(this.diem, other.diem);
    }

    @Override
    public String toString() {
        return this.ten + ": " + this.diem;
    }
}

// Cách sử dụng:
List<SinhVien> danhSach = new ArrayList<>();
danhSach.add(new SinhVien("An", 8.5));
danhSach.add(new SinhVien("Binh", 7.0));
danhSach.add(new SinhVien("Cuong", 9.0));

Collections.sort(danhSach); // Sắp xếp danh sách theo thứ tự tự nhiên (theo điểm)
System.out.println(danhSach);
// Output: [Binh: 7.0, An: 8.5, Cuong: 9.0]
```

## 2. Interface `Comparator`

`Comparator` được sử dụng khi bạn muốn:
-   Sắp xếp các đối tượng của một lớp mà bạn không thể sửa đổi (ví dụ: lớp từ thư viện bên ngoài).
-   Cung cấp nhiều quy tắc sắp xếp khác nhau cho cùng một lớp.

### Cách triển khai

Bạn tạo một lớp riêng implement `Comparator<TenLop>` và override phương thức `compare()`.

```java
import java.util.Comparator;

public class MyCustomComparator implements Comparator<TenLop> {
    @Override
    public int compare(TenLop o1, TenLop o2) {
        // logic so sánh
    }
}
```

### Quy tắc của `compare(T o1, T o2)`

-   Trả về **số âm** nếu `o1` đứng *trước* `o2`.
-   Trả về **số không** nếu `o1` *bằng* `o2`.
-   Trả về **số dương** nếu `o1` đứng *sau* `o2`.

### Ví dụ: Sắp xếp SinhVien theo tên (dùng Comparator)

```java
import java.util.Comparator;

class SapXepTheoTen implements Comparator<SinhVien> {
    @Override
    public int compare(SinhVien sv1, SinhVien sv2) {
        // Sắp xếp theo thứ tự alphabet của tên
        return sv1.ten.compareTo(sv2.ten);
    }
}

// Cách sử dụng:
List<SinhVien> danhSach = ...; // Giống ví dụ trên
Collections.sort(danhSach, new SapXepTheoTen()); // Cung cấp Comparator làm đối số
// Hoặc dùng Lambda expression (ngắn gọn hơn)
danhSach.sort((sv1, sv2) -> sv1.ten.compareTo(sv2.ten));

System.out.println(danhSach);
// Output: [An: 8.5, Binh: 7.0, Cuong: 9.0]
```

## Khi nào dùng cái nào?

-   Sử dụng `Comparable` khi có một cách sắp xếp **chính, tự nhiên** cho đối tượng.
-   Sử dụng `Comparator` khi bạn cần các quy tắc sắp xếp **phụ, linh hoạt** hoặc không thể thay đổi mã nguồn của lớp cần sắp xếp.

Đối với bài toán của bạn, bạn có thể tạo một lớp `GameThu` và cho nó implement `Comparable<GameThu>` để so sánh dựa trên thời gian chơi.

