package HealthPassage;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Steven0516
 * @create 2021-10-22
 */
public class PassageGet {


    public  String  info2(Document document){
        Elements txt = document.getElementsByClass("yxl-editor-article ");

        System.out.println(txt.text().length());
        return txt.text();
    }

    public static void  info(Document document){
        Elements txt = document.getElementsByClass("yxl-editor-article ");
        Elements span = txt.select("p span");
        StringBuilder sb = new StringBuilder();
        for (Element line: span){
            if(!line.select("strong span").text().equals("")){
                continue;
            }
            String text = line.text();
            System.out.println(text);
            sb.append(text);
        }
        System.out.println("--------------------");
        System.out.println(sb.toString());
        System.out.println(sb.toString().length());

    }
    public static void main(String[] args) throws IOException, InterruptedException {
        PassageGet passageGet = new PassageGet();
        int size = 0;
        Document doc = Jsoup.connect("https://www.xinli001.com/").get();
        Elements content = doc.getElementsByClass("content");
        for(Element passage: content){
            Elements mainTitle = passage.select("p.main-title");
            String mainTitleS = mainTitle.text();
            System.out.println(mainTitleS);

            Elements smallTitle = passage.select("p.small-title");
            String smallTitleS = smallTitle.text();
            if(smallTitleS.equals(""))  continue;
            System.out.println(smallTitleS);

            Elements category = passage.select("p.ci-title");
            String catgoryS = category.text();
            System.out.println(catgoryS);

            Elements img = passage.select("img");
            String imgUrl = img.attr("abs:src");
            System.out.println(imgUrl);

            Elements info = passage.select("a.common-a");
            String infoHref = info.attr("href");
            System.out.println(infoHref);

            Connection connection = Jsoup.connect(infoHref);
            //获取网页的Document对象
            Document document = connection.timeout(10*1000).get();

            String detail = passageGet.info2(document);
            System.out.println(detail);
            System.out.println("------------------------------------------");
            size ++;
            Thread.sleep(3000);
        }

        System.out.println(size);



    }

    @Test
    public void temp() throws IOException {
//        PassageGet.info2(Jsoup.connect("https://www.xinli001.com/info/100478729?source=pc-home").get());
    }
}
