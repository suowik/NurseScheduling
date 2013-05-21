package pl.edu.pk.nurse.data.util;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 12:03
 */
public enum  Vacancy {
    FULL(0), PART_32(1), PART_20(2);
    private int value;

    private Vacancy(int value) {
        this.value = value;
    }

    public static Vacancy convert(int value){
        switch (value){
            case 0:
                return FULL;
            case 1:
                return PART_32;
            case 2:
                return PART_20;
            default:
                throw new IllegalStateException();
        }
    }

    public int getValue() {
        return value;
    }
}
