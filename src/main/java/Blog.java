import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Steven0516
 * @create 2021-08-18
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    String url;
    int page;
    Document dom;
    ArrayList<Passage> all = new ArrayList<>();


    public Blog(String url, Document doc) {
        Elements select = doc.select("a.page-number");
        this.url = url;
        this.page = select.size() + 1;
        this.dom = doc;
    }

    public static Document connect(String url, String get) throws IOException {
        return Jsoup.connect(url).get();
    }


    public static Boolean connect(String url) throws MyException {

        try {
            Document doc = Jsoup.connect(url).get();
            if (!doc.title().equals(null)) {
                System.out.println("-------连接博客成功！");
            }
        } catch (Exception e) {
            throw new MyException("---该链接无效，请重启输入正确网址");
        }
        return true;
    }

    public ArrayList<Passage> getAllPass() throws IOException {
        Elements txt = dom.select("a.article-title");
        for (Element eve : txt) {
            Passage p = new Passage(url.substring(0, url.length() - 1) + eve.attr("href"), eve.text());
            all.add(p);
        }

        for (int i = 2; i <= page; i++) {
            String url = this.url + "page/" + i + "/#content-inner";
            Document doc = Jsoup.connect(url).get();
            Elements ar = doc.select("a.article-title");
            for (Element eve : ar) {
                Passage p = new Passage(url.substring(0, url.length() - 1) + eve.attr("href"), eve.text());
                all.add(p);
            }
        }

        return all;
    }


    public void refresh(ArrayList<Passage> passages, int count) throws Exception {
        int index = 1;
        while (index <= count) {
            for (Passage eve : passages) {
                Document shuaxin = Jsoup.connect(eve.url)
                        .header("Accept-Encoding", "gzip, deflate")

                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")

                        .maxBodySize(0)

                        .timeout(2000)

                        .get();
//                Document doc = Jsoup.connect(eve.url).get();
                System.out.println(eve.title + "success");
            }
            index++;
            Thread.sleep(2000);
        }

    }
}
