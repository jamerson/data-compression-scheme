package nl.company.challenge.compression;

import nl.company.challenge.io.InputBuffer;

interface DecodingStrategyInterface {
    byte errorByte = 0X3F;

    byte[] decode(InputBuffer inputBuffer);
}