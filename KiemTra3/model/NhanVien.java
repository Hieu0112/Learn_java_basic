/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KiemTra3.model;
import KiemTra3.controller.*;
import java.io.Serializable;

/**
 *
 * @author trinh
 */
public class NhanVien implements Serializable{
    private int ma;
    private String hoten,diachi,dthoai;
    private static int sma=1000;

    public NhanVien() {
    }

    public NhanVien(int ma, String hoten, String diachi, String dthoai) {
        this.ma = ma;
        this.hoten = hoten;
        this.diachi = diachi;
        this.dthoai = dthoai;
    }

    public NhanVien(String hoten, String diachi, String dthoai) throws TrongExe,DienThoaiEx{
        if(hoten.isEmpty()||diachi.isEmpty()) throw new TrongExe();
        if(!dthoai.matches("\\d+"))
            throw new DienThoaiEx();
        this.ma = sma++;
        this.hoten = hoten;
        this.diachi = diachi;
        this.dthoai = dthoai;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDthoai() {
        return dthoai;
    }

    public void setDthoai(String dthoai) {
        this.dthoai = dthoai;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        NhanVien.sma = sma;
    }

    public Object[] toObject(){
        return new Object[]{
          ma,hoten,diachi,dthoai  
        };
    }
    
}
