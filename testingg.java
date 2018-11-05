import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by im501 on 2017-08-07.
 */
public class testingg {
    static int A[] = new int[500001], count = 0, min, v = 0;
    static boolean b[] = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        bw.write((~0) + "\n");
        bw.flush();bw.close();
    }

//    private static double factorialApproximation(long n){
//        return Math.sqrt(2.0*Math.PI*n)*Math.pow(n,n)*Math.pow(Math.E, -n);
//    }
}
