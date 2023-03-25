
package Buoi8;
import java.io.Serializable;
public class SinhVien implements Serializable{
    private String ma,name;

    public SinhVien() {
    }
    
    public SinhVien(String ma, String name) {
        this.ma = ma;
        this.name = name;
    }

    public String getMa() {
        return ma;
    }

    public String getName() {
        return name;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ma+" "+name;
    }
    
}
