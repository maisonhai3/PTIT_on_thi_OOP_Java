# Hướng dẫn Sắp xếp (Sorting) trong Java

Mục tiêu: Sắp xếp một danh sách các đối tượng (ví dụ: `GameThu`) theo một tiêu chí cụ thể (ví dụ: thời gian chơi giảm dần).

## Phương pháp: Sử dụng `list.sort()` với Lambda

Đây là cách hiện đại và ngắn gọn nhất trong Java để sắp xếp một `ArrayList` hoặc `List`.

### 1. Chuẩn bị danh sách

Giả sử bạn có một `List<GameThu>` và mỗi đối tượng `GameThu` có một phương thức `getThoiGianChoi()` trả về số phút chơi.

```java
List<GameThu> danhSach = new ArrayList<>();
// ... thêm các game thủ vào danh sách ...
```

### 2. Viết biểu thức sắp xếp

Sử dụng phương thức `sort()` của `List` và cung cấp cho nó một biểu thức lambda để so sánh hai đối tượng.

**Cú pháp Lambda để so sánh:**
`(obj1, obj2) -> { logic so sánh }`

**Logic so sánh:**
*   Để **sắp xếp tăng dần**: `Integer.compare(obj1.getValue(), obj2.getValue())`
*   Để **sắp xếp giảm dần**: `Integer.compare(obj2.getValue(), obj1.getValue())` (chỉ cần đảo vị trí `obj1` và `obj2`)

### 3. Áp dụng vào bài toán

Để sắp xếp danh sách game thủ theo thời gian chơi **giảm dần**, chúng ta làm như sau:

```java
// danhSach là List<GameThu>
danhSach.sort((gameThu1, gameThu2) -> {
    // So sánh thời gian chơi của gameThu2 với gameThu1 để có thứ tự giảm dần
    return Integer.compare(gameThu2.getThoiGianChoi(), gameThu1.getThoiGianChoi());
});
```

**Phiên bản ngắn gọn hơn (khuyên dùng):**

```java
danhSach.sort((g1, g2) -> Integer.compare(g2.getThoiGianChoi(), g1.getThoiGianChoi()));
```

### Giải thích

*   `danhSach.sort(...)`: Gọi phương thức sắp xếp trực tiếp trên danh sách.
*   `(g1, g2)`: `sort` sẽ tự động lấy ra hai phần tử (`g1` và `g2`) từ danh sách để so sánh.
*   `->`: Ký hiệu của biểu thức lambda.
*   `Integer.compare(a, b)`: Một cách an toàn để so sánh hai số nguyên.
    *   Trả về số âm nếu `a < b`.
    *   Trả về `0` nếu `a == b`.
    *   Trả về số dương nếu `a > b`.
*   Bằng cách đặt `g2` trước `g1` trong `Integer.compare`, chúng ta đã đảo ngược thứ tự so sánh, dẫn đến kết quả là một danh sách được sắp xếp giảm dần.

Sau khi dòng lệnh này thực thi, `danhSach` sẽ được sắp xếp lại theo đúng yêu cầu.
