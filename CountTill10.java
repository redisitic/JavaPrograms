import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class CountTill10 extends JFrame implements ActionListener{
    JButton button;
    JLabel label;
    JTextField tf;
    GridLayout layout;
    JLabel outlabel;
    int count = 0;
    public CountTill10(){
        layout = new GridLayout(2,3, 10, 10);

        button = new JButton("Count");
        button.addActionListener(this);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        label = new JLabel("Total = ");
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));

        tf = new JTextField(""+count);
        tf.setEditable(false);
        tf.setBackground(new Color(0,0,0));
        tf.setForeground(new Color(255, 0, 0));
        tf.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        tf.setPreferredSize(new Dimension(240, 20));

        JLabel empty = new JLabel("");

        outlabel = new JLabel("");
        outlabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Count to 10");
        this.setLayout(layout);
        this.add(button);
        this.add(label);
        this.add(tf);
        this.add(empty);
        this.add(outlabel);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            if(count < 10){
                count++;
                tf.setText(""+count);
                if(count >= 5){
                    tf.setForeground(new Color(255, 255, 0));
                }
                if(count >= 10){
                    tf.setForeground(new Color(0, 255, 0));
                }
            } else{
                button.setEnabled(false);
                outlabel.setText("Congratulations! You won.");
            }
            
        }

    }
        public static void main(String[] args) {
        new CountTill10();
    }

}
