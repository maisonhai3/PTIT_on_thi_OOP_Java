# Java TreeMap

`TreeMap` trong Java là một phần của Java Collections Framework. Giống như `HashMap`, nó cũng lưu trữ các cặp key-value, nhưng có một điểm khác biệt quan trọng: `TreeMap` luôn duy trì các phần tử của nó được sắp xếp theo thứ tự tự nhiên của các key (hoặc theo một `Comparator` được cung cấp).

## Đặc điểm chính của TreeMap

-   **Lưu trữ cặp Key-Value:** Mỗi phần tử bao gồm một key và một value.
-   **Key là duy nhất:** Không cho phép các key trùng lặp.
-   **Sắp xếp theo Key:** Đây là đặc điểm nổi bật nhất. Các key được sắp xếp theo thứ tự tăng dần (thứ tự tự nhiên) hoặc theo một `Comparator` tùy chỉnh. Do đó, khi bạn duyệt qua map, các key sẽ luôn theo một thứ tự có thể đoán trước được.
-   **Không cho phép key `null`:** Vì `TreeMap` cần so sánh các key để duy trì thứ tự, nó không chấp nhận key là `null` (sẽ gây ra `NullPointerException`).
-   **Hiệu suất:** Các thao tác cơ bản như `put`, `get`, `remove` có hiệu suất là O(log n), vì `TreeMap` được triển khai dưới dạng cây đỏ-đen (Red-Black tree). Điều này chậm hơn so với O(1) của `HashMap` nhưng là sự đánh đổi để có được một tập hợp được sắp xếp.

## Khi nào nên sử dụng TreeMap?

Sử dụng `TreeMap` khi bạn cần:
1.  Duyệt qua các key theo một thứ tự cụ thể.
2.  Lấy key nhỏ nhất hoặc lớn nhất.
3.  Tìm các key lớn hơn hoặc nhỏ hơn một key nhất định.

Sử dụng `HashMap` khi bạn không quan tâm đến thứ tự và chỉ cần hiệu suất truy cập nhanh nhất.

## Cách tạo một TreeMap

Để sử dụng `TreeMap`, bạn cần import nó từ `java.util.TreeMap`.

```java
import java.util.TreeMap;
import java.util.Map;

// Cú pháp
TreeMap<KieuDuLieuKey, KieuDuLieuValue> tenBien = new TreeMap<>();

// Ví dụ: Một TreeMap để lưu điểm số của sinh viên (sắp xếp theo tên)
TreeMap<String, Double> diemSo = new TreeMap<>();
```

## Các thao tác cơ bản

Các thao tác cơ bản (`put`, `get`, `remove`, `containsKey`, `size`) tương tự như `HashMap`.

```java
diemSo.put("Charlie", 8.5);
diemSo.put("Alice", 9.0);
diemSo.put("Bob", 7.5);

// Khi duyệt, các key sẽ theo thứ tự: Alice, Bob, Charlie
for (Map.Entry<String, Double> entry : diemSo.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
// Output:
// Alice: 9.0
// Bob: 7.5
// Charlie: 8.5
```

## Các phương thức đặc biệt

Vì được sắp xếp, `TreeMap` cung cấp các phương thức hữu ích để làm việc với thứ tự.

-   `firstKey()`: Trả về key nhỏ nhất.
-   `lastKey()`: Trả về key lớn nhất.
-   `firstEntry()`: Trả về cặp key-value có key nhỏ nhất.
-   `lastEntry()`: Trả về cặp key-value có key lớn nhất.
-   `headMap(toKey)`: Trả về một view của map chứa các key nhỏ hơn `toKey`.
-   `tailMap(fromKey)`: Trả về một view của map chứa các key lớn hơn hoặc bằng `fromKey`.
-   `subMap(fromKey, toKey)`: Trả về một view của map trong một khoảng key.

### Ví dụ:

```java
System.out.println("Sinh viên đầu tiên trong danh sách: " + diemSo.firstKey()); // Alice
System.out.println("Sinh viên cuối cùng trong danh sách: " + diemSo.lastKey());   // Charlie

// Lấy các sinh viên có tên bắt đầu từ "Bob" trở đi
Map<String, Double> phanSau = diemSo.tailMap("Bob");
System.out.println(phanSau); // {Bob=7.5, Charlie=8.5}
```

`TreeMap` là một lựa chọn tuyệt vời khi thứ tự của các key là quan trọng đối với logic ứng dụng của bạn.

