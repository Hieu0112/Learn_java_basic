
package so4;
public class String_class {
    private String s;

    public String_class() {
    }
    
    public String_class(String s) {
        this.s = s;
    }

    public String ChuanHoa3() {
        String ss=s.trim().replaceAll("\\s+"," ").toLowerCase();
        String[] str=ss.split(" ");
        ss="";
        for(int i=0;i<str.length;i++){
            ss+=String.valueOf(str[i].charAt(0)).toUpperCase()+str[i].substring(1);
            ss+=" ";
        }
        return ss;
    }
    
    public void ChuanHoa4() {
            String ss=s.trim().toLowerCase();
            ss=ss.replaceAll("\\s+"," ");
            String[] res = ss.split(" ");
            for (int j = 0; j < res.length; j++) {
                ss = "";
                ss += String.valueOf(res[j].charAt(0)).toUpperCase() + res[j].substring(1);
                res[j] = ss;
            }
            for(int j=1;j<res.length;j++){
                    System.out.print(res[j]);
                    if(j!= res.length-1) System.out.print(" ");
                }
            System.out.println(", "+res[0].toUpperCase());
    }
    
    public String ChuanHoa5(){
        String[] res=s.split(" ");
        String a="";
        a+=res[res.length-1];
        for(int i=0;i<res.length-1;i++){
            a+=res[i].charAt(0);
        }
        return a.toLowerCase() + "@ptit.edu.vn";
    }
}
