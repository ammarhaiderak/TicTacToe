/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ammar
 */
public class MyGame extends JFrame implements ActionListener, MyView {

    private JButton b00, b01, b02, b10, b11, b12, b20, b21, b22;
    private int turn = 0; //0 for player 1 & 
    private JPanel panel;
    private ImageIcon cross;
    private ImageIcon tick;
    private ImageIcon current;
    private Controller c;
    private JButton currBtn;
    //private int winner = -1;
//1 for player 2

    MyGame() {
        initGui();
        c = new Controller(this, new Grid(this));
    }

    public void switchTurn() {

        if (turn == 1) {
            turn = 0;
            current = tick;
        } else {
            turn = 1;
            current = cross;
        }

        JOptionPane.showMessageDialog(null, "PLAYER " + (turn + 1) + "'s TURN");
    }

    private void initGui() {

        // Container c = getContentPane();
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        add(panel);

        // c.setLayout(new GridLayout(3, 3));
        setSize(600, 600);
        b00 = new JButton("");
        b01 = new JButton("");
        b02 = new JButton("");
        b10 = new JButton("");
        b11 = new JButton("");
        b12 = new JButton("");
        b20 = new JButton("");
        b21 = new JButton("");
        b22 = new JButton("");

        b00.setName("0,0");
        b01.setName("0,1");
        b02.setName("0,2");
        b10.setName("1,0");
        b11.setName("1,1");
        b12.setName("1,2");
        b20.setName("2,0");
        b21.setName("2,1");
        b22.setName("2,2");

        b00.addActionListener(this);
        b01.addActionListener(this);
        b02.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b20.addActionListener(this);
        b21.addActionListener(this);
        b22.addActionListener(this);

        tick = new ImageIcon("C:\\Users\\ammar\\Documents\\NetBeansProjects\\TicTacToe\\src\\images\\tick.jpg");
        cross = new ImageIcon("C:\\Users\\ammar\\Documents\\NetBeansProjects\\TicTacToe\\src\\images\\cross.png");
        current = tick;
        //validate();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.add(b00);
        panel.add(b01);
        panel.add(b02);
        panel.add(b10);
        panel.add(b11);
        panel.add(b12);
        panel.add(b20);
        panel.add(b21);
        panel.add(b22);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        currBtn = (JButton) e.getSource();
        String index = currBtn.getName();
        String[] rowCol = index.split(",");
        int row = Integer.parseInt(rowCol[0]);
        int col = Integer.parseInt(rowCol[1]);

        c.markOnGrid(row, col, turn);

    }

    public void updateGrid() {
        currBtn.setIcon(current);
    }

    public void displayWinner(int status) {
        String msg = "DRAWN!";

        if (status != 2) {
            msg = "Player " + (status + 1) + " is Winner";
        }

        JOptionPane.showMessageDialog(null, msg);

        dispose();
    }
}
