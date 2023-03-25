/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kethua;

public interface CongNgheTT {
    public static final int SO_Tin=96;
    public String khoi="A";
    public static String ngoaingu(){
        return "Tieng anh";
    }
    public default void cnRieng(){
        System.out.println("Tuy truong");
    }
    //prototype
    public void daicuong();
}
