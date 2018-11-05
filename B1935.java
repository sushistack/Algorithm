import java.io.*;
import java.util.Stack;

public class B1935 {
    static int n;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Calculator calculator = new Calculator(br.readLine());
        for (int i = 0; i < n; i++) {
            calculator.initValue(i, Integer.parseInt(br.readLine()));
        }
        bw.write(String.format("%.2f", calculator.calculate()) + "\n");
        bw.flush();bw.close();
    }

}

class Calculator {
    int[] numbers;
    int[] weight;
    String in;
    Stack<Double> num;
    Stack<Character> op;
    
    public Calculator(String in) {
        numbers = new int[26];
        weight = new int[128];
        num = new Stack<>();
        op = new Stack<>();
        this.in = in;
        weight['('] = 0;
        weight['+'] = weight['-'] = 1;
        weight['*'] = weight['/'] = 2;
    }

    public void initValue(int i, int value) {
        numbers[i] = value;
    }

    public double calculate() {
        for (char c : in.toCharArray()) {
            switch (c) {
                case '+' :case '-' :case '*' :case '/' :
                    calculate(c);
                    break;
                default:
                    num.push((double)numbers[c - 65]);
                    break;
            }
        }
        while (!op.isEmpty()) {
            calculate(op.pop());
        }
        return num.pop();
    }

    private void calculate(char c) {
        double next = num.pop();
        double prev = num.pop();
        double result = 0.;
        switch (c) {
            case '+' : result = prev + next; break;
            case '-' : result = prev - next; break;
            case '*' : result = prev * next; break;
            case '/' : result = prev / next; break;
        }
        num.push(result);
    }
}
