package fx.leyu.baby.name.books;

import com.alibaba.fastjson.JSONArray;
import fx.leyu.baby.name.books.model.SiJing;
import fx.leyu.baby.name.utils.StopWordsUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhuzhihui
 */
public class SiJingHandler {
    public Map<Character, Integer> handleWord() throws IOException {
        String str = FileUtils.readFileToString(new File("./data/shijing.json"));
        List<SiJing> siJingList = JSONArray.parseArray(str, SiJing.class);

        Map<Character, Integer> countMap = new HashMap<>();
        for (SiJing siJing : siJingList) {
            for (String sentence : siJing.getContent()) {
                for (char c : sentence.toCharArray()) {
                    if (!StopWordsUtils.isStopWord(c)) {
                        Integer count = countMap.get(c);
                        count = Objects.isNull(count) ? 1 : count + 1;
                        countMap.put(c, count);
                    }
                }
            }
        }
        return countMap;
    }
}
