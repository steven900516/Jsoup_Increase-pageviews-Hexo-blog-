package blog;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
@author Steven0516
@create 2021-08-18
*/public class Spider {
    private static Log logger = LogFactory.getLog(Spider.class);

    private static List<String> list = new ArrayList<String>();

    /**
     * 随机获取一个Ip地址
     * @return
     */
    public static String[] getRandomIp() {
        if (list.size() == 0) {
            list.add("47.111.56.178:80");
            list.add("121.61.89.48:61234");
            list.add("222.94.212.39:8118");
            list.add("111.29.3.222:8080");
            list.add("111.29.3.188:80");
            list.add("123.115.254.208:8118");
            list.add("183.247.152.98:53281");
            list.add("58.254.220.116:53579");
            list.add("27.159.167.176:9999");
            list.add("114.248.0.31:8060");
            list.add("218.2.226.42:80");
            list.add("27.208.28.139:8060");
            list.add("58.246.3.178:53281");
            list.add("115.29.42.152:80");
            list.add("183.234.241.105:8118");
            list.add("223.85.196.75:9999");
            list.add("223.111.131.101:8080");
            list.add("27.203.242.102:8060");
            list.add("223.215.102.59:61234");
            list.add("47.111.56.178:80");
            list.add("121.61.89.48:61234");
            list.add("223.215.102.59:61234");
            list.add("112.250.107.37:53281");
            list.add("117.141.155.242:53281");

        }

        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n).split(":");
    }

    /**
     * Jsoup打开连接地址获取Document对象
     * @param url
     * @return
     */
    public static Document getDocument(String url) {
        try {
            Connection conn = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true).userAgent("Mozilla");
            // 设置代理
            String ip[] = Spider.getRandomIp();
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8090));
            conn.proxy(proxy);
            // 设置超时时间并获取Document对象
            Document document = conn.timeout(8000).get();

        } catch (Exception e) {
            logger.error("抓取失败...");
        }
        return null;
    }
}
