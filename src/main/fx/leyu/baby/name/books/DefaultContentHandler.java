package fx.leyu.baby.name.books;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import fx.leyu.baby.name.books.model.SiJing;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author zhuzhihui
 */
public class DefaultContentHandler<T> implements ContentHandler<T> {

    @Override
    public String handle(String path, Class<T> clazz, ContentParser<T> parser) {
        String str = null;
        try {
            str = FileUtils.readFileToString(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<T> itemList = JSONArray.parseArray(str, clazz);
        StringBuilder builder = new StringBuilder();
        for (T t : itemList) {
            System.out.println(JSON.toJSONString(t));
            builder.append(parser.parser(t));
        }
        return builder.toString();
    }
}
