def listFunc(a, b):
    return [i for i in range(a, b+1)] #Create list of ints from 1 to 5, Haskell equivalent [1..5]

def applicatorFunc(a, b, s):
    if s=='s':
        return sum(listFunc(a, b))
    else:
        return sum(listFunc(a, b))/((b-a+1))

print(applicatorFunc(1, 5, 's'))