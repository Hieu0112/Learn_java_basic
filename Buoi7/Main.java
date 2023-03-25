
package Buoi7;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args){
        try{
            File file=new File("src/Buoi7/info.txt");
            Scanner sc=new Scanner(file);
            double sum=0;
            while(sc.hasNextLine()){
                sum=0;
                String line=sc.nextLine();
                line=line.replaceAll("\\s+"," ");
                String[] arr=line.split(";");
                System.out.print("name: "+arr[1].trim()+" ");
                System.out.print("ID#"+arr[0].trim()+" ");
               
                for(int i=2;i<arr.length;i++){
                    try{
                        sum+=Double.parseDouble(arr[i]);
                    }
                    catch(NumberFormatException e){
                        
                    }
                }
                    
                System.out.print("Time: ");
                System.out.format("%.1f\n",sum);
                System.out.format("%.1f",sum/(arr.length-2));
                System.out.println(" hours/day");
            }
            
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
