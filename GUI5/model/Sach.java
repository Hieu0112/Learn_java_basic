
package GUI5.model;

import java.io.Serializable;

public class Sach implements Serializable{
    private int ma;
    private String name,tgia,cn;
    private int sl;
    private static int sma=10000;

    public Sach() {
        ma=sma++;
    }

    public Sach(int ma, String name, String tgia, String cn, int sl) {
        this.ma = ma;
        this.name = name;
        this.tgia = tgia;
        this.cn = cn;
        this.sl = sl;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTgia() {
        return tgia;
    }

    public void setTgia(String tgia) {
        this.tgia = tgia;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Sach.sma = sma;
    }
    public Object[] toObjects(){
        return new Object[]{
            ma,name,tgia,cn,sl
        };
    }
}
