package nl.company.challenge.io;

import java.util.ArrayList;
import java.util.List;

public class OutputBuffer {
    private final List<Byte> outputBuffer = new ArrayList<>();
    int bufferPos = 0;

    public void add(byte value) {
        outputBuffer.add(value);
        bufferPos += 1;
    }

    public int size() {
        return bufferPos;
    }

    public byte get(int index) {
        return outputBuffer.get(index);
    }

    public byte[] toByteArray() {
        byte[] result = new byte[outputBuffer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = outputBuffer.get(i);
        }
        return result;
    }
}