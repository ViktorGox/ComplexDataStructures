package Utilities;

public class Tuple<F,S> {
    public Tuple() {
    }

    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F first;
    public S second;
}
