package starlight;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.mysql.jdbc.ResultSetMetaData;

public class PERDER2 extends javax.swing.JFrame {

    Redimensionar redim = new Redimensionar();

    Conexion conexion = new Conexion();

    public PERDER2() {
        this.setUndecorated(true);
        initComponents();

        redim.setImageLabel(lbl_fondo, "src/Recursos/ranking.png");
        //CAMBIAR EL ICONO A LA VENTANA
        ImageIcon icon = new ImageIcon("src/Recursos/Icono.png");
        this.setIconImage(icon.getImage());
        redim.setImageLabel(lbl_cerrar, "src/Recursos/Cerrar.png");


        MostrarTabla();

        // Redondear las esquinas del JFrame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); //setShape es un metodo de la clase importada y RoundRectangle es una clase predefinida de la clase geom

        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void MostrarTabla() {
        try {
            nivel.setText("TOP 3");
            String query = "SELECT U.Username AS Usuario,\n"
                    + "       SUM(TotalScores.Puntaje) AS Total_Puntos\n"
                    + "FROM (SELECT ID_User, Puntaje FROM M1N1\n"
                    + "    UNION ALL\n"
                    + "    SELECT ID_User, Puntaje FROM M1N2\n"
                    + "    UNION ALL\n"
                    + "    SELECT ID_User, Puntaje FROM M2N1\n"
                    + "    UNION ALL\n"
                    + "    SELECT ID_User, Puntaje FROM M2N2\n"
                    + "    UNION ALL\n"
                    + "    SELECT ID_User, Puntaje FROM M3N1\n"
                    + "    UNION ALL\n"
                    + "    SELECT ID_User, Puntaje FROM M3N2) AS TotalScores\n"
                    + "INNER JOIN Users AS U ON TotalScores.ID_User = U.ID_User\n"
                    + "GROUP BY U.Username\n"
                    + "ORDER BY Total_Puntos DESC;";

            Statement stan = (Statement) conexion.ConexionBD().createStatement();
            ResultSet resultSet = stan.executeQuery(query);
            CustomTableModel tableModel = new CustomTableModel();
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            tabla.setModel(tableModel);
            customizeTableAppearance();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
            e.printStackTrace();  // Añade esta línea para imprimir el stack trace
        }
    }

    private void customizeTableAppearance() {
        // Establecer la altura de las filas
        tabla.setRowHeight(41);

        // Centrar el texto en las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Cambiar la fuente y los colores de la tabla
        tabla.setFont(new Font("Arial", Font.BOLD, 14));
        tabla.setForeground(Color.WHITE);
        tabla.setBackground(new Color(51, 51, 51));
        tabla.setSelectionForeground(Color.BLACK);
        tabla.setSelectionBackground(Color.YELLOW);

        // Cambiar la apariencia del encabezado de la tabla
        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(102, 102, 102));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }

