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
def tour_sort(arr):
    for i in range((n - 2) // 2, -1, -1):
        tour_sift(arr, i, n - 1)
    for j in range(n - 1, 0, -1):
        arr[j], arr[0] = arr[0], arr[j]
        tour_sift(arr, 0, j - 1)
    return arr

def tour_sift(arr, i, j):
    start = i
    while True:
        child = start * 2 + 1
        if child > j:
            break
        if child + 1 <= j and arr[child] < arr[child + 1]:
            child += 1
        if arr[start] < arr[child]:
            arr[start], arr[child] = arr[child], arr[start]
            start = child
        else:
            break

for i in arr:
  print(tour_sort(i))