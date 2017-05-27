/*
 * Javier Abellán. 13 de noviembre de 2003
 *
 * Ventana.java
 *
 */
package Ejemplo1;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 * Ejemplo de uso del GridBagLayout. Los componentes salen apelotonados en el
 * centro de la ventana.
 */
public class Ventana extends JFrame {

    /**
     * Constructor por defecto.
     */
    JTable tabla, table;
    JScrollPane scroll, scrollPane;
    DefaultTableModel ModeloTabla, dtm;

   /* public Ventana() { //Ver GRIDBAGLAYOUT Ejemplo
        super("Ejemplo 3 GridBagLayout");
        this.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JTextArea cajaTexto = new JTextArea("Area texto");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        // El area de texto debe estirarse en ambos sentidos.
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;
        this.getContentPane().add(cajaTexto, constraints);
        constraints.weighty = 0.0;

        JButton boton1 = new JButton("Boton 1");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        // El botón 1 debe ocupar la posición NORTH de su celda
        constraints.anchor = GridBagConstraints.NORTH;
     // El botón 1 no debe estirarse. Habíamos cambiado este valor en el
        // area de texto, asi que lo restauramos.
        constraints.fill = GridBagConstraints.NONE;
        this.getContentPane().add(boton1, constraints);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 0.0;

        JButton boton2 = new JButton("Boton 2");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        // El boton 2 debe ocupar la posición NORTH de su celda.
        constraints.anchor = GridBagConstraints.NORTH;
        this.getContentPane().add(boton2, constraints);
        constraints.weighty = 0.0;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton boton3 = new JButton("Boton 3");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add(boton3, constraints);

        JButton boton4 = new JButton("Boton 4");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add(boton4, constraints);

        JTextField campoTexto = new JTextField("Campo texto");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        // El campo de texto debe estirarse sólo en horizontal.
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.getContentPane().add(campoTexto, constraints);
    }*/

    
     public Ventana() { //Ver JTable

     AgregarPrimeraTabla();
     AgregarSegundaTabla();

     }
    public void AgregarPrimeraTabla() {

        //array bidimencional de objetos con los datos de la tabla
        Object[][] data = {
            {"Mary", "Campione", "Esquiar", new Integer(5), new Boolean(false)},
            {"Lhucas", "Huml", "Patinar", new Integer(3), new Boolean(true)},
            {"Kathya", "Walrath", "Escalar", new Integer(2), new Boolean(false)},
            {"Marcus", "Andrews", "Correr", new Integer(7), new Boolean(true)},
            {"Angela", "Lalth", "Nadar", new Integer(4), new Boolean(false)}
        };
        //array de String's con los títulos de las columnas
        String[] columnNames = {"Nombre", "Apellido", "Pasatiempo",
            "Años de Practica", "Soltero(a)"};
        //se crea la Tabla
        ModeloTabla = new DefaultTableModel(data, columnNames);

        tabla = new JTable(ModeloTabla);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 70)); //Se define el tamaño

        // una vez creada la tabla con su modelo
        // podemos agregar columnas
        String[] newColumn = {"Flan", "Pastel", "Helado", "Barquillo", "Manzana"};
        ModeloTabla.addColumn("Postre", newColumn);

        //filas
        Object[] newRow = {"Pepe", "Grillo", "Tenis", new Integer(5), new Boolean(false), "Pera"};
        ModeloTabla.addRow(newRow);

        //o modificar una celda en especifico
        ModeloTabla.setValueAt("Catherine", 1, 1);

        scroll = new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);
    }

    public void AgregarSegundaTabla() {
        //creamos el arreglo de objetos que contendra el
        //contenido de las columnas
        Object[] data = new Object[5];
        // creamos el modelo de Tabla
        dtm = new DefaultTableModel();
        // se crea la Tabla con el modelo DefaultTableModel
        table = new JTable(dtm);
        // insertamos las columnas
        for (int column = 0; column < 5; column++) {
            dtm.addColumn("Columna " + column);
        }
        // insertamos el contenido de las columnas
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 5; column++) {
                data[column] = "Celda " + row + "," + column;
               // System.out.println("Celda " + row + "," + column);
            }
            
            dtm.addRow(data);
        }
        //se define el tamaño
        table.setPreferredScrollableViewportSize(new Dimension(300, 200));
        //Creamos un JscrollPane y le agregamos la JTable
        scrollPane = new JScrollPane(table);
        //Agregamos el JScrollPane al contenedor
        add(scrollPane, BorderLayout.SOUTH);
    }

    public static void main(String args[]) {
        JFrame aplicacion = new Ventana();
        aplicacion.setSize(700, 500);
        aplicacion.setResizable(true);
        aplicacion.setLocationRelativeTo(null);
        aplicacion.setVisible(true);
        aplicacion.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
