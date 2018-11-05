import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class HttpURLConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36";


    private final String cookie = "skin=classic; ac_pas_locale_timezone=ko#5fKR#7cKorea#20Standard#20Time; WMONID=VmOY13jlSYk; JSESSIONID=0000Us9OO4jUusEblgvkQ-n04uy:15t1k1bb9";
    private final String url1 = "https://kupis.konkuk.ac.kr/sugang/acd/cour/aply/courBasket1ApplyReg.jsp";
    private final String url2 = "https://kupis.konkuk.ac.kr/sugang/acd/cour/aply/courLessinApplyReg.jsp";

    private final String params1 = "CuriAdd=0&CuriCdt=7.0&CuriCdtWarnFg=7.0&CuriCnt=3&CuriMax=18&preSngj=3.59&Schdiv=1&strCorsNm=&strDeptCd=&strMultPobtDiv01=&strSaveCheck=Y&strSbjtId=0717";

    public static void main(String[] args) throws Exception {

        ArrayList<Params> paramsList = new ArrayList<>();

        paramsList.add(new Params("N", "mac", "0704", "", "", "Y", "N", "0704",
                "ACCA58837", "B04046", "3", "3", "", "122183", "9", "01",
                "0", "2.0", "1", "1", "2.0", "18", "0", "3.59", "",
                "1", "", "", ""));

        paramsList.add(new Params("N", "mac", "0717", "", "", "Y", "N", "0717",
                "ACCA55512", "B04046", "2", "2", "", "122183", "9", "01",
                "0", "2.0", "1", "2", "5.0", "18", "0", "3.59", "",
                "1", "", "", ""));


        paramsList.add(new Params("N", "mac", "0711", "", "", "Y", "N", "0711",
                "ACCA55025", "B04046", "2", "2", "", "122183", "9", "01",
                "0", "2.0", "1", "3", "7.0", "18", "0", "3.59", "",
                "1", "", "", ""));

        paramsList.add(new Params("N", "mac", "1612", "", "", "Y", "N", "1612",
                "BKSA57150", "B04054", "3", "3", "", "126841", "9", "01",
                "0", "2.0", "1", "4", "9.0", "18", "0", "3.59", "",
                "1", "", "", ""));


        paramsList.add(new Params("N", "mac", "0722", "", "", "Y", "N", "0722",
                "BKUA60482", "B04046", "1", "1", "", "006751", "9", "01",
                "0", "2.0", "1", "5", "12.0", "18", "0", "3.59", "",
                "1", "", "", ""));


        paramsList.add(new Params("N", "mac", "1605", "", "", "Y", "N", "1605",
                "BKSA55584", "B04054", "2", "2", "", "126841", "9", "01",
                "0", "2.0", "1", "7", "14.0", "18", "0", "3.59", "",
                "1", "", "", ""));

        HttpURLConnectionExample http = new HttpURLConnectionExample();


        while (true) {
            for (int i = 0; i < paramsList.size(); i++) {
                http.sendPost(paramsList.get(i));
            }
        }

    }


    // HTTP POST request
    private void sendPost(Params params) throws Exception {

        String url = url2;
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Connection", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Cookie", cookie);
        con.setRequestProperty("Host", "kupis.konkuk.ac.kr");
        con.setRequestProperty("Referer", url);
        con.setRequestProperty("Upgrade-Insecure-Requests", "1");
        con.setRequestProperty("User-Agent", USER_AGENT);

        StringBuffer sb = new StringBuffer();
        sb.append("strSaveCheck=");sb.append(params.getStrSaveCheck());sb.append("&");
        sb.append("strBrowser=");sb.append(params.getStrBrowser());sb.append("&");
        sb.append("strSbjtId=");sb.append(params.getStrSbjtId());sb.append("&");
        sb.append("new=");sb.append(params.getNew_());sb.append("&");
        sb.append("deldirect=");sb.append(params.getDeldirect());sb.append("&");
        sb.append("del=");sb.append(params.getDel());sb.append("&");
        sb.append("new1=");sb.append(params.getNew1());sb.append("&");
        sb.append("arg_sbjt_id=");sb.append(params.getArg_sbjt_id());sb.append("&");
        sb.append("arg_haksu_id=");sb.append(params.getArg_haksu_id());sb.append("&");
        sb.append("arg_pobt_div=");sb.append(params.getArg_pobt_div());sb.append("&");
        sb.append("arg_pnt=");sb.append(params.getArg_pnt());sb.append("&");
        sb.append("arg_tm=");sb.append(params.getArg_tm());sb.append("&");
        sb.append("arg_camp_fg=");sb.append(params.getArg_camp_fg());sb.append("&");
        sb.append("arg_sust=");sb.append(params.getArg_sust());sb.append("&");
        sb.append("arg_shyr=");sb.append(params.getArg_shyr());sb.append("&");
        sb.append("arg_clss_no=");sb.append(params.getArg_clss_no());sb.append("&");
        sb.append("strKcuCount=");sb.append(params.getStrKcuCount());sb.append("&");
        sb.append("CuriCdtWarnFg=");sb.append(params.getCuriCdtWarnFg());sb.append("&");
        sb.append("MinCuriCnt=");sb.append(params.getMinCuriCnt());sb.append("&");
        sb.append("CuriCnt=");sb.append(params.getCuriCnt());sb.append("&");
        sb.append("CuriCdt=");sb.append(params.getCuriCdt());sb.append("&");
        sb.append("CuriMax=");sb.append(params.getCuriMax());sb.append("&");
        sb.append("CuriAdd=");sb.append(params.getCuriAdd());sb.append("&");
        sb.append("PreSngj=");sb.append(params.getPreSngj());sb.append("&");
        sb.append("basketAply=");sb.append(params.getBasketAply());sb.append("&");
        sb.append("Schdiv=");sb.append(params.getSchdiv());sb.append("&");
        sb.append("strCorsNm=");sb.append(params.getStrCorsNm());sb.append("&");
        sb.append("strDeptCd=");sb.append(params.getStrDeptCd());sb.append("&");
        sb.append("strMultPobtDiv01=");sb.append(params.getStrMultPobtDiv01());

        String urlParameters = sb.toString();
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        //System.out.println(response.toString());

    }


    private static class Params {
        private String strSaveCheck;
        private String strBrowser;
        private String strSbjtId;
        private String new_;
        private String deldirect, del, new1, arg_sbjt_id, arg_haksu_id, arg_pobt_div, arg_pnt, arg_tm, arg_camp_fg, arg_sust, arg_shyr, arg_clss_no;
        private String strKcuCount;
        private String CuriCdtWarnFg;
        private String MinCuriCnt;
        private String CuriCnt;
        private String CuriCdt;
        private String CuriMax;
        private String CuriAdd;
        private String PreSngj;
        private String basketAply;
        private String Schdiv;
        private String strCorsNm;
        private String strDeptCd;
        private String strMultPobtDiv01;

        public Params(String strSaveCheck, String strBrowser, String strSbjtId, String new_, String deldirect, String del, String new1, String arg_sbjt_id, String arg_haksu_id, String arg_pobt_div, String arg_pnt, String arg_tm, String arg_camp_fg, String arg_sust, String arg_shyr, String arg_clss_no, String strKcuCount, String curiCdtWarnFg, String minCuriCnt, String curiCnt, String curiCdt, String curiMax, String curiAdd, String preSngj, String basketAply, String schdiv, String strCorsNm, String strDeptCd, String strMultPobtDiv01) {
            this.strSaveCheck = strSaveCheck;this.strBrowser = strBrowser;this.strSbjtId = strSbjtId;
            this.new_ = new_;this.deldirect = deldirect;this.del = del;this.new1 = new1;this.arg_sbjt_id = arg_sbjt_id;
            this.arg_haksu_id = arg_haksu_id;this.arg_pobt_div = arg_pobt_div;this.arg_pnt = arg_pnt;
            this.arg_tm = arg_tm;this.arg_camp_fg = arg_camp_fg;this.arg_sust = arg_sust;this.arg_shyr = arg_shyr;
            this.arg_clss_no = arg_clss_no;this.strKcuCount = strKcuCount;CuriCdtWarnFg = curiCdtWarnFg;
            MinCuriCnt = minCuriCnt;CuriCnt = curiCnt;CuriCdt = curiCdt;CuriMax = curiMax;CuriAdd = curiAdd;
            PreSngj = preSngj;this.basketAply = basketAply;Schdiv = schdiv;
            this.strCorsNm = strCorsNm;this.strDeptCd = strDeptCd;this.strMultPobtDiv01 = strMultPobtDiv01;
        }

        public String getStrSaveCheck() {
            return strSaveCheck;
        }

        public void setStrSaveCheck(String strSaveCheck) {
            this.strSaveCheck = strSaveCheck;
        }

        public String getStrBrowser() {
            return strBrowser;
        }

        public void setStrBrowser(String strBrowser) {
            this.strBrowser = strBrowser;
        }

        public String getStrSbjtId() {
            return strSbjtId;
        }

        public void setStrSbjtId(String strSbjtId) {
            this.strSbjtId = strSbjtId;
        }

        public String getNew_() {
            return new_;
        }

        public void setNew_(String new_) {
            this.new_ = new_;
        }

        public String getDeldirect() {
            return deldirect;
        }

        public void setDeldirect(String deldirect) {
            this.deldirect = deldirect;
        }

        public String getDel() {
            return del;
        }

        public void setDel(String del) {
            this.del = del;
        }

        public String getNew1() {
            return new1;
        }

        public void setNew1(String new1) {
            this.new1 = new1;
        }

        public String getArg_sbjt_id() {
            return arg_sbjt_id;
        }

        public void setArg_sbjt_id(String arg_sbjt_id) {
            this.arg_sbjt_id = arg_sbjt_id;
        }

        public String getArg_haksu_id() {
            return arg_haksu_id;
        }

        public void setArg_haksu_id(String arg_haksu_id) {
            this.arg_haksu_id = arg_haksu_id;
        }

        public String getArg_pobt_div() {
            return arg_pobt_div;
        }

        public void setArg_pobt_div(String arg_pobt_div) {
            this.arg_pobt_div = arg_pobt_div;
        }

        public String getArg_pnt() {
            return arg_pnt;
        }

        public void setArg_pnt(String arg_pnt) {
            this.arg_pnt = arg_pnt;
        }

        public String getArg_tm() {
            return arg_tm;
        }

        public void setArg_tm(String arg_tm) {
            this.arg_tm = arg_tm;
        }

        public String getArg_camp_fg() {
            return arg_camp_fg;
        }

        public void setArg_camp_fg(String arg_camp_fg) {
            this.arg_camp_fg = arg_camp_fg;
        }

        public String getArg_sust() {
            return arg_sust;
        }

        public void setArg_sust(String arg_sust) {
            this.arg_sust = arg_sust;
        }

        public String getArg_shyr() {
            return arg_shyr;
        }

        public void setArg_shyr(String arg_shyr) {
            this.arg_shyr = arg_shyr;
        }

        public String getArg_clss_no() {
            return arg_clss_no;
        }

        public void setArg_clss_no(String arg_clss_no) {
            this.arg_clss_no = arg_clss_no;
        }

        public String getStrKcuCount() {
            return strKcuCount;
        }

        public void setStrKcuCount(String strKcuCount) {
            this.strKcuCount = strKcuCount;
        }

        public String getCuriCdtWarnFg() {
            return CuriCdtWarnFg;
        }

        public void setCuriCdtWarnFg(String curiCdtWarnFg) {
            CuriCdtWarnFg = curiCdtWarnFg;
        }

        public String getMinCuriCnt() {
            return MinCuriCnt;
        }

        public void setMinCuriCnt(String minCuriCnt) {
            MinCuriCnt = minCuriCnt;
        }

        public String getCuriCnt() {
            return CuriCnt;
        }

        public void setCuriCnt(String curiCnt) {
            CuriCnt = curiCnt;
        }

        public String getCuriCdt() {
            return CuriCdt;
        }

        public void setCuriCdt(String curiCdt) {
            CuriCdt = curiCdt;
        }

        public String getCuriMax() {
            return CuriMax;
        }

        public void setCuriMax(String curiMax) {
            CuriMax = curiMax;
        }

        public String getCuriAdd() {
            return CuriAdd;
        }

        public void setCuriAdd(String curiAdd) {
            CuriAdd = curiAdd;
        }

        public String getPreSngj() {
            return PreSngj;
        }

        public void setPreSngj(String preSngj) {
            PreSngj = preSngj;
        }

        public String getBasketAply() {
            return basketAply;
        }

        public void setBasketAply(String basketAply) {
            this.basketAply = basketAply;
        }

        public String getSchdiv() {
            return Schdiv;
        }

        public void setSchdiv(String schdiv) {
            Schdiv = schdiv;
        }

        public String getStrCorsNm() {
            return strCorsNm;
        }

        public void setStrCorsNm(String strCorsNm) {
            this.strCorsNm = strCorsNm;
        }

        public String getStrDeptCd() {
            return strDeptCd;
        }

        public void setStrDeptCd(String strDeptCd) {
            this.strDeptCd = strDeptCd;
        }

        public String getStrMultPobtDiv01() {
            return strMultPobtDiv01;
        }

        public void setStrMultPobtDiv01(String strMultPobtDiv01) {
            this.strMultPobtDiv01 = strMultPobtDiv01;
        }
    }

}
