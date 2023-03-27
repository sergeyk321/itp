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

s = "Преступление и наказание, Три товарища, Униженные и оскорбленные, Портрет Дориана Грея, 20000 лье под водой"
str = s.split(", ")

deq1 = Deque() #отсортирован
deq2 = Deque() #не отсортирован
deq1.addFront(str[0]) #начальный

for i in range(1, len(str)):
    if str[i] <= deq1.items[0]: 
        deq1.addFront(str[i]) #ставим первым 
    elif str[i] > deq1.items[-1]:
        deq1.addRear(str[i]) #ставим последним
    else:
        while str[i] > deq1.items[0]:
            deq2.addFront(deq1.removeRear())
        deq1.addFront(str[i]) 
        while not deq2.isEmpty():
            deq1.addFront(deq2.removeRear()) #в обратном порядке
while not deq1.isEmpty():
    print(deq1.removeRear())