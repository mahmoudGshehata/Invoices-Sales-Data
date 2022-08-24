package Frames;

import Frames.files.FileOperator;
import Frames.invoice.InvoiceCreator;
import Frames.invoice.InvoiceRemover;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {
    private JMenuBar MB;
    private JMenu M;
    private JMenuItem MI1;
    private JMenuItem MI2;
    private JLabel L1;
    private JLabel L2;
    private JLabel L3;
    private JLabel L4;
    private JLabel L5;
    private JTextField TF1;
    private JTextField TF2;
    private JButton B1;
    private JButton B2;
    private JButton B3;
    private JButton B4;
    private JTable T1;
    private String[] coulmn = {"No.", "Date", "Customer", "Total"};
    private String[][] data = {

    };
    private JTable T2;
    private String[] coulmn2 = {"No.", "Date", "Customer", "Total"};
    private String[][] data2 = {
    };

    public Frame1() {
        super("Sales Invoice Generator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(900, 700);
        setLocation(50, 50);

        MB = new JMenuBar();
        M = new JMenu("File");
        MI1 = new JMenuItem("Load File");
        MI1.addActionListener(this);
        MI1.setActionCommand("LF");
        MI2 = new JMenuItem("Save File");
        MI2.addActionListener(this);
        MI2.setActionCommand("SF");
        MB.add(M);
        M.add(MI1);
        M.add(MI2);
        setJMenuBar(MB);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        T1 = new JTable(data, coulmn);
        T2 = new JTable(data2, coulmn2);
        TF1 = new JTextField(15);
        L1 = new JLabel("Invoices Table");
        L1.setBounds(20, 10, 150, 15);
        L2 = new JLabel("Invoices Number");
        L2.setBounds(460, 25, 110, 15);
        L3 = new JLabel("Invoices Date");
        L3.setBounds(460, 55, 110, 15);
        L4 = new JLabel("Customer Name");
        L4.setBounds(460, 85, 110, 15);
        L5 = new JLabel("Invoices Total");
        L5.setBounds(460, 115, 110, 15);
        TF1 = new JTextField();
        TF1.setBounds(580, 50, 310, 20);
        TF2 = new JTextField();
        TF2.setBounds(580, 80, 310, 20);
        B1 = new JButton("Create New Invoice");
        B1.setBounds(80, 585, 140, 20);
        B1.addActionListener(this);
        B1.setActionCommand("CNI");
        B2 = new JButton("Delete Invoice");
        B2.setBounds(240, 585, 120, 20);
        B2.addActionListener(this);
        B2.setActionCommand("DI");
        B3 = new JButton("Save");
        B3.setBounds(590, 600, 50, 20);
        B3.addActionListener(this);
        B3.setActionCommand("S");
        B4 = new JButton("Cancel");
        B4.setBounds(690, 600, 60, 20);
        B4.addActionListener(this);
        B4.setActionCommand("C");
        add(L1);
        add(L2);
        add(L3);
        add(L4);
        add(L5);
        add(TF1);
        add(TF2);
        add(B1);
        add(B2);
        add(B3);
        add(B4);

        JPanel P1 = new JPanel();
        P1.setLayout(new BoxLayout(P1, BoxLayout.Y_AXIS));
        P1.setBounds(10, 35, 430, 530);
        P1.setBorder(blackline);
        P1.add(new JScrollPane(T1));
        this.add(P1);

        JPanel P2 = new JPanel();
        P2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Invoice Items", TitledBorder.LEFT, TitledBorder.TOP));
        P2.setLayout(new BoxLayout(P2, BoxLayout.Y_AXIS));
        P2.setBounds(460, 150, 430, 420);
        P2.add(new JScrollPane(T2));
        this.add(P2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "LF":
                new FileOperator(this).LoadFile(T1);
                break;
            case "SF":
                new FileOperator(this).SaveFile();
                break;
            case "CNI":
                new InvoiceCreator().CreateNewInvoice(data, data.length, coulmn);
                break;
            case "DI":
                new InvoiceRemover().DeleteInvoice(data, 1);
                break;
            case "S":
                Save();
                break;
            case "C":
                System.exit(0);
                break;
        }
    }

    private void Save() {
        String[] arr = new String[4];
        arr[0] = TF1.getText();
        arr[1] = TF2.getText();
        arr[2] = TF1.getText();
        arr[3] = TF2.getText();
    }
}

