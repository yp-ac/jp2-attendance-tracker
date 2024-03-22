import javax.swing.GroupLayout.Alignment;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class LoginPage extends JFrame {
    private static final long serialVersionUID = 7522526792628754248L;

    private JTextField userid;
    private JButton loginb;
    private JButton cancelb;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField pwd;

    public LoginPage() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel2 = new JLabel();
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel3 = new JLabel();
        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userid = new JTextField();
        loginb = new JButton();
        cancelb = new JButton();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Information");
        setName("Login");

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("User Type");

        loginb.setText("Login");
        loginb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancelb.setText("Cancel");
        cancelb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ATTENDANCE MANAGEMENT SYSTEM");

        pwd = new JTextField();

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(87)
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 324,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(68)
                                                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(76)
                                                                .addComponent(loginb, GroupLayout.PREFERRED_SIZE, 108,
                                                                        GroupLayout.PREFERRED_SIZE)))
                                                .addGap(79)
                                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(cancelb, GroupLayout.PREFERRED_SIZE, 106,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(userid, GroupLayout.PREFERRED_SIZE, 150,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(pwd, GroupLayout.PREFERRED_SIZE, 150,
                                                                        GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(89, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                .addGap(44)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(userid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(36)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(58)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(cancelb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(loginb, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                                .addGap(56)));
        getContentPane().setLayout(layout);

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        try {
            DB db = DB.getDB();
            String username = userid.getText();
            String password = pwd.getText();
            boolean isLoginSuccess = false;
            
            isLoginSuccess = db.isValidUser(username, password);
            if (isLoginSuccess) {
                JOptionPane.showMessageDialog(null, "Succesfully logged in");

                Teacher1 f2 = new Teacher1(userid.getText());
                f2.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or paswword");
            }
        } catch (Exception e) {
            System.out.println("Something is wrong");
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        System.exit(1);
    }

    public static void main(String args[]) {
        new LoginPage().setVisible(true);
    }

}
