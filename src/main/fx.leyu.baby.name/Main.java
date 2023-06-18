package fx.leyu.baby.name;

import fx.leyu.baby.name.books.SiJingHandler;

import java.io.IOException;

/**
 * @author zhuzhihui
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SiJingHandler siJingHandler = new SiJingHandler();
        siJingHandler.handleWord();
    }
}
