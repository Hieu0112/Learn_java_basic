
package ICPC;
import java.util.*;
public class TichMax3so {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]a=new int[n];
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            arr[i]=a[i];
        }
        Arrays.sort(a);
        int max1=(a[n-3]*a[n-2]*a[n-1]);
        int max2=(a[0]*a[1]*a[n-1]);
        System.out.println(Math.max(max1, max2));
    }
}
