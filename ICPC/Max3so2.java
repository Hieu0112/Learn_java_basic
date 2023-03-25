/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ICPC;

import java.util.Arrays;
import java.util.Scanner;
public class Max3so2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=0;
        int[]a=new int[n];
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            arr[i]=a[i];
        }
        Arrays.sort(a);
        int max1=(a[n-3]*a[n-2]*a[n-1]);
        int max2=(a[0]*a[1]*a[n-1]);
        if(max1>max2){
            x=a[n-3];
        }
        else x=a[0];
    }
}
