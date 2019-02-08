package nl.company.challenge;

import static org.junit.Assert.assertArrayEquals;

import nl.company.challenge.compression.Decoding;
import nl.company.challenge.compression.RegularDecodingStrategyImpl;
import nl.company.challenge.compression.TrivialDecodingStrategyImpl;
import nl.company.challenge.io.InputBuffer;
import nl.company.challenge.io.exceptions.InvalidInputData;

import org.junit.Test;

import java.io.*;

public class AppFunctionalTest
{
    @Test
    public void trivialDecoding() throws IOException, InvalidInputData {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {0x00, 0x61});
        byte[] buffer = new byte[2];
        int bytesRead = -1;
        InputBuffer inputBuffer = new InputBuffer();
        byte[] expected = {0x61};

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            inputBuffer.readBuffer(buffer, bytesRead);
        }

        Decoding decoding = new Decoding(new TrivialDecodingStrategyImpl());
        byte[] actual = decoding.decode(inputBuffer);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void trivialDecoding2() throws IOException, InvalidInputData {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {0x00, 0x61, 0x00, 0x39});
        byte[] buffer = new byte[4];
        int bytesRead = -1;
        InputBuffer inputBuffer = new InputBuffer();
        byte[] expected = {0x61, 0x39};

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            inputBuffer.readBuffer(buffer, bytesRead);
        }

        Decoding decoding = new Decoding(new TrivialDecodingStrategyImpl());
        byte[] actual = decoding.decode(inputBuffer);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void regularDecoding() throws IOException, InvalidInputData {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {0x00, 0x61, 0x01, 0x01, 0x00, 0x62, 0x03, 0x02, 0x03, 0x03});
        byte[] buffer = new byte[10];
        int bytesRead = -1;
        InputBuffer inputBuffer = new InputBuffer();
        byte[] expected = {0x61, 0x61, 0x62, 0x61, 0x61, 0x62, 0x61, 0x61};

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            inputBuffer.readBuffer(buffer, bytesRead);
        }

        Decoding decoding = new Decoding(new RegularDecodingStrategyImpl());
        byte[] actual = decoding.decode(inputBuffer);

        assertArrayEquals(expected, actual);
    }

    @Test(expected=InvalidInputData.class)
    public void trivialDecodingWithIrregularData() throws IOException, InvalidInputData {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {0x00, 0x61, 0x00, 0x39, 0x00 });
        byte[] buffer = new byte[5];
        int bytesRead = -1;
        InputBuffer inputBuffer = new InputBuffer();
        byte[] expected = {0x61, 0x39, 0x3F};

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            inputBuffer.readBuffer(buffer, bytesRead);
        }

        Decoding decoding = new Decoding(new TrivialDecodingStrategyImpl());
        byte[] actual = decoding.decode(inputBuffer);
    }
}
