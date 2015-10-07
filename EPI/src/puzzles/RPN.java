package puzzles;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Pankaj on 10/7/15.
 */
public class RPN {
    public static int eval(String rpnExpression) throws Exception {
        String delimiter = ",";
        String[] rpnList = rpnExpression.split(delimiter);
        Stack<Integer> stack = new Stack<>();
        for (String s : rpnList) {
            try {
                int x = Integer.parseInt(s);
                stack.push(x);
            } catch (NumberFormatException e) {
                int y = stack.pop();
                int x = stack.pop();
                int res;
                switch (s) {
                    case "+":
                        res = x + y;
                        break;
                    case "-":
                        res = x - y;
                        break;
                    case "*":
                        res = x * y;
                        break;
                    case "/":
                        res = x / y;
                        break;
                    default:
                        throw new Exception(String.format("Unknow operator encountered : %s", s));
                }
                stack.push(res);
            }
        }
        try {
            int res = stack.pop();
            if (!stack.isEmpty()) throw new Exception("Extra input");
            return res;
        } catch (EmptyStackException e) {
            throw new Exception("Incomplete input");
        }
    }
}
