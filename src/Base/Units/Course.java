package Base.Units;

public abstract class Course {
    private String teacher, nameCode, capacity,
    credit, examTime, classDate, classTime;

    public Course(String teacher, String nameCode, String capacity, String credit,
                  String examTime, String classDate, String classTime) {
        this.teacher = teacher;
        this.nameCode = nameCode;
        this.capacity = capacity;
        this.credit = credit;
        this.examTime = examTime;
        this.classDate = classDate;
        this.classTime = classTime;
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

    public String getCredit() {
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
