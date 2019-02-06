# Euler2 Problem
# Find the sum of Fibonacci numbers that are even and under 1M

firstValue = 0
secondValue = 1
fibSum = 0

i = 0
while i < 4000000:    
    i = secondValue + firstValue
    firstValue = secondValue
    secondValue = i
    if(i%2 == 0):
        fibSum += i
    

print(fibSum)