package java.lang;

public class Object {
    static {
        System.out.println("my object");
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        return true;
    }

    protected Object clone() throws CloneNotSupportedException {
        return this;
    }

    public String toString() {
        return "myObject";
    }

    protected void finalize() throws Throwable {
    }
}
