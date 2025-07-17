package patterns.structutral.decorator.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(Main.class.getResource("Ali.txt").toString());
        try (InputStream inputStream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(Main.class.getResource("Ali.txt").toString())))) {
            byte[] bytes = new byte[31];
            inputStream.read(bytes, 0, 31);
            for (byte b : bytes)
                System.out.println((char) b);
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}
