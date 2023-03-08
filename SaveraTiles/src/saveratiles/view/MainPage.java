/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveratiles.view;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import saveratiles.util.DBConnection;

/**
 *
 * @author User
 */
public class MainPage extends javax.swing.JFrame {

    DBConnection db = new DBConnection();

    PreparedStatement pst;
    String[] columsForP = {"Product Code", "Product Name", "Size", "Total Quantity", "Rate Psft", "Origin", "Date", "Time"};
    String[] columsForB = {"Name", "Contract", "Email", "Address", "Bill", "Amount", "Discount", "Less", "Total Amount", "paid", "Due", "Date", "Time"};

    public void ShowDataForProduct() {
        String sql = "select * from product";
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columsForP);
        tblMProduct.setModel(model); ///
        ResultSet rs;

        try {
            pst = db.getconn().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String Pcode = rs.getString("Product_Code");
                String Pname = rs.getString("Product_Name");
                String Ssize = rs.getString("PSize");
                int Quantity = rs.getInt("Total_Quantity");
                int Rate = rs.getInt("Rate_Psft");
                String Origin = rs.getString("Origin");
                String Ddate = rs.getString("PDate");
                String Ttime = rs.getString("PTime");
                model.addRow(new Object[]{Pcode, Pname, Ssize, Quantity, Rate, Origin, Ddate, Ttime});

            }
            pst.close();
            db.getconn().close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showDataForCustomer() {

        String sql = "select* from customer";
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columsForB);
        jTable1.setModel(model);
        ResultSet rs;

        try {
            pst = db.getconn().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String Name = rs.getString("name");
                String Contract = rs.getString("contract");
                String Email = rs.getString("email");
                String Address = rs.getString("adress");
                String Bill = rs.getString("bill");
                String Amount = rs.getString("amount");
                String Discount = rs.getString("discount");
                String Less = rs.getString("less");
                String TotalAmount = rs.getString("totalamount");
                String Paid = rs.getString("paid");
                String Due = rs.getString("due");
                String Date = rs.getString("date");
                String Time = rs.getString("time");

                model.addRow(new Object[]{Name, Contract, Email, Address, Bill, Amount, Discount, Less, TotalAmount, Paid, Due, Date, Time});

                pst.cancel();
                db.getconn().close();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MainPage() {
        initComponents();
        jTabbedPane1.setSelectedIndex(6);
        // DateAndTime();
        TTime();
        DDate();
        ShowDataForProduct();
        showDataForCustomer();
    }

    public void clear() {//ata addProuct er jonne 
        tPcode.setText(" ");
        tTquantity.setText("");
        tRpsft.setText("");
        cSize.setSelectedIndex(0);
        cOrigin.setSelectedIndex(0);
        cPname.setSelectedIndex(0);
    }

    public void Pclear() {//ata Product Update er jonne 

        int choice = JOptionPane.showConfirmDialog(null, " Do you want to Reset ❓ :",
                "Reset", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            jTextField11.setText("");
            jTextField10.setText("");
            jTextField9.setText("");
            jTextField8.setText("");
            jTextField7.setText("");
            jTextField13.setText("");
            tsearch.setText("");
        }
    }

    void TTime() {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MMM-YYYY");
        ttime.setText(s.format(date));
    }

    void DDate() {

        new Timer(0, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss a");
                tdate.setText(s.format(date));
            }
        }).start();
    }
