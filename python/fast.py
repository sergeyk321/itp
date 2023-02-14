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

def fast_sort(arr):
    if len(arr) > 0: #без этого list out of range
        k = arr[len(arr) // 2]
        low = []
        mid = []
        high = []
        for i in arr:
            if i < k:
                low.append(i) 
            elif i > k: 
                high.append(i) 
            else: 
                mid.append(i)
        return fast_sort(low) + mid + fast_sort(high) #вписываются по очереди. применяем fast_sort к каждому подмассиву
    else:
        return arr

for i in arr:
    print(fast_sort(i))