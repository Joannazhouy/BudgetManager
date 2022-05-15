package ui;
import model.Entries;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;


public class BudgetManagerApp extends JFrame implements ActionListener {
    private Entries expense;
    private Entries income;
    private int Budget = 0;

    public static final int FRAME_WIDTH = 801;
    public static final int FRAME_HEIGHT = 500;
    public static final int BUTTON_HEIGHT = 60;
    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_WIDTH_SMALL = 90;

    Color bColor = new Color(115,142,126);
    Color buttonColor = new Color(239, 220, 195);
    JButton add = new JButton("Add A New Entry");
    JButton stat = new JButton("Statistics");
    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    URL url = BudgetManagerApp.class.getResource("icon.gif");
    ImageIcon myIcon = new ImageIcon(url);
    JLabel box = new JLabel();
    JTextArea displayArea1 = new JTextArea();
    JTextArea displayArea2 = new JTextArea();
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();




    public BudgetManagerApp() {
        expense = new Entries();
        income = new Entries();
        init();
    }

    //init gui
    public void init() {
        //setting up the base frame: bounds, title, visibility and functions
        this.setTitle("The Budget Manager App");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        Container container = this.getContentPane();
        container.setBackground(bColor);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //add all the visible components
        this.addComponent();
        this.setVisible(true);

    }

    //add all the visible components onto the frame
    public void addComponent(){
        this.add(addButtonSetUp());
        this.add(statButtonSetUp());
        this.add(loadButtonSetUp());
        this.add(saveButtonSetUp());
        this.setResizable(false);
        box.setBounds(10, 10, 120, 80);
        box.setIcon(myIcon);
        this.add(box);
        this.add(contentBoxSetUp());
        this.add(contentBoxSetUp2());
    }

    // setup for Add A New Entry button
    public JButton addButtonSetUp(){
        add.setBounds(40, 130,BUTTON_WIDTH, BUTTON_HEIGHT);
        return basicSetUp(add);

    }

    // setup for Statisitics button
    public JButton statButtonSetUp(){
        stat.setBounds(40, 150 + BUTTON_HEIGHT,BUTTON_WIDTH, BUTTON_HEIGHT);
        return basicSetUp(stat);
    }

    // setup for expense display area
    public JScrollPane contentBoxSetUp(){
        scrollPane1.setBounds(280, 130,210, 260 );
        //setting background color for the scroll pane is finally working! but white is fine..
        //scrollPane1.getViewport().setBackground(buttonColor);
        scrollPane1.getViewport().add(displayArea1);
        displayArea1.setText("hello! welcome!");
        displayArea1.setEnabled(false);
        return scrollPane1;
    }

    //setup for income display area
    public JScrollPane contentBoxSetUp2(){
        scrollPane2.setBounds(510, 130, 210, 260);
        scrollPane2.add(displayArea2);
        return scrollPane2;
    }

    //setup for loadButton
    public JButton loadButtonSetUp(){
        load.setBounds(40, 170 + BUTTON_HEIGHT + BUTTON_HEIGHT, BUTTON_WIDTH_SMALL, BUTTON_HEIGHT);
        return basicSetUp(load);
    }

    //setup for saveButton
    public JButton saveButtonSetUp(){
        save.setBounds(60 + BUTTON_WIDTH_SMALL, 170 + BUTTON_HEIGHT + BUTTON_HEIGHT, BUTTON_WIDTH_SMALL, BUTTON_HEIGHT);
        return basicSetUp(save);
    }

    //general setup for all buttons
    private JButton basicSetUp(JButton stat) {
        stat.setBorderPainted(false);
        stat.setOpaque(true);
        stat.setBackground(buttonColor);
        stat.addActionListener(this);
        stat.setFont(new Font("HanziPen SC", Font.BOLD, 18));
        stat.setForeground(new Color(145, 97, 55));
        return stat;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            System.out.println("button clicked");
        }

    }
}

