/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.JOptionPane;

/**
 * @author leopa
 */
public class Ventana {
    public static void mostrarInfor(String x) {
        JOptionPane.showMessageDialog(null, x);
    }

    public static String pedirInfo(String x) {
        return JOptionPane.showInputDialog(x);
    }

    public static boolean pedirBoolean(String x) {
        int devolver = JOptionPane.showConfirmDialog(null,
                x, "Please select",
                JOptionPane.YES_NO_OPTION);

        if (devolver == 1) {
            return true;
        } else {
            if (devolver == 0) {
                return false;
            } else {
                return true;
            }

        }

    }


}
