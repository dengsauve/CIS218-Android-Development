public class Zebra extends Animal {
    private int numStrips;
    private int numTeeth;

    public Zebra(String name, String color, int numStrips, int numTeeth) {
        super(name, color);
        this.numStrips = numStrips;
        this.numTeeth = numTeeth;
    }

    @Override
    public String toString() {
        return "Zebra{" +
                super.toString() +
                ", numStrips=" + numStrips +
                ", numTeeth=" + numTeeth +
                '}';
    }

    public int getNumStrips() {
        return numStrips;
    }

    public void setNumStrips(int numStrips) {
        this.numStrips = numStrips;
    }

    public int getNumTeeth() {
        return numTeeth;
    }

    public void setNumTeeth(int numTeeth) {
        this.numTeeth = numTeeth;
    }
}
