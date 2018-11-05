import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TranslatorInfixToPostfix translator = new TranslatorInfixToPostfix();
        String ans = translator.getPostfix(br.readLine());
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}

class TranslatorInfixToPostfix {
    Stack<Character> op;
    List<Character> result;
    int weight[];

    public TranslatorInfixToPostfix() {
        op = new Stack<>();
        result = new ArrayList<>();
        weight = new int[128];
        weight['('] = 0;
        weight['+'] = weight['-'] = 1;
        weight['*'] = weight['/'] = 2;
    }

    public String getPostfix(String in) {
        StringBuilder sb = new StringBuilder();
        for (char c : in.toCharArray()) {
            switch (c) {
                case '(' :
                    op.push(c);
                    break;
                case ')' :
                    while (op.peek() != '(') {
                        result.add(op.pop());
                    }
                    op.pop();
                    break;
                case '+' : case '-' :case '*' : case '/' :
                    while (!op.isEmpty() && weight[c] <= weight[op.peek()]) {
                        result.add(op.pop());
                    }
                    op.push(c);
                    break;
                default:
                    result.add(c);
                    break;
            }
        }

        while (!op.isEmpty()) {
            result.add(op.pop());
        }

        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

}