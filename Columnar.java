import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class Columnar extends JFrame implements ActionListener {

    GridLayout layout = new GridLayout(4, 2, 10, 10);
    Font plain = new Font("Segoe UI", Font.PLAIN, 20);
    Font bold = new Font("Segoe UI", Font.BOLD, 20);

    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JButton button1;
    JButton button2;

    public Columnar(){
        JLabel l1 = new JLabel("Enter the Text: ");
        JLabel l2 = new JLabel("Enter the Key: ");
        JLabel l3 = new JLabel("Output: ");
        
        tf1 = new JTextField("");
        tf1.setFont(plain);
        tf2 = new JTextField("");
        tf2.setFont(plain);
        tf3 = new JTextField("");
        tf3.setBackground(new Color(0, 0, 0));
        tf3.setForeground(new Color(0, 255, 0));
        tf3.setEditable(false);

        button1 = new JButton("Encrypt");
        button1.addActionListener(this);
        button2 = new JButton("Decrypt");
        button2.addActionListener(this);

        this.add(l1);
        this.add(tf1);
        this.add(l2);
        this.add(tf2);
        this.add(button1);
        this.add(button2);
        this.add(l3);
        this.add(tf3);
        this.setTitle("Columnar Cipher");
        this.setLayout(layout);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static String encrypt(String plaintext, String key){
        int colNum = key.length();
        int rowNum = (plaintext.length() / colNum) + (plaintext.length() % colNum == 0 ? 0 : 1);
        char[][] mat = new char[rowNum][colNum];
        int index = 0;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (index < plaintext.length()) {
                    mat[i][j] = plaintext.charAt(index);
                    index++;
                } else {
                    mat[i][j] = ' ';
                }
            }
        }

        StringBuilder ciphertext = new StringBuilder();
        Integer[] keyOrder = new Integer[colNum];
        for (int i = 0; i < colNum; i++) {
            keyOrder[i] = i;
        }
        Arrays.sort(keyOrder, (a, b) -> Character.compare(key.charAt(a), key.charAt(b)));
        for (int i = 0; i < colNum; i++) {
            int column = keyOrder[i];
            for (int j = 0; j < rowNum; j++) {
                ciphertext.append(mat[j][column]);
            }
        }

        return ciphertext.toString();
        }

    public static String decrypt(String ciphertext, String key){
        int colNum = key.length();
        int rowNum = ciphertext.length() / colNum;
        if (ciphertext.length() % colNum != 0) {
            rowNum++;
        }
        char[][] mat = new char[rowNum][colNum];
        Integer[] keyOrder = new Integer[colNum];

        for (int i = 0; i < colNum; i++) {
            keyOrder[i] = i;
        }
        Arrays.sort(keyOrder, (a, b) -> Character.compare(key.charAt(a), key.charAt(b)));
        int index = 0;
        for (int i = 0; i < colNum; i++) {
            int column = keyOrder[i];
            for (int j = 0; j < rowNum; j++) {
                if (index < ciphertext.length()) {
                    mat[j][column] = ciphertext.charAt(index++);
                }
            }
        }

        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                plaintext.append(mat[i][j]);
            }
        }

        return plaintext.toString();
    }

    public void actionPerformed(ActionEvent e){
        String str;
        String key;
        if(e.getSource() == button1){
            str = tf1.getText();
            key = tf2.getText();
            tf3.setText(encrypt(str, key));
        }
        if(e.getSource() == button2){
            str = tf1.getText();
            key = tf2.getText();
            tf3.setText(decrypt(str, key));
        }
    }
    
    public static void main(String args[]){
        new Columnar();
    }
}