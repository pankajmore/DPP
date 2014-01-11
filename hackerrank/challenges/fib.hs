-- Enter your code here. Read input from STDIN. Print output to STDOUT
import Control.Monad

--fib :: [Int]
fib = 0:1:zipWith (+) fib (tail fib)

readInt :: String -> Int
readInt = read

fibIO = do
    x <- getLine
    putStrLn $ show $ (fib !! (readInt x)) `mod` 100000007

main = do
    n <- getLine
    replicateM (readInt n) fibIO
