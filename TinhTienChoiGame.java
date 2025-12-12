import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalTime;

class GameThu implements Comparable<GameThu> {
    public String ma;
    public String ten;
    public Duration tongGioChoi;

    public GameThu (String ma, String ten){
        this.ma = ma;
        this.ten = ten;
    }

    @Override
    public int compareTo(GameThu other){
        return other.tongGioChoi.compareTo(this.tongGioChoi);
    }

    public void TinhThoiGianChoi(LocalTime gioVao, LocalTime gioRa){
        this.tongGioChoi = Duration.between(gioVao, gioRa);
    }

    @Override
    public String toString() {
        long hours = tongGioChoi.toHours();
        long minutes = tongGioChoi.toMinutes() % 60;
        return ma + " " + ten + " " + hours + " gio " + minutes + " phut";
    }
}

public class TinhTienChoiGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int soGameThu = Integer.parseInt(sc.nextLine());
        ArrayList<GameThu> dsGameThu = new ArrayList<GameThu>();

        for (int i = 0; i < soGameThu; i++){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String gioVaoStr = sc.nextLine();
            String gioRaStr = sc.nextLine();

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime gioVao = LocalTime.parse(gioVaoStr, fmt);
            LocalTime gioRa = LocalTime.parse(gioRaStr, fmt);

            GameThu g = new GameThu(ma, ten);
            g.TinhThoiGianChoi(gioVao, gioRa);

            dsGameThu.add(g);
        }

        Collections.sort(dsGameThu);

        for (GameThu g : dsGameThu) {
            System.out.println(g);
        }
    }
}
