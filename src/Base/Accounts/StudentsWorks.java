package Base.Accounts;

import Base.Units.Course;
import Base.University.College;

import java.util.ArrayList;

public interface StudentsWorks {
    void addCourse(Course course, College college);
    void removeCourse(Course course, College college);
    ArrayList showAllCourses(Course course, College college);
}
