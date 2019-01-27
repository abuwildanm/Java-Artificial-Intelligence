package CSP;

import java.util.List;

public interface Constraint {

    List<Variable> getScope();

    boolean satisfied(Assignment asgn);
}


