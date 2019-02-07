def largestFactor(num):
    factor = 2
    while factor * factor <= num:
        while num % factor == 0:
            num /= factor
        factor += 1
    if (num > 1):
        return num
    return factor

print largestFactor(13195)
print largestFactor(600851475143)
