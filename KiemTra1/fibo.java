
package KiemTra1;
public class fibo {
    private int n;
    public fibo(int n){
        this.n=n;
    }

    fibo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public long res(){
        long[] arr=new long[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++)
            arr[i]=arr[i-2]+arr[i-1];
        return arr[n];
    }
}
