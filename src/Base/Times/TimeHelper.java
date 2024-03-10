package Base.Times;

import Base.Additional.Scan;
import Base.Units.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class TimeHelper {
    private TimeHelper(){}

    private static final ArrayList<String> days = new ArrayList<>();
    static {
        days.add("Shanbe");
        days.add("Yekshanbe");
        days.add("Doshanbe");
        days.add("Seshanbe");
        days.add("Cheharshanbe");
    }
    private static Time time1 = null, time2 = null, time3 = null, time4 = null;
    public static void makeCorrectTime(Course course1, Course course2){
        String time = course1.getClassTime();
        int h = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int m = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        time1 = new Time(h, m, 0);
        h = (time.charAt(6) - '0') * 10 + (time.charAt(7) - '0');
        m = (time.charAt(9) - '0') * 10 + (time.charAt(10) - '0');
        time2 = new Time(h, m, 0);

        time = course2.getClassTime();
        h = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        m = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        time3 = new Time(h, m, 0);
        h = (time.charAt(6) - '0') * 10 + (time.charAt(7) - '0');
        m = (time.charAt(9) - '0') * 10 + (time.charAt(10) - '0');
        time4 = new Time(h, m, 0);
    }
    public static boolean okTadakhol(Course course1, Course course2){
        if(!course2.getClassDate().equals(course1.getClassDate()))
            return true;
        makeCorrectTime(course1, course2);
        if(time1.greaterThan(time4))return true;
        if(time3.greaterThan(time2))return true;
        return false;
    }
    public static String chooseDayes(Scan sc){
        System.out.println();
        for (int i = 1; i < 6; i++)
            System.out.println("type \"" + i + "\" for : " + days.get(i - 1));
        System.out.println("type \"" + 6 + "\" for : Shanbe - Doshanbe");
        System.out.println("type \"" + 7 + "\" for : Yekshanbe - Seshanbe");
//        System.out.println();
        String day = "";
        String ent = sc.nextLine();
        if(ent.equals("back")){
            return "back";
        }
        try {
            Scanner b = new Scanner(ent);
            int in = b.nextInt();
            if(b.hasNext()){
                return "";
            }
            if(in < 6 && in > 0)
                day = days.get(in);
            else if(in == 6){
                day = "Shanbe - Doshanbe";
            }
            else if(in == 7){
                day = "Yekshanbe - Seshanbe";
            }
            else{
                return "";
            }
        }catch (Exception e){
            return "";
        }
        return day;

    }
}
