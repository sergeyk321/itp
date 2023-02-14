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
def selection_sort(arr):
    for i in range(n):
        id = i
        for j in range(i + 1, n):
            if arr[id] > arr[j]:
                id = j
        arr[i], arr[id] = arr[id], arr[i]
    return arr

for i in arr:
  print(selection_sort(i))
