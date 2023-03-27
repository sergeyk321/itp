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

print(arr)    

# n = len(arr)
# def tour_sort(arr):
#     w = []
#     l = []
#     res = []
#     arr2 = [7, 4, 10, 9, 2, 1, 6]
#     k = len(arr2)
#     #heap = [4, 7, 10, 9]
#     heap = []
#     tree_size = n // 2 + 1
#     for i in range(tree_size):
#         heap.append(arr2[i])
#     for j in range(1, k):
        
#max heap
#l = 2 * i + 1
#r = 2 * i + 2    
#arr[0] = max


    #return 

    # for i in arr:
    #     print(tour_sort(i))