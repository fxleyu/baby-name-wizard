package fx.leyu.baby.name.books;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuzhihui
 */
public class SiJingHandler {
    public Map<String, Integer> handleWord() throws IOException {
        String str = FileUtils.readFileToString(new File("./data/shijing.json"));
        System.out.println(str);
        return new HashMap<>();
    }
}
