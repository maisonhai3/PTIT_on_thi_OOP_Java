# Xử lý chuỗi (String) trong Java

## 1. Khai báo chuỗi

```java
String str1 = "Hello World";
String str2 = new String("Hello Java");
```

## 2. Lấy độ dài chuỗi

```java
String s = "hello";
int doDai = s.length(); // 5
```

## 3. Nối chuỗi

```java
String s1 = "Hello";
String s2 = " World";
String s3 = s1 + s2; // "Hello World"
String s4 = s1.concat(s2); // "Hello World"
```

## 4. Lấy ký tự tại vị trí

```java
String s = "hello";
char c = s.charAt(0); // 'h'
```

## 5. So sánh chuỗi

**Lưu ý:** Luôn dùng `.equals()` để so sánh nội dung hai chuỗi, không dùng `==`.

```java
String s1 = "hello";
String s2 = "hello";
String s3 = "HELLO";

s1.equals(s2); // true
s1.equals(s3); // false
s1.equalsIgnoreCase(s3); // true (không phân biệt hoa thường)
```

## 6. Tìm kiếm trong chuỗi

```java
String s = "hello world";

s.contains("world"); // true
s.indexOf('o');      // 4 (vị trí đầu tiên)
s.lastIndexOf('o');  // 7 (vị trí cuối cùng)
s.startsWith("he");  // true
s.endsWith("ld");    // true
```

## 7. Trích xuất chuỗi con (Substring)

```java
String s = "hello world";

String sub1 = s.substring(6);      // "world" (từ vị trí 6 đến hết)
String sub2 = s.substring(0, 5);   // "hello" (từ vị trí 0 đến trước 5)
```

## 8. Chuyển đổi hoa/thường

```java
String s = "Hello World";

String lower = s.toLowerCase(); // "hello world"
String upper = s.toUpperCase(); // "HELLO WORLD"
```

## 9. Xóa khoảng trắng thừa

```java
String s = "  hello world  ";
String trimmed = s.trim(); // "hello world"
```

## 10. Thay thế ký tự/chuỗi

```java
String s = "hello world";

String replaced1 = s.replace('l', 'x'); // "hexxo worxd"
String replaced2 = s.replace("world", "java"); // "hello java"
```

## 11. Tách chuỗi (Split)

```java
String s = "java-python-c++";
String[] languages = s.split("-"); // ["java", "python", "c++"]

for (String lang : languages) {
    System.out.println(lang);
}
```

