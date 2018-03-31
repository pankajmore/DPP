package dailycodingproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Suppose we represent our file system by a string in the following manner: The string
 * "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 *
 * <p>
 *
 * <p>dir subdir1 subdir2 file.ext The directory dir contains an empty sub-directory subdir1 and a
 * sub-directory subdir2 containing a file file.ext.
 *
 * <p>
 *
 * <p>The string
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * represents:
 *
 * <p>
 *
 * <p>dir subdir1 file1.ext subsubdir1 subdir2 subsubdir2 file2.ext The directory dir contains two
 * sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level
 * sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a
 * file file2.ext.
 *
 * <p>
 *
 * <p>We are interested in finding the longest (number of characters) absolute path to a file within
 * our file system. For example, in the second example above, the longest absolute path is
 * "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 *
 * <p>
 *
 * <p>Given a string representing the file system in the above format, return the length of the
 * longest absolute path to a file in the abstracted file system. If there is no file in the system,
 * return 0.
 *
 * <p>
 *
 * <p>Note:
 *
 * <p>
 *
 * <p>The name of a file contains at least a period and an extension.
 *
 * <p>
 *
 * <p>The name of a directory or sub-directory will not contain a period.
 */
class DCP17 {
  static int longestFilePath(String s) {
    List<String> dirs = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean file = false;
    int max = 0;
    int depth = 0;
    for (int i = 0; i <= s.length(); i++) {
      char c;
      if (i == s.length()) {
        c = '\n';
      } else {
        c = s.charAt(i);
      }
      if (c == '\t') {
        depth++;
      } else if (c == '\n') {
        String filename = sb.toString();
        if (file) {
          int len = 0;
          for (int j = 0; j < depth; j++) {
            len += dirs.get(j).length() + 1;
          }
          len += filename.length();
          max = Math.max(max, len);
        } else {
          assert depth <= dirs.size();
          String dir = sb.toString();
          if (depth == dirs.size()) {
            dirs.add(dir);
          } else {
            dirs.set(depth, dir);
          }
        }
        file = false;
        depth = 0;
        sb = new StringBuilder();
      } else {
        if (c == '.') {
          file = true;
        }
        sb.append(c);
      }
    }
    return max;
  }
}
