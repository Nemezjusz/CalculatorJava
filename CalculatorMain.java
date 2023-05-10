import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorMain {

    public static void main(String[] args) {

        GUI gui = new GUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { gui.createAndShowGUI(); }
        });
    }

}