/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KiemTra1;
public class TongSo {
    private int n;
    public TongSo(int n){
        this.n=n;
    }
    public long res(){
        int so=0;
        while(n>0){
            so+=n%10;
            n/=10;
        }
        return so;
    }
}
