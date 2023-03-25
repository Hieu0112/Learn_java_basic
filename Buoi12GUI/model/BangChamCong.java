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
public class BangChamCong implements Serializable{
    private CongNhan congnhang;
    private XuongSanXuat xuong;
    private int songay;

    public BangChamCong() {
    }

    public BangChamCong(CongNhan congnhang, XuongSanXuat xuong, int songay) {
        this.congnhang = congnhang;
        this.xuong = xuong;
        this.songay = songay;
    }

    public CongNhan getCongnhang() {
        return congnhang;
    }

    public void setCongnhang(CongNhan congnhang) {
        this.congnhang = congnhang;
    }

    public XuongSanXuat getXuong() {
        return xuong;
    }

    public void setXuong(XuongSanXuat xuong) {
        this.xuong = xuong;
    }

    public int getSongay() {
        return songay;
    }

    public void setSongay(int songay) {
        this.songay = songay;
    }
    
    public String vietTK(){
        return congnhang.getMa()+":"+congnhang.getHoten();
    }
    public int getThuNhap(){
        return songay*xuong.getHeso()*140000;
    }
    public Object[] toObject(){
        return new Object[]{
            congnhang.getMa(),congnhang.getHoten(),
            xuong.getMa(),songay
        };
    }
}
