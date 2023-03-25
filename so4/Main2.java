
package so4;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String_class a=new String_class();
        while(true){
            int var=Integer.parseInt(sc.nextLine());
            switch (var) {
                case 0:
                     System.exit(0);
                    break;
                case 1:
                    a=new String_class(sc.nextLine());
                    break;
                case 2:
                    System.out.println(a.ChuanHoa3());
                    break;
                case 3:
                    a.ChuanHoa4();
                    break;
                case 4:
                    System.out.println(a.ChuanHoa5());
                    break;    
                default:
                   continue;
                   
            }
        }
    }
}
