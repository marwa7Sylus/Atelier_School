package school;

import java.util.ArrayList;

public class Subject {
    public String subject_name;
    private int code_alpha;
    public int hours;
    public ArrayList<Subject> subjects;
    public Subject(String subject_name, int code_alpha, int hours) {
        this.subject_name = subject_name;
        this.code_alpha = code_alpha;
        this.hours = hours;
        subjects = new ArrayList<>();
    }
    public void addSubject(String subject_name, int code_alpha, int hours) {
        subjects.add(new Subject(subject_name, code_alpha, hours));
        System.out.println("Subject added: " + subject_name + ", " + code_alpha + ", " + hours);
    }
    public int getCode_alpha() {return code_alpha;}


}
