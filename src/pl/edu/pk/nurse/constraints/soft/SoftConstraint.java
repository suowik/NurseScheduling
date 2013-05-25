package pl.edu.pk.nurse.constraints.soft;

import pl.edu.pk.nurse.constraints.Constraint;
import pl.edu.pk.nurse.constraints.ConstraintType;

/**
 * User: msendyka
 * Date: 25.05.13
 * Time: 10:17
 */
abstract class SoftConstraint implements Constraint {
    @Override
    public ConstraintType getType() {
        return ConstraintType.SOFT;
    }
}
