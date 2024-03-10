package Base.Units;

import Base.Accounts.Student;

import java.util.ArrayList;

public abstract class Course {
    private String teacher, nameCode,
            examTime, classDate, classTime, examDate, name;
    private int credit, capacity;

    ArrayList<Student> students;

    public Course(String teacher, String nameCode, int capacity, int credit,
                  String examTime, String classDate, String classTime, String examDate, String name) {
        this.teacher = teacher;
        this.nameCode = nameCode;
        this.capacity = capacity;
        this.credit = credit;
        this.examTime = examTime;
        this.classDate = classDate;
        this.classTime = classTime;
        this.examDate = examDate;
        this.name = name;
        students = new ArrayList<>();
    }
    public void addCapacity(int num){
        this.capacity += num;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
    }

    public String getTeacher() {
        return teacher;
    }

    public String getNameCode() {
        return nameCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCredit() {
        return credit;
    }

    public String getExamTime() {
        return examTime;
    }

    public String getClassDate() {
        return classDate;
    }

    public String getClassTime() {
        return classTime;
    }

    public String getExamDate(){
        return examDate;
    }

    public String getName() {
        return name;
    }
}
