/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kethua;

/**
 *
 * @author trinh
 */
public class PTIT implements CongNgheTT,MaKetTinh,TruyenThong{
    @Override
    public void daicuong() {
        System.out.println("hoc cac mon dai cuong");
    }

    @Override
    public void cnMKT() {
        System.out.println("Hoc ve ma ke tinh");
    }

    @Override
    public void cnArt() {
        System.out.println("hoc ve ve");
    }

    @Override
    public void cnMash(String fname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
