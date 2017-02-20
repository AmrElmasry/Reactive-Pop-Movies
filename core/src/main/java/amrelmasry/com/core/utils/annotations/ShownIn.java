package amrelmasry.com.core.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Amr on 20/02/17.
 */

/**
 * simple annotation to tell what context used the target object
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ShownIn {
    Class[] value();
}
