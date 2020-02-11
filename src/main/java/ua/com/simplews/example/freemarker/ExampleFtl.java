package ua.com.simplews.example.freemarker;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleFtl {

    public static void main(String[] args) {
        new ExampleFtl().run();
    }

    void run() {
        // Конфигурация
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        cfg.setClassForTemplateLoading(ExampleFtl.class, "/");
// модель данных
        Map<String, Object> root = new HashMap<>();
        root.put("name", "Freemarker");
        root.put("pedros", "Zopoa");
// шаблон
        Template temp = null;

        List<Book> books = new ArrayList<>();

        Book b1 = new Book("Garry POt", 11, "ZOpa1");
        Book b2 = new Book("MAhmud", -1, "Alla");

        books.add(b1);
        books.add(b2);

        root.put("books", books);

        try {
            temp = cfg.getTemplate("test.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------");
        try {
            try (StringWriter out2 = new StringWriter()) {

                try {
                    temp.process(root, out2);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
                System.out.println(out2.getBuffer().toString());

                out2.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
