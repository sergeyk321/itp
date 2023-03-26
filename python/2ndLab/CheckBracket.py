class Deque:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def addRear(self, item): #+последний
        self.items.append(item)

    def addFront(self, item):#+первый
        self.items.insert(0, item)

    def removeFront(self):#-последний
        return self.items.pop()

    def removeRear(self):#-первый
        return self.items.pop(0)

    def size(self):
        return len(self.items)
    
CheckBracket = open("CheckBracket.txt", "r", encoding="utf8")
s = CheckBracket.read()

def CheckBrackets(s):
    q = Deque()
    for br in s:
        if br == '[':
            q.addRear(br)
        else:
            if q.isEmpty():
                return False
            q.removeRear()
    return q.isEmpty()

print(CheckBrackets(s))