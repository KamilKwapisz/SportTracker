import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    private JButton button1;
    private JPanel panel1;
    private JTextField textField1;

    public Test() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Akuku!");
                textField1.setText("Nobody expected Spanish inquisition!!!");
                Printer p = new Printer("aaa");
                p.give();
            }
        });
        button1.setBounds(130,100,100, 40);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("First app");
        frame.setContentPane(new Test().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

