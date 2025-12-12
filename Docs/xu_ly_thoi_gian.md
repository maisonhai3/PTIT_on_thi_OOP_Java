# Hướng dẫn Xử lý Thời gian trong Java (Cho bài toán Game thủ)

Mục tiêu: Tính khoảng thời gian (bằng phút) giữa hai mốc thời gian có định dạng "hh:mm".

## Các bước thực hiện

### 1. Đọc dữ liệu đầu vào

Thời gian được cho dưới dạng chuỗi (String), ví dụ: `"10:30"`.

### 2. Tách giờ và phút

Sử dụng phương thức `split(":")` của chuỗi để tách giờ và phút.

```java
String gioVao = "10:30";
String[] parts = gioVao.split(":"); // Kết quả: ["10", "30"]
String gioStr = parts[0]; // "10"
String phutStr = parts[1]; // "30"
```

### 3. Chuyển đổi sang số

Sử dụng `Integer.parseInt()` để chuyển đổi chuỗi giờ và phút thành số nguyên (`int`).

```java
int gio = Integer.parseInt(gioStr); // 10
int phut = Integer.parseInt(phutStr); // 30
```

### 4. Quy đổi tất cả ra phút

Đây là cách đơn giản nhất để tính toán khoảng thời gian.

**Công thức:** `Tổng số phút = (Số giờ * 60) + Số phút`

```java
// Ví dụ với giờ vào "10:30" và giờ ra "12:00"

// Giờ vào
int phutVao = 10 * 60 + 30; // 630 phút

// Giờ ra
int phutRa = 12 * 60 + 0;  // 720 phút
```

### 5. Tính thời gian chơi

Lấy tổng số phút của giờ ra trừ đi tổng số phút của giờ vào.

```java
int thoiGianChoi = phutRa - phutVao; // 720 - 630 = 90 phút
```

### (Tùy chọn) Chuyển đổi ngược lại sang "X giờ Y phút"

Để hiển thị kết quả, bạn có thể chuyển đổi tổng số phút trở lại định dạng giờ và phút.

*   **Số giờ**: `tổng_phút / 60` (chia lấy phần nguyên)
*   **Số phút**: `tổng_phút % 60` (chia lấy phần dư)

```java
int thoiGianChoi = 90;
int gio = thoiGianChoi / 60; // 90 / 60 = 1
int phut = thoiGianChoi % 60; // 90 % 60 = 30

System.out.println(gio + " gio " + phut + " phut"); // Kết quả: 1 gio 30 phut
```

---

## Cách 2: Sử dụng thư viện `java.time` (Khuyến khích)

Từ Java 8 trở đi, Java cung cấp một bộ thư viện xử lý ngày giờ mới trong gói `java.time`, mạnh mẽ và dễ sử dụng hơn rất nhiều so với các lớp cũ.

### 1. Tạo `DateTimeFormatter`

Để parse (phân tích) chuỗi "HH:mm", chúng ta tạo một `DateTimeFormatter` với pattern tương ứng.

```java
import java.time.format.DateTimeFormatter;

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
```
*Lưu ý: `HH` (viết hoa) đại diện cho giờ trong ngày (0-23).*

### 2. Parse chuỗi thành `LocalTime`

Sử dụng `LocalTime.parse()` cùng với formatter đã tạo. `LocalTime` là một lớp biểu diễn thời gian trong ngày, không có ngày tháng hay múi giờ.

```java
import java.time.LocalTime;

String gioVaoStr = "10:30";
String gioRaStr = "12:00";

LocalTime gioVao = LocalTime.parse(gioVaoStr, formatter);
LocalTime gioRa = LocalTime.parse(gioRaStr, formatter);
```

### 3. Tính khoảng thời gian với `Duration`

Lớp `Duration` được dùng để đo khoảng thời gian giữa hai đối tượng `LocalTime`.

```java
import java.time.Duration;

Duration thoiGianChoi = Duration.between(gioVao, gioRa);
```

### 4. Lấy kết quả

Bạn có thể dễ dàng lấy ra tổng số phút từ đối tượng `Duration`.

```java
long soPhut = thoiGianChoi.toMinutes(); // Kết quả: 90
```

### Ví dụ tổng hợp

```java
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class TimeParserExample {
    public static void main(String[] args) {
        String gioVaoStr = "10:30";
        String gioRaStr = "12:00";

        // 1. Tạo formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // 2. Parse chuỗi thành LocalTime
        LocalTime gioVao = LocalTime.parse(gioVaoStr, formatter);
        LocalTime gioRa = LocalTime.parse(gioRaStr, formatter);

        // 3. Tính khoảng thời gian
        Duration duration = Duration.between(gioVao, gioRa);

        // 4. Lấy tổng số phút
        long totalMinutes = duration.toMinutes();
        System.out.println("Tổng thời gian chơi: " + totalMinutes + " phút"); // Tổng thời gian chơi: 90 phút

        // Chuyển đổi ngược lại để hiển thị
        long hours = totalMinutes / 60;
        long minutes = totalMinutes % 60;
        System.out.println("Tương đương: " + hours + " giờ " + minutes + " phút"); // Tương đương: 1 giờ 30 phút
    }
}
```

**Ưu điểm của cách này:**
-   **An toàn:** Tự động kiểm tra định dạng thời gian. Nếu chuỗi đầu vào không phải là "HH:mm" (ví dụ: "10/30"), nó sẽ báo lỗi `DateTimeParseException` thay vì chạy sai.
-   **Rõ ràng:** Mã nguồn dễ đọc và thể hiện rõ ý định.
-   **Mạnh mẽ:** Dễ dàng mở rộng cho các bài toán phức tạp hơn (ví dụ: tính toán qua ngày, múi giờ...).

