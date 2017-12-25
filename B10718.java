import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B10718 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("강한친구 대한육군\n" +
                "강한친구 대한육군\n");bw.flush();bw.close();
    }
}
