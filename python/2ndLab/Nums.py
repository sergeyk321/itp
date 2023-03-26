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
    
num = open("Nums.txt", "r", encoding="utf8")
s = num.read().split(" ")
    
q = Deque()
numbers = []
for nums in s:
    numbers.append(int(nums)) #[-1 2 -3 4]

for n in numbers:
    if n < 0: #[-1], [-1 2], [-3 -1 2], [-3 -1 2 4], положительные по порядку
        q.addFront(n) 
    else:
        q.addRear(n) 

while not q.isEmpty(): #отрицательные в конец
    n = q.removeRear()
    if n < 0: #[-1 2 4 -3], [2 4 -3 -1]
        q.addRear(n)
    else:
        q.addFront(n)
        break 
 
while not q.isEmpty(): #берем с конца
    n = q.removeFront() 
    if n < 0: #-1 -3 2 4
        print(n)
    else:
        q.addRear(n)
        break
while not q.isEmpty():
    print(q.removeRear())