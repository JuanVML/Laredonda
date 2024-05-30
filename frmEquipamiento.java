package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmEquipamiento extends javax.swing.JFrame {

    private Campo_1 campo1;
    private Campo_2 campo2;
    private Campo_3 campo3;
    private Campo_4 campo4;
    private Campo_5 campo5;
    private Campo_6 campo6;

    private DefaultTableModel modeloTabla;
    private String[] nombresArticulos = {"Botines", "Guantes", "Canilleras", "Polos", "Tarjetas", "Medias"};
    private JComboBox<String>[] jcbxs; // Declaración sin inicialización
    private JButton[] jbtnAgregars; // Declaración sin inicialización

    public frmEquipamiento(Campo_1 campo1, Campo_2 campo2, Campo_3 campo3, Campo_4 campo4, Campo_5 campo5, Campo_6 campo6) {
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.campo3 = campo3;
        this.campo4 = campo4;
        this.campo5 = campo5;
        this.campo6 = campo6;

        initComponents();
        jcbxs = new JComboBox[]{jcbx1, jcbx2, jcbx3, jcbx4, jcbx5, jcbx6};
        jbtnAgregars = new JButton[]{jbtnAgregar1, jbtnAgregar2, jbtnAgregar3, jbtnAgregar4, jbtnAgregar5, jbtnAgregar6};
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Artículo");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio U.");
        modeloTabla.addColumn("Precio T.");
        jtblCarrito.setModel(modeloTabla);

        // ActionListener para cada botón
        for (int i = 0; i < nombresArticulos.length; i++) {
            int indiceArticulo = i;

            jbtnAgregars[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    agregarAlCarrito(nombresArticulos[indiceArticulo], jcbxs[indiceArticulo]);
                }
            });
        }
    }

    private void agregarAlCarrito(String articulo, JComboBox<String> comboboxCantidad) {
        String cantidadStr = comboboxCantidad.getSelectedItem().toString();

        if (cantidadStr.equals("<<seleccione>>")) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int cantidad = Integer.parseInt(cantidadStr);
        double precioUnitario = 2.0;
        double precioTotal = cantidad * precioUnitario;

        modeloTabla.addRow(new Object[]{articulo, cantidad, precioUnitario, precioTotal});

        calcularTotal();

        // Restablecer el combobox a la opción por defecto después de agregar
        comboboxCantidad.setSelectedIndex(0);
    }

    private void calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            total += (double) modeloTabla.getValueAt(i, 3); // Columna "Precio T."
        }
        jtxtTotalPagar.setText("S/. " + String.format("%.2f", total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pEquipamiento1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jbtnCancelarE = new javax.swing.JButton();
        jbtnAceptarE = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jcbx6 = new javax.swing.JComboBox<>();
        jcbx1 = new javax.swing.JComboBox<>();
        jcbx2 = new javax.swing.JComboBox<>();
        jcbx3 = new javax.swing.JComboBox<>();
        jcbx4 = new javax.swing.JComboBox<>();
        jcbx5 = new javax.swing.JComboBox<>();
        jbtnAgregar4 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jbtnAgregar3 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jbtnAgregar1 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jbtnAgregar2 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jbtnAgregarLays8 = new javax.swing.JButton();
        jbtnAgregar6 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jbtnAgregar5 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jButton51 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblCarrito = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jtxtTotalPagar = new javax.swing.JTextField();
        jbtnReservarCarrito = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pEquipamiento1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(60, 71, 84));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnCancelarE.setBackground(new java.awt.Color(204, 204, 204));
        jbtnCancelarE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnCancelarE.setForeground(new java.awt.Color(0, 0, 0));
        jbtnCancelarE.setText("Cancelar");
        jbtnCancelarE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbtnCancelarEMouseMoved(evt);
            }
        });
        jbtnCancelarE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnCancelarEMouseExited(evt);
            }
        });
        jPanel8.add(jbtnCancelarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 140, 40));

        jbtnAceptarE.setBackground(new java.awt.Color(204, 204, 204));
        jbtnAceptarE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtnAceptarE.setForeground(new java.awt.Color(0, 0, 0));
        jbtnAceptarE.setText("Aceptar");
        jbtnAceptarE.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbtnAceptarEMouseMoved(evt);
            }
        });
        jbtnAceptarE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnAceptarEMouseExited(evt);
            }
        });
        jPanel8.add(jbtnAceptarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 140, 40));

        pEquipamiento1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 470, 1020, 80));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/soccer-boots.png"))); // NOI18N
        pEquipamiento1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 80, 80));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/soccer-boots.png"))); // NOI18N
        pEquipamiento1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 80, 80));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/gloves (1).png"))); // NOI18N
        pEquipamiento1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 80, 60));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/soccer (2).png"))); // NOI18N
        pEquipamiento1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 80, 80));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/football-shirt (2).png"))); // NOI18N
        pEquipamiento1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 276, 60, 80));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/red-card.png"))); // NOI18N
        pEquipamiento1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 80, 80));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/football-long-socks-with-white-lines (1).png"))); // NOI18N
        pEquipamiento1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 80, 70));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/football-long-socks-with-white-lines (1).png"))); // NOI18N
        pEquipamiento1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 80, 70));

        jcbx6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<seleccione>>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "++" }));
        pEquipamiento1.add(jcbx6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        jcbx1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<seleccione>>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "++" }));
        pEquipamiento1.add(jcbx1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 160, -1, -1));

        jcbx2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<seleccione>>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "++" }));
        pEquipamiento1.add(jcbx2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jcbx3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<seleccione>>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "++" }));
        pEquipamiento1.add(jcbx3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jcbx4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<seleccione>>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "++" }));
        pEquipamiento1.add(jcbx4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jcbx5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<seleccione>>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "++" }));
        pEquipamiento1.add(jcbx5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jbtnAgregar4.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar4.setFont(new java.awt.Font("Mongolian Baiti", 0, 12)); // NOI18N
        jbtnAgregar4.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar4.setText("Agregar al carrito");
        jbtnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregar4ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jbtnAgregar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 120, 20));

        jButton47.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 140, 170));

        jbtnAgregar3.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar3.setFont(new java.awt.Font("Mongolian Baiti", 0, 12)); // NOI18N
        jbtnAgregar3.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar3.setText("Agregar al carrito");
        jbtnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregar3ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jbtnAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, 20));

        jButton48.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 140, 170));

        jbtnAgregar1.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar1.setFont(new java.awt.Font("Mongolian Baiti", 0, 12)); // NOI18N
        jbtnAgregar1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar1.setText("Agregar al carrito");
        jbtnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregar1ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jbtnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 120, 20));

        jButton49.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 140, 170));

        jbtnAgregar2.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar2.setFont(new java.awt.Font("Mongolian Baiti", 0, 12)); // NOI18N
        jbtnAgregar2.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar2.setText("Agregar al carrito");
        jbtnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregar2ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jbtnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 120, 20));

        jButton50.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 140, 170));

        jbtnAgregarLays8.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregarLays8.setFont(new java.awt.Font("Mongolian Baiti", 0, 12)); // NOI18N
        jbtnAgregarLays8.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarLays8.setText("Agregar al carrito");
        jbtnAgregarLays8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarLays8ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jbtnAgregarLays8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 120, 20));

        jbtnAgregar6.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar6.setFont(new java.awt.Font("Mongolian Baiti", 0, 12)); // NOI18N
        jbtnAgregar6.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar6.setText("Agregar al carrito");
        jbtnAgregar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregar6ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jbtnAgregar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 120, 20));

        jButton52.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 140, 170));

        jbtnAgregar5.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar5.setFont(new java.awt.Font("Mongolian Baiti", 0, 12)); // NOI18N
        jbtnAgregar5.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar5.setText("Agregar al carrito");
        jbtnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregar5ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jbtnAgregar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 120, 20));

        jLabel31.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Tu Carrito");
        pEquipamiento1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 95, 90, 40));

        jButton51.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 140, 170));

        jtblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Articulo", "Cantidad", "Precio U.", "Precio T."
            }
        ));
        jScrollPane1.setViewportView(jtblCarrito);

        pEquipamiento1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 270, 160));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        pEquipamiento1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 270, 130));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setText("Tu Total");
        pEquipamiento1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 60, -1));

        jLabel48.setBackground(new java.awt.Color(0, 0, 0));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setText("S/.");
        pEquipamiento1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 20, 20));

        jtxtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTotalPagarActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jtxtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 130, -1));

        jbtnReservarCarrito.setBackground(new java.awt.Color(0, 0, 0));
        jbtnReservarCarrito.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jbtnReservarCarrito.setForeground(new java.awt.Color(255, 255, 255));
        jbtnReservarCarrito.setText("Reservar");
        jbtnReservarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnReservarCarritoActionPerformed(evt);
            }
        });
        pEquipamiento1.add(jbtnReservarCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 230, -1));
        pEquipamiento1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 270, 130));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ddb18728a2772d3228ecaa8e83aa3c63.jpg"))); // NOI18N
        pEquipamiento1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(-330, -40, 1170, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pEquipamiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pEquipamiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCancelarEMouseMoved
        jbtnCancelarE.setBackground(new Color(178, 68, 75));
    }//GEN-LAST:event_jbtnCancelarEMouseMoved

    private void jbtnCancelarEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCancelarEMouseExited
        jbtnCancelarE.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jbtnCancelarEMouseExited

    private void jbtnAceptarEMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAceptarEMouseMoved
        jbtnAceptarE.setBackground(new Color(115, 153, 142));
    }//GEN-LAST:event_jbtnAceptarEMouseMoved

    private void jbtnAceptarEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAceptarEMouseExited
        jbtnAceptarE.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jbtnAceptarEMouseExited

    private void jbtnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregar4ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jbtnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregar3ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jbtnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregar1ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jbtnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregar2ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jbtnAgregarLays8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarLays8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregarLays8ActionPerformed

    private void jbtnAgregar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregar6ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jbtnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregar5ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jtxtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTotalPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTotalPagarActionPerformed

    private void jbtnReservarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnReservarCarritoActionPerformed
        String totalPagar = jtxtTotalPagar.getText();
        if (campo1 != null) {
            campo1.setMontoEquipo(totalPagar);
        }
        if (campo2 != null) {
            campo2.setMontoEquipo(totalPagar);
        }
        if (campo3 != null) {
            campo3.setMontoEquipo(totalPagar);
        }
        if (campo4 != null) {
            campo4.setMontoEquipo(totalPagar);
        }
        if (campo5 != null) {
            campo5.setMontoEquipo(totalPagar);
        }
        if (campo6 != null) {
            campo6.setMontoEquipo(totalPagar);
        }
        // Cerrar frmEquipamiento
        this.dispose();
    }//GEN-LAST:event_jbtnReservarCarritoActionPerformed

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
            java.util.logging.Logger.getLogger(frmEquipamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEquipamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEquipamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEquipamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAceptarE;
    private javax.swing.JButton jbtnAgregar1;
    private javax.swing.JButton jbtnAgregar2;
    private javax.swing.JButton jbtnAgregar3;
    private javax.swing.JButton jbtnAgregar4;
    private javax.swing.JButton jbtnAgregar5;
    private javax.swing.JButton jbtnAgregar6;
    private javax.swing.JButton jbtnAgregarLays8;
    private javax.swing.JButton jbtnCancelarE;
    private javax.swing.JButton jbtnReservarCarrito;
    private javax.swing.JComboBox<String> jcbx1;
    private javax.swing.JComboBox<String> jcbx2;
    private javax.swing.JComboBox<String> jcbx3;
    private javax.swing.JComboBox<String> jcbx4;
    private javax.swing.JComboBox<String> jcbx5;
    private javax.swing.JComboBox<String> jcbx6;
    private javax.swing.JTable jtblCarrito;
    private javax.swing.JTextField jtxtTotalPagar;
    private javax.swing.JPanel pEquipamiento1;
    // End of variables declaration//GEN-END:variables
}
