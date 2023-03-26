class Deque:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def addRear(self, item):
        self.items.append(item)

    def addFront(self, item):
        self.items.insert(0, item)

    def removeFront(self):
        return self.items.pop()

    def removeRear(self):
        return self.items.pop(0)

    def size(self):
        return len(self.items)

Ceaser = open("ceaser.txt", "r", encoding = "utf8")
s = Ceaser.read()
a='абвгдежзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'

cypher = Deque()
for i in a:
    cypher.addRear(i)

def enc(let):
    for i in range(cypher.size()):
        t = cypher.removeRear()
        if t == let:
            cypher.addRear(t)
            val = cypher.removeRear()
            val = cypher.removeRear()
            cypher.addRear(val)
            return val
        cypher.addRear(t)

encrMes = ""
for i in s:
    if encLet := enc(i):
        encrMes += encLet
print(encrMes)