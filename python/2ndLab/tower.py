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

a = []
b = []
c = []

n = 6
for i in range(n, 0, -1):
    push(a, str(i))

def circular_queue(a, b):   
        if len(a) > 0 and len(b) == 0:
            push(b, (pop(a)))
        elif len(a) == 0 and len(b) > 0:
            push(a, (pop(b)))
        elif a[-1] > b[-1]:
            push(a, (pop(b)))
        else:
            push(b, (pop(a)))


if n % 2 == 0:
    while len(c) != n:
        circular_queue(a, b)
        circular_queue(a, c)
        circular_queue(b, c)
else:
    while len(c) != n:
        circular_queue(a, c)
        if a == 1:
            push(c, (pop(a)))
        circular_queue(a, b)
        circular_queue(b, c)
        print("Башня 1 = " + str(a))
        print("Башня 2 = " + str(b))
        print("Башня 3 = " + str(c))
if len(c) == n:
    while not check_empty(c):
        print(f'Диски:{c}')
        print(pop(c))