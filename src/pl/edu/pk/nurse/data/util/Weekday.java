package pl.edu.pk.nurse.data.util;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:35
 */
public enum Weekday {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7);
    int index;
    Weekday(int index){
        this.index = index;
    }
    public int index(){
        return index;
    }
}
