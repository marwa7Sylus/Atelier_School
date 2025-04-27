package school;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SchoolManagement extends Frame {
    // Basic components
    private Label titleLabel;
    private Button addStudentBtn;
    private Button addProfessorBtn;
    private Button addSubjectBtn;
    private Button showDataBtn;
    private TextField nameField;
    private TextField valueField;
    private TextArea displayArea;

    // Lists to store data
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Professors> professorList = new ArrayList<>();
    private ArrayList<Subject> subjectList = new ArrayList<>();

    public SchoolManagement() {
        // Basic window setup
        setTitle("School Management");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);

        // Create components
        titleLabel = new Label("School Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        nameField = new TextField(15);
        valueField = new TextField(15);

        addStudentBtn = new Button("Add Student");
        addProfessorBtn = new Button("Add Professor");
        addSubjectBtn = new Button("Add Subject");
        showDataBtn = new Button("Show All Data");

        displayArea = new TextArea(15, 45);
        displayArea.setEditable(false);

        // Add labels for text fields
        Label nameLabel = new Label("Name:");
        Label valueLabel = new Label("Value:");

        // Add components to frame
        add(titleLabel);
        add(nameLabel);
        add(nameField);
        add(valueLabel);
        add(valueField);
        add(addStudentBtn);
        add(addProfessorBtn);
        add(addSubjectBtn);
        add(showDataBtn);
        add(displayArea);

        // Add action listeners
        addStudentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        addProfessorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProfessor();
            }
        });

        addSubjectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addSubject();
            }
        });

        showDataBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllData();
            }
        });

        // Window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        // Display the frame
        setVisible(true);
    }

    // Method to add a student (very simplified)
    private void addStudent() {
        String name = nameField.getText();
        if(name.isEmpty()) {
            displayArea.setText("Please enter a student name!");
            return;
        }

        try {
            int age = Integer.parseInt(valueField.getText());
            // Create a basic student with minimal information
            Student student = new Student(name, age, "LastName", 1000 + studentList.size(), name + "@school.com");
            studentList.add(student);

            displayArea.setText("Added student: " + name);
            nameField.setText("");
            valueField.setText("");

            // Add a default subject and grade if we have subjects
            if(!subjectList.isEmpty()) {
                student.addNote(subjectList.get(0), 15.0);
            }
        } catch(NumberFormatException e) {
            displayArea.setText("Please enter a valid age in the value field!");
        }
    }

    // Method to add a professor (very simplified)
    private void addProfessor() {
        String name = nameField.getText();
        if(name.isEmpty()) {
            displayArea.setText("Please enter a professor name!");
            return;
        }

        try {
            float hours = Float.parseFloat(valueField.getText());

            // Create a subject if we don't have one yet
            if(subjectList.isEmpty()) {
                Subject subject = new Subject("Default Subject", 100, 30);
                subjectList.add(subject);
            }

            // Create a basic professor
            Professors professor = new Professors(name, "LastName", name + "@school.com",
                    "permanent", hours, subjectList.get(0));
            professorList.add(professor);
            professor.addProfessor(professor);

            displayArea.setText("Added professor: " + name);
            nameField.setText("");
            valueField.setText("");
        } catch(NumberFormatException e) {
            displayArea.setText("Please enter valid hours in the value field!");
        }
    }

    // Method to add a subject (very simplified)
    private void addSubject() {
        String name = nameField.getText();
        if(name.isEmpty()) {
            displayArea.setText("Please enter a subject name!");
            return;
        }

        try {
            int hours = Integer.parseInt(valueField.getText());

            // Create a basic subject
            Subject subject = new Subject(name, 200 + subjectList.size(), hours);
            subjectList.add(subject);

            displayArea.setText("Added subject: " + name);
            nameField.setText("");
            valueField.setText("");
        } catch(NumberFormatException e) {
            displayArea.setText("Please enter valid hours in the value field!");
        }
    }

    // Method to display all data
    private void showAllData() {
        StringBuilder result = new StringBuilder();

        // Show students
        result.append("=== STUDENTS ===\n");
        if(studentList.isEmpty()) {
            result.append("No students added yet.\n");
        } else {
            for(Student s : studentList) {
                result.append("- ").append(s.name).append(" (Age: ").append(s.age).append(")\n");

                // Show grades if any
                result.append("  Grades: ");
                boolean hasGrades = false;
                for(Subject subject : subjectList) {
                    Double grade = s.getNoteForSubject(subject);
                    if(grade != null) {
                        result.append(subject.subject_name).append("=").append(grade).append(", ");
                        hasGrades = true;
                    }
                }
                if(!hasGrades) {
                    result.append("None");
                }
                result.append("\n");
            }
        }

        // Show professors
        result.append("\n=== PROFESSORS ===\n");
        if(professorList.isEmpty()) {
            result.append("No professors added yet.\n");
        } else {
            for(Professors p : professorList) {
                result.append("- ").append(p.getFullName())
                        .append(" (Salary: ").append(p.getSalary()).append(" Dhs)\n");
            }
        }

        // Show subjects
        result.append("\n=== SUBJECTS ===\n");
        if(subjectList.isEmpty()) {
            result.append("No subjects added yet.\n");
        } else {
            for(Subject s : subjectList) {
                result.append("- ").append(s.subject_name)
                        .append(" (Hours: ").append(s.hours).append(")\n");
            }
        }

        displayArea.setText(result.toString());
    }

    public static void main(String[] args) {
        new SchoolManagement();
    }
}