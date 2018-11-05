import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Line2018_4 {
    static int n;
    static String m, e, d, in, ins[], t[];
    static boolean isParameter;
    static Map<String, String> users = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            m = st.nextToken();
            e = st.nextToken();
            t = e.split(" ");
            isParameter = (t[t.length - 1].equals("data"));
            d = (st.hasMoreTokens()) ? st.nextToken() : null;

        }

        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static String createUser(String method, String user) {
        if (!method.equals("POST")) return "405 METHOD_NOT_ALLOWED";
        if (users.containsKey(user)) return "403 FORBIDDEN";
        users.put(user, null);
        return "201 CREATED";
    }

    private static String selectUser() {
        return "";
    }
}
