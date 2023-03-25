
package ICPC;
import java.util.Scanner;
public class LuyenICPC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            int n=sc.nextInt();
            int m=sc.nextInt();
            if(n==0&&m==0)
                break;
            int max1=Math.max(m, n);
            long[] bp=new long[max1+1];
            bp[0]=0;
            for(int i=1;i<=max1;i++){
                bp[i]=(1+1+2*(long)(i-1))*(long)i/2;
            }
            int chia=(int)(Math.sqrt(m));
            if(chia<=1) chia++;
            int het = 0,du;
            long trong=0,tong1=bp[m];
            for(int i=1;i<=Math.min(n+1,chia);i++){
                het=m/i;
                du=m%i;
                long res=i*bp[het]+bp[du];
                if(res<tong1){
                    tong1=res;
                    trong=i-1;
                }
            }
            n=(int)(n-trong);
            long x=0;
            if(trong>=1){   
                n++;
                x=trong-1;
            }
            System.out.println(x+bp[n]-tong1);
        }
    }
}
