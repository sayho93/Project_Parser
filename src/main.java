import java.io.IOException;

public class main {
    public static final String url="http://yjham2002.woobi.co.kr/cb_directory/getArticles.php";
    public static void main(String[] args) throws IOException {
        Connector connector = new Connector(url);
        connector.connect();
        connector.Json();
    }

}
