# StringBuilder trong Java

## 1. StringBuilder là gì?

`StringBuilder` là một lớp trong Java cung cấp một chuỗi ký tự có thể thay đổi (mutable). Khác với `String` là bất biến (immutable), mỗi lần bạn sửa đổi một đối tượng `String`, một đối tượng `String` mới sẽ được tạo ra. `StringBuilder` cho phép bạn sửa đổi chuỗi mà không cần tạo đối tượng mới, giúp cải thiện hiệu năng đáng kể, đặc biệt là khi phải nối chuỗi nhiều lần trong vòng lặp.

## 2. Khi nào nên dùng StringBuilder?

Khi bạn cần thực hiện nhiều thao tác sửa đổi trên một chuỗi, chẳng hạn như:
- Nối chuỗi trong vòng lặp.
- Xây dựng một chuỗi phức tạp từ nhiều phần nhỏ.
- Thường xuyên chèn, xóa, hoặc thay thế các phần của chuỗi.

## 3. Khởi tạo StringBuilder

```java
// Khởi tạo rỗng
StringBuilder sb1 = new StringBuilder();

// Khởi tạo với một chuỗi ban đầu
StringBuilder sb2 = new StringBuilder("Hello");

// Khởi tạo với dung lượng ban đầu (tối ưu hiệu năng)
StringBuilder sb3 = new StringBuilder(50);
```

## 4. Các phương thức phổ biến

### `append()` - Nối chuỗi
Thêm nội dung vào cuối chuỗi.

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
sb.append(123);
System.out.println(sb.toString()); // "Hello World123"
```

### `insert()` - Chèn chuỗi
Chèn nội dung vào một vị trí cụ thể.

```java
StringBuilder sb = new StringBuilder("HelloWorld");
sb.insert(5, " "); // Chèn vào vị trí thứ 5
System.out.println(sb.toString()); // "Hello World"
```

### `delete()` - Xóa chuỗi con
Xóa một phần của chuỗi.

```java
StringBuilder sb = new StringBuilder("HelloWorld");
sb.delete(5, 10); // Xóa từ vị trí 5 đến trước vị trí 10
System.out.println(sb.toString()); // "Hello"
```

### `deleteCharAt()` - Xóa ký tự
Xóa một ký tự tại vị trí cụ thể.

```java
StringBuilder sb = new StringBuilder("Hello");
sb.deleteCharAt(1); // Xóa ký tự 'e'
System.out.println(sb.toString()); // "Hllo"
```

### `replace()` - Thay thế chuỗi
Thay thế một phần của chuỗi bằng một chuỗi khác.

```java
StringBuilder sb = new StringBuilder("Hello World");
sb.replace(6, 11, "Java"); // Thay thế "World" bằng "Java"
System.out.println(sb.toString()); // "Hello Java"
```

### `reverse()` - Đảo ngược chuỗi
Đảo ngược toàn bộ chuỗi.

```java
StringBuilder sb = new StringBuilder("hello");
sb.reverse();
System.out.println(sb.toString()); // "olleh"
```

### `length()` - Lấy độ dài
Trả về số ký tự hiện có trong `StringBuilder`.

```java
StringBuilder sb = new StringBuilder("Hello");
int len = sb.length(); // 5
```

### `toString()` - Chuyển về String
Để có được đối tượng `String` cuối cùng từ `StringBuilder`.

```java
StringBuilder sb = new StringBuilder("Final String");
String finalString = sb.toString();
```

