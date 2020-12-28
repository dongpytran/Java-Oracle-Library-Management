/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.BookDLL;
import DLL.EmployeeDLL;
import DLL.ReadersDLL;
import DLL.ReturnExchangeDLL;
import Entity.Books;
import Entity.Employees;
import Entity.Readers;
import Entity.ReturnExchange;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PY
 */
public class ReturnExchangeForm extends javax.swing.JFrame {

    /**
     * Creates new form ReturnExchangeForm
     */
    ArrayList<ReturnExchange> listReEx = new ArrayList<>();
    ReturnExchangeDLL reExDLL = new ReturnExchangeDLL();
    ArrayList<Books> listBook = new ArrayList<>();
    BookDLL bookDLL = new BookDLL();
    ArrayList<Readers> listRe = new ArrayList<>();
    ReadersDLL reDLL = new ReadersDLL();
    ArrayList<Employees> listEm = new ArrayList<>();
    EmployeeDLL emDLL = new EmployeeDLL();
    public ReturnExchangeForm() {
        initComponents();
        this.setTitle("RETURN & EXCHANGE MANAGEMENT");
        this.setLocationRelativeTo(null);
        jPanel1.setVisible(false);
        showTable();
        librianShow();
    }

    public void showTable(){
        listReEx = reExDLL.getAll();
        Vector clums = new Vector();
        Vector data = new Vector();
        clums.add("ReturnCode");
        clums.add("Book");
        clums.add("Reader");
        clums.add("Librian");
        clums.add("DayBorrow");
        clums.add("DayReturn");
        for(ReturnExchange r : listReEx){
            Vector row = new Vector();
            row.add(r.getReCode().trim());
            listBook=bookDLL.getByCode(r.getBookCode().trim());
            if(listBook.size()>0){
                row.add(listBook.get(0).getBookName());
            }else{
                row.add("Empty");
            }
            listRe = reDLL.getByNum(r.getCardNum().trim());
            if(listRe.size()>0){
                row.add(listRe.get(0).getReName());
            }else{
                row.add("Empty");
            }
            row.add(r.getEmCode().trim());
            row.add(r.getDayBorrow().trim());
            if(r.getDayReturn() != null){
                row.add(r.getDayReturn().trim());
            }else{
                row.add("");
            }   
            data.add(row);
        }
        TableModel dtm = new DefaultTableModel(data,clums);
        jTable1.setModel(dtm);
        jTable1.setDefaultEditor(Object.class, null);
    }
    public void librianShow(){
        listEm = emDLL.getAll();
        for (Employees e : listEm) {
            emBox.addItem(e.getEmCode().trim());
        }
    }
    private void displayShow(){
        if(jTable1.getSelectedRow() != -1){
            int row = jTable1.getSelectedRow();
            listReEx = reExDLL.getAll();
            txtReexCode.setText(listReEx.get(row).getReCode().trim());
            txtBook.setText(listReEx.get(row).getBookCode().trim());
            txtCardNum.setText(listReEx.get(row).getCardNum().trim());
            txtDayBorrow.setText(listReEx.get(row).getDayBorrow().trim());
            if(listReEx.get(row).getDayReturn()!=null){
                txtDayReturn.setText(listReEx.get(row).getDayReturn().trim());
            }else{
                txtDayReturn.setText("");
            }
            emBox.setSelectedItem(listReEx.get(row).getEmCode().trim());
        }
    }
    private void setAllNew(){
        
        txtReexCode.setEditable(true);
        txtReexCode.setText("");
        txtBook.setText("");
        txtCardNum.setText("");
        txtDayBorrow.setText("");
        txtDayReturn.setText("");
        emBox.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCardNum = new javax.swing.JTextField();
        txtBook = new javax.swing.JTextField();
        txtReexCode = new javax.swing.JTextField();
        emBox = new javax.swing.JComboBox<>();
        txtDayBorrow = new javax.swing.JTextField();
        txtDayReturn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        reexuser = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/return1.png"))); // NOI18N
        jLabel1.setText("RETURN EXCHANGE MANAGEMENT");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Edit Data"));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/new.png"))); // NOI18N
        jButton1.setText("NEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/remove.png"))); // NOI18N
        jButton3.setText("REMOVE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save.png"))); // NOI18N
        jButton5.setText("SAVE TXT");
        jPanel1.add(jButton5);

        jButton6.setForeground(new java.awt.Color(204, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))); // NOI18N
        jButton6.setText("CLOSE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Data Binding"));

        jLabel2.setText("ReExCode :");

        jLabel3.setText("Book Code :");

        jLabel4.setText("CardNum :");

        jLabel5.setText("Librian :");

        jLabel6.setText("Day Borrow :");

        jLabel7.setText("Day Return :");

        txtDayReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDayReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtReexCode)
                    .addComponent(txtBook)
                    .addComponent(txtCardNum, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emBox, 0, 120, Short.MAX_VALUE)
                    .addComponent(txtDayBorrow)
                    .addComponent(txtDayReturn))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtReexCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDayBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtCardNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDayReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel8.setText("Hello :");

        reexuser.setText("jLabel9");

        jMenu1.setText("System");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/book2.png"))); // NOI18N
        jMenuItem2.setText("Books Management");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/em2.png"))); // NOI18N
        jMenuItem3.setText("Employees Management");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pub1.png"))); // NOI18N
        jMenuItem4.setText("PublishingHouse Management");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/card2.png"))); // NOI18N
        jMenuItem5.setText("ReaderCards Management");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reader2.png"))); // NOI18N
        jMenuItem6.setText("Readers Management");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Function");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        jMenuItem1.setText("Edit Data");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1)
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reexuser)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(reexuser))
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jPanel1.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        displayShow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setAllNew();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateNow = date.format(formatter).toString();
        txtDayReturn.setText(dateNow);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String reCode = txtReexCode.getText().trim();
        String book = txtBook.getText().trim();
        String card = txtCardNum.getText().trim();
        String dayborrow = txtDayBorrow.getText().trim();
        String dayreturn = txtDayReturn.getText().trim();
        String emCode = emBox.getSelectedItem().toString().trim();
        ReturnExchange re = new ReturnExchange();
        re.setReCode(reCode);
        re.setCardNum(card);
        re.setBookCode(book);
        re.setDayBorrow(dayborrow);
        re.setDayReturn(dayreturn);
        re.setEmCode(emCode);
        if(reExDLL.addData(re)){
            JOptionPane.showMessageDialog(this, "Added!");
            System.out.println("Added ReturnCode: "+reCode);
            showTable();
        }else{
            JOptionPane.showMessageDialog(this, "Add Failed!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTable1.getSelectedRow()!=-1){
            String reCode = txtReexCode.getText().trim();
            String book = txtBook.getText().trim();
            String card = txtCardNum.getText().trim();
            String dayborrow = txtDayBorrow.getText().trim();
            String dayreturn = txtDayReturn.getText().trim();
            String emCode = emBox.getSelectedItem().toString().trim();
            ReturnExchange re = new ReturnExchange();
            re.setReCode(reCode);
            re.setCardNum(card);
            re.setBookCode(book);
            re.setDayBorrow(dayborrow);
            re.setDayReturn(dayreturn);
            re.setEmCode(emCode);
            if(reExDLL.updateData(re)){
                JOptionPane.showMessageDialog(this, "Updated!");
                System.out.println("Updated ReturnCode: "+reCode);
                showTable();
            }else{
                JOptionPane.showMessageDialog(this, "Update Failed!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Choose a ReturnExchange Record!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTable1.getSelectedRow()!=-1){
            if(JOptionPane.showConfirmDialog(this, "Delete this Return Record?")==JOptionPane.OK_OPTION){
                if(reExDLL.removeData(txtReexCode.getText().trim())){
                    JOptionPane.showMessageDialog(this, "Deleted!");
                    System.out.println("Deleted ReturnExchange Record : "+txtReexCode.getText().trim());
                    showTable();
                }else{
                    JOptionPane.showMessageDialog(this, "Delete Failed");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Choose a ReturnExchange Record!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        BooksForm b = new BooksForm();
        b.setVisible(true);
        b.book_user.setText(reexuser.getText());
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        EmployeesForm e = new EmployeesForm();
        e.setVisible(true);
        e.emuser.setText(reexuser.getText());
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        PublishForm p = new PublishForm();
        p.setVisible(true);
        p.pubuser.setText(reexuser.getText());
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ReCardsForm r = new ReCardsForm();
        r.setVisible(true);
        r.carduser.setText(reexuser.getText());
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ReadersForm r = new ReadersForm();
        r.setVisible(true);
        r.reuser.setText(reexuser.getText());
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void txtDayReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDayReturnActionPerformed
        
    }//GEN-LAST:event_txtDayReturnActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnExchangeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnExchangeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnExchangeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnExchangeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnExchangeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> emBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JLabel reexuser;
    private javax.swing.JTextField txtBook;
    private javax.swing.JTextField txtCardNum;
    private javax.swing.JTextField txtDayBorrow;
    private javax.swing.JTextField txtDayReturn;
    private javax.swing.JTextField txtReexCode;
    // End of variables declaration//GEN-END:variables
}
