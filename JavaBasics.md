# Java Cơ Bản

## 1. Cấu trúc chương trình

```java
public class TenClass {
    public static void main(String[] args) {
        // Code ở đây
    }
}
```

## 2. Biến và Kiểu dữ liệu

```java
int soNguyen = 10;
double soThuc = 3.14;
boolean dungSai = true;
char kyTu = 'A';
String chuoi = "Hello";
```

## 3. Nhập xuất

```java
// Xuất
System.out.println("Hello World");  // Có xuống dòng
System.out.print("Hello");          // Không xuống dòng

// Nhập
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
String s = sc.nextLine();
```

## 4. Điều kiện

```java
if (a > b) {
    // làm gì đó
} else if (a == b) {
    // làm gì đó
} else {
    // làm gì đó
}
```

## 5. Vòng lặp

```java
// For
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// While
while (dieukien) {
    // làm gì đó
}

// Do-while
do {
    // làm gì đó
} while (dieukien);
```

## 6. Mảng

```java
// Khai báo
int[] arr = new int[5];
int[] arr2 = {1, 2, 3, 4, 5};

// Truy cập
arr[0] = 10;
int x = arr[0];

// Duyệt mảng
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// For-each
for (int num : arr) {
    System.out.println(num);
}
```

## 7. Hàm (Method)

```java
public static int tong(int a, int b) {
    return a + b;
}

public static void inRa(String s) {
    System.out.println(s);
}
```

## 8. Toán tử

```java
// Số học
+  -  *  /  %

// So sánh
==  !=  >  <  >=  <=

// Logic
&&  ||  !
```

## 9. Import thư viện

```java
import java.util.*;        // Tất cả java.util
import java.util.Scanner;  // Chỉ Scanner
import java.util.Arrays;   // Chỉ Arrays
```

## 10. Một số hàm hay dùng

```java
Arrays.sort(arr);              // Sắp xếp mảng
Math.max(a, b);                // Số lớn hơn
Math.min(a, b);                // Số nhỏ hơn
Math.abs(x);                   // Giá trị tuyệt đối
String.valueOf(n);             // Số -> Chuỗi
Integer.parseInt("123");       // Chuỗi -> Số
```

