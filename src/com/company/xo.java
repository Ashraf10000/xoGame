package com.company;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class xo extends JFrame implements ActionListener {

    private Random random = new Random();
    private JPanel panel = new JPanel();
    private JButton buttons[] = new JButton[9];
    private JButton reset;
    private JLabel title;
    boolean player1 = random.nextBoolean();

    xo() {
        setSize(480, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        title = new JLabel();
        title.setText("X-O_GAME");
        title.setBounds(0, 0, 480, 95);
        title.setFont(new Font("Ink Free", Font.BOLD, 40));
        title.setOpaque(true);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.GREEN);
        title.setHorizontalAlignment(JLabel.CENTER);

        panel.setBounds(0, 95, 480, 400);
        panel.setLayout(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 70));
            buttons[i].addActionListener(this);
            buttons[i].setOpaque(false);
            buttons[i].setFocusable(false);
        }

        reset = new JButton("Reset");
        reset.setBounds(160, 515, 150, 70);
        reset.addActionListener(this);
        reset.setFont(new Font("MV Boli", Font.BOLD, 20));
        reset.setOpaque(false);
        reset.setFocusable(false);

        add(reset);
        add(panel);
        add(title);
        First_Turn();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++){
            if (e.getSource() == buttons[i]) {

                    if (player1 && buttons[i].getText().equals("")) {
                        title.setText("O's Turn");
                        buttons[i].setText("X");
                        player1 = false;
                        buttons[i].setForeground(Color.BLUE);
                        Check_Winner();
                    }
                    else {
                        if (buttons[i].getText().equals("")) {
                            title.setText("X's Turn");
                            buttons[i].setText("O");
                            player1 = true;
                            buttons[i].setForeground(Color.RED);
                            Check_Winner();
                        }
                    }
            }
        }

        if (e.getSource() == reset) {
            for (JButton button : buttons) {
                button.setText("");
                button.setEnabled(true);
                button.setBackground(null);
            }
               title.setText(First_Turn());
        }

    }

    public void Check_Winner() {
        for(int i=0;i<9;i+=3) {
            if (!buttons[i].getText().equals("")) {
                if ((buttons[i].getText().equals(buttons[i + 1].getText()) &&
                        buttons[i].getText().equals(buttons[i + 2].getText()))) {
                    if (buttons[i].getText().equals("X")) {
                        title.setText("XWins");
                    } else {
                        title.setText("OWins");
                    }
                    buttons[i].setBackground(Color.MAGENTA);
                    buttons[i + 1].setBackground(Color.MAGENTA);
                    buttons[i + 2].setBackground(Color.MAGENTA);
                    for(JButton button:buttons){
                    button.setEnabled(false);
                }
                }
            }
        }

        for(int i=0;i<3;i++){
            if(!buttons[i].getText().equals("")){
                if((buttons[i].getText().equals(buttons[i + 3].getText()) &&
                        buttons[i].getText().equals(buttons[i + 6].getText()))){
                    if(buttons[i].getText().equals("X")){
                        title.setText("XWins");
                    }
                    else{
                        title.setText("OWins");

                    }
                    buttons[i].setBackground(Color.MAGENTA);
                    buttons[i+3].setBackground(Color.MAGENTA);
                    buttons[i+6].setBackground(Color.MAGENTA);
                    for(JButton button:buttons){
                        button.setEnabled(false);
                    }
                }
            }
        }
        if(!buttons[0].getText().equals("")){
            if(buttons[0].getText().equals(buttons[4].getText()) &&
                    buttons[0].getText().equals(buttons[8].getText())){
                if(buttons[0].getText().equals("X")){
                    title.setText("XWins");
                }
                else {
                    title.setText("OWins");
                }
                buttons[0].setBackground(Color.MAGENTA);
                buttons[4].setBackground(Color.MAGENTA);
                buttons[8].setBackground(Color.MAGENTA);
                for(JButton button:buttons){
                    button.setEnabled(false);
                }
            }
        }

        if(!buttons[2].getText().equals("")) {
            if ((buttons[2].getText().equals(buttons[4].getText()) &&
                    buttons[2].getText().equals(buttons[6].getText()))) {
                if (buttons[2].getText().equals("X")) {
                    title.setText("X Wins");
                } else {
                    title.setText("O Wins");
                }
                buttons[2].setBackground(Color.MAGENTA);
                buttons[4].setBackground(Color.MAGENTA);
                buttons[6].setBackground(Color.MAGENTA);
                for(JButton button:buttons){
                    button.setEnabled(false);
                }
            }
        }

    }
        public String First_Turn(){
            if (player1){
                try {
                    Thread.sleep(1000);
                    title.setText("X's Turn");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            else {
                try {
                    Thread.sleep(1000);
                    title.setText("O's Turn");
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            }
            return title.getText();
        }



}









