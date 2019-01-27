package CSP;

public class Variable {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == getClass()) {
            return this.name.equals(((Variable) obj).name);
        }
        return false;
    }

    public int hashCode() {
        return name.hashCode();
    }
}

