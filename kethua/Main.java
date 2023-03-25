/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kethua;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author trinh
 */
public class Main {
    public static void main(String[] args) {
        CongNgheTT cn=new PTIT();
        PTIT pt=new PTIT();
        List list =new  Vector();
        TruyenThong t=new TruyenThong(){
            @Override
            public void cnArt() {
                int x=90;
                System.out.println(x);
            }
            @Override
            public void cnMash(String name) {
                System.out.println("hello"+name );
        }
        };
        t.cnArt();
        t.cnMash("Khoa CNTT");
        Demo demo=new Demo("ptit") {
            @Override
            public void lay() {
                System.out.println(this.getName());
            }
        };
        demo.lay();
    }
}
