
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Teacher1 extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -5925756146593045815L;

    public Teacher1(String s) {
        initComponents(s);
    }

    String iddd = null;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void initComponents(String s) {
        String name = s;
        jLabel1 = new JLabel();
        DB db = DB.getDB();
        sub = new JComboBox();
        sub.setModel(new DefaultComboBoxModel(db.getClasss().toArray()));
        jLabel2 = new JLabel("Choose Class");
        jButton1 = new JButton("Take Attendance");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Takeattendence t = new Takeattendence((String) sub.getSelectedItem());
                t.setVisible(true);
                dispose();
            }
        });
        jButton2 = new JButton("Generate Report");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Report t = new Report((String) sub.getSelectedItem());
                t.setVisible(true);
                dispose();
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("WELCOME " + name);

        sub.setEditable(true);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(102, 102, 102)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(sub, 0, 133, Short.MAX_VALUE))
                                .addContainerGap(97, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(83, Short.MAX_VALUE)));

        pack();
    }

    public static void main(String args[]) {
        new Teacher1("Yash").setVisible(true);
    }

    private JButton jButton1;
    private JButton jButton2;
    @SuppressWarnings("rawtypes")
    private JComboBox sub;
    private JLabel jLabel1;
    private JLabel jLabel2;
}
