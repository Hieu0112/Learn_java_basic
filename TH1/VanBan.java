
package TH1;
import java.util.Scanner;
public class VanBan {
    private String str;

    public VanBan() {
    }

    public VanBan(String str) {
        this.str = str;
    }
    public void nhap(Scanner sc){
        this.str=sc.nextLine();
    }
    public int sotu(){
        String[] s=str.split("\\s+");
        return s.length;
    }
    public int socau(){
        String[] s=str.split("[\\.\\?\\!]");
        return s.length;
    }
}
