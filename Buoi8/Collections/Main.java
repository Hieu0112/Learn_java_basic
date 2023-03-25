
package Buoi8.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add(123);
        c.add("Thu2");
        Iterator i=c.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
