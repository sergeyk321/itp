# Создаем пустой стек
def create_stack():
    stack = []
    return stack

# Проверка на пустоту
def check_empty(stack):
    return len(stack) == 0

# Добавляем элементы в стек
def push(stack, item):
    stack.append(item)
    #print("Добавлен элемент: " + item)

# Удаляем элементы из стека
def pop(stack):
    if (check_empty(stack)):
        return "Стек пуст"
    return stack.pop()

rev = open("Books.txt", "r", encoding = "utf8")
s = rev.read()
str = s.split("\n")

answer = ""
st = create_stack()
for c in str:
    push(st, c)
while not check_empty(st):
    print(st.pop())

# for c in str:
#     book = s.strip()
#     print(book)
#     push(st, book)
# print()
# while not check_empty(st):
#     print(pop(st))