import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B7287 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("84\n");bw.flush();
        bw.write("alreadyj\n");bw.flush();
        bw.close();
    }
}
