from HTMLParser import HTMLParser
from collections import defaultdict
N = int(raw_input())
d = defaultdict(set)
l = [raw_input() for _ in xrange(N)]
s = "".join(l)
class MyHTMLParser(HTMLParser):
    def handle_starttag(self, tag, attrs):
        d[tag].union(set())
        ls = [x[0] for x in attrs]
        for l in ls:
            d[tag].add(l)
parser = MyHTMLParser()
parser.feed(s)
for tag in sorted(d.iterkeys()):
    print "{0}:{1}".format(tag,",".join(sorted(d[tag])))
