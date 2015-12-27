package puzzles;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import static puzzles.Tail.tail;
import static puzzles.Tail.tail1;

public class TailTest {

    @Test
    public void testTail() throws Exception {
        String filename = "./src/puzzles/Tail.java";
        List<String> lines = new BufferedReader(new FileReader(filename)).lines().collect(Collectors.toList());
        assert tail(filename, 0).equals("");
        assert tail(filename, 1).equals(lastNLines(lines, 1));
        assert tail(filename, 2).equals(lastNLines(lines, 2));
        assert tail(filename, 3).equals(lastNLines(lines, 3));
        assert tail(filename, 100).equals(lastNLines(lines, 100));
    }

    @Test
    public void testTail1() throws Exception {
        String filename = "./src/puzzles/Tail.java";
        List<String> lines = new BufferedReader(new FileReader(filename)).lines().collect(Collectors.toList());
        assert tail1(filename, 0).equals("");
        assert tail1(filename, 1).equals(lastNLines(lines, 1));
        assert tail1(filename, 2).equals(lastNLines(lines, 2));
        assert tail1(filename, 3).equals(lastNLines(lines, 3));
        assert tail1(filename, 100).equals(lastNLines(lines, 100));
    }

    private String lastNLines(List<String> lines, int N) {
        StringBuilder sb = new StringBuilder();
        int start = lines.size() - N >= 0 ? lines.size() - N : 0;
        for (String s : lines.subList(start, lines.size())) sb.append(s).append("\n");
        return sb.toString();
    }
}