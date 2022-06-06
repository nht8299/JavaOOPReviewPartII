package problem2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanhSachCongNhan {
    List<CongNhan> danhSachCongNhan = new ArrayList<>();

    public List<CongNhan> addCongNhan(int number){
       danhSachCongNhan.add(createCongNhan(number));
       return danhSachCongNhan;
    }
    public CongNhan createCongNhan(int number){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhập mã công nhân "+number +" : ");
        String newMaCN = keyboard.nextLine();
        System.out.println("Nhập Họ của công nhân: ");
        String newHoCN = keyboard.nextLine();
        System.out.println("Nhập Tên của công nhân: ");
        String newTenCN = keyboard.nextLine();
        System.out.println("Nhập số sản phẩm của công nhân: ");
        Integer newSoSP = keyboard.nextInt();

        while (newSoSP <= 0){
            System.out.println("Lỗi! Vui lòng nhập lại số sản phẩm lớn hơn 0!");
            newSoSP = keyboard.nextInt();
        }
        CongNhan newCongNhan = CongNhan.builder()
                .maCN(newMaCN)
                .mHo(newHoCN)
                .mTen(newTenCN)
                .mSoSP(newSoSP)
                .build();
        return newCongNhan;
    }

    public Integer getNumberOfCongNhan(){
        return danhSachCongNhan.size();
    }
    public CongNhan getAllCongNhan(){
        CongNhan getCongNhan = null;
        for (CongNhan congNhan:danhSachCongNhan) {
            getCongNhan = congNhan;
        }
        return getCongNhan;
    }
    public void getCongNhanInfomation(){
        for (CongNhan congNhan:danhSachCongNhan
             ) {
            System.out.println(congNhan.toString());
        }
    }
    public double totalLuong(){
        double totalLuong = 0;
        for (CongNhan congNhan:danhSachCongNhan) {
            totalLuong += congNhan.getLuong();
        }
        return totalLuong;
    }
    public CongNhan getCongNhanHaveSoSPGreaterThan200(){
        CongNhan getCongNhan = null;
        for (CongNhan congNhan:danhSachCongNhan) {
           if ( congNhan.getMSoSP() > 200 ){
               getCongNhan = congNhan;
           }
        }
        return getCongNhan;
    }
    public List<CongNhan>sortBySoSP(){
        Collections.sort(danhSachCongNhan, new Comparator<CongNhan>() {
            @Override
            public int compare(CongNhan o1, CongNhan o2) {
                return o2.getMSoSP()-o1.getMSoSP();
            }
        });
        return danhSachCongNhan;
    }
}
