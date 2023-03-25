package ICPC;
import java.util.*;
public class TamGiac {
static int nhon;
static int vuong;
static int tu;
static int n;
static int[] arr;
static int[] a;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = Integer.parseInt(in.nextLine());
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        nhon=0; vuong=0;tu=0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(a[i]+a[j]<=a[j+1]) continue;
                for(int k=j+1;k<n;k++){
                    if(a[i]+a[j]<=a[k]) break;
                    tamgiac(a[i],a[j],a[k]);
                }
            }
        }
        System.out.println(nhon+" "+vuong+" "+tu);
    }
    public static void tamgiac(int x,int y,int z){
        if(x+y>z&&y+z>x&&x+z>y){
            if(Math.abs(x*x+y*y-z*z)==0||Math.abs(x*x+z*z-y*y)==0||Math.abs(y*y+z*z-x*x)==0){
                vuong++;
            }
            else if((x*x+y*y<z*z)||(x*x+z*z<y*y)||(y*y+z*z)<x*x){
                tu++;
            }
            else {
                nhon++;
            }
        }
    }
    
}