module Main where

main = 
    do
    print (myFunc1 5)
    print (myFunc2 10)
    print (func3)

myFunc1 x = x*10
myFunc2 x = x*2
func3 = "Hello, this is 3rd Func"