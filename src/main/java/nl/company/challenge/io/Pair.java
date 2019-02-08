package nl.company.challenge.io;

public class Pair {
    private byte p;
    private byte q;

    public byte getP() {
        return p;
    }

    public byte getQ() {
        return q;
    }

    public Pair(byte p, byte q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "p=" + String.format("%02X", p) +
                ", q=" + String.format("%02X", q) +
                '}';
    }
}
