package inspera.parser.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to perform list operations
 */
public class ListUtils {

    public static <T> List<T> removeAll(List<T> list, List<T> remove) {
        List<T> listCopy = new ArrayList<>(list);
        listCopy.removeAll(remove);
        return listCopy;
    }

    public static <T> List<T> retainAll(List<T> list, List<T> remove) {
        List<T> listCopy = new ArrayList<>(list);
        listCopy.retainAll(remove);
        return listCopy;
    }
}
