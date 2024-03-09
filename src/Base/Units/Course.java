package Base.Units;

import Base.Accounts.Student;

import java.util.ArrayList;

public abstract class Course {
    private String teacher, nameCode, capacity,
            examTime, classDate, classTime;
    private int credit;

    ArrayList<Student> students;

    public Course(String teacher, String nameCode, String capacity, int credit,
                  String examTime, String classDate, String classTime) {
        this.teacher = teacher;
        this.nameCode = nameCode;
        this.capacity = capacity;
        this.credit = credit;
        this.examTime = examTime;
        this.classDate = classDate;
        this.classTime = classTime;
        students = new ArrayList<>();
    }
    public void addCapacity(int num){
        this.credit += num;
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

    public String getCapacity() {
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
}
