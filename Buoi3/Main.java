
package Buoi3;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TaiLieu tl=new TaiLieu();
        while(true){
            int so=Integer.parseInt(sc.nextLine());
            switch (so) {
                case 0:
                    System.exit(0);
                case 1:
                    tl=new TaiLieu(sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()));
                    break;
                case 2:
                    System.out.println(tl.toString());
                    break;
                case 3:
                    tl.setName(sc.nextLine());
                    break;
                case 4:
                    System.out.println(tl.getSo());
                    break;
                default:
                    System.out.println("NhapLai");
            }
        }
    }
}
