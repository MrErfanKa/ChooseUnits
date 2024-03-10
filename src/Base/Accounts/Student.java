package Base.Accounts;

import Base.Times.TimeHelper;
import Base.Units.CoreCourse;
import Base.Units.Course;

import java.util.ArrayList;

public class Student extends Account implements StudentsWorks{

    private ArrayList<Course> courses;
    public Student(String userName, String password) {
        super(userName, password);
        courses = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public int coursesNumbers(){
        return courses.size();
    }

    public int coreCoursesNumbers(){
        int num = 0;
        for(Course course : courses)
            if(course instanceof CoreCourse)
                num++;
        return num;
    }

    public boolean isTimeValid(Course newCourse){
        for(Course course : courses)
            if(!(TimeHelper.okTadakhol(course, newCourse)) ||
            (course.getExamTime().equals(newCourse.getExamTime()) &&
                course.getExamDate().equals(newCourse.getExamDate())) ||
            coursesNumbers() + newCourse.getCredit() > 20 ||
            coreCoursesNumbers() >= 5)
                return false;
        return true;
    }
    @Override
    public void addCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    @Override
    public void removeCourse(Course course) {
        courses.remove(course);
        course.removeStudent(this);
    }

}
