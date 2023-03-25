
package Buoi8;
import java.io.Serializable;
public class VeTau implements Serializable{
    private int ma;
    private String ngay;
    private double gia;

    public VeTau() {
    }

    public VeTau(int ma, String ngay, double gia) {
        this.ma = ma;
        this.ngay = ngay;
        this.gia = gia;
    }

    @Override
    public String toString() {
        return ma+" "+ngay+" "+gia;
    }
    
}
