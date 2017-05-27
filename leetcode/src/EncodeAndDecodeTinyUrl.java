import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/encode-and-decode-tinyurl/ Created by pankaj on 27/05/17. */
class EncodeAndDecodeTinyUrl {
  private final List<String> urls;

  EncodeAndDecodeTinyUrl() {
    urls = new ArrayList<>();
  }

  // Encodes a URL to a shortened URL.
  String encode(final String longUrl) {
    Integer size = urls.size();
    urls.add(longUrl);
    return size.toString();
  }

  // Decodes a shortened URL to its original URL.
  String decode(final String shortUrl) {
    int idx = Integer.parseInt(shortUrl);
    return urls.get(idx);
  }
}
