package proiecGUI;

import proiectPAO.BD.DbConnectionUtil;
import proiectPAO.service.CashRegisterServiceDB;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class cashRegisterLogin {
    JPanel Panel2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton nextButton;
    private JButton showCashRegisterButton;

    private static Connection connection = DbConnectionUtil.getDBConnection();
    private static CashRegisterServiceDB cashRegisterServiceDB = new CashRegisterServiceDB(connection);


    public cashRegisterLogin() {
        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean login = false;
                String name = textField1.getText();
                String number = textField2.getText();
                try {
                    login = cashRegisterServiceDB.login(name, Integer.parseInt(number));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                if (login == true) {
                    JFrame frame = new JFrame("Furniture Product");
                    frame.setContentPane(new product().Panel1);
                    frame.setBackground(Color.pink);
                    frame.setMinimumSize(new Dimension(800, 500));
                    //            afisam in centrul ecranului
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.dispose();
                    frame.setVisible(true);
                    SwingUtilities.getRoot(nextButton).setVisible(false);
                } else
                    JOptionPane.showMessageDialog(null, "Login Fail!");


            }
        });

        showCashRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, cashRegisterServiceDB.getCashRegister());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
