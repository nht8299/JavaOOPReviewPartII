package problem2;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CongNhan {
    private String maCN;
    private String mHo;
    private String mTen;
    private Integer mSoSP;
    private double luong;

    public double getLuong() {
        return tinhLuong();
    }

    private double tinhLuong() {
        if ( mSoSP >= 600 ) {
            luong = mSoSP * 0.65;
        } else if ( mSoSP >= 400 ) {
            luong = mSoSP * 0.6;
        } else if ( mSoSP >= 200 ) {
            luong = mSoSP * 0.55;
        } else luong = mSoSP * 0.5;
        return luong;
    }
}
