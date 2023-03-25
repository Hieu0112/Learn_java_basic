package ICPC;


import java.util.*;
public class TichMax2 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = Integer.parseInt(in.nextLine());
       long[] a = new long[n+1];
       long[] b = new long[n+1];
       b[0] = 0;
       b[1]=0;
       for(int i=0;i<n;i++){
           a[i] = in.nextLong();
       }
       ArrayList<Long> list = new ArrayList<>();
       list.add(a[0]);
       list.add(a[1]);
       for(int i=2;i<n;i++){
           list.add(a[i]);
           Collections.sort(list);
           long max1 = list.get(list.size()-1)*list.get(list.size()-2)*list.get(list.size()-3);
           long max2 = list.get(0)*list.get(1)*list.get(list.size()-1);
           b[i] = Math.max(max1,max2);
       }
       for(int i=0;i<n;i++){
           System.out.print(b[i]+" ");
       }
    }
    
}
