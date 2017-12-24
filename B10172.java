import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B10172 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("|\\_/|\n");bw.flush();
        bw.write("|q p|   /}\n");bw.flush();
        bw.write("( 0 )\"\"\"\\\n");bw.flush();
        bw.write("|\"^\"`    |\n");bw.flush();
        bw.write("||_/=\\\\__|\n");bw.flush();
        bw.close();
    }
}
