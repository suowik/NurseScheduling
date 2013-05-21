package pl.edu.pk.nurse.constraints.hard;

import pl.edu.pk.nurse.constraints.Constraint;
import pl.edu.pk.nurse.constraints.ConstraintType;

/**
 * User: msendyka
 * Date: 21.05.13
 * Time: 20:17
 */
public abstract class HardConstraint implements Constraint {

    @Override
    public ConstraintType getType() {
        return ConstraintType.HARD;
    }
}
