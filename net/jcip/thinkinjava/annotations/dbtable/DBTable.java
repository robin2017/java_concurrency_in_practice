//: annotations/database/DBTable.java
package net.jcip.thinkinjava.annotations.dbtable;
import java.lang.annotation.*;


// Applies to classes only
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
  public String name() default "";
}
