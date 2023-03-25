
package GUI5.controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
public class IOEFIle {
    //Doc File
    public static <T> List <T> Doc(String fname){
        List<T> list=new ArrayList<>();
        try{
            ObjectInputStream o=new ObjectInputStream(new FileInputStream(fname));
            list=(List<T>)o.readObject();
        }
        catch(IOException e){
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return list;
    }
    
    //Viet vao file
    public static void Viet(String fname,List arr){
        try{
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(fname));
            o.writeObject(arr);
            o.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}
