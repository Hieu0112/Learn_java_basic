
package ICPC;

import java.util.Scanner;

public class DoanConnt {
    static boolean[] dp=new boolean[2000009];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int H=sc.nextInt();
        String P=sc.next();
        int dem=1;
        int[] a=new int[H+1];
        for(int i=2;i<2000009;i++)
            dp[i]=false;
        for(int i=2;i<2000009;i++){
		if(!dp[i]){
			a[dem++]=i;
			for(int j=2*i;j<2000009;j+=i)
				dp[j]=true;
		}
		if(dem==H+1)
                    break;
	}
        int so=0;
        for(int i=N;i<=H;i++){
            String res=String.valueOf(a[i]);
            if(res.contains(P))
                so++;
        }
        System.out.println(so);
    }
}
