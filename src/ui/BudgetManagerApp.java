package ui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;


public class BudgetManagerApp {
    public static void main(String[] args) {
        Frame appFrame = new Frame("The Budget Manager");
        appFrame.setSize(600,400);
        appFrame.setBackground(new Color(115, 142, 126));
        appFrame.setLocationRelativeTo(null);
        appFrame.setVisible(true);
        appFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });




    }
}
