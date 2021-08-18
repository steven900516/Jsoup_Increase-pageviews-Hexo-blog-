import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2021-08-18
 */
public class TypeUtils {
    private static Scanner in = new Scanner(System.in);
    private static List<String> list = new ArrayList<String>();

    public static String url(){
        System.out.println("请输入Hexo 博客链接（首页url）:");
        String next = in.next();
        return next;
    }

    public static String getIn(){
        String next = in.next();
        return next;
    }


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

}
