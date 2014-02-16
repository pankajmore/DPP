def rotate(A,k):
    n = len(A)
    B = A[(n-k):]+A[:(n-k)]
    return B

def search(A,x):
    left = 0
    right = len(A) - 1
    if A[left] > A[right]:
        # increasing order case
        while left < right:
            print left,right
            mid = (left + right)/2
            if A[mid] < A[left]:
                if x < A[mid]:
                    right = mid - 1
                elif x > A[mid]:
                    if x > A[right]:
                        right = mid - 1
                    else:
                        left = mid + 1
                else:
                    return True
            else:
                assert(A[mid] >= A[left])
                if x > A[mid]:
                    left = mid + 1
                elif x < A[mid]:
                    if x > A[right]:
                        right = mid - 1
                    else:
                        left = mid + 1
                else:
                    return True
    if A[left] == x:
        return True
    return False
