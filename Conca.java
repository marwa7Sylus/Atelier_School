package school;

public class Conca {
    private Student student;
    private Subject subject;
    private double note;
    public Conca(Student student, Subject subject, double note) {
        this.student = student;
        this.subject = subject;
        this.note = note;
    }
    public Student getStudent() {
        return student;
    }
    public Subject getSubject() {
        return subject;
    }
    public double getNote() {
        return note;
    }
    public void setNote(double note) {
        this.note = note;
    }
}