//   
//    public void DateAndTime(){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYY/HH/dd HH:mm:ss a");
//        LocalDateTime nw = LocalDateTime.now();
//        tdate.setText(dtf.format(nw));
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        home = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tdate = new javax.swing.JLabel();
        ttime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMProduct = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        tsearch = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        search = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tPcode = new javax.swing.JTextField();
        tTquantity = new javax.swing.JTextField();
        tRpsft = new javax.swing.JTextField();
        cPname = new javax.swing.JComboBox<>();
        cSize = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        cOrigin = new javax.swing.JComboBox<>();
        jButton16 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        AddProductInBill = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jButton15 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField21 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        AddProductInBill1 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1104, 660));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(180, 550));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 153));
        jButton1.setText("Add Product");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setMargin(new java.awt.Insets(2, 7, 2, 14));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 138, 180, 51));

        home.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        home.setForeground(new java.awt.Color(0, 51, 153));
        home.setText("Home");
        home.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        home.setMargin(new java.awt.Insets(2, 7, 2, 14));
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel3.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 81, 180, 51));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 153));
        jButton3.setText("Delete & Update ");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setMargin(new java.awt.Insets(2, 7, 2, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 195, 180, 51));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 153));
        jButton4.setText("Product Details");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setMargin(new java.awt.Insets(2, 7, 2, 14));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 252, 180, 51));

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 153));
        jButton5.setText("Log-out");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setMargin(new java.awt.Insets(2, 7, 2, 14));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 423, 180, 51));

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 51, 153));
        jButton6.setText("Customer Details");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setMargin(new java.awt.Insets(2, 7, 2, 0));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 366, 180, 51));

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 51, 153));
        jButton7.setText("Billing");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setMargin(new java.awt.Insets(2, 7, 2, 14));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 309, 180, 51));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/SaveraLogo.jpg"))); // NOI18N

        tdate.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        tdate.setForeground(new java.awt.Color(0, 0, 153));

        ttime.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        ttime.setForeground(new java.awt.Color(0, 0, 153));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Time :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Date :");

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Wide Latin", 3, 48)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Savera Tiles");

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 51, 204));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("69, Bir Uttam CR Datta Road, Sonargaon Road, Dhaka 1205");
        jLabel47.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ttime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ttime, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 110));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/rsz_ht.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 905, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23))
        );

        jTabbedPane1.addTab("D", jPanel1);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        tblMProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMProduct);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/refresh.png"))); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 56)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 85));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/chart-histogram.png"))); // NOI18N
        jLabel25.setText("Product Details");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator10))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("P", jPanel9);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jTextField7.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel10.setText("Rate pSft");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel11.setText("Total Quantity");

        jTextField8.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        jTextField9.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel13.setText("Product Name");

        jTextField10.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel14.setText("Product Code");

        Delete.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        Delete.setForeground(new java.awt.Color(0, 51, 102));
        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/trash.png"))); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 51, 102));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/cross-circle (1).png"))); // NOI18N
        jButton8.setText("Close");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 51, 102));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/refresh.png"))); // NOI18N
        jButton9.setText("Reset");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        tsearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsearchActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel15.setText("Size");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/boxes.png"))); // NOI18N
        jLabel16.setText("Product Code");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel17.setText("Origin");

        jTextField13.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        update.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        update.setForeground(new java.awt.Color(0, 51, 102));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/loading.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        search.setForeground(new java.awt.Color(0, 51, 102));
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/search.png"))); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 56)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 85));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/edit-alt.png"))); // NOI18N
        jLabel29.setText("Delete & Update ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jLabel16)
                            .addGap(12, 12, 12)
                            .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(search)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jSeparator3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField10))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField9))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField8)
                                            .addComponent(jTextField7)
                                            .addComponent(jTextField13)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(227, 227, 227))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(update)
                                .addGap(75, 75, 75)
                                .addComponent(Delete)
                                .addGap(92, 92, 92)
                                .addComponent(jButton9)
                                .addGap(72, 72, 72)
                                .addComponent(jButton8)
                                .addGap(12, 12, 12)))))
                .addGap(156, 156, 156))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(Delete)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("U", jPanel7);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel4.setText("Product Code");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel5.setText("Product Name");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel6.setText("Size");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel7.setText("Total Quantity");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel8.setText("Rate pSft");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel9.setText("Origin");

        tPcode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tTquantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tRpsft.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cPname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cPname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empty", "Wall ", "Floor", "Ceramic Tiles", "Porcelain Tiles", "Quarry Tiles", "Mosaic Tiles", "Marble Tiles", "Travertine Tiles", "Slate Tiles", "Sandstone Tiles", "Terrazzo Tiles", "Onyx Tiles", "Wooden Tiles", " " }));

        cSize.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empty", "24 Inches * 48 inches", "32 Inches * 32 inches", "24 Inches * 24 inches", "18 inches * 18 inches", "18 Inches * 24 inches", "12 inches* 24 inches", "12 Inches * 12 inches", "8 Inches * 12 inches", "8 Inches * 8 inches", "300mm X 600mm", "600mm X 600mm", "610mm X 610mm", "800mm X 800mm", "250mm X 300mm", "300mm X 450mm", "300mm X 600mm", "800 x 600mm", "250 x 350 mm", "350 X 450 mm" }));
        cSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSizeActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 51, 153));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/shopping-cart-add.png"))); // NOI18N
        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        cOrigin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cOrigin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empty", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic (CAR)", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czechia", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "H", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates (UAE)", "United Kingdom (UK)", "United States of America (USA)", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City (Holy See)", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe", " ", " ", " " }));
        cOrigin.setMaximumSize(new java.awt.Dimension(166, 28));
        cOrigin.setMinimumSize(new java.awt.Dimension(166, 28));
        cOrigin.setPreferredSize(new java.awt.Dimension(166, 28));

        jButton16.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 51, 153));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/eye.png"))); // NOI18N
        jButton16.setText("View Data");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 56)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 85));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/layer-plus (1).png"))); // NOI18N
        jLabel37.setText("Add Product ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tTquantity)
                                    .addComponent(tRpsft)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tPcode, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton16))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cOrigin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cPname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 228, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(285, 285, 285))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tRpsft, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cSize, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cPname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("N", jPanel5);

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/refresh.png"))); // NOI18N
        jButton11.setText("Refresh");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 56)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 85));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/chart-histogram.png"))); // NOI18N
        jLabel39.setText("Customer Details");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4)
                    .addComponent(jSeparator9))
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel39)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("C", jPanel12);

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setPreferredSize(new java.awt.Dimension(968, 675));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Calculation Details");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel19.setText("Name");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel20.setText("Contract No");

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel21.setText("Email");

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel22.setText("Address");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel24.setText("P_Code");

        jTextField5.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel26.setText("New Rate");

        jTextField14.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel27.setText("Quantity");

        jTextField15.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField15KeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel30.setText("Buyer Details");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel31.setText("Total Amount");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel32.setText("Discount ");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel34.setText("Grand Total");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel35.setText("Paid");

        jTextField17.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField17KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField17KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });

        jTextField18.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        jTextField19.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField19KeyReleased(evt);
            }
        });

        jTextField20.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        AddProductInBill.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        AddProductInBill.setForeground(new java.awt.Color(0, 51, 102));
        AddProductInBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/shopping-cart-add.png"))); // NOI18N
        AddProductInBill.setText("Add ");
        AddProductInBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductInBillActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 51, 102));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/layer-plus.png"))); // NOI18N
        jButton12.setText("Save");
        jButton12.setMargin(new java.awt.Insets(2, 0, 2, 14));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 51, 102));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/arrows-repeat.png"))); // NOI18N
        jButton13.setText("Reset");
        jButton13.setMargin(new java.awt.Insets(2, 0, 2, 14));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel36.setText("Product Details");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel28.setText("Bill No :");

        jButton15.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 51, 102));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/cross-circle (1).png"))); // NOI18N
        jButton15.setText("Close");
        jButton15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton15.setMargin(new java.awt.Insets(2, 0, 2, 14));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Coe", "Product Rate", "Quantity", "Total"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable3);

        jTextField21.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel42.setText("Due");

        AddProductInBill1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        AddProductInBill1.setForeground(new java.awt.Color(0, 51, 102));
        AddProductInBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/trash.png"))); // NOI18N
        AddProductInBill1.setText("Delete");
        AddProductInBill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductInBill1ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 51, 0));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel44.setText("Less");

        jTextField22.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 0, 51));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 56)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 85));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/comment-alt.png"))); // NOI18N
        jLabel38.setText("Billing");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(210, 210, 210))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(208, 208, 208))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                .addComponent(jTextField2))))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(AddProductInBill, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5)))
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(447, 447, 447)
                        .addComponent(AddProductInBill1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel34)
                                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.LEADING)))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(242, 242, 242))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(898, 898, 898)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddProductInBill)))
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddProductInBill1)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(jButton13)
                            .addComponent(jButton15))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel33)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("B", jPanel10);

        jPanel6.setBackground(new java.awt.Color(243, 245, 249));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAndPicture/a3843e404a271edb47b1908dd2a6230b.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(51, 51, 51))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 73, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("W", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 910, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to Log Out", "Select", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            setVisible(false);
            new Log().setVisible(true);

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_homeActionPerformed

    private void AddProductInBill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductInBill1ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) this.jTable3.getModel();
        int[] rows = jTable3.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            model.removeRow(rows[i] - i);
        }
    }//GEN-LAST:event_AddProductInBill1ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextArea1.setText("");
        jLabel45.setText("");
        jTextField5.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField20.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTable3.setModel(new DefaultTableModel(null, new String[]{"Product Code", "Puduct Rate", "Quantity", "Total"}));
        //        dispose();
        //        new MainPage().setVisible(true);
        //           jTabbedPane1.setSelectedIndex(8);
        total = 0;
        amount = 0;
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, " Do you want this data in DataBase ?:",
                "Close", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            DateTimeFormatter dttf = DateTimeFormatter.ofPattern("YYYY/HH/dd");
            LocalDateTime nnw = LocalDateTime.now();
            String date = dttf.format(nnw);

            DateTimeFormatter dtime = DateTimeFormatter.ofPattern("hh:mm a");
            LocalDateTime stime = LocalDateTime.now();
            String tttime = dtime.format(stime);

            String sql = "insert into customer() values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                pst = db.getconn().prepareStatement(sql);

                pst.setString(1, jTextField1.getText().trim());
                pst.setString(2, jTextField2.getText().trim());
                pst.setString(3, jTextField3.getText().trim());
                pst.setString(4, jTextArea1.getText().trim());
                pst.setString(5, jLabel45.getText().trim());
                pst.setString(6, jTextField20.getText().trim());
                pst.setString(7, jTextField17.getText().trim());
                pst.setString(8, jTextField22.getText().trim());
                pst.setString(9, jTextField18.getText().trim());
                pst.setString(10, jTextField19.getText().trim());
                pst.setString(11, jTextField21.getText().trim());
                pst.setString(12, date);
                pst.setString(13, tttime);

                pst.executeUpdate();
                pst.close();
                db.getconn().close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        String name = jTextField1.getText();
        String contract = jTextField2.getText();
        String email = jTextField3.getText();
        String adress = jTextArea1.getText();
        String bill = jLabel45.getText();
        //        String code = jTextField5.getText();
        //        String rate = jTextField14.getText();
        //        String quantity = jTextField15.getText();
        String amount = jTextField20.getText();
        String discount = jTextField17.getText();
        String totalamount = jTextField18.getText();
        String paid = jTextField19.getText();
        String due = jTextField21.getText();
        String less = jTextField22.getText();

        //date and time er jonne
        int select = JOptionPane.showConfirmDialog(null, " Do you want to PDF this data :",
                "Close", JOptionPane.YES_NO_OPTION);
        if (select == JOptionPane.YES_OPTION) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-YYYY    HH:mm:ss a");
            LocalDateTime nw = LocalDateTime.now();
            String time = dtf.format(nw);

            String path = "D:\\";

            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path + "" + name + " " + ttime.getText() + ".pdf"));
                doc.open();
                Paragraph paragraph = new Paragraph(
                        "                                                                         Savera Tiles\n"
                        + "                                  69,CR Datto Road(Sonargaon Roaad), Hatirpool, Dhaka -1205\n"
                        + "                                                              E-mail: saveratiles@gmail.com\n"
                        + "                                                                   Phone : +02-58612250\n"
                        + "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                doc.add(paragraph);
                Paragraph paragraph1 = new Paragraph("\n" + "\n"
                        + "Date & Time  :    " + time + "\n"
                        + "Bill No           :    " + bill + "\n"
                        + "Name            :    " + name + "\n"
                        + "Contract No  :    " + contract + "\n"
                        + "E-mail           :    " + email + "\n"
                        + "Adress          :    " + adress + "\n" + "\n"
                );
                doc.add(paragraph1);

                PdfPTable tbl = new PdfPTable(4);
                tbl.addCell("Product Code");
                tbl.addCell("Product Rate");
                tbl.addCell("Quantity");
                tbl.addCell("Total");
                for (int i = 0; i < jTable3.getRowCount(); i++) {
                    String c = jTable3.getValueAt(i, 0).toString();
                    String r = jTable3.getValueAt(i, 1).toString();
                    String q = jTable3.getValueAt(i, 2).toString();
                    String t = jTable3.getValueAt(i, 3).toString();
                    tbl.addCell(c);
                    tbl.addCell(r);
                    tbl.addCell(q);
                    tbl.addCell(t);
                }
                doc.add(tbl);

                Paragraph paragraph2 = new Paragraph("\n"
                        + "                                                                                   Total Amount          " + amount + "\n"
                        + "                                                                                    Discount               " + discount + "%" + "\n"
                        + "                                                                                    Less                      " + less + "\n"
                        + "                                                                                    Grand Amount      " + totalamount + "\n"
                        + "                                                                                    Paid                       " + paid + "\n"
                        + "                                                                                    Due                      " + due + "\n" + "\n" + "\n"
                );
                doc.add(paragraph2);

                Paragraph paragraph3 = new Paragraph("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + "\n" + "\n");
                doc.add(paragraph3);
                Paragraph paragraph4 = new Paragraph("                    Goods received in good condition" + "\n" + "\n" + "Recevied by___________________                                           Issued by____________________" + "\n" + "                    Customar's signature                                                                For Savera Tiles");
                doc.add(paragraph4);

                // JOptionPane.showMessageDialog(null, "Click 🆗 to create PDF file 📌");
            } catch (Exception e) {

            }
            doc.close();

        } else {
            jTabbedPane1.setSelectedIndex(6);
        }


    }//GEN-LAST:event_jButton12ActionPerformed

    private void AddProductInBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductInBillActionPerformed
        // TODO add your handling code here:
        int qun = Integer.parseInt(jTextField15.getText());
        int neQ = 0;
        String productCode = jTextField5.getText().trim();
        String sql = "select Total_Quantity from product where Product_Code=? ";
        ResultSet rs;

        try {
            pst = db.getconn().prepareStatement(sql);
            pst.setString(1, productCode);
            rs = pst.executeQuery();

            while (rs.next()) {
                int acQ = rs.getInt("Total_Quantity");
                neQ = acQ - qun;
            }

            pst.close();
            db.getconn().close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        int select = JOptionPane.showConfirmDialog(null, "Do you want to save data in SQL ?", "Save In SQL", JOptionPane.YES_NO_OPTION);
        if (select == JOptionPane.YES_OPTION) {
            String sQl = "Update product set Total_Quantity=? where Product_Code=?";
            try {
                pst = db.getconn().prepareStatement(sQl);

                pst.setInt(1, neQ);
                pst.setString(2, productCode);

                pst.executeUpdate();

                pst.close();
                db.getconn().close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String Pcode = jTextField5.getText();
        int Prate = Integer.parseInt(jTextField14.getText());
        int Pquantity = Integer.parseInt(jTextField15.getText());
        total = Prate * Pquantity;

        amount += total;
        String ttaka = String.valueOf(amount);
        jTextField20.setText(ttaka);

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.addRow(new Object[]{Pcode, Prate, Pquantity, total});

        jTextField5.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
    }//GEN-LAST:event_AddProductInBillActionPerformed

    private void jTextField19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyReleased
        // TODO add your handling code here:
        int total = Integer.parseInt(jTextField18.getText());
        int paid = Integer.parseInt(jTextField19.getText());
        int due = total - paid;

        String tt = String.valueOf(due);
        jTextField21.setText(tt);
        int due1 = Integer.parseInt(jTextField21.getText());
        if (due1 > 0) {
            jLabel43.setText("due");

        } else {

            jLabel43.setText("paid");
        }
    }//GEN-LAST:event_jTextField19KeyReleased

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyTyped

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyReleased
        // TODO add your handling code here:
        int Ttotal = Integer.parseInt(jTextField20.getText());
        int Disc = Integer.parseInt(jTextField17.getText());

        int Dis = Ttotal - (Ttotal * Disc / 100);
        float less = Ttotal * Disc / 100;
        String t = String.valueOf(less);
        jTextField22.setText(t);

        String tt = String.valueOf(Dis);
        jTextField18.setText(tt);
    }//GEN-LAST:event_jTextField17KeyReleased

    private void jTextField17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyPressed

    }//GEN-LAST:event_jTextField17KeyPressed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        long bill = Math.round(Math.random() * 10000000);
        String tt = String.valueOf("ST-" + bill);
        jLabel45.setText(tt);
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        ShowDataForProduct();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        int choice = JOptionPane.showConfirmDialog(null, "Do you want to ADD new product ?", "Add Product", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/HH/dd");
            LocalDateTime nw = LocalDateTime.now();
            String date = dtf.format(nw);

            DateTimeFormatter dtime = DateTimeFormatter.ofPattern("hh:mm a");
            LocalDateTime stime = LocalDateTime.now();
            String time = dtime.format(stime);

            try {

                String sql = "insert into product () values(?,?,?,?,?,?,?,?)";
                pst = db.getconn().prepareStatement(sql);

                pst.setString(1, tPcode.getText().trim());
                pst.setString(2, cPname.getSelectedItem().toString());
                pst.setString(3, cSize.getSelectedItem().toString());
                pst.setString(4, tTquantity.getText().trim());
                pst.setString(5, tRpsft.getText().trim());
                pst.setString(6, cOrigin.getSelectedItem().toString());
                pst.setString(7, date);
                pst.setString(8, time);

                pst.executeUpdate();

                clear();
                pst.close();
                db.getconn().close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jTabbedPane1.setSelectedIndex(6);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void cSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cSizeActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        String productCode = tsearch.getText().trim();
        String sql = "select Product_Code, Product_Name, PSize, Total_Quantity, Rate_Psft, Origin from product where Product_Code=? ";
        ResultSet rs;
        try {
            pst = db.getconn().prepareStatement(sql);

            pst.setString(1, productCode);

            rs = pst.executeQuery();

            while (rs.next()) {

                jTextField11.setText(rs.getString("Product_Code"));
                jTextField10.setText(rs.getString("Product_Name"));
                jTextField9.setText(rs.getString("PSize"));
                jTextField8.setText(rs.getString("Total_Quantity"));
                jTextField7.setText(rs.getString("Rate_Psft"));
                jTextField13.setText(rs.getString("Origin"));
                tsearch.setText("");

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, " Do you want to Update ❓",
                "Update", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String search = jTextField11.getText().trim();
            String sql = "Update product set Product_Code=?,Product_Name=?,PSize =?, Total_Quantity=?,Rate_Psft=?,Origin=? where Product_Code=?";
            try {
                pst = db.getconn().prepareStatement(sql);

                pst.setString(1, jTextField11.getText().trim());
                pst.setString(2, jTextField10.getText().trim());
                pst.setString(3, jTextField9.getText().trim());
                pst.setString(4, jTextField8.getText().trim());
                pst.setString(5, jTextField7.getText().trim());
                pst.setString(6, jTextField13.getText().trim());
                pst.setString(7, search);

                pst.executeUpdate();

                pst.cancel();
                db.getconn().close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_updateActionPerformed

    private void tsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tsearchActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Pclear();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, " Do you want to Delete ❓",
                "Delete", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String sql = "delete from product where Product_Code=?";
            try {
                pst = db.getconn().prepareStatement(sql);
                pst.setString(1, jTextField11.getText());
                Pclear();
                pst.cancel();
                db.getconn().close();

                pst.executeUpdate();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_DeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ShowDataForProduct();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        String productCode = jTextField5.getText().trim();
        String sql = "select Rate_Psft,Total_Quantity from product where Product_Code=? ";
        ResultSet rs;

        try {
            pst = db.getconn().prepareStatement(sql);
            pst.setString(1, productCode);
            rs = pst.executeQuery();
            while (rs.next()) {
                jTextField14.setText(rs.getString("Rate_Psft"));
                jTextField15.setText(rs.getString("Total_Quantity"));
            }

            pst.close();
            db.getconn().close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTextField5KeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        showDataForCustomer();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15KeyReleased

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    int total = 0;
    int amount = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProductInBill;
    private javax.swing.JButton AddProductInBill1;
    private javax.swing.JButton Delete;
    private javax.swing.JComboBox<String> cOrigin;
    private javax.swing.JComboBox<String> cPname;
    private javax.swing.JComboBox<String> cSize;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton search;
    private javax.swing.JTextField tPcode;
    private javax.swing.JTextField tRpsft;
    private javax.swing.JTextField tTquantity;
    private javax.swing.JTable tblMProduct;
    private javax.swing.JLabel tdate;
    private javax.swing.JTextField tsearch;
    private javax.swing.JLabel ttime;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
