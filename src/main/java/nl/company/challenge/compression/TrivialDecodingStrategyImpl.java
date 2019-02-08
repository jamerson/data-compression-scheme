package nl.company.challenge.compression;

import nl.company.challenge.io.InputBuffer;
import nl.company.challenge.io.Pair;

public class TrivialDecodingStrategyImpl implements DecodingStrategyInterface {

    public byte[] decode(InputBuffer inputBuffer) {

        byte[] result = new byte[inputBuffer.getSize()];
        int pos = 0;
        while(inputBuffer.hasPair()) {
            Pair pair = inputBuffer.getPair();
            if (pair.getP() == 0) {
                result[pos++] = pair.getQ();
            } else {
                result[pos++] = errorByte;
            }
        }
        return result;
    }
}
