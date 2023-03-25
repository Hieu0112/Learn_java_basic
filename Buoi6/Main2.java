/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi6;

/**
 *
 * @author trinh
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String re="[a-zA-Z ]+";
        String rema="B\\d{2}[a-zA-Z]{4}\\d{3}$";
        
        SinhVien a;
        String ten;
        while(true){
            try{
            System.err.println("ten: ");
            ten=sc.nextLine();
            if(ten.matches(re)){
                break;
            }
            else throw new NgoaiLename("Ten sai dinh dang");
            }
            catch(NgoaiLename e){
                System.err.print(e);
            }
        }
        System.out.println(ten);
        String ma;
        while(true){
            try{
            System.err.println("ma: ");
            ma=sc.nextLine();
            if(ma.matches(rema)){
                break;
            }
            else throw new NgoaiLeMSV("ma sai dinh dang");
            }
            catch(NgoaiLeMSV e){
                System.err.print(e);
            }
        }
        System.out.println(ma);
        String so;
        int reso=0;
        while(true){
            try{
            System.err.println("so: ");
            so=sc.nextLine();
            if(Integer.parseInt(so)>0){
                break;
            }
            else throw new Ngoaileso("so sai dinh dang");
            }
            catch(Ngoaileso e){
                System.err.print(e);
            }
        }
        System.out.println(so);
        a=new SinhVien(ma, ten, Integer.parseInt(so));
    }
}