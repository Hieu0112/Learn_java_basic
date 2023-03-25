
package ICPC;
import java.util.Scanner;
public class LamTronSo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.next();
        long so=Long.parseLong(n);
        if(n.length()<=1){
            System.out.println(n);
        }    
        else{
            int x=n.charAt(0)-'0';
            int len=n.length()-2;
            int len1=len+1;
            String res=String.valueOf(x)+"5";
            while(len-->0){
                res+="0";
            }
            if(so>=Long.parseLong(res))
                x++;
            String res1=String.valueOf(x);
            while(len1-->0)
                res1+="0";
            System.out.println(res1);
        }
    }
}
