package puzzles;

import java.io.PrintStream;
import java.util.*;

/**
 * Created by Pankaj on 6/6/15.
 */
public class PhoneMnemonic {
    private static final Map<Integer, char[]> _keypad;

    static {
        _keypad = new HashMap<Integer, char[]>();
        _keypad.put(2, "ABC".toCharArray());
        _keypad.put(3, "DEF".toCharArray());
        _keypad.put(4, "GHI".toCharArray());
        _keypad.put(5, "JKL".toCharArray());
        _keypad.put(6, "MNO".toCharArray());
        _keypad.put(7, "PQRS".toCharArray());
        _keypad.put(8, "TUV".toCharArray());
        _keypad.put(9, "WXYZ".toCharArray());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        String s = in.nextLine();
        ArrayList<char[]> mnemonics = mnemonics(s.toCharArray());
        for (char[] mnemonic : mnemonics) {
            out.println(mnemonic);
        }

    }

    private static ArrayList<char[]> mnemonics(char[] s) {
        int N = s.length;
        ArrayList<char[]> curr = new ArrayList<char[]>();
        ArrayList<char[]> old = new ArrayList<char[]>();
        for (char ch : _keypad.get(s[0] - '0')) {
            char[] t = new char[N];
            t[0] = ch;
            curr.add(t);
        }
        for (int i = 1; i < N; i++) {
            old.clear();
            for (char[] c : curr) {
                old.add(c);
            }
            curr.clear();
            for (char[] cs : old) {
                for (char ch : _keypad.get(s[i] - '0')) {
                    char[] newcs = Arrays.copyOf(cs, N);
                    newcs[i] = ch;
                    curr.add(newcs);
                }
            }
        }
        return curr;
    }

}
