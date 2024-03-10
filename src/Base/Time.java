package Base;

import java.util.Comparator;

public class Time implements Comparable<Time> {

    private int hour, minute, second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public boolean lessThan(Time time){
        return time.greaterThan(this);
    }
    public boolean greaterThan(Time o){
        if(this.hour >= o.getHour())
            return true;
        else if(this.hour < o.getHour())
            return false;
        else if(this.minute >= o.getMinute())
            return true;
        else if(this.minute < o.getMinute())
            return false;
        else return (this.second >= o.getSecond());
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(Time o) {
        if(this.hour > o.getHour())
            return 1;
        else if(this.hour < o.getHour())
            return -1;
        else if(this.minute > o.getMinute())
            return 1;
        else if(this.minute < o.getMinute())
            return -1;
        else return (this.second - o.getSecond());
    }

}
