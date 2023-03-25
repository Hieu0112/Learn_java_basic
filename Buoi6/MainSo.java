/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi6;

import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class MainSo {
    public static void main(String[] args) {
        String res="-?\\d+.?\\d+";
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.matches(res))
            System.out.println(s);
    }
}
