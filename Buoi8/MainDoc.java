/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi8;

import java.util.ArrayList;
import java.util.List;

public class MainDoc {
    public static void main(String[] args) {
        List<SinhVien>list1=IOFILE.read("src/Buoi8/sv.dat");
        for (SinhVien sinhVien : list1) {
            System.out.println(sinhVien);
        }
        
        List<VeTau>list2=IOFILE.read("src/Buoi8/vt.dat");
        for (VeTau veTau : list2) {
            System.out.println(veTau);
        }
    }
}
