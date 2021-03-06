/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DLL.RememberUserDLL;
import DLL.UserDLL;
import Entity.RememberUser;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author PY
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    RememberUserDLL re = new RememberUserDLL();
    public LoginForm() {
        initComponents();
        this.setTitle("Log in");
        this.setLocationRelativeTo(null);
        if(re.getAll().isEmpty()){
            log_jCheckRemember.setSelected(false);
            log_txtUser.setText("");
            log_txtPass.setText("");
        }else{
            log_jCheckRemember.setSelected(true);
            log_txtUser.setText(re.getAll().get(0).getUsers().trim());
            log_txtPass.setText(re.getAll().get(0).getPas());
        }
    }
    
    public  boolean checkSavePass(){
        if(log_jCheckRemember.isSelected()){
            return true;
        }
        else{
            return false;
        }
    }
    
    private void LoginBase(String username, String pass, String logon){
        try {
                // Set the connection properties.
                // required: SYSDBA
                Properties prop = new Properties();
                prop.setProperty("user",username);
                prop.setProperty("password",pass);
                prop.setProperty("internal_logon",logon);

                OracleDataSource ods = new OracleDataSource();
                ods.setConnectionProperties(prop);
                ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
                OracleConnection ocon = (OracleConnection)ods.getConnection();
                System.out.println("Connected");     

                // shutdown the database
                //ocon.close();
                //ods.close();;
                if(username.equals("sys as sysdba")){
                    SYSFORM s = new SYSFORM();
                    s.setVisible(true);
                    this.setVisible(false);
                }
                else{
                    MainSystem m = new MainSystem();
                    m.setVisible(true);
                    m.main_user.setText(log_txtUser.getText().trim());
                    this.setVisible(false);
                }

              } catch(SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, e);
              }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        log_txtUser = new javax.swing.JTextField();
        log_txtPass = new javax.swing.JPasswordField();
        log_jBtnChangePass = new javax.swing.JButton();
        log_jCheckRemember = new javax.swing.JCheckBox();
        log_jBtnLogin = new javax.swing.JButton();
        log_jBtnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("LOG IN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\Download\\DOAN_QLTHUVIEN\\src\\Image\\library.png")); // NOI18N
        jLabel4.setText("Library Management");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Username :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Password :");

        log_jBtnChangePass.setText("CHANGE");
        log_jBtnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_jBtnChangePassActionPerformed(evt);
            }
        });

        log_jCheckRemember.setText("Remember me");

        log_jBtnLogin.setText("LOGIN");
        log_jBtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_jBtnLoginActionPerformed(evt);
            }
        });

        log_jBtnCancel.setText("CANCEL");
        log_jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_jBtnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(log_jCheckRemember, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(log_txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(log_txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(log_jBtnChangePass)
                .addGap(23, 23, 23))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(log_jBtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(log_jBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(log_txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(log_txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(log_jBtnChangePass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(log_jCheckRemember)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(log_jBtnCancel)
                    .addComponent(log_jBtnLogin))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log_jBtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_jBtnLoginActionPerformed
        
        String u =log_txtUser.getText();
        String p = log_txtPass.getText().trim();
        if(u.isEmpty() && p.isEmpty()){
            JOptionPane.showMessageDialog(this, "Type Username and Password!");
            return;
        }
        if(u.isEmpty()){
            JOptionPane.showMessageDialog(this, "Username not null!");
            return;
        }
        if(p.isEmpty()){
            JOptionPane.showMessageDialog(this, "Password not null!");
            return;
        }
        String logon = "DEFAULT";
        if(log_txtUser.getText().equals("sys")){
            logon = "as sysdba";
        }
        if(checkSavePass()){
            ArrayList<RememberUser> listRemem = re.getAll();
            if(listRemem.isEmpty()){
                LoginBase(u, p, logon);
                RememberUser r = new RememberUser();
                r.setUsers(u);
                r.setPas(p);
                re.AddData(r);
            }else{
                if(listRemem.get(0).getUsers().equals(u)){
                    LoginBase(u, p, logon);
                }else if(!listRemem.get(0).getUsers().equals(u)){
                    re.RemoveData();
                    LoginBase(u, p, logon);
                    RememberUser r = new RememberUser();
                    r.setUsers(u);
                    r.setPas(p);
                    re.AddData(r);
                }
            }
        }else{
            re.RemoveData();
            LoginBase(u, p, logon);
        }
        
    }//GEN-LAST:event_log_jBtnLoginActionPerformed

    private void log_jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_jBtnCancelActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Exit? (Y/N)")== JOptionPane.OK_OPTION)
            System.exit(0);
    }//GEN-LAST:event_log_jBtnCancelActionPerformed

    private void log_jBtnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_jBtnChangePassActionPerformed
        ChangePass c = new ChangePass();
        c.setVisible(true);
    }//GEN-LAST:event_log_jBtnChangePassActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton log_jBtnCancel;
    private javax.swing.JButton log_jBtnChangePass;
    private javax.swing.JButton log_jBtnLogin;
    private javax.swing.JCheckBox log_jCheckRemember;
    private javax.swing.JPasswordField log_txtPass;
    private javax.swing.JTextField log_txtUser;
    // End of variables declaration//GEN-END:variables
}
