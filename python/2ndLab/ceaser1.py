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

Ceaser = open("ceaser.txt", "r", encoding = "utf8")
s = Ceaser.read()
a='абвгдежзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'

deq = Deque()
for i in a:
    deq.addRear(i) #A

def enc(let):
    for i in range(deq.size()):
        t = deq.removeRear() #опустошаем до тех пор пока t != let(i)
        if t == let:
            deq.addRear(t) 
            val = deq.removeRear() #+1
            val = deq.removeRear() #+2
            deq.addRear(val) 
            return val
        deq.addRear(t) #загоняем в конец дека

ans = ""
for i in s:
    ans += enc(i)
print(ans)