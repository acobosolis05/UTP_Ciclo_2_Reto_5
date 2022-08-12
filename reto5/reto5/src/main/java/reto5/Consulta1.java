package reto5;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.sql.*;

public class Consulta1 extends JFrame{
    
    public Consulta1(){// Constructor

        String jdbcUrl = "jdbc:sqlite:ProyectosConstruccion.db";
        try{
            Connection conexion = DriverManager.getConnection(jdbcUrl);
            String sql1 = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia";
            //String sql2 = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla') ORDER BY Constructora;";
            //String sql3 = "SELECT ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento' ORDER BY Constructora;";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql1);

            DefaultTableModel modelo1 = new DefaultTableModel();
            JTable tabla1 = new JTable(modelo1);
            modelo1.addColumn("Id Lider");
            modelo1.addColumn("Nombre");
            modelo1.addColumn("Primer Apellido");
            modelo1.addColumn("Ciudad Residencia");

            while (rs.next()){
                Object[] fila = new Object[4];
                for (int i=0; i<fila.length; i++){
                    fila[i] = rs.getObject(i+1);
                }
                modelo1.addRow(fila);
            }
            rs.close();
            stm.close();
            conexion.close();
            tabla1.setPreferredScrollableViewportSize(new Dimension(500,250));
            add(tabla1);
            tabla1.setLocation(400, 400);

            JScrollPane scrollPane = new JScrollPane(tabla1); 
            add(scrollPane);

            /*frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);*/
        }
        catch(Exception e){
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
    }

    /*public static void main(String[] args) {
        Consulta1 ventana1 = new Consulta1();
        ventana1.pack();
        ventana1.setVisible(true);
        ventana1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }*/
}
