
package File;
import java.io.*;
import java.util.Scanner;
public class GhiFile {
    public static void main(String[] args) throws IOException {
    FileWriter myWriter = new FileWriter("HieuDepTrai.txt");
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    myWriter.write(s+"\n");
    myWriter.close();
    } 
}

