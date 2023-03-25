
package Buoi10.GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField; 
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Main extends JFrame 
//        implements DocumentListener
//        c1: implements ActionListener
{
    private JLabel lb1;
    private JTextField ta,tb,tc;
    private JButton bt1,bt2;
    private void InitCpmponents(){
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setTitle("Giai Phuong trinh Bac 2");
        setLayout(new GridLayout(5, 2));
        add(new JLabel("Nhap a:"));
        ta=new JTextField();
        add(ta);
        
        add(new JLabel("Nhap b:"));
        tb=new JTextField();
        add(tb);
        
        add(new JLabel("Nhap c:"));
        tc=new JTextField();
        add(tc);
        
        add(new JLabel("Ket qua :"));
        lb1=new JLabel("Nhap");
        add(lb1);
        
        bt1=new JButton("Lam Lai");
        add(bt1);
        bt2=new JButton("Giai Phuong Trinh");
        add(bt2);
        
        bt1.addActionListener(new ActionListener() {
            //c2
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
                tb.setText("");
                tc.setText("");
                ta.requestFocus();
                bt2.setEnabled(false);
            }
        });
        bt2.addActionListener(ex->{
            String sa=ta.getText();
            String sb=tb.getText();
            String sc=tc.getText();
            double a,b,c;
            try{
                String rt="";
                a=Double.parseDouble(sa);
                b=Double.parseDouble(sb);
                c=Double.parseDouble(sc);
                double dt=b*b-4*a*c;
                if(dt==0){
                    rt="Phuong Trinh co Nghiem Kep X1=X2="+-b/(2*a);
                }
                else if(dt<0){
                    rt="PT vo Ngiem";
                }
                else{
                    rt="X1= "+(-b-Math.sqrt(dt))/(2*a)+"X2= "+ (-b+Math.sqrt(dt))/(2*a);
                }
                lb1.setForeground(Color.blue);
                lb1.setText(rt);
            }
            catch(NumberFormatException e){
                lb1.setForeground(Color.red);
                lb1.setText("Vui Long Nhap So");
            }
        });
        ta.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               check();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            });
        tb.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               check();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
                }
        );
        tc.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               check();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
                }
        );
    }
    private void check(){
        String sa=ta.getText();
        String sb=tb.getText();
        String sc=tc.getText();
        String re="^[0-9]+\\.?\\d";
        if((!sa.matches(re))||(!sb.matches(re))||(!sc.matches(re))){
            lb1.setForeground(Color.red);
            lb1.setText("Nhap So");
            bt1.setEnabled(true);
        }
        else{
            bt2.setEnabled(true);
        }
        if(sa.isEmpty()||sb.isEmpty()||sc.isEmpty()){
            bt1.setEnabled(false);
            lb1.setText("Nhap So");
            bt2.setEnabled(false);
        }
    }
    public Main(){
        InitCpmponents();
        bt1.setEnabled(false);
        bt2.setEnabled(false);
    }
    public static void main(String[] args) {
        Main m=new Main();
        m.setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//    
//    }
}
