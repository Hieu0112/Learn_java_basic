
package Buoi7;
import java.io.*;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        xulynv nv=new xulynv();
        svv[] v=new svv[3];
        v[0]=new svv("so1","so2",200);
        v[1]=new svv("so3","so4",300);
        v[2]=new svv("so5","so6",400);
        nv.setNv(v);
        nv.setN(3);
        
        nv.viet();
        nv.doc();
    }
}
