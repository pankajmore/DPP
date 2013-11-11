from collections import deque

class Tree():
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None
    def __repr__(self):
        return self.data
    def postOrder(self):
        s = ""
        if(self.left):
            s += self.left.postOrder()
        if(self.right):
            s += self.right.postOrder()
        s+= str(self.data)
        return s
    def bfs(self):
        d = deque()
        d.append(self)
        s = ""
        while(len(d)!=0):
            t = d.popleft()
            s += str(t.data)
            if t.left:
                d.append(t.left)
            if t.right:
                d.append(t.right)
        return s

def constructTreeFromLevelOrder(s):
    q = deque()
    root = Tree(1)
    q.append(root)
    i = 1
    while len(q) != 0:
        t = q.popleft()
        if t.data == 1:
            t.left = Tree(int(s[i]))
            i += 1
            q.append(t.left)
            t.right = Tree(int(s[i]))
            i += 1
            q.append(t.right)
    assert(i==len(s))
    return root

def postOrder(s):
    t = constructTreeFromLevelOrder(s)
    return t.postOrder()

# t = Tree(2)
# t.left = Tree(1)
# t.right = Tree(3)
# print(t.postOrder())
# print(t.bfs())
print(postOrder("111001000"))
