package com.fathi.aop;

import com.fathi.aop.exceptions.AccountException;
import javax.swing.JOptionPane;
import java.awt.Font;

/**
 *
 * @author fathi
 */
public class MainWindow extends javax.swing.JFrame {
    
    Client c;

    public MainWindow() {
    	setTitle("AspectJ Example");
        initComponents();
        c = new Client(1);
    }

    @SuppressWarnings("unchecked")                 
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextPane();
        btnWithdraw = new javax.swing.JButton();
        btnDispose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setFont(new Font("Dialog", Font.BOLD, 14));
        lblBalance = new javax.swing.JLabel();
        lblBalance.setText("0.0 DA");
        lblBalance.setFont(new Font("Dialog", Font.BOLD, 14));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        jLabel1.setText("AspectJ Example");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        jLabel2.setText("Amount");

        txtAmount.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N

        btnWithdraw.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        btnDispose.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        btnDispose.setText("Dispose");
        btnDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisposeActionPerformed(evt);
            }
        });

        jLabel3.setText("Your balance");
        
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtAmount))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDispose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnWithdraw)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblBalance)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWithdraw)
                    .addComponent(btnDispose))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblBalance))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
	            .addContainerGap())
        );

        pack();
    }         

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {
		float amount = 0.0f;
    	if (!txtAmount.getText().isBlank() && txtAmount.getText().matches("\\b\\d+\\b")) {
    		amount = Float.parseFloat(txtAmount.getText());
    		txtLog.setText(txtLog.getText() + "\n" + c.dispose(amount, 0));
            lblBalance.setText(String.valueOf(c.getAccount(0).getAmount()) + " DA");
    	} else {
    		JOptionPane.showMessageDialog(null, "You should enter only numbers", "Exception", JOptionPane.ERROR_MESSAGE);
    	}
    }                                          

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {
        float amount = 0.0f;
    	if (!txtAmount.getText().isBlank() && txtAmount.getText().matches("\\b\\d+\\b")) {
    		amount = Float.parseFloat(txtAmount.getText());
            txtLog.setText(txtLog.getText() + "\n" + c.withdraw(amount, 0));
            lblBalance.setText(String.valueOf(c.getAccount(0).getAmount()) + " DA");
    	} else {
    		JOptionPane.showMessageDialog(null, "You should enter only numbers", "Exception", JOptionPane.ERROR_MESSAGE);
    	}
    }                                           

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDispose;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtLog;
    // End of variables declaration
}
