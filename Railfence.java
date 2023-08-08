import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;


public class Railfence extends JFrame implements ActionListener{

    GridLayout layout = new GridLayout(4, 2, 10, 10);
    Font plain = new Font("Segoe UI", Font.PLAIN, 20);
    Font bold = new Font("Segoe UI", Font.BOLD, 20);

    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JButton button;
    public Railfence(){

        JLabel l1 = new JLabel("Enter the sentence: ");
        l1.setFont(bold);
        JLabel l2 = new JLabel("Enter the Height: ");
        l2.setFont(bold);
        JLabel l3 = new JLabel("Output: ");
        l3.setFont(bold);
        JLabel l4 = new JLabel("");
        l4.setFont(plain);
        
        tf1 = new JTextField("");
        tf1.setFont(plain);
        tf2 = new JTextField("");
        tf2.setFont(plain);
        tf3 = new JTextField("");
        tf3.setFont(plain);
        tf3.setEditable(false);

        button = new JButton("Submit");
        button.addActionListener(this);

        this.add(l1);
        this.add(tf1);
        this.add(l2);
        this.add(tf2);
        this.add(l4);
        this.add(button);
        this.add(l3);
        this.add(tf3);
        this.setTitle("Railfence Encryptor");
        this.setLayout(layout);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    public static String encrypt(String str, int n){
        char[][] rail = new char[n][str.length()];
        for (int i = 0; i < n; i++)
            Arrays.fill(rail[i], '\n');
        boolean dirDown = false;
        int row = 0;
        int col = 0;
        for (int i = 0; i < str.length(); i++) {
            if (row == 0 || row == (n - 1))
                dirDown = !dirDown;
            rail[row][col++] = str.charAt(i);
            if (dirDown)
                row++;
            else
                row--;
        }
        StringBuilder encryptedStr = new StringBuilder();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < str.length(); j++)
                if (rail[i][j] != '\n')
                    encryptedStr.append(rail[i][j]);
 
        return encryptedStr.toString();
    }

    public void actionPerformed(ActionEvent e){
        String str;
        int n;
        if(e.getSource() == button){
            str = tf1.getText();
            n = Integer.parseInt(tf2.getText());
            tf3.setText(encrypt(str, n));
        }
    }
    public static void main(String args[]){
        Railfence rl = new Railfence();
    }
}