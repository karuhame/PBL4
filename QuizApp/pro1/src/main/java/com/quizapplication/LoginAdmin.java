package com.quizapplication;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class LoginAdmin extends javax.swing.JFrame {

    /**
     * Creates new form LoginAdmin
     */
    public LoginAdmin() {
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

        labelUsername = new javax.swing.JLabel();
        fieldUsername = new javax.swing.JTextField();
        labelUsername1 = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        optionShowpass = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();
        labelLayoutLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("frameLgin"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsername.setText("User Name");
        getContentPane().add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 200, 130, -1));

        fieldUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(fieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 240, 310, -1));

        labelUsername1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelUsername1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsername1.setText("Password");
        getContentPane().add(labelUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 310, 105, -1));

        fieldPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 310, -1));

        optionShowpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        optionShowpass.setText("Show Password");
        optionShowpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionShowpassActionPerformed(evt);
            }
        });
        getContentPane().add(optionShowpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 390, 140, -1));

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 430, 150, 30));

        btnLogin1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        btnLogin1.setText("Back");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 430, 120, 30));

        labelLayoutLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login Background.PNG"))); // NOI18N
        getContentPane().add(labelLayoutLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUsernameActionPerformed

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Main().setVisible(true);
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if(fieldUsername.getText().equals("admin") && fieldPassword.getText().equals("123456")){
            new AdminHome().setVisible(true);
        }else{
            ImageIcon icon=new ImageIcon(getClass().getResource("/image/Incorrect Password.png"));
            JOptionPane.showMessageDialog(null, "<html><b style=\"color: red; font-size: 10px\">Incorrect <br> Username or Password</b></html>","Show",JOptionPane.INFORMATION_MESSAGE,icon);
            
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void optionShowpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionShowpassActionPerformed
        if(optionShowpass.isSelected()){
            fieldPassword.setEchoChar((char) 0);
        }else{
            fieldPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_optionShowpassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JLabel labelLayoutLogin;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel labelUsername1;
    private javax.swing.JCheckBox optionShowpass;
    // End of variables declaration//GEN-END:variables
}