package nl.company.challenge.io;

import java.util.ArrayList;
import java.util.List;

import nl.company.challenge.io.exceptions.InvalidInputData;

public class InputBuffer {
    private final List<Pair> pairs = new ArrayList<>();
    private int pos = 0;

    public void readBuffer(byte[] buffer, int size) throws InvalidInputData {
        for (int i = 0; i < size; i += 2) {
            if (i >= size || i + 1 >= size) {
                throw new InvalidInputData();
            }
            byte p = buffer[i];
            byte q = buffer[i + 1];
            Pair readPair = new Pair(p, q);
            pairs.add(readPair);
        }
    }

    public Pair getPair() {
        return hasPair()?pairs.get(pos++):null;
    }

    public boolean hasPair() {
        return pos < pairs.size();
    }

    public int getSize() {
        return pairs.size();
    }
}
