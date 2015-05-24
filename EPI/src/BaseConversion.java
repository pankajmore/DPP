import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by pankajm on 5/11/15.
 */
public class BaseConversion {
    static char map[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                         'A', 'B', 'C', 'D', 'E', 'F'};

    public static long toDecimal(String num, int base){
        long n = 0;
        long p = 1;
        for(int i=num.length()-1;i>=0;i--){
            int d = ctoi(num.charAt(i));
            n += d*p;
            p *= base;
        }
        return n;
    }

    private static int ctoi(char c) {
        for(int i=0;i<16;i++)
            if(map[i] == c)
                return i;
        return -1;
    }

    public static String fromDecimal(long n,int base){
        StringBuilder s = new StringBuilder();
        while(n > 0){
            s.append(itoc((int) (n%base)));
            n /= base;
        }
        s.reverse();
        return s.toString();
    }

    private static char itoc(int l) {
        return map[l];
    }

    private static String convert(String s, int fromBase, int toBase){
        return fromDecimal(toDecimal(s, fromBase), toBase);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        while(true){
            String s = in.next();
            int base = in.nextInt();
            for(int i=2;i<=16;i++){
                out.println(convert(s,base,i));
            }
        }
    }
}
