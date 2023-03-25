/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KiemTra1;

/**
 *
 * @author trinh
 */
public class KhoangSo {
    private int n,m;
    public KhoangSo(int n,int m){
        this.n=n;
        this.m=m;
    }
    public void res(){
        for(int i=n;i<=m;i++){
            boolean ok=true;
            if(i<2) ok=false;
            if(ok)
                for(int j=2;j<=(int)Math.sqrt(i)+1;j++)
                    if(i%j==0){
                        ok=false;
                        break;
                    }
            if(ok)
                System.out.println(i+" ");
        }
        System.out.println("");
    }
}
