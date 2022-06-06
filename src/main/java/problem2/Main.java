package problem2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanhSachCongNhan danhSachCongNhan = new DanhSachCongNhan();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hãy cho biết số lượng công nhân muốn nhập: ");
        int numberOfCongNhan = keyboard.nextInt();
        for (int i =1;i <= numberOfCongNhan ; i++){
            danhSachCongNhan.addCongNhan(i);
        }
        danhSachCongNhan.getCongNhanInfomation();
        System.out.println("Số lượng nhân viên: "+danhSachCongNhan.getNumberOfCongNhan());
        System.out.printf("Tổng lương: %.2f \n",danhSachCongNhan.totalLuong());
        System.out.println("Công nhân có số sản phẩm trên 200: ");
        System.out.println(danhSachCongNhan.getCongNhanHaveSoSPGreaterThan200().toString());
        System.out.println("Danh sách công nhân xếp theo số sản phẩm giảm dần: ");
        System.out.println(danhSachCongNhan.sortBySoSP().toString());
    }
}
