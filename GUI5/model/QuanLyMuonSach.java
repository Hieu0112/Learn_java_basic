
package GUI5.model;

import java.io.Serializable;

public class QuanLyMuonSach implements Serializable{
    private BanDoc bandoc;
    private Sach sach;
    private int sl;
    private String tt;

    public QuanLyMuonSach() {
    }

    public QuanLyMuonSach(BanDoc bandoc, Sach sach, int sl, String tt) {
        this.bandoc = bandoc;
        this.sach = sach;
        this.sl = sl;
        this.tt = tt;
    }

    public BanDoc getBandoc() {
        return bandoc;
    }

    public void setBandoc(BanDoc bandoc) {
        this.bandoc = bandoc;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }
    public String getMavaName(){
        return bandoc.getMa()+"-"+bandoc.getHoten();
    }
    public Object[] toObject(){
        return new Object[]{
            bandoc.getMa(),bandoc.getHoten(),
            sach.getMa(),sach.getName(),sl,tt
        };
    }
}
