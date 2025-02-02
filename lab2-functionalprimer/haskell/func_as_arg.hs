--create inpFunc

inpFunc a b = [a..b] 

--Define applicatorFunc
applicatorFunc inpFunc a b s | s == 's' = sum (inpFunc a b) 
                             | otherwise = (sum (inpFunc a b) )/(b-a +1) -- applicatorFunc calls inpFunc passing arguments a,b and character for sum or else  

main = do
    let result = applicatorFunc inpFunc 1 5 'a' --Calling applicator function by giving inpfunction parameters a=1 b=5 as a sum
    putStrLn("sum = " ++ show(result))