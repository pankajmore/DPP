package puzzles;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Pankaj on 6/6/15.
 */
public class PhoneMnemonic {
    private static final List<String> _keypad = Arrays.asList("0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        String s = in.nextLine();
        ArrayList<char[]> mnemonics = mnemonics(s.toCharArray());
        mnemonics.forEach(out::println);
    }

    public static ArrayList<char[]> mnemonics(char[] s) {
        int N = s.length;
        ArrayList<char[]> curr = new ArrayList<>();
        ArrayList<char[]> old = new ArrayList<>();
        for (char ch : _keypad.get(s[0] - '0').toCharArray()) {
            char[] t = new char[N];
            t[0] = ch;
            curr.add(t);
        }
        for (int i = 1; i < N; i++) {
            old.clear();
            old.addAll(curr);
            curr.clear();
            for (char[] cs : old) {
                for (char ch : _keypad.get(s[i] - '0').toCharArray()) {
                    char[] newcs = Arrays.copyOf(cs, N);
                    newcs[i] = ch;
                    curr.add(newcs);
                }
            }
        }
        return curr;
    }

    public static List<String> phoneMnemonic(String phoneNumber) {
        int N = phoneNumber.length();
        char[] partialMnemonic = new char[N];
        List<String> mnemonics = new ArrayList<>();
        phoneMnemonicHelper(phoneNumber, 0, partialMnemonic, mnemonics);
        return mnemonics;
    }

    private static void phoneMnemonicHelper(String phoneNumber, int idx, char[] partialMnemonic, List<String> mnemonics) {
        if (idx == phoneNumber.length()) mnemonics.add(new String(partialMnemonic));
        else {
            for (char ch : _keypad.get(phoneNumber.charAt(idx) - '0').toCharArray()) {
                partialMnemonic[idx] = ch;
                phoneMnemonicHelper(phoneNumber, idx + 1, partialMnemonic, mnemonics);
            }
        }
    }
}
