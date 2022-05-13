package ui;
import model.Entries;

import java.awt.*;
import javax.swing.*;


public class BudgetManagerApp extends JFrame{
    private Entries expense;
    private Entries income;

    public BudgetManagerApp(){
        init();
    }

    public void init() {
        this.setTitle("Buddy");
        this.setSize(600, 400);
        Container container = this.getContentPane();
        container.setBackground(new Color(115,142,126));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    }

