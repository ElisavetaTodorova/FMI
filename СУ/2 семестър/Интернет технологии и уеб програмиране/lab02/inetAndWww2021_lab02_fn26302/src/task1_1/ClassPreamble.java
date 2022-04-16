package task1_1;

import java.lang.annotation.Documented;

/**
 * Includes author, date, currentRevision, lastModified, by, reviewers
 * @author Elisaveta Todorova
 */


@Documented
public @interface ClassPreamble {
  
  String author();
  String date();
  int currentRevision();
  String lastModified();
  String by();
  String[] reviewers();
}
