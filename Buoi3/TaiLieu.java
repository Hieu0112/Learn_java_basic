
package Buoi3;
import java.util.*;
public class TaiLieu {
    private String ma,name;
    private int so;

    public TaiLieu() {
    }
    
    public TaiLieu(String ma, String name, int so) {
        String x="0";
        if(so>=1000) x="1";
        this.ma = x+ma;
        this.name = name;
        this.so = so;
    }
    public void Nhap(Scanner sc){
        this.ma=sc.nextLine();
        this.name=sc.nextLine();
        this.so=Integer.parseInt(sc.nextLine());
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSo() {
        return so;
    }
    
    @Override
    public String toString() {
        return ma+" "+name+" "+so;
    }
    
    
}
