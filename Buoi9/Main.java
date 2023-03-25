
package Buoi9;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        DanhSach ds=new DanhSach();
        String src="src/Buoi9/NhanVien.dat";
        Scanner sc=new Scanner(System.in);
        while (true) {            
            int t=Integer.parseInt(sc.nextLine());
            switch (t) {
                case 1:
                    ds.nhap();
                    break;
                case 2:
                    ds.hienThi();
                    break;
                case 3:
                    ds.Luu(src);
                    break;
                case 4:
                    ds.doc(src);
                    break;
                case 5:
                    ds.xoa();
                    break;
                case 6:
                    ds.Sua();
                    break;
                case 7:
                    int x=ds.timten();
                    System.out.println(x);
                    break;  
            }
        }
    }
}
