
package ICPC;

import java.util.Scanner;

public class Bo3sopytago {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long l=1,r=100000;
        if(n==100000) r--;
        long kq=n*n*2;
        boolean ok=false;
        while(l<r){
            long res=l*l+r*r;
            if(res==kq) {
                ok=true;
                break;
            }
            else if(res>kq){
                r--;
            }
            else l++;
        }
        if(ok)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
