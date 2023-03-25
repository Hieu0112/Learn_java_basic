
package Buoi7;
public class svv {
    private String name,code;
    private double so;

    public svv(String name, String code,double so) {
        this.name = name;
        this.code = code;
        this.so = so;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getSo() {
        return so;
    }

    
    @Override
    public String toString() {
        return name+" "+"code: "+code+" so: "+so;
    }

    
}
