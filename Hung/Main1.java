
package Hung;
import java.util.Scanner;
        
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        SoThuc st=new SoThuc();
        while(true){
        int x=Integer.parseInt(sc.nextLine());
        switch (x) {
            case 8:
                st.nhap(sc);
                break;
            case 9:
                System.out.println(st.CosX());
                break;
            }
        }
    }
}
