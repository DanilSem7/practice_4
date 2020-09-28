package ru.mirea.practice_4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Winner extends JFrame{
    JPanel[] pnl = new JPanel[4];
    private int ACMilanScore = 0;
    private int RealMadridScore = 0;
    private String getWinner(int _ACMilanScore, int _RealMadridScore) {
        if (_ACMilanScore > _RealMadridScore) return "AC Milan";
        if (_ACMilanScore < _RealMadridScore) return "Real Madrid";
        String draw = "DRAW";
        return draw;
    }

    public Winner() {
        super("Table of results of matches");
        setLayout(new GridLayout(2, 2));

        for (int i = 0; i < pnl.length; i++) {
            pnl[i] = new JPanel();
            pnl[i].setLayout(new BorderLayout());
            add(pnl[i]);
        }

        JButton but1 = new JButton("AC Milan");
        JButton but2 = new JButton("Real Madrid");
        JLabel label1 = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        JLabel label3 = new JLabel("Winner: DRAW", SwingConstants.CENTER);

        but1.addMouseListener (new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ACMilanScore++;
                label1.setText("Result: " + ACMilanScore + " X " + RealMadridScore);
                label2.setText("Last Scorer: AC Milan");
                label3.setText("Winner: " + getWinner(ACMilanScore, RealMadridScore));
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        but2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RealMadridScore++;
                label1.setText("Result: " + ACMilanScore + " X " + RealMadridScore);
                label2.setText("Last Scorer: Real Madrid");
                label3.setText("Winner: " + getWinner(ACMilanScore, RealMadridScore));
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        pnl[0].add(but1, BorderLayout.CENTER);
        pnl[2].add(but2, BorderLayout.CENTER);
        pnl[1].add(label1, BorderLayout.CENTER);
        pnl[1].add(label2, BorderLayout.SOUTH);
        pnl[3].add(label3, BorderLayout.CENTER);
        setSize(500, 250);
    }

    public static void main(String[] args) {
        new Winner().setVisible(true);
    }
}