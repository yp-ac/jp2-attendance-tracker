import javax.swing.GroupLayout.Alignment;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.io.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class Takeattendence extends JFrame {
	private static final long serialVersionUID = 3502024109032056383L;
	private JLabel jLabel1;
	int i = 0;

	public Takeattendence(String k) {
		initComponents(k);
	}

	public void UpdateJTable() {

	}

	@SuppressWarnings("unchecked")
	private void initComponents(String section) {
		i = 0;
		DB db = DB.getDB();
		Object[] students = db.getStudents(section).toArray();
		jLabel1 = new JLabel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("ATTENDANCE REPORT");

		@SuppressWarnings("rawtypes")
		JComboBox stucb = new JComboBox();
		stucb.setModel(new DefaultComboBoxModel<>(students));

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnAbsent = new JButton("Absent");
		btnAbsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stu = (String) stucb.getSelectedItem();
				db.updateAttendance(section, stu, false);
				if (++i < students.length) {
					stucb.setSelectedIndex(i);
				}
			}
		});

		JButton btnPresent = new JButton("Present");
		btnPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stu = (String) stucb.getSelectedItem();
				db.updateAttendance(section, stu, true);
				if (++i < students.length) {
					stucb.setSelectedIndex(i);
				}
			}
		});

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(35, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap(86, Short.MAX_VALUE)
								.addComponent(lblStudent)
								.addGap(58)
								.addComponent(stucb, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addGap(108))
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(107)
								.addComponent(btnAbsent)
								.addGap(90)
								.addComponent(btnPresent)
								.addContainerGap(145, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(184)
								.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(227)));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(stucb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStudent, GroupLayout.PREFERRED_SIZE, 14,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnPresent)
										.addComponent(btnAbsent))
								.addGap(18)
								.addComponent(btnSubmit)
								.addContainerGap(35, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

		pack();
	}

	public static void main(String args[]) {
		new Takeattendence("N3").setVisible(true);
	}

}
