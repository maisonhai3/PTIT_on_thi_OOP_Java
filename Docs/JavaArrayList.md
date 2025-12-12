# ArrayList trong Java

## 1. ArrayList là gì?

`ArrayList` là một lớp trong `java.util` package, thuộc Java Collections Framework. Nó triển khai (implements) giao diện `List`.

`ArrayList` về cơ bản là một **mảng có thể thay đổi kích thước** (resizable array hay dynamic array). Nó cung cấp sự linh hoạt khi bạn không biết chính xác số lượng phần tử cần lưu trữ, hoặc khi số lượng phần tử thay đổi trong quá trình chạy chương trình.

## 2. So sánh Array và ArrayList

| Tính năng | Array (Mảng) | ArrayList |
| :--- | :--- | :--- |
| **Kích thước** | Cố định (Fixed-size) | Động (Dynamic-size) |
| **Khai báo** | `int[] arr = new int[10];` | `ArrayList<Integer> list = new ArrayList<>();` |
| **Thêm phần tử** | `arr[0] = 100;` | `list.add(100);` |
| **Kiểu dữ liệu** | Có thể chứa cả kiểu nguyên thủy (primitive) và đối tượng (object) | Chỉ chứa kiểu đối tượng. Phải dùng wrapper class cho kiểu nguyên thủy (ví dụ `Integer` thay cho `int`) |
| **Hiệu năng** | Nhanh hơn vì kích thước cố định | Chậm hơn một chút do có chi phí quản lý kích thước động |
| **Phương thức** | Ít, chủ yếu là thuộc tính `length` | Rất nhiều phương thức tiện ích (`add`, `remove`, `get`, `size`...) |

## 3. Cách sử dụng

### Import

Để sử dụng `ArrayList`, bạn cần import nó từ package `java.util`.

```java
import java.util.ArrayList;
```

### Khởi tạo

```java
// Khởi tạo một ArrayList rỗng để lưu trữ các chuỗi
ArrayList<String> names = new ArrayList<>();

// Khởi tạo một ArrayList để lưu trữ các số nguyên
// Lưu ý: Phải dùng lớp vỏ (wrapper class) Integer, không phải int
ArrayList<Integer> numbers = new ArrayList<>();
```

## 4. Các phương thức phổ biến

Giả sử chúng ta có: `ArrayList<String> fruits = new ArrayList<>();`

### `add()` - Thêm phần tử
Thêm phần tử vào cuối danh sách.

```java
fruits.add("Apple"); // ["Apple"]
fruits.add("Banana"); // ["Apple", "Banana"]
fruits.add(1, "Orange"); // Thêm "Orange" vào vị trí 1: ["Apple", "Orange", "Banana"]
```

### `get()` - Lấy phần tử
Lấy phần tử tại một vị trí (index) cụ thể.

```java
String firstFruit = fruits.get(0); // "Apple"
```

### `set()` - Cập nhật phần tử
Thay đổi giá trị của phần tử tại một vị trí cụ thể.

```java
fruits.set(1, "Grape"); // Thay "Orange" bằng "Grape": ["Apple", "Grape", "Banana"]
```

### `remove()` - Xóa phần tử
Xóa phần tử tại một vị trí hoặc xóa một đối tượng cụ thể.

```java
fruits.remove(2); // Xóa phần tử tại vị trí 2: ["Apple", "Grape"]
fruits.remove("Apple"); // Xóa phần tử "Apple": ["Grape"]
```

### `size()` - Lấy kích thước
Trả về số lượng phần tử hiện có trong danh sách.

```java
int count = fruits.size(); // 1
```

### `clear()` - Xóa tất cả
Xóa tất cả các phần tử khỏi danh sách.

```java
fruits.clear(); // []
System.out.println(fruits.size()); // 0
```

### `isEmpty()` - Kiểm tra rỗng
Kiểm tra xem danh sách có rỗng hay không.

```java
boolean empty = fruits.isEmpty(); // true
```

### `contains()` - Kiểm tra sự tồn tại
Kiểm tra xem một phần tử có tồn tại trong danh sách hay không.

```java
fruits.add("Mango");
boolean hasMango = fruits.contains("Mango"); // true
```

## 5. Duyệt qua ArrayList

Có nhiều cách để duyệt qua các phần tử của `ArrayList`.

### Dùng vòng lặp for-each (cách phổ biến nhất)

```java
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

### Dùng vòng lặp for với chỉ số

```java
for (int i = 0; i < fruits.size(); i++) {
    System.out.println(fruits.get(i));
}
```

## 6. Sắp xếp ArrayList (Sorting)

Để sắp xếp một `ArrayList`, bạn có thể dùng `Collections.sort()` hoặc phương thức `sort()` của chính `ArrayList`.

### Sắp xếp theo thứ tự tự nhiên
Sử dụng `Collections.sort()` cho các kiểu dữ liệu cơ bản như `String` hoặc `Integer`.

```java
import java.util.ArrayList;
import java.util.Collections;

ArrayList<String> names = new ArrayList<>();
names.add("John");
names.add("Alice");
names.add("Bob");

// Sắp xếp theo alphabet
Collections.sort(names); // ["Alice", "Bob", "John"]
```

### Sắp xếp tùy chỉnh với Comparator
Sử dụng `list.sort(Comparator)` để sắp xếp các đối tượng phức tạp.

```java
// Giả sử bạn có một lớp 'Player' với trường 'score'
// players.sort(Comparator.comparing(Player::getScore));

// Sắp xếp ngược (điểm cao nhất trước)
// players.sort(Comparator.comparing(Player::getScore).reversed());
```
