/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.DataFileDLL;
import DLL.DatabaseInfoDLL;
import DLL.InstanceDLL;
import DLL.SgaDLL;
import Entity.DataFile;
import Entity.Database;
import Entity.Instance;
import Entity.Sga;
import java.awt.Button;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;
import Entity.SyncPipe;
import java.io.PrintWriter;

/**
 *
 * @author PY
 */
public class SysFunctionForm extends javax.swing.JFrame {

    /**
     * Creates new form SysFunctionForm
     */
    ArrayList<Sga> listSga = new ArrayList<>();
    SgaDLL sgaDll = new SgaDLL();
    
    ArrayList<Instance> listIns = new ArrayList<>();
    InstanceDLL inDLL = new InstanceDLL();
    
    ArrayList<Database> listDb = new ArrayList<>();
    DatabaseInfoDLL dbDll = new DatabaseInfoDLL();
    
    ArrayList<DataFile> listDataF = new ArrayList<>();
    DataFileDLL dataFDll = new DataFileDLL();
    public SysFunctionForm() {
        initComponents();
        this.setTitle("SYS FUNCTION");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sgaShow();
        pgaShow();
        instanceShow();
        sessionShow();
        dataFileShow();
    }
    
    public void sgaShow(){
        Vector clums = new Vector();
        Vector data = new Vector();
        listSga = sgaDll.getALL();
        clums.add("NAME");
        clums.add("VALUE");
        for(Sga b : listSga){
            Vector row = new Vector();
            row.add(b.getName().trim());
            row.add(b.getValue());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        jTable1.setModel(dtm);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.requestFocus();
    }
    public void pgaShow(){
        Vector clums = new Vector();
        Vector data = new Vector();
        listSga = sgaDll.getALLpGa();
        clums.add("NAME");
        clums.add("VALUE");
        for(Sga b : listSga){
            Vector row = new Vector();
            row.add(b.getName().trim());
            row.add(b.getValue());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        jTable2.setModel(dtm);
        jTable2.setDefaultEditor(Object.class, null);
        jTable2.setAutoCreateRowSorter(true);
        jTable2.requestFocus();
    }
    
    public void instanceShow(){
        Vector clums = new Vector();
        Vector data = new Vector();
        listIns = inDLL.getALL();
        clums.add("INSTANCE_NAME");
        clums.add("HOST_NAME");
        clums.add("VERSION");
        clums.add("STARTUP_DATE");
        clums.add("STATUS");
        for(Instance b : listIns){
            Vector row = new Vector();
            row.add(b.getName().trim());
            row.add(b.getHost());
            row.add(b.getVersion());
            row.add(b.getDate());
            row.add(b.getStatus());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        jTable3.setModel(dtm);
        jTable3.setDefaultEditor(Object.class, null);
        jTable3.setAutoCreateRowSorter(true);
        jTable3.requestFocus();
    }
    
    public void sessionShow(){
        Vector clums = new Vector();
        Vector data = new Vector();
        listDb = dbDll.getALL();
        clums.add("NAME");
        clums.add("CREATED");
        clums.add("OPEN_MODE");
        clums.add("DATABASE_ROLE");
        for(Database b : listDb){
            Vector row = new Vector();
            row.add(b.getName().trim());
            row.add(b.getCreated());
            row.add(b.getMode());
            row.add(b.getRole());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        jTable4.setModel(dtm);
        jTable4.setDefaultEditor(Object.class, null);
        jTable4.setAutoCreateRowSorter(true);
        jTable4.requestFocus();
    }
    
    public void dataFileShow(){
        Vector clums = new Vector();
        Vector data = new Vector();
        listDataF = dataFDll.getAll();
        clums.add("FILE_NAME");
        clums.add("TABLESPACE_NAME");
        clums.add("BYTES");
        clums.add("MAXBYTES");
        clums.add("STATUS");
        for(DataFile b : listDataF){
            Vector row = new Vector();
            row.add(b.getName().trim());
            row.add(b.getTable());
            row.add(b.getBytes());
            row.add(b.getMaxbytes());
            row.add(b.getStatus());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        jTable5.setModel(dtm);
        jTable5.setDefaultEditor(Object.class, null);
        jTable5.setAutoCreateRowSorter(true);
        jTable5.requestFocus();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SGA_MEMORY");

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
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("PGA_MEMORY");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setText("INSTANCE_DETAILS");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel4.setText("DATABASE_DETAILS");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jButton2.setText("Profiles And Users");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("DATAFILES");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jButton1.setText("Shutdown");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Startup (Full Opitions)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("SYSTEM DETAILS");

        jButton4.setText("View Sessions");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Backup Database");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Restore Database");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Delete All Backup Files");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane4))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel3)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(15, 15, 15)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(54, 54, 54)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        user u = new user();
        u.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(JOptionPane.showConfirmDialog(this, "Shut down database ?")== JOptionPane.OK_OPTION){
            try {
            // Set the connection properties.
            // required: SYSDBA
            Properties prop = new Properties();
            prop.setProperty("user","sys");
            prop.setProperty("password","Oracle123");
            prop.setProperty("internal_logon","sysdba");

            OracleDataSource ods = new OracleDataSource();
            ods.setConnectionProperties(prop);
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            OracleConnection ocon = (OracleConnection)ods.getConnection();
            System.out.println("Connected");     

            // shutdown the database
            ocon.shutdown(OracleConnection.DatabaseShutdownMode.IMMEDIATE);
            ocon.shutdown(OracleConnection.DatabaseShutdownMode.ABORT);
            System.out.println("Instance stopped");
            /*
            stmt.execute("alter database close normal");
            stmt.execute("alter database dismount");
            stmt.close();
            System.out.println("Database closed and dismounted");
            ocon.shutdown(OracleConnection.DatabaseShutdownMode.FINAL);*/
            ocon.close();
            ods.close();
            System.out.println("Database stopped");
            JOptionPane.showMessageDialog(this, "Database stopped!");

          } catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
          }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*try {
      // Set the connection properties.
      // required: SYSDBA and PRELIM_AUTH = true
            Properties prop = new Properties();
            prop.setProperty("user","sys");
            prop.setProperty("password","Oracle123");
            prop.setProperty("internal_logon","sysdba");
            prop.setProperty("prelim_auth","true");
            

            OracleDataSource ods = new OracleDataSource();
            ods.setConnectionProperties(prop);
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            OracleConnection ocon = (OracleConnection)ods.getConnection();
            System.out.println("Connected");

            // startup the database
            ocon.shutdown(OracleConnection.DatabaseShutdownMode.ABORT);
            ocon.startup(OracleConnection.DatabaseStartupMode.NO_RESTRICTION);
            System.out.println("Instance started");
            ocon.close();
            ods.close();

            // At this time only the instance is started. The database is
            // not mounted or opened. You must reconnect as SYSDBA without
            // the PRELIM_AUTH
            prop.clear();
            prop.setProperty("user","sys");
            prop.setProperty("password","Oracle123");
            prop.setProperty("internal_logon","sysdba");

            ods = new OracleDataSource();
            ods.setConnectionProperties(prop);
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ocon = (OracleConnection)ods.getConnection();
            System.out.println("Reconnected");

            // mount and open the database
            Statement stmt = ocon.createStatement();
            stmt.execute("alter database mount");
            stmt.execute("alter database open");
            System.out.println("Database mounted and open");
            stmt.close();
            ocon.close();
            ods.close();
            JOptionPane.showMessageDialog(this, "Database Open and Mounted!");
          } catch(SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
          }*/
        String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);

                new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
                PrintWriter stdin = new PrintWriter(p.getOutputStream());
                stdin.println("sqlplus sys/Oracle123 as sysdba");
                stdin.println("startup");
                Thread.sleep(100);
                

                stdin.close();
                p.waitFor();
                p.destroy();
                JOptionPane.showMessageDialog(this, "Startup Database Successfully!");
	     
		} catch (Exception e) {
	 		e.printStackTrace();
		}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        SessionForm s = new SessionForm();
        s.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);

                new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
                PrintWriter stdin = new PrintWriter(p.getOutputStream());
                stdin.println("cd C:\\app\\product\\12.1.0\\dbhome_1\\database");
                stdin.println("rman target /");
                stdin.println("backup database plus archivelog;");
                Thread.sleep(500);
                stdin.println("exit");
                stdin.close();
                p.waitFor();
                p.destroyForcibly();
                JOptionPane.showMessageDialog(this, "Backup database successfully!");
	     
		} catch (Exception e) {
	 		e.printStackTrace();
		}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Are you sure to delete all backup files?") == JOptionPane.OK_OPTION){
            String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);

                new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
                PrintWriter stdin = new PrintWriter(p.getOutputStream());
                stdin.println("cd C:\\app\\product\\12.1.0\\dbhome_1\\database");
                stdin.println("rman target /");
                stdin.println("delete backup;");
                Thread.sleep(200);
                stdin.println("YES");
                Thread.sleep(500);
                stdin.println("exit");
                stdin.close();
                p.waitFor();
                p.destroyForcibly();
                JOptionPane.showMessageDialog(this, "Deteled all backup files successfully!");
	     
		} catch (Exception e) {
	 		e.printStackTrace();
		}
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(SysFunctionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SysFunctionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SysFunctionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SysFunctionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SysFunctionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables
}
