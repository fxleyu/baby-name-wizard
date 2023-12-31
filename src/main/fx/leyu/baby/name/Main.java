package fx.leyu.baby.name;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import fx.leyu.baby.name.books.ContentHandler;
import fx.leyu.baby.name.books.DefaultContentHandler;
import fx.leyu.baby.name.books.model.Poet;
import fx.leyu.baby.name.books.model.SiJing;
import fx.leyu.baby.name.utils.StopWordsUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author zhuzhihui
 */
public class Main {
    public static void main(String[] args) {
        String content = "";
        content += parseShiJing();
        content += parseTangShi();
        content = ZhConverterUtil.toSimple(content);
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : content.toCharArray()) {
            if (!StopWordsUtils.isStopWord(c)) {
                Integer count = countMap.get(c);
                count = Objects.isNull(count) ? 1 : count + 1;
                countMap.put(c, count);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(countMap.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
            System.out.println(characterIntegerEntry.getKey() + " " + characterIntegerEntry.getValue());
        }

    }

    private static String parseTangShi() {
        ContentHandler<Poet> poetHandler = new DefaultContentHandler<>();
        return poetHandler.handle("./data/唐诗三百首.json", Poet.class, (x) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (String paragraph : x.getParagraphs()) {
                stringBuilder.append(paragraph);
            }
            return stringBuilder;
        });
    }

    private static String parseShiJing() {
        ContentHandler<SiJing> shiJingHandler = new DefaultContentHandler<>();
        return shiJingHandler.handle("./data/shijing.json", SiJing.class, (x) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (String c : x.getContent()) {
                stringBuilder.append(c);
            }
            return stringBuilder;
        });
    }
}
