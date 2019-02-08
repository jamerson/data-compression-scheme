package nl.company.challenge.compression;

import nl.company.challenge.io.InputBuffer;

public class Decoding {
    DecodingStrategyInterface decodingStrategy = null;

    public Decoding(DecodingStrategyInterface decodingStrategy) {
        this.decodingStrategy = decodingStrategy;
    }

    public byte[] decode(InputBuffer inputBuffer) {
        return decodingStrategy.decode(inputBuffer);
    }
}
