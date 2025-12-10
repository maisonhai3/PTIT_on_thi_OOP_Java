# Java HashMap

`HashMap` trong Java là một phần của Java Collections Framework. Nó sử dụng một cấu trúc dữ liệu gọi là bảng băm (hash table) để lưu trữ các cặp key-value.

## Đặc điểm chính của HashMap

-   **Lưu trữ cặp Key-Value:** Mỗi phần tử trong `HashMap` bao gồm một key (khóa) và một value (giá trị) tương ứng.
-   **Key là duy nhất:** `HashMap` không cho phép các key trùng lặp. Nếu bạn cố gắng chèn một cặp key-value với một key đã tồn tại, giá trị cũ sẽ bị ghi đè bởi giá trị mới.
-   **Cho phép một key `null` và nhiều giá trị `null`:** Bạn có thể có một key là `null` và nhiều value là `null`.
-   **Không có thứ tự:** `HashMap` không đảm bảo thứ tự của các phần tử. Thứ tự có thể thay đổi theo thời gian.
-   **Hiệu suất cao:** `HashMap` cung cấp hiệu suất O(1) (thời gian không đổi) cho các thao tác cơ bản như `put` (thêm/cập nhật) và `get` (lấy) trong điều kiện lý tưởng.

## Cách tạo một HashMap

Để sử dụng `HashMap`, bạn cần import nó từ `java.util.HashMap`.

```java
import java.util.HashMap;

// Cú pháp
HashMap<KieuDuLieuKey, KieuDuLieuValue> tenBien = new HashMap<>();

// Ví dụ: Một HashMap để lưu tên và tuổi
HashMap<String, Integer> tuoiCuaMoiNguoi = new HashMap<>();
```

## Các thao tác cơ bản

### 1. Thêm phần tử (put)

Sử dụng phương thức `put(key, value)` để thêm một cặp key-value vào `HashMap`.

```java
tuoiCuaMoiNguoi.put("Alice", 30);
tuoiCuaMoiNguoi.put("Bob", 25);
tuoiCuaMoiNguoi.put("Charlie", 35);

// Nếu key đã tồn tại, giá trị sẽ được cập nhật
tuoiCuaMoiNguoi.put("Alice", 31); // Tuổi của Alice bây giờ là 31
```

### 2. Lấy phần tử (get)

Sử dụng phương thức `get(key)` để lấy giá trị tương ứng với một key. Nếu key không tồn tại, nó sẽ trả về `null`.

```java
int tuoiCuaAlice = tuoiCuaMoiNguoi.get("Alice"); // 31
```

### 2.1. Lấy giá trị với giá trị mặc định (getOrDefault)

Sử dụng `getOrDefault(key, defaultValue)` để lấy giá trị cho một key. Nếu key không tồn tại, nó sẽ trả về một giá trị mặc định.

```java
// Lấy tuổi của David, nếu không có thì trả về 20
int tuoiCuaDavid = tuoiCuaMoiNguoi.getOrDefault("David", 20); // 20
```

### 3. Xóa phần tử (remove)

Sử dụng phương thức `remove(key)` để xóa một cặp key-value.

```java
tuoiCuaMoiNguoi.remove("Bob");
```

### 4. Kiểm tra sự tồn tại

-   `containsKey(key)`: Kiểm tra xem một key có tồn tại trong map hay không.
-   `containsValue(value)`: Kiểm tra xem một giá trị có tồn tại trong map hay không.

```java
boolean coBobKhong = tuoiCuaMoiNguoi.containsKey("Bob"); // false
boolean coAi25TuoiKhong = tuoiCuaMoiNguoi.containsValue(25); // false
```

### 5. Lấy kích thước (size)

Sử dụng phương thức `size()` để lấy số lượng cặp key-value trong map.

```java
int soNguoi = tuoiCuaMoiNguoi.size(); // 2
```

## Duyệt qua HashMap

Bạn có thể duyệt qua các phần tử của `HashMap` theo nhiều cách.

### 1. Duyệt qua các key

```java
for (String ten : tuoiCuaMoiNguoi.keySet()) {
    System.out.println("Key: " + ten);
}
```

### 2. Duyệt qua các giá trị

```java
for (Integer tuoi : tuoiCuaMoiNguoi.values()) {
    System.out.println("Value: " + tuoi);
}
```

### 3. Duyệt qua các cặp key-value

Đây là cách hiệu quả nhất để duyệt qua cả key và value cùng một lúc.

```java
import java.util.Map;

for (Map.Entry<String, Integer> entry : tuoiCuaMoiNguoi.entrySet()) {
    String ten = entry.getKey();
    Integer tuoi = entry.getValue();
    System.out.println(ten + " là " + tuoi + " tuổi.");
}
```

`HashMap` là một công cụ cực kỳ mạnh mẽ và được sử dụng rộng rãi trong lập trình Java để quản lý dữ liệu một cách hiệu quả.

