
package KiemTra1;
public class Sin {
    private double x,epsilon;
    public Sin(double x,double epsilon){
        this.x=x;
        this.epsilon=epsilon;
    }
    public double res(){
        double a=x;
        int i=1;
        double s=a;
        int dau=-1;
        while(a>epsilon){
            a*=x*x/(2*(double)i*((double)i*2+1));
            s+=dau*a;
            dau=-dau;
            i++;
        }
        return s;
    }
}
