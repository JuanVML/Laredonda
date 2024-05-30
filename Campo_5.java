package Vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Campo_5 extends javax.swing.JFrame {
  
    public Campo_5() {
        initComponents();
   
         ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Verificar si ambos combobox tienen selecciones válidas
                    if (!jcbxHInicioC1.getSelectedItem().toString().equals("--Seleccionar--") &&
                        !jcbxHFinC1.getSelectedItem().toString().equals("--Seleccionar--")) {
                        calcularCostoTiempo();
                    } else {
                        jtxtCostoTiempo.setText(""); // Limpiar el campo si falta alguna selección
                    }
                }
            }
        };
        jcbxHInicioC1.addItemListener(itemListener);
        jcbxHFinC1.addItemListener(itemListener);
        
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularPagoTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularPagoTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calcularPagoTotal();
            }
        };

        jtxtCostoTiempo.getDocument().addDocumentListener(documentListener);
        jtxtMontoEquipo.getDocument().addDocumentListener(documentListener);
    }
// Método para establecer el monto del equipo
public void setMontoEquipo(String monto) {
        jtxtMontoEquipo.setText(monto);
    }
    private void calcularPagoTotal() {
        try {
            // Obtener valores de los campos, reemplazando "S/." y manejando campos vacíos
            double costoTiempo = Double.parseDouble(jtxtCostoTiempo.getText().replace("S/. ", "").isEmpty() ? "0" : jtxtCostoTiempo.getText().replace("S/. ", ""));
            double montoEquipos = Double.parseDouble(jtxtMontoEquipo.getText().replace("S/. ", "").isEmpty() ? "0" : jtxtMontoEquipo.getText().replace("S/. ", ""));

            // Calcular y mostrar el pago total
            double pagoTotal = costoTiempo + montoEquipos;
            jtxtPagoTotal.setText("S/. " + String.format("%.2f", pagoTotal));
        } catch (NumberFormatException e) {
            // Manejar errores de formato de número (por ejemplo, si el usuario ingresa texto en lugar de números)
            jtxtPagoTotal.setText("S/. 0.00"); // O mostrar un mensaje de error
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jcbxHFinC1 = new javax.swing.JComboBox<>();
        jcbxHInicioC1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jbtnMarco = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jbtnIr = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtxtMontoEquipo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtxtCostoTiempo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jtxtPagoTotal = new javax.swing.JTextField();
        jbtnGuardarCampo1 = new javax.swing.JButton();
        jbtnVolverCampo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(60, 71, 84));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/pitch.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 70, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Campo 5");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        jSeparator1.setBackground(new java.awt.Color(60, 71, 84));
        jSeparator1.setForeground(new java.awt.Color(60, 71, 84));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 10, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setText("Hora Fin:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 60, 40));

        jcbxHFinC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00" }));
        jPanel1.add(jcbxHFinC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 120, -1));

        jcbxHInicioC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00" }));
        jPanel1.add(jcbxHInicioC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("Hora Inicio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 70, 40));

        jbtnMarco.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbtnMarcoMouseMoved(evt);
            }
        });
        jbtnMarco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMarcoActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnMarco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 300, 90));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Equipamiento deportivos necesarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION), "Equipamiento deportivos a agregar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 1, 14), new java.awt.Color(14, 41, 69))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ir a visualizar los aquipamientos");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 200, 30));

        jbtnIr.setText("Ir");
        jbtnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIrActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnIr, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 130, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Monto de equipos agregados:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 190, 30));
        jPanel2.add(jtxtMontoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 220, -1));

        jLabel10.setText("S/.");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 20, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 620, 160));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jtxtCostoTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 150, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Costo por Tiempo:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 40));

        jLabel8.setText("S/.");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 190, 70));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pago Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("S/.");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 20, 20));
        jPanel4.add(jtxtPagoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 230, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 340, 70));

        jbtnGuardarCampo1.setBackground(new java.awt.Color(32, 112, 61));
        jbtnGuardarCampo1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jbtnGuardarCampo1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarCampo1.setText("Guardar");
        jbtnGuardarCampo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarCampo1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnGuardarCampo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 120, 40));

        jbtnVolverCampo1.setBackground(new java.awt.Color(18, 133, 190));
        jbtnVolverCampo1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jbtnVolverCampo1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVolverCampo1.setText("Volver");
        jbtnVolverCampo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverCampo1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnVolverCampo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 120, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnMarcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMarcoActionPerformed
        //frmSistema equipo = new frmSistema();
        //equipo.setVisible(true);
    }//GEN-LAST:event_jbtnMarcoActionPerformed

    private void jbtnMarcoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnMarcoMouseMoved
         jbtnMarco.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_jbtnMarcoMouseMoved

    private void jbtnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIrActionPerformed
        Campo_1 campo1 = new Campo_1(); // Inicializa si es necesario
        Campo_3 campo3 = new Campo_3(); // Inicializa si es necesario
        Campo_4 campo4 = new Campo_4(); // Inicializa si es necesario
        Campo_2 campo2 = new Campo_2(); // Inicializa si es necesario
        Campo_6 campo6 = new Campo_6(); // Inicializa si es necesario
        
        frmEquipamiento equipamiento = new frmEquipamiento(campo1, campo2, campo3, campo4, this, campo6);
        equipamiento.setVisible(true);
    }//GEN-LAST:event_jbtnIrActionPerformed

    private void jbtnVolverCampo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverCampo1ActionPerformed
     dispose();
    }//GEN-LAST:event_jbtnVolverCampo1ActionPerformed

    private void jbtnGuardarCampo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarCampo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnGuardarCampo1ActionPerformed

    private void calcularCostoTiempo() {
        String horaInicio = jcbxHInicioC1.getSelectedItem().toString();
        String horaFin = jcbxHFinC1.getSelectedItem().toString();

        // Validar que se hayan seleccionado ambas horas
        if (horaInicio.equals("--Seleccionar--") || horaFin.equals("--Seleccionar--")) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona ambas horas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calcular el costo y mostrar el resultado
        double costoTiempo = calcularCostoTiempo(horaInicio, horaFin);
        jtxtCostoTiempo.setText("S/. " + String.format("%.2f", costoTiempo));
    }

    private double calcularCostoTiempo(String horaInicio, String horaFin) {
        // Extraer las horas y minutos de cada selección
        int horaInicioNum = Integer.parseInt(horaInicio.split(":")[0]);
        int minInicioNum = Integer.parseInt(horaInicio.split(":")[1]);
        int horaFinNum = Integer.parseInt(horaFin.split(":")[0]);
        int minFinNum = Integer.parseInt(horaFin.split(":")[1]);

        // Calcular la diferencia en minutos
        int minutosTotales = (horaFinNum * 60 + minFinNum) - (horaInicioNum * 60 + minInicioNum);

        // Calcular el costo total
        double costoTotal = 0.0;
        while (minutosTotales > 0) {
            if (minutosTotales >= 60) {
                costoTotal += 60.0;  // Costo por hora completa
                minutosTotales -= 60;
            } else {
                costoTotal += 30.0;  // Costo por media hora
                minutosTotales -= 30;
            }
        }

        return costoTotal;
    } 

    public static void main(String args[]) {

        FlatLightLaf.setup();
        UIManager.put("Button.arc", 50);
        UIManager.put("TextComponent.arc", 50);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Campo_5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnGuardarCampo1;
    private javax.swing.JButton jbtnIr;
    private javax.swing.JButton jbtnMarco;
    private javax.swing.JButton jbtnVolverCampo1;
    private javax.swing.JComboBox<String> jcbxHFinC1;
    private javax.swing.JComboBox<String> jcbxHInicioC1;
    private javax.swing.JTextField jtxtCostoTiempo;
    private javax.swing.JTextField jtxtMontoEquipo;
    private javax.swing.JTextField jtxtPagoTotal;
    // End of variables declaration//GEN-END:variables

    private void System(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
