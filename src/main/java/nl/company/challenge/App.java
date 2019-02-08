package nl.company.challenge;

import nl.company.challenge.compression.Decoding;
import nl.company.challenge.compression.DecodingStrategyFactory;
import nl.company.challenge.io.InputBuffer;
import nl.company.challenge.io.exceptions.InvalidInputData;
import java.io.*;
import java.util.Arrays;

public class App
{
    private static final int BUFFER_SIZE = 10;

        public static void main( String[] args ) throws IOException {
            InputStream inputStream = new DataInputStream(System.in);
            OutputStream outputStream = new DataOutputStream(System.out);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            InputBuffer inputBuffer = new InputBuffer();

            try {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    inputBuffer.readBuffer(buffer, bytesRead);
                }
            } catch (InvalidInputData e) {
                System.err.println("The input data is invalid");
            }

            Decoding decoding = new Decoding(DecodingStrategyFactory.getStrategy());
            byte[] result = decoding.decode(inputBuffer);
            System.out.println(Arrays.toString(result));
            outputStream.write(result, 0, result.length);
            outputStream.flush();
        }
}
