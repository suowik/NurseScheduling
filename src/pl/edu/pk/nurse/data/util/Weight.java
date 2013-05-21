package pl.edu.pk.nurse.data.util;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:31
 */
public class Weight {
    private int value;

    public Weight(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weight weight = (Weight) o;

        if (value != weight.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "value=" + value +
                '}';
    }
}
