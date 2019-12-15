# triplets with sum 0
# [‑1,0,1,2,‑1,‑4]
# [-4,-1,-1,0,1,2]
#         ^ ^   ^

def get_triplets(arr, n):
    arr.sort()
    result = []
    for i in range(0,n-2):
        if i != 0 and arr[i] == arr[i-1]:
            continue 
        j = i+1
        k = n-1
        while j < k:
            if arr[i] + arr[j] + arr[k] == 0:
                result.append([arr[i], arr[j], arr[k]])

            if arr[i] + arr[j] + arr[k] < 0:
                curr = j
                while arr[curr] == arr[j] and j < k:
                    j += 1
            else:
                curr = k
                while arr[curr] == arr[k] and j < k:
                    k -= 1
    print(result)


arr = [-1, 0, 1, 2, -1, -4]
n = len(arr)
get_triplets(arr, n)