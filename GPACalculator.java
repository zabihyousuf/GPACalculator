
/*
 * This GPA Calculator was created by Zabihullah Yousuf, UVa Computing ID: zy2qd
 * The aesthetic of this application was made through NetBeans 8.2 and the controls
 * were made on Eclipse. 
 */

/*
 *  All Needed Imports
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GPACalculator extends JFrame {
	private static final long serialVersionUID = 1L; // added simply to remove suggestions given by eclipse

	// Variables for "Calculate" button
	private double numOfGradePoints;
	private double numOfCreditHours;
	private double futureCredits;
	private double futurePoints;

	// Variables declaration
	private JButton CalcButton;
	private JButton add15BlankCredits;
	private JButton addClassToList;
	private JTextField class1;
	private JButton clearAllClasses;
	private JLabel courseName;
	private JTextField creditHour1;
	private JLabel creditHours;
	private JLabel creditHoursNeeded;
	private JLabel grade;
	private JComboBox<String> grade1;
	private JScrollPane jScrollPane1;
	private JSeparator jSeparator1;
	private JTextField requiredGPAResult;
	private JTable tableForClasses;
	private JLabel targetGPA;
	private JTextField targetGpaResult;
	private JTextField yourGPABox;
	private JButton removeOneCourse;
	// End of variables declaration

	public GPACalculator() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Look and feel not set.");
		}

		// start of initializing all variables
		courseName = new JLabel();
		class1 = new JTextField();
		CalcButton = new JButton();
		clearAllClasses = new JButton();
		creditHours = new JLabel();
		creditHour1 = new JTextField();
		grade = new JLabel();
		grade1 = new JComboBox<>();
		addClassToList = new JButton();
		targetGPA = new JLabel();
		creditHoursNeeded = new JLabel();
		jScrollPane1 = new JScrollPane();
		tableForClasses = new JTable();
		targetGpaResult = new JTextField();
		jSeparator1 = new JSeparator();
		add15BlankCredits = new JButton();
		yourGPABox = new JTextField();
		requiredGPAResult = new JTextField();
		removeOneCourse = new JButton();
		// end of initializing all variables

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("GPA Calculator");
		setResizable(false);

		// start of setting all texts
		courseName.setText("Course Name");
		clearAllClasses.setText("Clear All Courses");
		creditHours.setText("Credit Hours");
		grade.setText("Grade");
		addClassToList.setText("Add");
		targetGPA.setText("Overall Target GPA:");
		CalcButton.setText("Calculate");
		add15BlankCredits.setText("Add 15 Blank Credits");
		creditHoursNeeded.setText("Required GPA for Blank Credits to Meet Target:");
		removeOneCourse.setText("Remove Course");
		// end of setting all texts

		CalcButton.setBackground(new Color(51, 153, 0)); // makes the "Calculate" button red
		CalcButton.setForeground(new Color(1, 1, 1));
		CalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) { // adds an action listener to the "Calculate"
															// button
				calcButtonActionPerformed(evt);
			}
		});

		clearAllClasses.setBackground(new Color(255, 51, 51)); // turns the "Clear All Courses" button to red
		clearAllClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) { // adds an action listener to the "Clear All
															// Courses" button
				clearAllClassesActionPerformed(evt);
			}
		});

		grade1.setModel(new DefaultComboBoxModel<>(
				new String[] { "Select", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F" })); // creates
																												// a
																												// combobox
																												// for
																												// all
																												// the
																												// grades

		addClassToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) { // adds an action listener to the "Add" button
				addClassToListActionPerformed(evt);
			}
		});

		tableForClasses.setModel(new DefaultTableModel(new Object[][] { // creates a JTable for the
																		// classes to be added into

		}, new String[] { "All Courses", "Credit Hours", "Grade" }) { // Sets the names for the columns
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L; // added to remove eclipse suggestion

			boolean[] canEdit = new boolean[] { false, false, false }; // makes sure the column names cannot be edited

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPane1.setViewportView(tableForClasses);
		tableForClasses.getAccessibleContext().setAccessibleName("");
		tableForClasses.getAccessibleContext().setAccessibleDescription("");

		targetGpaResult.setEditable(true); // allows the user to enter a target GPA
		requiredGPAResult.setEditable(false); // disables the user to edit the required GPA

		add15BlankCredits.addActionListener(new ActionListener() { // adds an action listener to the "Add
																	// 15 Blank Credits" button
			public void actionPerformed(ActionEvent evt) {
				add15BlankCreditsActionPerformed(evt);
			}
		});

		yourGPABox.setEditable(false); // disables the user to edit their GPA

		removeOneCourse.addActionListener(new ActionListener() { // adds an action listener to the
																	// "Remove Course" button
			public void actionPerformed(ActionEvent evt) {
				removeOneCourseActionPerformed(evt);
			}
		});

		// Start of formatting and styling the JFrame by adding gaps and components to a
		// GroupLayout.
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(targetGPA)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(
										targetGpaResult, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(add15BlankCredits)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(CalcButton)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(yourGPABox, GroupLayout.PREFERRED_SIZE, 56,
												GroupLayout.PREFERRED_SIZE)
										.addGap(16, 16, 16))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
														.addComponent(removeOneCourse)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(clearAllClasses))
												.addGroup(layout.createSequentialGroup().addComponent(creditHoursNeeded)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(requiredGPAResult, GroupLayout.PREFERRED_SIZE, 56,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(class1, GroupLayout.PREFERRED_SIZE, 128,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup().addGap(19, 19, 19)
																.addComponent(courseName)))
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup().addGap(7, 7, 7)
																.addComponent(creditHours).addGap(31, 31, 31)
																.addComponent(grade))
														.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
																.addComponent(creditHour1, GroupLayout.PREFERRED_SIZE,
																		55, GroupLayout.PREFERRED_SIZE)
																.addGap(17, 17, 17)
																.addComponent(grade1, GroupLayout.PREFERRED_SIZE, 96,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(addClassToList)))))
								.addContainerGap())))
				.addComponent(jSeparator1, GroupLayout.Alignment.TRAILING));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(creditHours)
								.addComponent(courseName).addComponent(grade))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(creditHour1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(grade1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(class1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(addClassToList))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
						.addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(add15BlankCredits).addComponent(CalcButton).addComponent(yourGPABox,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(targetGPA)
								.addComponent(targetGpaResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(creditHoursNeeded, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
								.addComponent(requiredGPAResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(clearAllClasses).addComponent(removeOneCourse))
						.addContainerGap()));
		// end of styling and formatting
		pack();
		this.setLocationRelativeTo(null); // makes sure the GUI spawns in the center of the screen
	}

	private void calcButtonActionPerformed(ActionEvent evt) {

		double finalGPA = (numOfGradePoints / numOfCreditHours); // calculates a final GPA from the total grade points
																	// and credits in the JTable
		DecimalFormat df = new DecimalFormat("##.###");
		String gpaToString = df.format(finalGPA); // formats the final GPA to 3 decimal places
		yourGPABox.setText(gpaToString);

		double parseTarget = -1;
		try {
			parseTarget = Double.parseDouble(targetGpaResult.getText().toString());
		} catch (Exception e) {
			// keeps code from breaking
		}

		// start of calculating target GPA
		futurePoints = parseTarget * (numOfCreditHours + futureCredits) - numOfGradePoints;
		double requiredGPACalc = (futurePoints / futureCredits);
		String requiredGPA = df.format(requiredGPACalc);
		// end of calculating target GPA.

		yourGPABox.setText(gpaToString);

		if (parseTarget > 0) { // makes sure that there is an value in the target GPA.
			requiredGPAResult.setText(requiredGPA);
			if (parseTarget > 4) { // checks to see if target GPA is over 4
				requiredGPAResult.setText("");
				JOptionPane.showMessageDialog(null, "Relax, the highest GPA attainable is a 4.0");
			} else if (requiredGPACalc > 4.0) { // if the required GPA is higher than 4, it gives a warning
				JOptionPane.showMessageDialog(null,
						"With your current GPA, you are unable to attain your target GPA\nbecause it is impossible to "
								+ "attain a GPA of over 4.0 in one semester. " + "\n"
								+ "Try adding more credits and recalculating.");
				// requiredGPAResult.repaint();
			} else if (requiredGPACalc < 2.0) { // if the required GPA is lower than 2, it gives a warning
				JOptionPane.showMessageDialog(null,
						"You will need a cumulative GPA of " + requiredGPA
								+ " for those credits semester in order to meet that target." + "\n"
								+ "Cut down on credits if you wish.");
			}

		}
	}

	private void clearAllClassesActionPerformed(ActionEvent evt) {

		// Clears all the rows in the table.
		DefaultTableModel model = (DefaultTableModel) tableForClasses.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();

		// Resets everything
		numOfCreditHours = 0;
		numOfGradePoints = 0;
		futureCredits = 0;
		yourGPABox.setText("");
		targetGpaResult.setText("");
		requiredGPAResult.setText("");

	}

	private void addClassToListActionPerformed(ActionEvent evt) {

		// Each time a row is added, it grabs the values (grade points and credit hours)
		// inserted and adds them to the variables below
		double gpaNumber = 0;
		double totalCredits = 0;
		double totalGradePoint = 0;

		DefaultTableModel model = (DefaultTableModel) tableForClasses.getModel();

		if (creditHour1.getText().toString().equals("")) { // makes sure that the credit hours in the only required
															// field needed
			class1.repaint();
			creditHour1.repaint();
			grade1.repaint();
		}
		if (grade1.getSelectedItem().toString().equals("Select")) { // ensures that if the user does not give a grade,
																	// the column for the grade does not display
																	// "Select"
			model.addRow(new Object[] { class1.getText(), creditHour1.getText(), "" }); // adds a new row to the table
		} else {
			// if all the inputs are correct, it adds a row to the table
			model.addRow(new Object[] { class1.getText(), creditHour1.getText(), grade1.getSelectedItem().toString() }); 
		}

		/*
		 * Start of check to see what grade the user has given for the added class.
		 * Grade points are calculated by the number for the letter grade * the number
		 * of credit hours Each letter has been given its number equivalence.
		 */
		if (grade1.getSelectedItem().toString().equals("A")) {
			gpaNumber = 4.0;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("A-")) {
			gpaNumber = 3.7;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("B+")) {
			gpaNumber = 3.33;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("B")) {
			gpaNumber = 3;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("B-")) {
			gpaNumber = 2.7;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("C+")) {
			gpaNumber = 2.30;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("C")) {
			gpaNumber = 2.0;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("C-")) {
			gpaNumber = 1.7;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("D+")) {
			gpaNumber = 1.30;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("D")) {
			gpaNumber = 1.0;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("D-")) {
			gpaNumber = 0.7;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("F")) {
			gpaNumber = 0;
			totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
			totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
		}
		if (grade1.getSelectedItem().toString().equals("Select")) {
			futureCredits = futureCredits + Integer.parseInt(creditHour1.getText()); // Adds to the total credits of
																						// classes with no grades
		}

		numOfGradePoints = numOfGradePoints + totalGradePoint; // Adds local grade points to total grade points
		numOfCreditHours = numOfCreditHours + totalCredits; // Adds local credit hours to total credit hours

	}

	private void add15BlankCreditsActionPerformed(ActionEvent evt) {

		// adds 15 blank rows with 3 credit hours each
		DefaultTableModel model = (DefaultTableModel) tableForClasses.getModel();
		model.addRow(new Object[] { "", 3, "" });
		model.addRow(new Object[] { "", 3, "" });
		model.addRow(new Object[] { "", 3, "" });
		model.addRow(new Object[] { "", 3, "" });
		model.addRow(new Object[] { "", 3, "" });

		futureCredits = futureCredits + 15; // Adds to the total credits of classes with no grades
	}

	private void removeOneCourseActionPerformed(ActionEvent evt) {

		// Each time a row is deleted, it grabs the values (grade points and credit
		// hours) inserted and adds them to the variables below
		double gpaNumber = 0;
		double totalCredits = 0;
		double totalGradePoint = 0;
		DefaultTableModel model = (DefaultTableModel) tableForClasses.getModel();

		if (tableForClasses.getSelectedRow() != -1) {

			int column = 2;
			int row = tableForClasses.getSelectedRow();
			String value = tableForClasses.getModel().getValueAt(row, column).toString(); // grabs the value for the
																							// grade inserted
			model.removeRow(tableForClasses.getSelectedRow());

			// Start of checking to see what the grade inserted was for the row being
			// deleted and adds the integers to the variables above
			if (value.equals("A")) {
				gpaNumber = 4.0;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("A-")) {
				gpaNumber = 3.7;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("B+")) {
				gpaNumber = 3.33;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("B")) {
				gpaNumber = 3;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("B-")) {
				gpaNumber = 2.7;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("C+")) {
				gpaNumber = 2.30;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("C")) {
				gpaNumber = 2.0;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("C-")) {
				gpaNumber = 1.7;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("D+")) {
				gpaNumber = 1.30;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("D")) {
				gpaNumber = 1.0;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("D-")) {
				gpaNumber = 0.7;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (value.equals("F")) {
				gpaNumber = 0;
				totalCredits = totalCredits + Integer.parseInt(creditHour1.getText());
				totalGradePoint = totalGradePoint + (gpaNumber * Integer.parseInt(creditHour1.getText()));
			}
			if (grade1.getSelectedItem().toString().equals("Select")) { // if the row deleted had no grade value, it
																		// will subtract the number of credit hours from
																		// the total future credits being taken
				futureCredits = futureCredits - Integer.parseInt(creditHour1.getText());
			}
			// End of checking to see what the grade inserted was and adds the integers to
			// the variables above
		}
		numOfGradePoints = numOfGradePoints - totalGradePoint; // Subtracts local grade points from total grade points
		numOfCreditHours = numOfCreditHours - totalCredits;// Subtracts local credit hours from total credit hours
	}

	public static void main(String args[]) {
		new GPACalculator().setVisible(true);
	}

}
