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
def shell_sort(arr):
    p = n // 2
    while p > 0:
        for i in range(p, n):
            while i >= p and arr[i] < arr[i - p]:
                arr[i], arr[i - p] = arr[i - p], arr[i]
                i -= p
        p //= 2
    return arr
    
for i in arr:
    print(shell_sort(i))