
package juevesinicio;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {

  // Iconos para el jToggleButton2
    private final Icon iconVisible = new ImageIcon(getClass().getResource("/imagenes/Eye_20.png"));
    private final Icon iconOculto = new ImageIcon(getClass().getResource("/imagenes/Hide_20.png"));
    // PARA MOSTRAR VISIBILIDAD:
    private boolean passwordVisible = false; // Estado inicial del campo de contraseña

    public Registro() {
    initComponents();
        setImageLabel(jLabel1, "src/imagenes/redes.png");
        setImageLabel(jLabel2, "src/imagenes/250.png");

        // Agregar FocusListener al usuario para restablecer el texto si está vacío
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

        // Agregar FocusListener al correo  para restablecer el texto si está vacío
        jtxtcorreo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jtxtcorreo.getText().equals("Ingrese correo electronico")) {
                    jtxtcorreo.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jtxtcorreo.getText().isEmpty()) {
                    jtxtcorreo.setText("Ingrese correo electronico");
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

        // Agregar FocusListener al jPasswordField1 para restablecer el texto si está vacío
        jpsContraconfirma.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(jpsContraconfirma.getPassword()).equals("Ingrese su contraseña")) {
                    jpsContraconfirma.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(jpsContraconfirma.getPassword()).isEmpty()) {
                    jpsContraconfirma.setText("Ingrese su contraseña");
                }
            }
        });

        // Agregar MouseListener a JFrame para restablecer el texto si se hace clic en cualquier parte
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtxtcorreo.getText().isEmpty()) {
                    jtxtcorreo.setText("Ingrese correo electronico");
                }
                if (jtxtUsu.getText().isEmpty()) {
                    jtxtUsu.setText("Ingrese su nombre de usuario");
                }

                if (String.valueOf(jpsContra.getPassword()).isEmpty()) {
                    jpsContra.setText("Ingrese su contraseña");
                }
                if (String.valueOf(jpsContraconfirma.getPassword()).isEmpty()) {
                    jpsContraconfirma.setText("Ingrese su contraseña");
                }
            }
        });

        // Establecer el icono inicial del jToggleButton2
        jtbvision.setIcon(iconOculto);

        jtbvision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePasswordVisibility(); // Cambiar la visibilidad de la contraseña
                toggleButtonIcon(); // Cambiar el icono del boton
            }
        });
    
    jpsContraconfirma.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (String.valueOf(jpsContraconfirma.getPassword()).equals("Ingrese su contraseña")) {
            jpsContraconfirma.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (!String.valueOf(jpsContraconfirma.getPassword()).equals(String.valueOf(jpsContra.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, revise por favor.", "Error", JOptionPane.ERROR_MESSAGE);
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
    //Para mostrar los iconos:
 private void toggleButtonIcon() {
        // Alternar entre los iconos
        if (jtbvision.getIcon() == iconVisible) {
            jtbvision.setIcon(iconOculto);
        } else {
            jtbvision.setIcon(iconVisible);
        }
    }   
// Método para alternar la visibilidad de la contraseña en toggle
    private void togglePasswordVisibility() {
        passwordVisible = !passwordVisible; // Invertir el estado actual
        
        // Actualizar el contenido del campo de contraseña
        if (passwordVisible) {
            jpsContraconfirma.setEchoChar((char) 0); // Mostrar texto claro
            jtbvision.setIcon(iconVisible);
        } else {
            jpsContraconfirma.setEchoChar('*'); // Mostrar asteriscos
            jtbvision.setIcon(iconOculto);
        }
    }

        // Método para registrar el usuario en la base de datos
   private void registrarUsuario() {
    // Recoger los datos del formulario
    String nombreUsuario = jtxtUsu.getText();
    String correo = jtxtcorreo.getText();
    String contrasena = String.valueOf(jpsContra.getPassword());
    String contrasenaConfirma = String.valueOf(jpsContraconfirma.getPassword());
    int diaNacimiento = Integer.parseInt((String) jcbxdia.getSelectedItem());
    String mesNacimiento = (String) jcbxmes.getSelectedItem();
    int anioNacimiento = Integer.parseInt((String) jcbxanio.getSelectedItem());

    // Validar que los campos no estén vacíos (puedes mejorar esta validación)
    if (nombreUsuario.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || contrasenaConfirma.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar que las contraseñas coincidan
    if (!contrasena.equals(contrasenaConfirma)) {
        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden, revise por favor.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Insertar los datos en la base de datos
    try (Connection conn = DatabaseConnection.getConnection()) {
        String sql = "INSERT INTO Usuarios (NombreUsuario, Correo, Contrasena, DiaNacimiento, MesNacimiento, AnioNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nombreUsuario);
        pstmt.setString(2, correo);
        pstmt.setString(3, contrasena);
        pstmt.setInt(4, diaNacimiento);
        pstmt.setString(5, mesNacimiento);
        pstmt.setInt(6, anioNacimiento);

        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Registro exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al registrar el usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jtbvision = new javax.swing.JToggleButton();
        jpsContra = new javax.swing.JPasswordField();
        jpsContraconfirma = new javax.swing.JPasswordField();
        jcbxmes = new javax.swing.JComboBox<>();
        jcbxdia = new javax.swing.JComboBox<>();
        jcbxanio = new javax.swing.JComboBox<>();
        jtxtUsu = new javax.swing.JTextField();
        jtxtcorreo = new javax.swing.JTextField();
        btnregresar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir-amigo.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 160, 150));

        jtbvision.setBackground(new java.awt.Color(204, 204, 204));
        jtbvision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eye_20.png"))); // NOI18N
        jtbvision.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jtbvision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbvisionActionPerformed(evt);
            }
        });
        getContentPane().add(jtbvision, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 50, 40));
        getContentPane().add(jpsContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 260, 40));
        getContentPane().add(jpsContraconfirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 260, 40));

        jcbxmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECCIONE--", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        getContentPane().add(jcbxmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, 40));

        jcbxdia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECCIONE--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(jcbxdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 140, 40));

        jcbxanio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECCIONE--", "1920", "1921" }));
        getContentPane().add(jcbxanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 150, 40));
        getContentPane().add(jtxtUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 370, 50));
        getContentPane().add(jtxtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 370, 50));

        btnregresar.setBackground(new java.awt.Color(0, 153, 255));
        btnregresar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnregresar.setForeground(new java.awt.Color(255, 255, 255));
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha-izquierda.png"))); // NOI18N
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 580, 160, 40));

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/acceso.png"))); // NOI18N
        jButton2.setText("Registrarte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 170, 40));

        jLabel9.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mes:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Contraseña:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo electronico:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirma Contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Año:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Día:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CREAR TU CUENTA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 120));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void jtbvisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbvisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbvisionActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
      InicioSesion  p1 = new InicioSesion();
      p1.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 registrarUsuario();       
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jcbxanio;
    private javax.swing.JComboBox<String> jcbxdia;
    private javax.swing.JComboBox<String> jcbxmes;
    private javax.swing.JPasswordField jpsContra;
    private javax.swing.JPasswordField jpsContraconfirma;
    private javax.swing.JToggleButton jtbvision;
    private javax.swing.JTextField jtxtUsu;
    private javax.swing.JTextField jtxtcorreo;
    // End of variables declaration//GEN-END:variables
}
