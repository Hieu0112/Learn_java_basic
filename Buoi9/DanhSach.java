
package Buoi9;
import java.util.*;
public class DanhSach{
    private  List<NhanVien> list;
    Scanner sc=new Scanner(System.in);
    public DanhSach() {
        list =new ArrayList<>();
    }

    public DanhSach(List<NhanVien> list) {
        this.list = list;
    }

    public void setList(List<NhanVien> list) {
        this.list = list;
    }
    
    public void nhap(){
        String re="^[ABC]{1}\\d{2}";
        String ma,ten,ns;
        while(true){
            try{
                ma=sc.nextLine();
                if(ma.matches(re)){
                    break;
                }
                else throw new EXep("Loi");
            }catch(EXep e){
                System.out.println(e);
            }        
        }
        ten=sc.nextLine();
        ns=sc.nextLine();
        double so=Double.parseDouble(sc.nextLine());
        NhanVien a=new NhanVien(ma, ten, ns, so);
        list.add(a);
    }
    public void hienThi(){
        for (NhanVien nhanVien : list) {
            System.out.println(nhanVien);
        }
        System.out.println("Tong so: "+list.size());
    }
    public void Luu(String fname){
        IOFiname.write(fname, list);
    }
    public void doc(String fname){
        this.list=IOFiname.read(fname);
        hienThi();
    }
    public int tim(String ma){
        for (int i = 0; i < list.size(); i++) {
             if(list.get(i).getMa().equals(ma))
                 return i;
        }
        return -1;
    }
    public int timten(){
        String nnaam=sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
             if(list.get(i).getTen().equals(nnaam))
                 return i;
        }
        return -1;
    }
    public void Sua(){
        String ma=sc.nextLine();
        int vt=tim(ma);
        if(vt==-1){
            System.out.println("NO");
        }
        else{
             list.set(vt, new NhanVien(ma,sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine())));
        }
    }
    public void xoa(){
        String ma=sc.nextLine();
        int vt=tim(ma);
        if(vt==-1){
            System.out.println("NO");
        }
        else{
             list.remove(vt);
        }
    }
    
}
