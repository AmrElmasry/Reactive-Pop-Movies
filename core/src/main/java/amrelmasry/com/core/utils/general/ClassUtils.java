package amrelmasry.com.core.utils.general;

/**
 * Created by Amr on 11/02/17.
 */

public class ClassUtils {

    public static String generateClassTag(Object o) {
        return o.getClass().getSimpleName();
    }
}
