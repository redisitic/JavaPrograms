import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManasGUI extends JFrame implements ActionListener{
    JButton button;
    JTextField inputText;
    JLabel outLabel;
    BoxLayout layout;
    public ManasGUI(){
        layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Manas is dumb");
        this.setLayout(layout);

        button = new JButton("Submit");
        button.addActionListener(this);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        JLabel label = new JLabel("Enter the Person's name: ");
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));

        inputText = new JTextField(20);
        inputText.setPreferredSize(new Dimension(120, 40));
        inputText.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        outLabel = new JLabel(" ");
        outLabel.setPreferredSize(new Dimension(700, 40));
        outLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        outLabel.setVerticalAlignment(SwingConstants.CENTER);
        outLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(label);
        this.add(inputText);
        this.add(button);
        this.add(outLabel);

        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            String name = inputText.getText();
            button.setEnabled(false);
            if(name == "" || name == " " || name == null){
                name = "Manas";
            }
            outLabel.setText(name + " is kutta, bhenchod, mawali, bhosdike, madarchod, baap ki chut, saala, bhen ka loda and chutiya.");

        }

    }
        public static void main(String[] args) {
        new ManasGUI();
    }

}

