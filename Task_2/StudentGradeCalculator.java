package Task_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame implements ActionListener {
    private JTextField[] markFields;
    private JButton calculateButton;

    public StudentGradeCalculator() {
        setTitle("Student Grade Calculator");
        setLayout(new GridLayout(5, 2));

        markFields = new JTextField[4]; // Assuming 4 subjects
        for (int i = 0; i < markFields.length; i++) {
            add(new JLabel("Subject " + (i + 1) + " Marks:"));
            markFields[i] = new JTextField();
            add(markFields[i]);
        }

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(new JLabel());
        add(calculateButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            int totalMarks = 0;
            int numSubjects = markFields.length;

            for (JTextField field : markFields) {
                totalMarks += Integer.parseInt(field.getText());
            }

            double averagePercentage = totalMarks / (double) numSubjects;

            // Logic to assign grades based on averagePercentage

            JOptionPane.showMessageDialog(this,
                    "Total Marks: " + totalMarks + "\nAverage Percentage: " + averagePercentage + "%");
        }
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }
}
