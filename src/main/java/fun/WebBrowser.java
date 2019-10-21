/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun;

import edu.samford.jonathanborden.stacksandqueues.ListStack;
import edu.samford.jonathanborden.stacksandqueues.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author borde
 */
public class WebBrowser extends javax.swing.JFrame {

    Stack<String> backStack = new ListStack<>();
    Stack<String> fowardStack = new ListStack<>();
    String currentUrl = "Home";

    /**
     * Creates new form WebBrowser
     */
    public WebBrowser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbuttonback = new javax.swing.JButton();
        jButtonfoward = new javax.swing.JButton();
        jTexturlbar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPage = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbuttonback.setFont(new java.awt.Font("Courier New", 0, 21)); // NOI18N
        jbuttonback.setText("<--Back");
        jbuttonback.setEnabled(false);
        jbuttonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonbackActionPerformed(evt);
            }
        });

        jButtonfoward.setFont(new java.awt.Font("Courier New", 0, 21)); // NOI18N
        jButtonfoward.setText("Foward-->");
        jButtonfoward.setActionCommand("");
        jButtonfoward.setEnabled(false);
        jButtonfoward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonfowardActionPerformed(evt);
            }
        });

        jTexturlbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexturlbarActionPerformed(evt);
            }
        });

        jTextPage.setEditable(false);
        jTextPage.setColumns(20);
        jTextPage.setRows(5);
        jScrollPane1.setViewportView(jTextPage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbuttonback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonfoward)
                        .addGap(2, 2, 2)
                        .addComponent(jTexturlbar, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonback)
                    .addComponent(jButtonfoward)
                    .addComponent(jTexturlbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonbackActionPerformed
        // TODO add your handling code here:

        if (!backStack.isEmpty()) {
            jButtonfoward.setEnabled(true);
            fowardStack.push(currentUrl);
            currentUrl = backStack.pop();
            if(backStack.isEmpty()){
                jbuttonback.setEnabled(false);
            }
            jTexturlbar.setText(currentUrl);
            // TODO: load the page at currentUrl
            loadCurrentPage();
        }
    }//GEN-LAST:event_jbuttonbackActionPerformed

    private void jButtonfowardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonfowardActionPerformed
        // TODO add your handling code here:
        if (!fowardStack.isEmpty()) {
            jbuttonback.setEnabled(true);
            backStack.push(currentUrl);
            currentUrl = fowardStack.pop();
            if(fowardStack.isEmpty()){
                jButtonfoward.setEnabled(false);
            }
            jTexturlbar.setText(currentUrl);
            // TODO: load the page at currentUrl
            loadCurrentPage();
        }
    }//GEN-LAST:event_jButtonfowardActionPerformed

    private void jTexturlbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexturlbarActionPerformed
        // TODO add your handling code here:
        // Push the current page onto the back stack
        backStack.push(currentUrl);
        currentUrl = jTexturlbar.getText();
        // retrieve th enew page using http
         loadCurrentPage();
        jbuttonback.setEnabled(true);
        //User just wiped out the foward stack, lets do the same
        jButtonfoward.setEnabled(false);
        fowardStack = new ListStack<>();
    }//GEN-LAST:event_jTexturlbarActionPerformed

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
            java.util.logging.Logger.getLogger(WebBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WebBrowser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonfoward;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextPage;
    private javax.swing.JTextField jTexturlbar;
    private javax.swing.JButton jbuttonback;
    // End of variables declaration//GEN-END:variables

    private void loadCurrentPage(){
        try {
            jTextPage.setText(getHTML(currentUrl));
        } catch (Exception ex) {
            Logger.getLogger(WebBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line + "\n");
      }
      rd.close();
      return result.toString();
   }

}
