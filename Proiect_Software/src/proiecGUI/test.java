package proiecGUI;



import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test {
        JFrame frame = new JFrame("CardLayout Demo");
        JPanel panelCont = new JPanel();
        JPanel panelFirst = new JPanel();
        JPanel panelSecond = new JPanel();
        JButton btnOne = new JButton("Switch");
        JButton btnTwo = new JButton("Back");

        CardLayout cl = new CardLayout();

        public test(){
            panelCont.setLayout(cl);

            panelFirst.add(btnOne);
            panelSecond.add(btnTwo);
            panelFirst.setBackground(Color.red);
            panelSecond.setBackground(Color.blue);

            panelCont.add(panelFirst,"1");
            panelCont.add(panelSecond,"2");
            cl.show(panelCont, "1");

            btnOne.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent arg0){
                    cl.show(panelCont, "2");
                }
            });

            btnTwo.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent arg0){
                    cl.show(panelCont, "1");
                }
            });

            frame.add(panelCont);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }

        public static void main(String[] args) {
            test a = new test();
        }

}
