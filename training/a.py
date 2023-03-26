# # put your python code here
# class Deque:
#     def __init__(self):
#         self.items = []

#     def isEmpty(self):
#         return self.items == []

#     def addRear(self, item):
#         self.items.append(item)

#     def addFront(self, item):
#         self.items.insert(0, item)

#     def removeFront(self):
#         return self.items.pop()

#     def removeRear(self):
#         return self.items.pop(0)

#     def size(self):
#         return len(self.items)

# Ceaser = open("ceaser.txt", "r", encoding = "utf8")
# s = Ceaser.read()
# a='абвгдежзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'
# cypher = Deque();
# for i in a:
#     cypher.addRear(i)

x = int(input());
y = input();
for i in range(len(y)):
    if (ord(y[i]) - x) >= 97:
        print(chr(ord(y[i]) - x), end = '');
    else:
        print(chr(ord(y[i]) - x + 26), end = '');