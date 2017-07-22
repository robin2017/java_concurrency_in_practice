//: annotations/database/Uniqueness.java
// Sample of nested annotations
package net.jcip.thinkinjava.annotations.dbtable;

public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
}
