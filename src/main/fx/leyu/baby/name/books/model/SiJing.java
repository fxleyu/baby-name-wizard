package fx.leyu.baby.name.books.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhuzhihui
 */
public class SiJing implements Serializable {
    /**
     * 标题 例如关雎
     */
    private String title;
    /**
     * 章节 例如国风
     */
    private String chapter;
    /**
     * 区域 例如周南
     */
    private String section;
    /**
     * 内容
     */
    private List<String> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
