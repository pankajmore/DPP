def parantheses(n):
    res = []
    addParen(res,n,n,"",0)
    return res

def addParen(ls,leftRem,rightRem,s,c):
    if leftRem < 0 or rightRem < 0:
        return
    if leftRem == 0 and rightRem == 0:
        ls.append(s)
    else:
        if leftRem > 0:
            addParen(ls,leftRem-1,rightRem,s+"(",c+1)
        if rightRem > leftRem:
            addParen(ls,leftRem,rightRem-1,s+")",c+1)
