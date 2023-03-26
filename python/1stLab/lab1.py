import random
import time

user_m = int(input())
user_n = int(input())
user_min_limit = int(input())
user_max_limit = int(input())
user_m, user_n, user_min_limit, user_max_limit
arr = []
for i in range(user_m):
    irr = []
    for j in range(user_n):
        irr.append(random.randint(user_min_limit, user_max_limit))
    arr.append(irr)
for i in range(user_m):
    print(arr[i])