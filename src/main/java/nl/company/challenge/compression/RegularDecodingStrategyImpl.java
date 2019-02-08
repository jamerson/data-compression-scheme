package nl.company.challenge.compression;

import nl.company.challenge.io.InputBuffer;
import nl.company.challenge.io.OutputBuffer;
import nl.company.challenge.io.Pair;

public class RegularDecodingStrategyImpl implements DecodingStrategyInterface {

    public byte[] decode(InputBuffer inputBuffer) {
        OutputBuffer outputBuffer = new OutputBuffer();

        int bufferPos = 0;
        while (inputBuffer.hasPair()) {
            Pair pair = inputBuffer.getPair();
            if (pair.getP() == 0X00) {
                outputBuffer.add(pair.getQ());
                bufferPos += 1;
            } else if (pair.getP() > 0X00) {
                int start = bufferPos - pair.getP();
                int end = pair.getQ();

                if(start < 0 || end < 0) {
                    outputBuffer.add(errorByte);
                } else {
                    for (int i = 0; i < end; i++) {
                        byte val = outputBuffer.get(start + i);
                        outputBuffer.add(val);
                        bufferPos += 1;
                    }
                }
            } else {
                outputBuffer.add(errorByte);
                bufferPos += 1;
            }
        }

        byte[] result = new byte[outputBuffer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = outputBuffer.get(i);
        }
        return outputBuffer.toByteArray();
    }
}
