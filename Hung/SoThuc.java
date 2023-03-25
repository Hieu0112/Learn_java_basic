
package Hung;
import java.util.Scanner;
public class SoThuc {
    private double x,epsilon;

    public SoThuc() {
        this.x=0;
        this.epsilon=0;
    }

    public SoThuc(double x, double epsilon) {
        this.x = x;
        this.epsilon = epsilon;
    }
    
    public void nhap(Scanner sc){
        this.x=Double.parseDouble(sc.nextLine());
        this.epsilon=Double.parseDouble(sc.nextLine());
    }
    public double CosX(){
        double a=1;
        int i=1;
        double s=1;
        int dau=-1;
        while(a>epsilon){
            a*=x*x/((2*(double)(i)-1)*(((double)i*2)));
            s+=dau*a;
            dau=-dau;
            i++;
        }
        return s;
    }
}
