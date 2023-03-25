
package TH1;

import Buoi5.Xulydaysonguyen;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        VanBan vb=new VanBan();
        Day ab = new Day();
        while (true) {

            int n, m;
            int t = sc.nextInt();

            switch (t) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                   ab.nhap(sc);
                    break;

                case 2:
                    System.out.println(ab.min0());
                    break;

                case 3:
                    ab.sx();
                    ab.xuat();
                    break;

                case 4:

                    
                    break;

                case 5:

                   vb.nhap(sc);
                    break;
                case 6:
                    int cau=vb.socau();
                    int tu=vb.sotu();
                    System.out.println(tu-cau);
                case 7:

                    int cau1=vb.socau();
                    System.out.println(cau1);
                    break;
                case 8:

//                    arr.MaTranChuyenVi();
                    break;
                case 9:

//                    System.out.println(arr.amx());
                    break;
                default:
                    System.out.println("Nhap Lai");
            }
        }
        
    }
}
