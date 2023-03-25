package ICPC;

import java.util.*;
import java.math.*;
public class giaiThua {
    static long mod=1000033;
    static long chia(long n,long k){
        if(k==0)
            return 1;
        else{
            long x=chia(n,k/2)%mod;
            if(k%2==0)
                return (x*x)%mod;
            else 
                return (n*((x*x)%mod))%mod;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long l=sc.nextLong()%mod;
            long r=sc.nextLong()%mod;
            long k=sc.nextLong()%mod;
            long gtL=1;
            for(long i=1;i<=l;i++){
                gtL*=i;
                gtL%=mod;
            }
            for(long i=l+1;i<=r;i++){
                gtL=gtL*gtL*i;
                gtL%=mod;
            }
            System.out.println(chia(gtL, k));
        }
        
    }

}
