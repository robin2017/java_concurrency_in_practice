//: annotations/database/SQLInteger.java
package net.jcip.thinkinjava.annotations.dbtable;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
  String name() default "";
  Constraints constraints() default @Constraints;
}
