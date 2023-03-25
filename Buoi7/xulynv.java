/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi7;


import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class xulynv {
    private svv[] nv;
    private int n;

    public xulynv() {
        nv=new svv[100];
        n=0;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setNv(svv[] nv) {
        this.nv = nv;
    }
    
    public void viet(){
        PrintWriter p=null;
        String st="";
        for(int i=0;i<n;i++){
            try{
                p=new PrintWriter("src/Buoi7/file1.txt");
                
                st+=nv[i].getCode()+","+nv[i].getName()+","+nv[i].getSo()+"\n";
                
            }
            catch(FileNotFoundException e){
                
            }
        }
        p.print(st);
        p.close();
    }
    public void doc(){
        svv[] nv=new svv[100];
        int n=0;
        try{
            BufferedReader bf=new BufferedReader(new FileReader("src/Buoi7/file1.txt"));
            String line="";
            while((line=bf.readLine())!=null){
                String[] s=line.split(",");
                nv[n++]=new svv(s[0],s[1],Double.parseDouble(s[2]));
            }
            bf.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        setN(n);
        setNv(nv);
    }
    public void hienthi(){
        for(int i=0;i<n;i++){
            System.out.println(nv[i]);
        }
    }
}
