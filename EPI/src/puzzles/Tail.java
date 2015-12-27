package puzzles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Pankaj on 12/27/15.
 */
public class Tail {
    /**
     * Time : Reads at most N lines
     * Space : N lines
     *
     * @param filename the name of the file
     * @param N        the number of lines
     * @return the last N lines of the file
     * @throws IOException
     */
    public static String tail(String filename, int N) throws IOException {
        RandomAccessFile filePtr = new RandomAccessFile(filename, "r");
        filePtr.seek(filePtr.length() - 1);
        int numLines = 0;
        StringBuilder sb = new StringBuilder();
        for (long i = filePtr.length() - 1; i >= 0; i--) {
            filePtr.seek(i);
            int b = filePtr.readByte();
            char c = (char) b;
            if (c == '\n') numLines++;
            if (numLines > N) break;
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    /**
     * Time : Reads the whole file, slower when N << total number of lines
     * Space : N lines
     *
     * @param filename the name of the file
     * @param N        the number of lines
     * @return the last N lines of the file
     * @throws IOException
     */
    public static String tail1(String filename, int N) throws IOException {
        final BufferedReader start = new BufferedReader(new FileReader(filename));
        final BufferedReader end = new BufferedReader(new FileReader(filename));
        while (N-- > 0 && end.ready()) {
            end.readLine();
        }
        while (end.readLine() != null) {
            start.readLine();
        }
        StringBuilder sb = new StringBuilder();
        while (start.ready()) sb.append(start.readLine()).append("\n");
        return sb.toString();
    }
}
