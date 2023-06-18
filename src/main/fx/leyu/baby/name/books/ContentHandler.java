package fx.leyu.baby.name.books;

/**
 * @author zhuzhihui
 */
public interface ContentHandler <T> {

    /**
     * 处理业务类型
     * @param path 路径
     * @param clazz 存在类
     * @param parser 内容解析
     * @return 解析后的结果
     */
    String handle(String path, Class<T> clazz, ContentParser<T> parser);
}
