import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    String ma;
    String hoTen;
    String lop;
    String mail;

    public SinhVien(String ma, String hoTen, String lop, String mail){
        this.ma = ma;
        this.hoTen = hoTen;
        this.lop = lop;
        this.mail = mail;
    }

    @Override
    public int compareTo(SinhVien other){
        if (this.lop.equals(other.lop)){
            return this.ma.compareTo(other.ma);
        }
        else{
            return this.lop.compareTo(other.lop);
        }
    }

    @Override
    public String toString(){
        return this.ma + " " + this.hoTen + " " + this.lop + " " + this.mail;
    }
}

public class SapXepSinhVienTheoLop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> dsSV = new ArrayList<>();

        int soSinhVien = Integer.parseInt(sc.nextLine());

        for(var i = 0; i <= soSinhVien; i++){
            String ma = sc.nextLine();
            String hoTen = sc.nextLine();
            String lop = sc.nextLine();
            String mail = sc.nextLine();

            SinhVien sv = new SinhVien(ma, hoTen, lop, mail);
            dsSV.add(sv);
        }

        Collections.sort(dsSV);

        for (var sv : dsSV){
            System.out.println(sv);
        }
    }
}
