
package so4;
import java.util.*;
public class Matrix {
    private int n,m;
    private int[][] matrixs;

    public Matrix() {
    }
    
    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrixs=new int[n][m];
    }

    public Matrix(int[][] matrixs) {
        this.n=matrixs.length;
        this.n=matrixs[0].length;
        this.matrixs = matrixs;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }
    
    public void nhap(Scanner sc){
        int [][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        this.matrixs=arr;
    }
    public int nMAxTong(){
        int sum=0;
        int hang=0;
        for(int i=0;i<n;i++){
            int sum1=0;
            for(int j=0;j<m;j++){
                sum1+=this.matrixs[i][j];
            }
            if(sum1>sum){
                hang=i;
            }
        }
        return hang;
    }

    public int[][] getMatrixs() {
        return matrixs;
    }
    
    public Matrix Hieu(Matrix b){
        int [][]arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=matrixs[i][j]-b.getMatrixs()[i][j];
            }
        }
        return new Matrix(arr);
    }
    public boolean Doixung(){
        m=n;
        for (int i=0; i<n-1; i++)
        for (int j=i+1; j<m; j++)
            if (matrixs[i][j]!=matrixs[j][i])
                return false;
        return true;
    }
}
