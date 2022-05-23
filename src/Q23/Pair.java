package Q23;

public class Pair {
    private int index;
    private Titan value;

    public Pair(int index, Titan value) {
        this.index = index;
        this.value = value;
    }

    public int getPairRisk() {
        return value.getRisk();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Titan getValue() {
        return value;
    }

    public void setValue(Titan value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\nTitan " + index + ": " + value;
    }
}
