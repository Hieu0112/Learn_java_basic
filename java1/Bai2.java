package java1;
import java.util.Scanner;
public class Bai2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        
        double s=Math.pow(Math.E, Math.sin(x)+7);
        double mau=x+Math.log(x+ Math.pow(Math.E, 2));
        System.out.println(s/mau);
    }
}
