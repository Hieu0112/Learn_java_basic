
package Buoi8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SinhVien>lsv=new ArrayList<>();
        lsv.add(new SinhVien("B10","ABC"));
        lsv.add(new SinhVien("B11","ABD"));
        lsv.add(new SinhVien("B12","BCD"));
        IOFILE.write("src/Buoi8/sv.dat", lsv);
        List<VeTau>lvt=new ArrayList<>();
        lvt.add(new VeTau(10,"ASn",10.0));
        lvt.add(new VeTau(11,"Awn",11.0));
        lvt.add(new VeTau(12,"Aadn",12.0));
        IOFILE.write("src/Buoi8/vt.dat", lvt);
    }
    
}
