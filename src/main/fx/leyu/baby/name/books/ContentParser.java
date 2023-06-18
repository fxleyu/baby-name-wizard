package fx.leyu.baby.name.books;

/**
 * @author zhuzhihui
 */
public interface ContentParser<T> {
    /**
     * 解析后结果
     * @param t 处理类型
     * @return 结果
     */
    StringBuilder parser(T t);
}
