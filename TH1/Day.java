
package TH1;

import java.util.Scanner;

public class Day {
    private int[] a;

    public Day(int[] a) {
        this.a = a;
    }
    public Day() {
    }
    public void dayso(int[] a) {
        this.a = a;
    }
    public void nhap(Scanner sc){
        int so=sc.nextInt();
        int [] arr=new int[so];
        for(int i=0;i<so;i++){
            arr[i]=sc.nextInt();
        }
        this.a=arr;
    }
    public int min0(){
        int so=999999999;
        for(int i=0;i<so;i++){
            if(so>a[i]&&a[i]>=0){
                so=a[i];
            }
        }
        return so;
    }
    public void xuat(){
       
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    public void sx(){
        for(int i=2;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]<=a[j]){
                    int tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                }
            }
        }
    }
}
