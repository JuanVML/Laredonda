package Vista;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Vista.DatabaseConnection;
import Vista.Registro;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class InicioSesion extends javax.swing.JFrame {
    // Iconos para el jToggleButton2

    private final Icon iconVisible = new ImageIcon(getClass().getResource("/Vista/Eye_20.png"));
    private final Icon iconOculto = new ImageIcon(getClass().getResource("/Vista/Hide_20.png"));
    // PARA MOSTRAR VISIBILIDAD:
    private boolean passwordVisible = false; // Estado inicial del campo de contraseña

    public InicioSesion() {
        initComponents();
        setImageLabel(jLabel1, "src/Vista/redes.png");
        setImageLabel(jLabel2, "src/Vista/a.png");
        setImageLabel(jLabel3, "src/Vista/250.png");

        // PARA ALTERNAR BOTONES EN LA CONTRASEÑA:
        // Agregar FocusListener al jTextField2 para restablecer el texto si está vacío
        jtxtUsu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jtxtUsu.getText().equals("Ingrese su nombre de usuario")) {
                    jtxtUsu.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jtxtUsu.getText().isEmpty()) {
                    jtxtUsu.setText("Ingrese su nombre de usuario");
                }
            }
        });

        // Agregar FocusListener al jPasswordField1 para restablecer el texto si está vacío
        jpsContra.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(jpsContra.getPassword()).equals("Ingrese su contraseña")) {
                    jpsContra.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(jpsContra.getPassword()).isEmpty()) {
                    jpsContra.setText("Ingrese su contraseña");
                }
            }
        });

        // Establecer el icono inicial del jToggleButton2
        jToggleButton2.setIcon(iconOculto);

        jToggleButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePasswordVisibility(); // Cambiar la visibilidad de la contraseña
                toggleButtonIcon(); // Cambiar el icono del boton
            }
        });

        // Agregar MouseListener a JFrame para restablecer el texto si se hace clic en cualquier parte
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtxtUsu.getText().isEmpty()) {
                    jtxtUsu.setText("Ingrese su nombre de usuario");
                }
                if (String.valueOf(jpsContra.getPassword()).isEmpty()) {
                    jpsContra.setText("Ingrese su contraseña");
                }
            }
        });
    }

    // Para la Imagen:
    private void setImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),
                labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
        this.repaint();
    }
    // Método para alternar la visibilidad de la contraseña en toglle

    private void togglePasswordVisibility() {
        passwordVisible = !passwordVisible; // Invertir el estado actual

        // Actualizar el contenido del campo de contraseña
        if (passwordVisible) {
            jpsContra.setEchoChar((char) 0); // Mostrar texto claro
            jToggleButton2.setIcon(iconVisible);
        } else {
            jpsContra.setEchoChar('*'); // Mostrar asteriscos
            jToggleButton2.setIcon(iconOculto);
        }
    }

    //Para mostrar los iconos:
    private void toggleButtonIcon() {
        // Alternar entre los iconos
        if (jToggleButton2.getIcon() == iconVisible) {
            jToggleButton2.setIcon(iconOculto);
        } else {
            jToggleButton2.setIcon(iconVisible);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jtxtUsu = new javax.swing.JTextField();
        jpsContra = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 80, 30));

        jToggleButton1.setBackground(new java.awt.Color(51, 51, 255));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrasena.png"))); // NOI18N
        jToggleButton1.setText("REGISTRARSE");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 180, 40));

        jToggleButton3.setBackground(new java.awt.Color(51, 255, 51));
        jToggleButton3.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciarsesion.png"))); // NOI18N
        jToggleButton3.setText("INICIAR SESION");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 180, 40));

        jToggleButton2.setBackground(new java.awt.Color(204, 204, 204));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eye_20.png"))); // NOI18N
        jToggleButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 50, 40));

        jtxtUsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jtxtUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 280, 40));
        jPanel1.add(jpsContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 260, 40));

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 150, 30));

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("INICIO DE SESION");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 250, 40));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 120));

        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 370, 490));

        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 569, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Registro p1 = new Registro();
        p1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        String username = jtxtUsu.getText();
        String password = new String(jpsContra.getPassword());

        if (DatabaseConnection.validateLogin(username, password)) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
            frmSistema sistema = new frmSistema();
            sistema.setVisible(true);
            dispose(); // Cierra la ventana de inicio de sesión actual
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 50);
        UIManager.put("TextComponent.arc", 50);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JPasswordField jpsContra;
    private javax.swing.JTextField jtxtUsu;
    // End of variables declaration//GEN-END:variables
}
