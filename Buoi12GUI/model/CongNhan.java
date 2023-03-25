/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi12GUI.model;

import java.io.Serializable;

/**
 *
 * @author trinh
 */
public class CongNhan implements Serializable{
    private int ma;
    private String hoten,dchi,dthoai;
    private int bac;

    public CongNhan() {
    }

    public CongNhan(int ma, String hoten, String dchi, String dthoai, int bac) {
        this.ma = ma;
        this.hoten = hoten;
        this.dchi = dchi;
        this.dthoai = dthoai;
        this.bac = bac;
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

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getDthoai() {
        return dthoai;
    }

    public void setDthoai(String dthoai) {
        this.dthoai = dthoai;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }
    public Object[] toObject(){
        return new Object[]{
          ma,hoten,dchi,dthoai,bac  
        };
    }
}
