package com.osproject.shell.windows.components;

import com.osproject.shell.windows.main.Login;
import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginFrame extends javax.swing.JFrame {

    private final Login login = new Login();
    private final AlertFrame alert = new AlertFrame(this);
    private int xMouse;
    private int yMouse;
    private final Color red = new Color(220, 53, 69);

    private final Color blue = new Color(9, 121, 176);
    private final Color darkBlue = new Color(0, 65, 115);
    private final Color gray = new Color(204, 204, 204);
    private final Color black = new Color(0, 0, 0);

    private Socket socket;

    /**
     * Creates new form Login
     */
    public LoginFrame(Socket socket) {
        this.socket = socket;
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        messageLabel.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        headBar = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        loginFormPane = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        welcomeMessagePane = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        sidePane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        contentPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headBar.setOpaque(false);
        headBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headBarMouseDragged(evt);
            }
        });
        headBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headBarMousePressed(evt);
            }
        });
        headBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setBackground(new java.awt.Color(9, 121, 176));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.setLayout(new java.awt.BorderLayout());

        exitLabel.setBackground(new java.awt.Color(220, 53, 69));
        exitLabel.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        exitLabel.setForeground(new java.awt.Color(255, 255, 255));
        exitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLabel.setText("X");
        exitLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.add(exitLabel, java.awt.BorderLayout.CENTER);

        headBar.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 40, 40));

        contentPane.add(headBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 40));

        loginFormPane.setBackground(new java.awt.Color(255, 255, 255));
        loginFormPane.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        loginFormPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginLabel.setFont(new java.awt.Font("Roboto", 0, 26)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(9, 121, 176));
        loginLabel.setText("Iniciar sesión");
        loginFormPane.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 160, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(9, 121, 176));
        jLabel2.setText("Contraseña");
        loginFormPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 240, 40));

        jPanel2.setBackground(new java.awt.Color(9, 121, 176));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        loginFormPane.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 240, 2));

        jPanel6.setBackground(new java.awt.Color(9, 121, 176));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        loginFormPane.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 170, 3));

        jPanel7.setBackground(new java.awt.Color(9, 121, 176));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        loginFormPane.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 240, 2));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(9, 121, 176));
        jLabel3.setText("Usuario");
        loginFormPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 240, 40));

        txtUserName.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(204, 204, 204));
        txtUserName.setText("Ingrese su nombre de usuario");
        txtUserName.setBorder(null);
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
        });
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserNameMousePressed(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        loginFormPane.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 240, -1));

        txtPassword.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("********");
        txtPassword.setToolTipText("");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        loginFormPane.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 240, -1));

        btnLogin.setBackground(new java.awt.Color(9, 121, 176));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresar");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        loginFormPane.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 110, 40));

        contentPane.add(loginFormPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 300, 340));

        welcomeMessagePane.setBackground(new java.awt.Color(0, 65, 115));
        welcomeMessagePane.setFocusable(false);
        welcomeMessagePane.setMaximumSize(new java.awt.Dimension(500, 390));
        welcomeMessagePane.setMinimumSize(new java.awt.Dimension(500, 390));
        welcomeMessagePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(335, 222));
        jPanel1.setMinimumSize(new java.awt.Dimension(335, 222));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        messageLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(255, 255, 255));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("Este es el sistema Shell Windows-Linux");
        messageLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        messageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(messageLabel);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Por favor inicie sesión para empezar");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel4);

        welcomeMessagePane.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 330, 90));

        jPanel3.setOpaque(false);

        welcomeLabel.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("¡Bienvenido!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        welcomeMessagePane.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        contentPane.add(welcomeMessagePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 390));

        sidePane.setBackground(new java.awt.Color(9, 121, 176));

        javax.swing.GroupLayout sidePaneLayout = new javax.swing.GroupLayout(sidePane);
        sidePane.setLayout(sidePaneLayout);
        sidePaneLayout.setHorizontalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        sidePaneLayout.setVerticalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        contentPane.add(sidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 310, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setBackground(darkBlue);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void headBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headBarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headBarMousePressed

    private void headBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headBarMouseDragged

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        try {
            socket.close();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(red);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(blue);
    }//GEN-LAST:event_btnExitMouseExited

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setBackground(blue);
    }//GEN-LAST:event_btnLoginMouseExited

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            txtPassword.setText("");
            txtPassword.setForeground(black);
        }
        if (txtUserName.getText().isBlank()) {
            txtUserName.setText("Ingrese su nombre de usuario");
            txtUserName.setForeground(gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked

        String userName = txtUserName.getText();
        String password = String.valueOf(txtPassword.getPassword());

        alert.setLocationRelativeTo(this);

        System.out.println("client@windows~$ Sending login request...");
        login.login(socket, userName, password);
        System.out.println("client@windows~$ Login request response received");

        if (userName.equals("Ingrese su nombre de usuario") || userName.isBlank()) {
            alert.getTitleLabel().setText("¡Atención!");
            alert.getMessageLabel().setText("Por favor introduzca un usuario");
            alert.setVisible(true);
            txtUserName.requestFocusInWindow();
        } else if (password.equals("********") || password.isBlank()) {
            alert.getTitleLabel().setText("¡Atención!");
            alert.getMessageLabel().setText("Por favor introduzca una contraseña");
            alert.setVisible(true);
            txtPassword.requestFocusInWindow();
        } else if (!login.isLogin()) {
            alert.getTitleLabel().setText("¡Atención!");
            alert.getMessageLabel().setText("Usuario y/o contraseña incorrectos");
            alert.setVisible(true);
        } else {
            alert.getTitleLabel().setText("¡Buen Trabajo!");
            alert.getMessageLabel().setText("Sesión iniciada correctamente");
            alert.setVisible(true);
        }
    }//GEN-LAST:event_btnLoginMouseClicked

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtUserNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMousePressed
        if (txtUserName.getText().equals("Ingrese su nombre de usuario")) {
            txtUserName.setText("");
            txtUserName.setForeground(black);
        }
        if (String.valueOf(txtPassword.getPassword()).isBlank()) {
            txtPassword.setText("********");
            txtPassword.setForeground(gray);
        }
    }//GEN-LAST:event_txtUserNameMousePressed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        if (txtUserName.getText().equals("Ingrese su nombre de usuario")) {
            txtUserName.setText("");
            txtUserName.setForeground(black);
        }
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            txtPassword.setText("");
            txtPassword.setForeground(black);
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            txtPassword.setText("");
            txtPassword.setForeground(black);
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        if (txtUserName.getText().equals("Ingrese su nombre de usuario")) {
            txtUserName.setText("");
            txtUserName.setForeground(black);
        }
    }//GEN-LAST:event_txtUserNameFocusGained

    public Login getLogin() {
        return login;
    }

    public AlertFrame getAlert() {
        return alert;
    }

    public Socket getSocket() {
        return socket;
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel headBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel loginFormPane;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPanel sidePane;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JPanel welcomeMessagePane;
    // End of variables declaration//GEN-END:variables

}
