package task1_2;

import java.lang.annotation.Documented;

@Documented
public @interface RequestForEnhancement {
  
  int id();
  String synopsis() default "unassigned";
  String engineer();
  String date();
}
