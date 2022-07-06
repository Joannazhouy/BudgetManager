package ui;
import model.Categories;
import model.Entries;
import model.Entry;
import model.TimeStamp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.nio.BufferUnderflowException;
import javax.swing.*;


public class BudgetManagerApp extends JFrame implements ActionListener {
    private Entries expense;
    private Entries income;
    private double budget = 0.0;

    public static final int FRAME_WIDTH = 801;
    public static final int FRAME_HEIGHT = 500;
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_WIDTH_SMALL = 90;

    Color BCOLOR = new Color(115,142,126);
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
    JButton editBudget = new JButton("Edit");
    JButton showAll = new JButton("Show All Entries");
    JLabel opening = new JLabel("Opening Balance: $" + Double.toString(budget));
    JLabel remaining = new JLabel("Remaining Balance: $0.0" );
    JTextField expenseDel = new JTextField(20);
    JTextField incomeDel = new JTextField(20);
    JButton expenseDelB = new JButton("delete");
    JButton incomeDelB = new JButton("delete");
    JDialog addDialogue;
    JTextField description = new JTextField(20);
    JTextField price = new JTextField(20);
    JTextField date = new JTextField(20);
    JButton addSubmit = new JButton("Submit");






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
        container.setBackground(BCOLOR);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //add all the visible components
        this.addComponent();
        this.setVisible(true);


    }

    //add all the visible components onto the frame
    public void addComponent(){
        this.add(getAdd());
        this.add(getStats());
        this.add(getLoad());
        this.add(getSave());
        this.setResizable(false);
        box.setBounds(25, 10, 220, 80);
        box.setIcon(myIcon);
        this.add(box);
        this.add(contentBoxSetUp());
        this.add(contentBoxSetUp2());
        this.add(getShowAll());
        this.add(getEdit());
        this.add(getOpening());
        this.add(getRemaining());
        this.add(getExpenseDel());
        this.add(getExpenseDelB());
    }

    // setup for Add A New Entry button
    private JButton getAdd(){
        add.setBounds(40, 130,BUTTON_WIDTH, BUTTON_HEIGHT);
        basicSetUp(add);
        return add;

    }

    // setup for Statisitics button
    private JButton getStats(){
        stat.setBounds(40, 150 + BUTTON_HEIGHT,BUTTON_WIDTH, BUTTON_HEIGHT);
        basicSetUp(stat);
        return stat;
    }

    // setup for expense display area
    private JScrollPane contentBoxSetUp(){
        scrollPane1.setBounds(280, 130,210, 260 );
        //setting background color for the scroll pane is finally working! but white is fine..
        //scrollPane1.getViewport().setBackground(buttonColor);
        scrollPane1.getViewport().add(displayArea1);
        displayArea1.setText("hello! welcome!");
        displayArea1.setEditable(false);
        return scrollPane1;
    }

    //setup for income display area
    private JScrollPane contentBoxSetUp2(){
        scrollPane2.setBounds(510, 130, 210, 260);
        scrollPane2.add(displayArea2);
        displayArea2.setEditable(false);
        return scrollPane2;
    }

    private JTextField getExpenseDel(){
        expenseDel.setBounds(280,400,50,30);
        expenseDel.setToolTipText("Type the index to delete");
        return expenseDel;
    }
    private JButton getExpenseDelB(){
        expenseDelB.setBounds(340, 405, 50, 20);
        basicSetUp(expenseDelB);
        expenseDelB.setText("delete");
        editBudget.setFont(new Font("HanziPen SC", Font.BOLD, 9));

        expenseDelB.setMargin(new Insets(0, -17, 0, -17));


        return expenseDelB;
    }



    //setup for loadButton
    private JButton getLoad(){
        load.setBounds(40, 170 + BUTTON_HEIGHT + BUTTON_HEIGHT, BUTTON_WIDTH_SMALL, BUTTON_HEIGHT);
        basicSetUp(load);
        return load;
    }

    //setup for saveButton
    private JButton getSave(){
        save.setBounds(60 + BUTTON_WIDTH_SMALL, 170 + BUTTON_HEIGHT + BUTTON_HEIGHT, BUTTON_WIDTH_SMALL, BUTTON_HEIGHT);
        basicSetUp(save);
        return save;
    }

    private JButton getShowAll(){
        showAll.setBounds(40, 190+BUTTON_HEIGHT+ BUTTON_HEIGHT+BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
        basicSetUp(showAll);
        return showAll;

    }

    private JButton getEdit(){
        editBudget.setBounds(510, 100, 40, 20);
        basicSetUp(editBudget);
        editBudget.setFont(new Font("HanziPen SC", Font.BOLD, 14));
        editBudget.setMargin(new Insets(-3, -17, -3, -17));
        return editBudget;
    }

    private JLabel getOpening(){
        opening.setBounds(565, 100, 150, 20);
        opening.setFont(new Font("HanziPen SC", Font.BOLD, 14));
        opening.setForeground(new Color(252, 246, 237));
        return opening;

    }
    private JLabel getRemaining(){
        remaining.setBounds(565, 70, 150, 20);
        remaining.setFont(new Font("HanziPen SC", Font.BOLD, 14));
        remaining.setForeground(new Color(252, 246, 237));
        return remaining;
    }

    private void addEntry(){
        addDialogue = new JDialog(this);
        Container content = addDialogue.getContentPane();
        content.setBackground(BCOLOR);
        addDialogue.setBounds(600, 300, 270, 400);
        addDialogue.setLayout(new FlowLayout());
        addDialogue.add(new JLabel("One-word description"));
        addDialogue.add(description);
        addDialogue.add(new JLabel("Price"));
        addDialogue.add(price);
        addDialogue.add(new JLabel("yyyy/mm/dd"));
        addDialogue.add(date);
        addSubmit.addActionListener(this);
        addDialogue.add(addSubmit);

        addDialogue.setVisible(true);
    }

    public void submitReceipt() {
        String description = this.description.getText();
        String price = this.price.getText();
        String date = this.date.getText();

        TimeStamp time = new TimeStamp(Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)), Integer.parseInt(date.substring(8, 10)));
        Entry r = new Entry(description, Double.parseDouble(price), time, Categories.FOOD);
        this.expense.addEntry(r);
        if (displayArea1.getText().equals("hello! welcome!")){
            System.out.println("ok");
            displayArea1.setText("");
            displayArea1.append(r.entryToString());
        } else{
            displayArea1.append(r.entryToString());

        }


        this.description.setText("");
        this.date.setText("");
        this.price.setText("");

    }



    //general setup for all buttons
    private void basicSetUp(JButton stat) {
        stat.setBorderPainted(false);
        stat.setOpaque(true);
        stat.setBackground(buttonColor);
        stat.addActionListener(this);
        stat.setFont(new Font("HanziPen SC", Font.BOLD, 18));
        stat.setForeground(new Color(145, 97, 55));
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            addEntry();
        } else if (e.getSource() == addSubmit) {
            submitReceipt();
        }

    }
}

