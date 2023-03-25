
package Buoi6;
import java.util.Scanner;
public class SinhVien {
    private String ma,name;
    private int tuoi;
    public SinhVien() {
    }
    public SinhVien(String ma, String name, int tuoi) {
        this.ma = ma;
        this.name = name;
        this.tuoi = tuoi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    
    public String toString(){
        return ma+" "+name+" "+tuoi;
    }
    
}
