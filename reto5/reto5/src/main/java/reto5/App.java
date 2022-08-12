package reto5;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener{ 
    
    private JLabel etiqueta1, etiqueta2, etiqueta3;
    private JButton btnC1, btnC2, btnC3;


    public App(){ //Constructor
        // Método setLayOut es heredado de la clase jFrame
        setLayout(null); //Los objetos en la ventana se ubican en posiciones absolutas
        etiqueta1 = new JLabel("CICLO 2 - RETO 5");
        etiqueta1.setBounds(200, 20, 100, 40);
        add(etiqueta1);

        etiqueta3 = new JLabel("Bienvenido a la solución del reto 5");
        etiqueta3.setBounds(150, 40, 300, 50);
        add(etiqueta3);

        etiqueta2 = new JLabel("Para visualizar el informe requerido presione el botón correspondiente");
        etiqueta2.setBounds(40, 70, 400, 50);
        add(etiqueta2);

        btnC1 = new JButton("Informe 1");
        btnC1.setBounds(30, 130, 100, 30);
        add(btnC1);
        btnC1.addActionListener(this);

        btnC2 = new JButton("Informe 2");
        btnC2.setBounds(180, 130, 100, 30);
        add(btnC2);
        btnC2.addActionListener(this);

        btnC3 = new JButton("Informe 3");
        btnC3.setBounds(330, 130, 100, 30);
        add(btnC3);
        btnC3.addActionListener(this);

    }
    
    public static void main( String[] args ) throws Exception
    {
        App ventana = new App();
        ventana.setBounds(50, 150, 500, 250);
        ventana.setTitle("Universidad Tecnológica de Pereira - MinTIC");
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnC1){
            Consulta1 ventana1 = new Consulta1();
            ventana1.pack();
            ventana1.setVisible(true);
            //ventana1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(App.this, "Generar un informe basándose en la tabla con la información respectiva al “Líder”.\nEl listado debe contener:el ID_Lider, el Nombre, el Primer_Apellido y la Ciudad_Residencia. \nEste informe debe estar ordenado por la “Ciudad_Residencia” de forma alfabética", "Informe 1", JOptionPane.INFORMATION_MESSAGE); //Ventana emergente que muestra la instrucción del informe 1
            System.out.println("El botón 1 fue presionado");
        }
        if (e.getSource() == btnC2){
            Consulta2 ventana2 = new Consulta2();
            ventana2.pack();
            ventana2.setVisible(true);
            JOptionPane.showMessageDialog(App.this, "Realizar un informe basándose en la información de los proyectos cuya clasificación sea “Casa Campestre” \ny que estén ubicados en las ciudades de “Santa Marta”, “Cartagena” y “Barranquilla”. \nEste informe debe contener: el ID_Proyecto, la Constructora, el Nùmero_Habitaciones y la respectiva Ciudad.", "Informe 2", JOptionPane.INFORMATION_MESSAGE); //Ventana emergente que muestra la instrucción del informe 2
            //ventana2.setDefaultCloseOperation(EXIT_ON_CLOSE);
            System.out.println("El botón 2 fue presionado");
        }
        if (e.getSource() == btnC3){
            Consulta3 ventana3 = new Consulta3();
            ventana3.pack();
            ventana3.setVisible(true);
            JOptionPane.showMessageDialog(App.this, "Realizar un informe basándose en las compras realizadas por los proyectos con el proveedor “Homecenter” y para la ciudad “Salento”. \nEste informe debe incluir: ID_Compra, Constructora y Banco_Vinculado.", "Informe 3", JOptionPane.INFORMATION_MESSAGE); //Ventana emergente que muestra la instrucción del informe 2
            System.out.println("El botón 3 fue presionado");
        }
    }
}
