import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UI extends JFrame{
    private JTextField textField1;
    private JLabel label;
    private JPanel p;
    private JButton btn1;
    public static long debut;
    static StringGenerator sg;
    public String password;
    public UI() {
        sg = new StringGenerator();


         // Password to test


        int maxLength = 4; // Maximum password length

        this.setContentPane(p);




        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                password = textField1.getText();
                if (password.length()>maxLength){
                    JOptionPane.showMessageDialog(null, "password should be less than 4 symbols");
                    found = true;

                }else{
                    debut = System.currentTimeMillis();
                    StringGenerator sg = new StringGenerator();

                    for (int i = 0; i < (int) Math.ceil(Math.pow(36, maxLength)); i++) {
                        String attempt = sg.generateString(i);
                        if (attempt.equals(password)) {
                            long fin = System.currentTimeMillis();
                            System.out.println("Password found: " + attempt + " in : " + (fin -debut));
                            JOptionPane.showMessageDialog(null, "the password is found : " + attempt + "\n and it was found in " + (fin -debut) + " millis ");
                            found = true;
                            break;
                        }
                    }
                    if (!found){
                        JOptionPane.showMessageDialog(null, "password is not found \n your password is strong");

                    }

                }



            }
        });








        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }


}
