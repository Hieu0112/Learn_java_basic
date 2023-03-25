
package KiemTra1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,m;
        int chon=sc.nextInt();      
        switch (chon) {
            case 1:
                n=sc.nextInt();
                fibo s=new fibo(n);
                System.out.println(s.res());
                break;
            case 2:
                n=sc.nextInt();
                TongSo s1= new TongSo(n);
                System.out.println(s1.res());
                break;
            case 3:
                n=sc.nextInt();
                m=sc.nextInt();
                KhoangSo a= new KhoangSo(n,m);
                a.res();
                break;
            case 4:
                double x=sc.nextDouble();
                double eps=sc.nextDouble();
                Sin so=new Sin(x,eps);
                System.out.println(so.res());
                break;
            default:
                return;
        }
    }
}
