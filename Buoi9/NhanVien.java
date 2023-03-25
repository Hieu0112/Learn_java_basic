/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi9;
import java.io.Serializable;
import java.util.*;
public class NhanVien implements Serializable{
    private String ma ,ten,ns;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String ns, double luong) {
        this.ma = ma;
        this.ten = ten;
        this.ns = ns;
        this.luong = luong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    
    @Override
    public String toString() {
        return ma + " "+ ten+" "+ns+" "+" "+ String.format("%.2f",luong);
    }
    
}

