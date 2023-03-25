
package Buoi8;
//Doc ra
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//Viet vao
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class IOFILE {
    //Doc ra
    public static <T> List <T> read(String fname){
        List<T> list =new ArrayList<>();
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
    //Viet vao
    public static <T> void write(String fname,List<T> arr){
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
