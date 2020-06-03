package proiecGUI;

import javax.swing.*;
import java.awt.*;

public class MyMenu {

    public static void main(String[] args) {


            JFrame frame1 = new JFrame("Login Cashier");
            frame1.setContentPane(new cashRegisterLogin().Panel2);
            frame1.setBackground(Color.pink);
//            afisam in centrul ecranului
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame1.setLocation(dim.width/4-frame1.getSize().width/4, dim.height/4-frame1.getSize().height/4);
            frame1.setMinimumSize(new Dimension(940, 500));
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.pack();
            frame1.setVisible(true);

        }
    }