    // Modelo de tabla personalizado para evitar edición de celdas
    private class CustomTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    // Método para configurar 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_cerrar = new javax.swing.JLabel();
        nuevo = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        filtros = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        top = new javax.swing.JLabel();
        nivel6 = new javax.swing.JLabel();
        nivel5 = new javax.swing.JLabel();
        nivel4 = new javax.swing.JLabel();
        nivel3 = new javax.swing.JLabel();
        nivel2 = new javax.swing.JLabel();
        nivel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(255, 255, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 600, 890, 20));

        lbl_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 40, 40));

        nuevo.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        nuevo.setForeground(new java.awt.Color(255, 255, 255));
        nuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nuevo.setText("Jugar de nuevo");
        nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nuevoMouseExited(evt);
            }
        });
        jPanel1.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 700, 220, 40));

        salir.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salir.setText("Salir");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirMouseExited(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 700, 90, 40));

        filtros.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        filtros.setForeground(new java.awt.Color(255, 255, 255));
        filtros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filtros.setText("Filtros de busqueda");
        jPanel1.add(filtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 390, 40));

        nivel.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 36)); // NOI18N
        nivel.setForeground(new java.awt.Color(255, 255, 255));
        nivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel.setText("TOP 3");
        nivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivelMouseClicked(evt);
            }
        });
        jPanel1.add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1030, 80));

        top.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        top.setForeground(new java.awt.Color(255, 255, 255));
        top.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        top.setText("TOP 3");
        top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topMouseExited(evt);
            }
        });
        jPanel1.add(top, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 640, 90, 40));

        nivel6.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        nivel6.setForeground(new java.awt.Color(255, 255, 255));
        nivel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel6.setText("Nivel 6");
        nivel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel6MouseExited(evt);
            }
        });
        jPanel1.add(nivel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 640, 90, 40));

        nivel5.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        nivel5.setForeground(new java.awt.Color(255, 255, 255));
        nivel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel5.setText("Nivel 5");
        nivel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel5MouseExited(evt);
            }
        });
        jPanel1.add(nivel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 640, 90, 40));

        nivel4.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        nivel4.setForeground(new java.awt.Color(255, 255, 255));
        nivel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel4.setText("Nivel 4");
        nivel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel4MouseExited(evt);
            }
        });
        jPanel1.add(nivel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 640, 90, 40));

        nivel3.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        nivel3.setForeground(new java.awt.Color(255, 255, 255));
        nivel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel3.setText("Nivel 3");
        nivel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel3MouseExited(evt);
            }
        });
        jPanel1.add(nivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 640, 90, 40));

        nivel2.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        nivel2.setForeground(new java.awt.Color(255, 255, 255));
        nivel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel2.setText("Nivel 2");
        nivel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel2MouseExited(evt);
            }
        });
        jPanel1.add(nivel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, 90, 40));

        nivel1.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        nivel1.setForeground(new java.awt.Color(255, 255, 255));
        nivel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel1.setText("Nivel 1");
        nivel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel1MouseExited(evt);
            }
        });
        jPanel1.add(nivel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, 90, 40));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setEnabled(false);
        tabla.setFocusable(false);
        tabla.setRequestFocusEnabled(false);
        tabla.setSelectionForeground(new java.awt.Color(0, 102, 255));
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 590, 150));
        jPanel1.add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseClicked
        //Cerrar aplicacion
        System.exit(0);
    }//GEN-LAST:event_lbl_cerrarMouseClicked

    private void nivel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1MouseClicked
        // TODO add your handling code here:
        try {
            nivel.setText("Nivel 1");
            String query = "SELECT Users.Username AS Usuario, M1N1.Puntaje\n"
                    + "FROM M1N1\n"
                    + "INNER JOIN Users ON M1N1.ID_User = Users.ID_User;";

            Statement stan = (Statement) conexion.ConexionBD().createStatement();
            ResultSet resultSet = stan.executeQuery(query);
            CustomTableModel tableModel = new CustomTableModel();
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            tabla.setModel(tableModel);
            customizeTableAppearance();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
            e.printStackTrace();  // Añade esta línea para imprimir el stack trace
        }
    }//GEN-LAST:event_nivel1MouseClicked

    private void nivel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2MouseClicked
        // TODO add your handling code here:
        try {
            nivel.setText("Nivel 2");
            String query = "SELECT Users.Username AS Usuario, M1N2.Puntaje\n"
                    + "FROM M1N2\n"
                    + "INNER JOIN Users ON M1N2.ID_User = Users.ID_User;";

            Statement stan = (Statement) conexion.ConexionBD().createStatement();
            ResultSet resultSet = stan.executeQuery(query);
            CustomTableModel tableModel = new CustomTableModel();
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            tabla.setModel(tableModel);
            customizeTableAppearance();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
            e.printStackTrace();  // Añade esta línea para imprimir el stack trace
        }
    }//GEN-LAST:event_nivel2MouseClicked

    private void nivel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3MouseClicked
        // TODO add your handling code here:
        try {
            nivel.setText("Nivel 3");
            String query = "SELECT Users.Username AS Usuario, M2N1.Puntaje\n"
                    + "FROM M2N1\n"
                    + "INNER JOIN Users ON M2N1.ID_User = Users.ID_User;";

            Statement stan = (Statement) conexion.ConexionBD().createStatement();
            ResultSet resultSet = stan.executeQuery(query);
            CustomTableModel tableModel = new CustomTableModel();
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            tabla.setModel(tableModel);
            customizeTableAppearance();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
            e.printStackTrace();  // Añade esta línea para imprimir el stack trace
        }
    }//GEN-LAST:event_nivel3MouseClicked

    private void nivel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4MouseClicked
        // TODO add your handling code here:
        try {
            nivel.setText("Nivel 4");
            String query = "SELECT Users.Username AS Usuario, M2N2.Puntaje\n"
                    + "FROM M2N2\n"
                    + "INNER JOIN Users ON M2N2.ID_User = Users.ID_User;";

            Statement stan = (Statement) conexion.ConexionBD().createStatement();
            ResultSet resultSet = stan.executeQuery(query);
            CustomTableModel tableModel = new CustomTableModel();
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            tabla.setModel(tableModel);
            customizeTableAppearance();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
            e.printStackTrace();  // Añade esta línea para imprimir el stack trace
        }
    }//GEN-LAST:event_nivel4MouseClicked

    private void nivel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel5MouseClicked
        // TODO add your handling code here:
        try {
            nivel.setText("Nivel 5");
            String query = "SELECT Users.Username AS Usuario, M3N1.Puntaje\n"
                    + "FROM M3N1\n"
                    + "INNER JOIN Users ON M3N1.ID_User = Users.ID_User;";

            Statement stan = (Statement) conexion.ConexionBD().createStatement();
            ResultSet resultSet = stan.executeQuery(query);
            CustomTableModel tableModel = new CustomTableModel();
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            tabla.setModel(tableModel);
            customizeTableAppearance();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
            e.printStackTrace();  // Añade esta línea para imprimir el stack trace
        }
    }//GEN-LAST:event_nivel5MouseClicked

    private void nivel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel6MouseClicked
        // TODO add your handling code here:
        try {
            nivel.setText("Nivel 6");
            String query = "SELECT Users.Username AS Usuario, M3N2.Puntaje\n"
                    + "FROM M3N2\n"
                    + "INNER JOIN Users ON M3N2.ID_User = Users.ID_User;";

            Statement stan = (Statement) conexion.ConexionBD().createStatement();
            ResultSet resultSet = stan.executeQuery(query);
            CustomTableModel tableModel = new CustomTableModel();
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            tabla.setModel(tableModel);
            customizeTableAppearance();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
            e.printStackTrace();  // Añade esta línea para imprimir el stack trace
        }
    }//GEN-LAST:event_nivel6MouseClicked

    private void topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topMouseClicked
        // TODO add your handling code here:
        MostrarTabla();
    }//GEN-LAST:event_topMouseClicked

    private void nivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nivelMouseClicked

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        Inicio i = new Inicio();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_salirMouseClicked

    private void nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseClicked
        // TODO add your handling code here:
        PR_22 p = new PR_22();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nuevoMouseClicked

    private void nuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseEntered
        // TODO add your handling code here:
        nuevo.setForeground(Color.GREEN);
    }//GEN-LAST:event_nuevoMouseEntered

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        // TODO add your handling code here:
        salir.setForeground(Color.RED);
    }//GEN-LAST:event_salirMouseEntered

    private void nuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseExited
        // TODO add your handling code here:
        nuevo.setForeground(Color.WHITE);
    }//GEN-LAST:event_nuevoMouseExited

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        // TODO add your handling code here:
        salir.setForeground(Color.WHITE);
    }//GEN-LAST:event_salirMouseExited

    private void nivel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1MouseEntered
        // TODO add your handling code here:
        nivel1.setForeground(Color.YELLOW);
    }//GEN-LAST:event_nivel1MouseEntered

    private void nivel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2MouseEntered
        // TODO add your handling code here:
        nivel2.setForeground(Color.YELLOW);
    }//GEN-LAST:event_nivel2MouseEntered

    private void nivel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3MouseEntered
        // TODO add your handling code here:
        nivel3.setForeground(Color.YELLOW);
    }//GEN-LAST:event_nivel3MouseEntered

    private void nivel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4MouseEntered
        // TODO add your handling code here:
        nivel4.setForeground(Color.YELLOW);
    }//GEN-LAST:event_nivel4MouseEntered

    private void nivel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel5MouseEntered
        // TODO add your handling code here:
        nivel5.setForeground(Color.YELLOW);
    }//GEN-LAST:event_nivel5MouseEntered

    private void nivel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel6MouseEntered
        // TODO add your handling code here:
        nivel6.setForeground(Color.YELLOW);
    }//GEN-LAST:event_nivel6MouseEntered

    private void topMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topMouseEntered
        // TODO add your handling code here
        top.setForeground(Color.YELLOW);
    }//GEN-LAST:event_topMouseEntered

    private void nivel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1MouseExited
        // TODO add your handling code here:
        nivel1.setForeground(Color.WHITE);
    }//GEN-LAST:event_nivel1MouseExited

    private void nivel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2MouseExited
        // TODO add your handling code here:
        nivel2.setForeground(Color.WHITE);
    }//GEN-LAST:event_nivel2MouseExited

    private void nivel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3MouseExited
        // TODO add your handling code here:
        nivel3.setForeground(Color.WHITE);
    }//GEN-LAST:event_nivel3MouseExited

    private void nivel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4MouseExited
        // TODO add your handling code here:
        nivel4.setForeground(Color.WHITE);
    }//GEN-LAST:event_nivel4MouseExited

    private void nivel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel5MouseExited
        // TODO add your handling code here:
        nivel5.setForeground(Color.WHITE);
    }//GEN-LAST:event_nivel5MouseExited

    private void nivel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel6MouseExited
        // TODO add your handling code here:
        nivel6.setForeground(Color.WHITE);
    }//GEN-LAST:event_nivel6MouseExited

    private void topMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topMouseExited
        // TODO add your handling code here:
        top.setForeground(Color.WHITE);
    }//GEN-LAST:event_topMouseExited

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
            java.util.logging.Logger.getLogger(PERDER2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PERDER2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PERDER2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PERDER2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PERDER2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel filtros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel nivel1;
    private javax.swing.JLabel nivel2;
    private javax.swing.JLabel nivel3;
    private javax.swing.JLabel nivel4;
    private javax.swing.JLabel nivel5;
    private javax.swing.JLabel nivel6;
    private javax.swing.JLabel nuevo;
    private javax.swing.JLabel salir;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel top;
    // End of variables declaration//GEN-END:variables
}
