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

txt = open("Letters.txt", "r", encoding="utf8")
s = txt.read()
answer = ""

numbers = create_stack()
letters = create_stack()
symbols = create_stack()

for ch in s:
    if ch.isdigit():
        push(numbers, ch)
    elif ch.isalpha():
        push(letters, ch)
    else:
        push(symbols, ch)
numbers.reverse()
letters.reverse()
symbols.reverse()

while not check_empty(numbers):
    answer += numbers.pop()
while not check_empty(letters):
    answer += letters.pop()
while not check_empty(symbols):
    answer += symbols.pop()

print(answer)