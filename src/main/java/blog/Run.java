package blog;

import org.jsoup.nodes.Document;

import java.util.ArrayList;

/**
 * @author Steven0516
 * @create 2021-08-18
 */
public class Run {
    public static void main(String[] args) throws Exception {
        String url = TypeUtils.url();
        if(Blog.connect(url)){
            Document dom = Blog.connect(url, "get");
            Blog blog = new Blog(url, dom);
            ArrayList<Passage> passages = blog.getAllPass();
            System.out.println( url + "……该博客共 " + passages.size()  + "篇文章……总共" + blog.page + "页");
            System.out.println("-------请输入需要刷的浏览量数：");
            String in = TypeUtils.getIn();
            int count = Integer.parseInt(in);
            blog.refresh(passages,count);
        }
    }
}
