package fx.leyu.baby.name;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import fx.leyu.baby.name.books.SiJingHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhuzhihui
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SiJingHandler siJingHandler = new SiJingHandler();
        Map<Character, Integer> map = siJingHandler.handleWord();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        String normalized = ZhConverterUtil.toSimple("西陸蟬聲唱，南冠客思侵。");
        System.out.println(normalized);
        for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
            //System.out.println(characterIntegerEntry.getKey() + " " + characterIntegerEntry.getValue());
        }
    }
}
