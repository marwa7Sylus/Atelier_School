package school;

import java.util.ArrayList;

public class Professors {
    private String firstName;
    private String lastName;
    private String email;
    private String state;
    private float salary;
    private Subject subject;
    private static ArrayList<Professors> professorList = new ArrayList<>();
    public Professors(String firstName, String lastName, String email, String state, float hours, Subject subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.state = state.toLowerCase();
        this.subject = subject;
        this.salary = calculateSalary(hours);
    }
    private float calculateSalary(float hours) {
        if (state.equals("vacataire")) {
            return hours * 300;
        } else if (state.equals("permanent")) {
            return hours * 200;
        } else {
            System.out.println("Type d'état invalide (vacataire ou permanent attendu)");
            return 0;
        }
    }
    public void addProfessor(Professors p) {
        professorList.add(p);
    }
    public static void listProfessors() {
        for (Professors p : professorList) {
            System.out.println(p.getFullName() + " | " + p.state + " | Salaire: " + p.salary + " Dhs");
        }
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public float getSalary() {
        return salary;
    }
    public Subject getSubject() {
        return subject;
    }
    public String getState() {
        return state;
    }
}
