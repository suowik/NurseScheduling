package pl.edu.pk.nurse.data.util;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:37
 */
public enum Shift {
    NO_SHIFT(0), EARLY(1), DAY(2), LATE(3), NIGHT(4);
    int value;

    private Shift(int value) {
        this.value = value;
    }

    public static Shift convert(int value) {
        switch (value) {
            case 0:
                return NO_SHIFT;
            case 1:
                return EARLY;
            case 2:
                return DAY;
            case 3:
                return LATE;
            case 4:
                return NIGHT;
            default:
                throw new IllegalArgumentException("wrong value");
        }
    }

    public int value() {
        return value;
    }
}
