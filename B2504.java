import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class B2504 {
    static String in, ans = "";
    static int sum = 0;
    static ArrayList<Data> numbers = new ArrayList<>();
    static ArrayList<Character> operator = new ArrayList<>();
    static Stack<Character> s = new Stack<>();
    static boolean isClose = false;
    public static void main(String[] args) throws IOException, ScriptException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        in = br.readLine();
        if (!available(in)) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '(' || in.charAt(i) == '[') {
                s.push(in.charAt(i));
                if (isClose) {
                    operator.add('+');isClose = false;
                }
            }else {
                if (!s.isEmpty()) if (in.charAt(i) == ')' && s.peek() == '(') {
                    s.pop();
                    if (isClose) operator.add('*');
                    numbers.add(new Data(2, s.size() + 1));
                    isClose = true;
                }
                if (!s.isEmpty()) if (in.charAt(i) == ']' && s.peek() == '[') {
                    s.pop();
                    if (isClose) operator.add('*');
                    numbers.add(new Data(3, s.size() + 1));
                    isClose = true;
                }
            }
        }
        String str = "";
        int plusDepth = -1;
        for (int j = 0; j < numbers.get(0).depth; j++) {
            str += "(";
        }
        str += numbers.get(0).n;
        str += operator.get(0);
        if (operator.get(0) == '+') plusDepth = numbers.get(0).depth;
        for (int i = 1; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).depth - numbers.get(i - 1).depth; j++) {
                str += "(";
            }
            str += numbers.get(i).n;
            for (int j = 0; j < numbers.get(i - 1).depth - numbers.get(i).depth; j++) {
                str += ")";
            }
            if (i < operator.size()) {
                str += (numbers.get(i).depth == plusDepth) ? ")" + operator.get(i) : operator.get(i);
                if(numbers.get(i).depth == plusDepth) plusDepth = -1;
                if (operator.get(i) == '+') plusDepth = numbers.get(i).depth;
            }

        }
        System.out.println(engine.eval(str));
    }

    public static boolean available(String input) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[' || input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            }else {
                if (!stack.isEmpty()) {
                    if (input.charAt(i) == ']' && stack.peek() == '[') {
                        stack.pop();
                    }
                    if (input.charAt(i) == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                }else {
                    flag = false; break;
                }
            }
        }
        return (flag) && (stack.isEmpty());
    }

    private static class Data {
        int n, depth;
        Data(int n, int depth) {
            this.n = n; this.depth = depth;
        }
    }
}
