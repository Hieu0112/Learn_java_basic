
package so4;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Matrix a=new Matrix();
        while(true){
            int t=sc.nextInt();
            switch (t) {
                case 1:
                    a=new Matrix(sc.nextInt(),sc.nextInt());
                    break;
                case 2:
                    a.nhap(sc);
                    break;
                case 3:
                        System.out.println(a.nMAxTong());
                    break;
                case 4:
                    Matrix a1=new Matrix(sc.nextInt(),sc.nextInt());
//                    int[][] arr=new int[a1.getN(),a1.getM());
                        a.Hieu(a1);
                    break;
                case 5:
                    System.out.println(a.Doixung());
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
