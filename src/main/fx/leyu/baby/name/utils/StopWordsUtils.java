package fx.leyu.baby.name.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuzhihui
 */
public class StopWordsUtils {
    private static final Set<Character> STOP_WORDS_SET = new HashSet<>();
    static {
        STOP_WORDS_SET.add('，');
        STOP_WORDS_SET.add('。');
    }

    public static boolean isStopWord(Character character) {
        return STOP_WORDS_SET.contains(character);
    }
}
