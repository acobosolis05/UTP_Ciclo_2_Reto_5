package reto5;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.sql.*;

public class Consulta2 extends JFrame{

    public Consulta2(){// Constructor

        String jdbcUrl = "jdbc:sqlite:ProyectosConstruccion.db";
        try{
            Connection conexion = DriverManager.getConnection(jdbcUrl);
            //String sql1 = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia";
            String sql2 = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla') ORDER BY Constructora;";
            //String sql3 = "SELECT ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento' ORDER BY Constructora;";
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql2);

            DefaultTableModel modelo2 = new DefaultTableModel();
            JTable tabla2 = new JTable(modelo2);
            modelo2.addColumn("Id Proyecto");
            modelo2.addColumn("Constructora");
            modelo2.addColumn("Número Habitaciones");
            modelo2.addColumn("Ciudad");

            while (rs.next()){
                Object[] fila = new Object[4];
                for (int i=0; i<fila.length; i++){
                    fila[i] = rs.getObject(i+1);
                }
                modelo2.addRow(fila);
            }
            rs.close();
            stm.close();
            conexion.close();
            tabla2.setPreferredScrollableViewportSize(new Dimension(500,250));
            add(tabla2);
            
            JScrollPane scrollPane = new JScrollPane(tabla2); 
            add(scrollPane);
        }
        catch(Exception e){
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Consulta2 ventana2 = new Consulta2();
        ventana2.pack();
        //ventana2.setVisible(true);
        ventana2.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
