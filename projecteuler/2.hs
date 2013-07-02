fib = 1:2:zipWith (+) fib (tail $ fib)

main = print $ sum $ [x | x <- take 100 fib, x < 4000000, x `rem` 2 ==0]

-- idea how to make haskell smarter to not hang on computing all of fib
