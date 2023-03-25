package ICPC;


import java.util.*;

public class XauConTuanHoan {

    public static void main(String[] args){
  
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String s=sc.next();
        String tmp;
        while(m-->0){
            int a = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int b = sc.nextInt();
            if(a == 1){  
                tmp="";
                int lap=r-l+1;
                while(lap-->0){
                    tmp+=String.valueOf(b);
                }
                s=s.substring(0, l-1)+tmp+s.substring(r);
            }
            else{
                boolean check = true;
                for(int i = l-1; i <= r-1; i++){
                    if(i + b > n-1) break;
                    if(s.charAt(i) != s.charAt(i+b)){
                        check=!check;
                        break;
                    }
                }
                if(check) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
