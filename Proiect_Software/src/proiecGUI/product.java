package proiecGUI;

import proiectPAO.BD.DbConnectionUtil;
import proiectPAO.model.products.FurnitureProduct;
import proiectPAO.service.FurnitureProductServiceDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class product {
    private JButton Adauga;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JRadioButton cuGarantieRadioButton;
    JPanel Panel1;
    private JLabel pretLabel;
    private JLabel transport;
    private JTextField transp;
    private JButton showProductButton;
    private JButton deleteProductButton;
    private JButton updateProductButton;
    private JRadioButton doesnTHaveGuaranteeRadioButton;
    private JButton guarantee;
    private JButton transportB;
    private JButton backButton;

    private static Connection connection = DbConnectionUtil.getDBConnection();
    private static FurnitureProductServiceDB furnitureProductServiceDB = new FurnitureProductServiceDB(connection);

    public product() {

        Adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String price = textField4.getText();
                String quantity = textField3.getText();
                String discount = textField2.getText();
                String priceTransport = transp.getText();
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                transp.setText("");
                FurnitureProduct furnitureProduct = new FurnitureProduct();
                furnitureProduct.setName(name);
                furnitureProduct.setPrice(Double.parseDouble(price));
                furnitureProduct.setQuantity(Integer.parseInt(quantity));
                furnitureProduct.setDiscount(Double.parseDouble(discount));
                furnitureProduct.setPriceTransport(Double.parseDouble(priceTransport));
                if (cuGarantieRadioButton.isSelected())
                    furnitureProduct.setHasGuarantee(cuGarantieRadioButton.isSelected());
                else
                    furnitureProduct.setHasGuarantee(cuGarantieRadioButton.isSelected());
                try {
                    furnitureProductServiceDB.addFurnitureProduct(furnitureProduct);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


                JOptionPane.showMessageDialog(null, "The product was added successfully!");
            }
        });
        showProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    JOptionPane.showMessageDialog(null, furnitureProductServiceDB.getFurnitureProduct());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                try {
                    furnitureProductServiceDB.deleteByName(name);
                    textField1.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "The product was deleted successfully!");
            }
        });
        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String newPrice = textField4.getText();
                textField4.setText("");
                textField1.setText("");
                try {
                    furnitureProductServiceDB.changePriceOfProduct(name, Double.parseDouble(newPrice));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "The product was updated successfully!");
            }
        });

        guarantee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (furnitureProductServiceDB.findByGuarantee().isEmpty())
                        JOptionPane.showMessageDialog(null, "There is no product having guarantee!");
                    else
                        JOptionPane.showMessageDialog(null, furnitureProductServiceDB.findByGuarantee());


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        transportB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (furnitureProductServiceDB.findByTransport().isEmpty())
                        JOptionPane.showMessageDialog(null, "There is no product having transport!");
                    else
                        JOptionPane.showMessageDialog(null, furnitureProductServiceDB.findByTransport());


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login Cashier");
                frame.setContentPane(new cashRegisterLogin().Panel2);
                frame.setBackground(Color.pink);
                frame.setMinimumSize(new Dimension(940, 500));
                //            afisam in centrul ecranului
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.dispose();
                frame.setVisible(true);
                SwingUtilities.getRoot(backButton).setVisible(false);
            }
        });
    }


}
