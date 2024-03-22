import java.io.*;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unused")
public class Report extends JFrame {
    private static final long serialVersionUID = 3502024109032056383L;

    public Report(String k) {
        initComponents(k);
    }

    private void initComponents(String section) {
        DB db = DB.getDB();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("ATTENDANCE REPORT");

        jTable2.setAutoCreateRowSorter(true);

        jScrollPane2.setViewportView(jTable2);


        try {
            String[] columnsName = { "id", "name", "status" };
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setColumnIdentifiers(columnsName);

            for (Object[] row : db.getAttendance(section)) {
                model.addRow(row);
            }

        } catch (Exception ex) {

        }
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 433,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 401,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(49, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addContainerGap(420, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 310,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(56, Short.MAX_VALUE))));

        pack();
    }

    private JLabel jLabel1;
    private JScrollPane jScrollPane2;
    private JTable jTable2;
}
