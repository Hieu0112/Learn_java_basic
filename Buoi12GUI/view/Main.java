package Buoi12GUI.view;

import Buoi12GUI.controller.IOEFIle;
import Buoi12GUI.controller.ValidEx;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Buoi12GUI.model.BangChamCong;
import Buoi12GUI.model.CongNhan;
import Buoi12GUI.model.XuongSanXuat;

/**
 *
 * @author trinh
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private List<CongNhan> listCN;
    private List<XuongSanXuat> listXuong;
    private List<BangChamCong> listBangCC;
    DefaultTableModel tmCN,tmXuong,tmBangCC;
    private String fCN,fXuong,fBangCC;
    public Main() {
        initComponents();
        fCN="src/Buoi12GUI/controller/CN.dat";
        fXuong="src/Buoi12GUI/controller/XSX.dat";
        fBangCC="src/Buoi12GUI/controller/BangCC.dat";
        if((new File(fCN)).exists()){
            listCN=IOEFIle.Doc(fCN);
        }
        else
            listCN=new ArrayList<>();
        
        if((new File(fXuong)).exists()){
            listXuong=IOEFIle.Doc(fXuong);
        }
        else
            listXuong=new ArrayList<>();
        
        if((new File(fBangCC)).exists()){
            listBangCC=IOEFIle.Doc(fBangCC);
        }
        else
            listBangCC=new ArrayList<>();
        
        tmCN=(DefaultTableModel)tbCN.getModel();
        tmXuong=(DefaultTableModel)tbXuong.getModel();
        tmBangCC=(DefaultTableModel)tbBangCC.getModel();
        docCN();
        docXuong();
        docBangCC();
        setButtonCN(true);
        setButtonXuong(true);
        eventCN();
        eventXuong();
        eventBangCC();
        
        thongkeBT.addActionListener(e->{
            Map<String,Integer>sum=listBangCC.stream().collect(Collectors.groupingBy(
                    BangChamCong::vietTK,Collectors.summingInt(BangChamCong::getThuNhap)
            ));
            thongketxt.setText(sum.toString());
        });
    }
    private void docCN(){
        tmCN.setRowCount(0);
        for (CongNhan congNhan : listCN) {
            tmCN.addRow(congNhan.toObject());
        }
    }
    private void docXuong(){
        tmXuong.setRowCount(0);
        for (XuongSanXuat x:listXuong) {
            tmXuong.addRow(x.toObject());
        }
    }
    private void docBangCC(){
        tmBangCC.setRowCount(0);
        for (BangChamCong bcc:listBangCC) {
            tmBangCC.addRow(bcc.toObject());
        }
    }
    private void setButtonCN(boolean b){
        themCNBT.setEnabled(b);
        capnhatCNBT.setEnabled(!b);
        boquaCNBT.setEnabled(!b);
    }
    private void setButtonXuong(boolean b){
        themXBT.setEnabled(b);
        capnhatXBT.setEnabled(!b);
        boquaXBT.setEnabled(!b);
    }
    private void eventCN(){
        themCNBT.addActionListener(e->{
            maCN.setText(1000+listCN.size()+"");
            hotenCN.requestFocus();
            setButtonCN(false);
        });
        capnhatCNBT.addActionListener(e->{
            try{
                if(!dthoaiCN.getText().matches("\\d+"))
                    throw new ValidEx("Dien thoai nhap so");
                CongNhan c=new CongNhan(Integer.parseInt(maCN.getText()),
                hotenCN.getText(),dchiCN.getText(),dthoaiCN.getText(),
                        Integer.parseInt(bacCN.getSelectedItem().toString())
                );
                listCN.add(c);
                tmCN.addRow(c.toObject());
                setButtonCN(true);
            }catch(ValidEx ex){
                JOptionPane.showMessageDialog(this, ex);
                dthoaiCN.setText("");
                dthoaiCN.requestFocus();
            }
        });
        xoaCNBT.addActionListener(e->{
        int row=tbCN.getSelectedRow();
        if(row>=0&&row<tbCN.getRowCount()){
            listCN.remove(row);
            tmCN.removeRow(row);
        }
        else{
            JOptionPane.showMessageDialog(this,"Chon dong de xoa");
        }
        });
        LuuCNBT.addActionListener(e->{
            IOEFIle.Viet(fCN, listCN);
        });
        boquaCNBT.addActionListener(e->{
            setButtonCN(true);
        });
    }
//    EVENT XUONG
    private void eventXuong(){
        themXBT.addActionListener(e->{
            maXuong.setText(100+listXuong.size()+"");
            tenXuong.requestFocus();
            setButtonXuong(false);
        });
        
        capnhatXBT.addActionListener(e->{
            XuongSanXuat x=new XuongSanXuat(
                    Integer.parseInt(maXuong.getText()),tenXuong.getText(),
                    Integer.parseInt(hesoXuong.getSelectedItem().toString()));
            listXuong.add(x);
            tmXuong.addRow(x.toObject());
            setButtonXuong(true);
        });
        
        suaXBT.addActionListener(e->{
        int row=tbXuong.getSelectedRow();
        if(row>=0&&row<tbXuong.getRowCount()){
            XuongSanXuat x=new XuongSanXuat(
                    Integer.parseInt(maXuong.getText()),tenXuong.getText(),
                    Integer.parseInt(hesoXuong.getSelectedItem().toString()));
            listXuong.set(row, x);
            tmXuong.removeRow(row);
            tmXuong.insertRow(row, x.toObject());
        }
        else{
            JOptionPane.showMessageDialog(this,"Chon dong de sua");
        }
        });
        LuuXBT.addActionListener(e->{
            IOEFIle.Viet(fXuong, listXuong);
        });
        boquaXBT.addActionListener(e->{
            setButtonXuong(true);
        });
    }
//    EVENT BANG CHAM CONG
    private int getSoNgay(int maCN){
        int so=0;
        for(BangChamCong i:listBangCC){
            if(i.getCongnhang().getMa()==maCN){
                so+=i.getSongay();
            }
        }
        return so;
    }
    private CongNhan getCongNhan(int ma){
        for (CongNhan congNhan : listCN) {
            if(congNhan.getMa()==ma)
                return congNhan;
        }
        return null;
    }
    private XuongSanXuat getSanXuat(int ma){
        for (XuongSanXuat i:listXuong) {
            if(i.getMa()==ma)
                return i;
        }
        return null;
    }
    private void eventBangCC(){
        lamtuoiBT.addActionListener(e->{
            maCNCB.removeAllItems();
            for (CongNhan congNhan : listCN) {
                maCNCB.addItem(congNhan.getMa()+"");
            }
            maXuongCB.removeAllItems();
            for (XuongSanXuat xsx:listXuong) {
                maXuongCB.addItem(xsx.getMa()+"");
            }
        });
        themBangCC.addActionListener(e->{
            try{
                int maCN=Integer.parseInt(maCNCB.getSelectedItem().toString());
                int maX=Integer.parseInt(maXuongCB.getSelectedItem().toString());
                int ngay=Integer.parseInt(soNgay.getText());
                if(getSoNgay(maCN)+ngay>31){
                    JOptionPane.showMessageDialog(this,"SO ngay lon hon 31");
                }
                else{
                    BangChamCong b=new BangChamCong(getCongNhan(maCN), 
                            getSanXuat(maX), ngay);
                    listBangCC.add(b);
                    tmBangCC.addRow(b.toObject());
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "NHAP SO");
            }
        });
        luuBangCC.addActionListener(e->{
            IOEFIle.Viet(fBangCC, listBangCC);
        });
        sxepBT.addActionListener(e->{
            int index=sxepCB.getSelectedIndex();
            if(index==0){
                listBangCC.sort(new Comparator<BangChamCong>(){
                    @Override
                    public int compare(BangChamCong o1, BangChamCong o2) {
                        String[] t1=o1.getCongnhang().getHoten().split("\\s+");
                        String[] t2=o2.getCongnhang().getHoten().split("\\s+");
                        String ten1=t1[t1.length-1]+o1.getCongnhang().getHoten();
                        String ten2=t2[t2.length-1]+o1.getCongnhang().getHoten();
                        return ten1.compareToIgnoreCase(ten2);
                    }
                    
                });
            }
            if(index==1){
                listBangCC.sort(new Comparator<BangChamCong>(){
                    @Override
                    public int compare(BangChamCong o1, BangChamCong o2) {
                        return o1.getSongay()-o2.getSongay();
                    }
                });
            }
            
            tmBangCC.setRowCount(0);
            for (BangChamCong i:listBangCC) {
                tmBangCC.addRow(i.toObject());
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCN = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maCN = new javax.swing.JTextField();
        hotenCN = new javax.swing.JTextField();
        dchiCN = new javax.swing.JTextField();
        dthoaiCN = new javax.swing.JTextField();
        bacCN = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        themCNBT = new javax.swing.JButton();
        capnhatCNBT = new javax.swing.JButton();
        boquaCNBT = new javax.swing.JButton();
        xoaCNBT = new javax.swing.JButton();
        LuuCNBT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbXuong = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        maXuong = new javax.swing.JTextField();
        tenXuong = new javax.swing.JTextField();
        hesoXuong = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        themXBT = new javax.swing.JButton();
        capnhatXBT = new javax.swing.JButton();
        boquaXBT = new javax.swing.JButton();
        suaXBT = new javax.swing.JButton();
        LuuXBT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBangCC = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        maCNCB = new javax.swing.JComboBox<>();
        maXuongCB = new javax.swing.JComboBox<>();
        soNgay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        sxepCB = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        themBangCC = new javax.swing.JButton();
        luuBangCC = new javax.swing.JButton();
        sxepBT = new javax.swing.JButton();
        lamtuoiBT = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        thongketxt = new javax.swing.JTextArea();
        thongkeBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma", "Ho va ten", "Dia chi", "Dien thoai", "Bac"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCN);
        if (tbCN.getColumnModel().getColumnCount() > 0) {
            tbCN.getColumnModel().getColumn(3).setResizable(false);
            tbCN.getColumnModel().getColumn(4).setResizable(false);
            tbCN.getColumnModel().getColumn(4).setHeaderValue("Bac");
        }

        jLabel1.setText("Ma");

        jLabel2.setText("Ho ten");

        jLabel3.setText("Dia chi");

        jLabel4.setText("Dien thoai");

        jLabel5.setText("Bac");

        bacCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maCN)
                    .addComponent(hotenCN)
                    .addComponent(dchiCN)
                    .addComponent(dthoaiCN)
                    .addComponent(bacCN, 0, 380, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(maCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(hotenCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dchiCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dthoaiCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bacCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        themCNBT.setText("Them");

        capnhatCNBT.setText("Cap nhat");

        boquaCNBT.setText("Bo qua");

        xoaCNBT.setText("Xoa");

        LuuCNBT.setText("Luu vao file");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boquaCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capnhatCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(themCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xoaCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LuuCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themCNBT)
                    .addComponent(xoaCNBT))
                .addGap(79, 79, 79)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capnhatCNBT)
                    .addComponent(LuuCNBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(boquaCNBT)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cong Nhan", jPanel1);

        tbXuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ma", "Ten xuong", "He so CV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbXuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbXuongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbXuong);

        jLabel6.setText("Ma");

        jLabel7.setText("Ho ten");

        jLabel10.setText("He So CV");

        hesoXuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maXuong, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenXuong, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesoXuong, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(maXuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tenXuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(hesoXuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        themXBT.setText("Them");

        capnhatXBT.setText("Cap nhat");

        boquaXBT.setText("Bo qua");

        suaXBT.setText("Sua");

        LuuXBT.setText("Luu vao file");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boquaXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capnhatXBT, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(themXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suaXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LuuXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themXBT)
                    .addComponent(suaXBT))
                .addGap(79, 79, 79)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capnhatXBT)
                    .addComponent(LuuXBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(boquaXBT)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Xuong San Xuat", jPanel2);

        tbBangCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma CN", "Ho va ten", "Ma Xuong", "So ngay LV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbBangCC);
        if (tbBangCC.getColumnModel().getColumnCount() > 0) {
            tbBangCC.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel8.setText("Ma CN");

        jLabel9.setText("Ma Xuong");

        jLabel11.setText("So Ngay LV");

        maCNCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maXuongCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Sap Xep");

        sxepCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sap xep theo ho ten cong nhan", "Sap xep theo so ngay lam viec" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addComponent(jLabel12))
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maCNCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maXuongCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(soNgay)
                    .addComponent(sxepCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(maCNCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(maXuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(soNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(sxepCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        themBangCC.setText("Them moi");

        luuBangCC.setText("Luu file");

        sxepBT.setText("Sap xep");

        lamtuoiBT.setText("Lam tuoi 2 ma");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lamtuoiBT)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(themBangCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(luuBangCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sxepBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(themBangCC)
                .addGap(30, 30, 30)
                .addComponent(luuBangCC)
                .addGap(32, 32, 32)
                .addComponent(lamtuoiBT)
                .addGap(29, 29, 29)
                .addComponent(sxepBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bang Cham Cong", jPanel3);

        thongketxt.setEditable(false);
        thongketxt.setColumns(20);
        thongketxt.setRows(5);
        jScrollPane4.setViewportView(thongketxt);

        thongkeBT.setText("Thong ke thu nhap");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(558, 558, 558)
                        .addComponent(thongkeBT)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(thongkeBT)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong Ke", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbXuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbXuongMouseClicked
        // TODO add your handling code here:
        int row=tbXuong.getSelectedRow();
        if(row>=0&&row<tbXuong.getRowCount()){
            maXuong.setText(tmXuong.getValueAt(row, 0).toString());
            tenXuong.setText(tmXuong.getValueAt(row, 1).toString());
            for(int i=0;i<hesoXuong.getItemCount();i++){
                if(hesoXuong.getItemAt(i).equals(tmXuong.getValueAt(row, 2).toString())){
                    hesoXuong.setSelectedIndex(i);
                }        
            }
        }
    }//GEN-LAST:event_tbXuongMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LuuCNBT;
    private javax.swing.JButton LuuXBT;
    private javax.swing.JComboBox<String> bacCN;
    private javax.swing.JButton boquaCNBT;
    private javax.swing.JButton boquaXBT;
    private javax.swing.JButton capnhatCNBT;
    private javax.swing.JButton capnhatXBT;
    private javax.swing.JTextField dchiCN;
    private javax.swing.JTextField dthoaiCN;
    private javax.swing.JComboBox<String> hesoXuong;
    private javax.swing.JTextField hotenCN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lamtuoiBT;
    private javax.swing.JButton luuBangCC;
    private javax.swing.JTextField maCN;
    private javax.swing.JComboBox<String> maCNCB;
    private javax.swing.JTextField maXuong;
    private javax.swing.JComboBox<String> maXuongCB;
    private javax.swing.JTextField soNgay;
    private javax.swing.JButton suaXBT;
    private javax.swing.JButton sxepBT;
    private javax.swing.JComboBox<String> sxepCB;
    private javax.swing.JTable tbBangCC;
    private javax.swing.JTable tbCN;
    private javax.swing.JTable tbXuong;
    private javax.swing.JTextField tenXuong;
    private javax.swing.JButton themBangCC;
    private javax.swing.JButton themCNBT;
    private javax.swing.JButton themXBT;
    private javax.swing.JButton thongkeBT;
    private javax.swing.JTextArea thongketxt;
    private javax.swing.JButton xoaCNBT;
    // End of variables declaration//GEN-END:variables
}
