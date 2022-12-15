/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.catapibb;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class CatApibb {
    
    public static void main(String[] args) throws IOException {
        StackApi stackGatos = new StackApi();

        int opcionMenu = -1;
        String[] opciones = {
            "1. Ver Gatos",
            "2. Bandeja de me gustas",
            "3. Revisar si mi bandeja de mg está llena",
            "4. Eliminar",
            "5. Salir"
        };

        do {
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos Java", "Menú Principal",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            for (int i = 0; i < opciones.length; i++) {
                if (opcion.equals(opciones[i])) {
                    opcionMenu = i;
                }
            }

            GatosService service = new GatosService();

            switch (opcionMenu) {
                case 0: {
                    System.out.println("Vas a ver a un gato.");
                    Gato g = service.getGatos();
                    stackGatos.push(g);
                }
                case 1: {
                    stackGatos.mostrarGato();
                }
                case 2 : {
                    if (stackGatos.estaLlena()) {
                        System.out.println("Tu bandeja de me gusta ya esta llenitabb");
                    } else {
                        System.out.println("Todavía hay espacio para más likes");
                    }
                }
                case 3: {
                    stackGatos.pop();
                }
                case 4: {
                    System.out.println("Vuelva pronto, miau!");
                }
            }
        } while (opcionMenu != 4);
    }
}
