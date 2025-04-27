package school;
import java.util.*;

public class Student {
    public String name;
    public int age;
    public String lastName;
    private final int code;
    private String email;
    private ArrayList<Student> students;
    private ArrayList<Conca> notes; // Liste pour stocker les notes de l'étudiant

    public Student(String name, int age, String lastName, int code, String email) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.code = code;
        this.email = email;
        students = new ArrayList<>();
        notes = new ArrayList<>(); // Initialisation de la liste des notes
    }

    public int getCode() { return code; }

    public String getEmail() { return email; }

    public void setEmail(String new_email) { email = new_email; }

    // Méthode pour ajouter une note
    public void addNote(Subject subject, double note) {
        Conca newNote = new Conca(this, subject, note);
        notes.add(newNote);
    }
    public Double getNoteForSubject(Subject subject) {
        for (Conca conca : notes) {
            if (conca.getSubject().subject_name.equals(subject.subject_name)) {
                return conca.getNote();
            }
        }
        return null;
    }

    public double calculateAverage() {
        if (notes.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Conca conca : notes) {
            sum += conca.getNote();
        }

        return sum / notes.size();
    }

    public void displayNotes() {
        System.out.println("Notes de " + name + " " + lastName + ":");
        for (Conca conca : notes) {
            System.out.println(conca.getSubject().subject_name + ": " + conca.getNote());
        }
        System.out.println("Moyenne: " + calculateAverage());
    }

    public void display() {
        System.out.println("Student name = " + name);
        System.out.println("Student age = " + age);
        System.out.println("Student lastName = " + lastName);
        System.out.println("Student code = " + code);
        System.out.println("Student email = " + email);
    }
}