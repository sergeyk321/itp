import random
import time

user_m = int(input())
user_n = int(input())
user_min_limit = int(input())
user_max_limit = int(input())
user_m, user_n, user_min_limit, user_max_limit
arr = []
for k in range(user_m):
    irr = []
    for l in range(user_n):
        irr.append(random.randint(user_min_limit, user_max_limit))
    arr.append(irr)

n = len(arr)
def ins_sort(arr):
    for i in range(1, n):
        k = arr[i] #текущее значение
        j = i
        while j > 0 and arr[j - 1] > k: #предыдущий элемент больше текущего значения
            arr[j] = arr[j - 1] #меняем местами
            j -= 1
        arr[j] = k #передаем следующее значение
    return arr
    
for i in arr:
    print(ins_sort(i))