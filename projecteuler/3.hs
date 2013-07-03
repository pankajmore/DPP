-- primes = 2 : 3 : ([5,7..] `minus` unionAll [[p*p, p*p+2*p..] | p <- tail primes])

-- primes = [n | n<-[2..], not $ elem n [j*k | j<-[2..n-1], k<-[2..n-1]]]
minus :: Ord a => [a] -> [a] -> [a]
minus [] _ = []
minus xs [] = xs
minus l1@(x:xs) l2@(y:ys)
    | x > y = minus l1 ys
    | x < y = x : minus xs l2
    | otherwise = minus xs l2

primes = let { sieve xs (p:ps) = let (h,t)=span (< p*p) xs in
                                   h ++ sieve (t `minus` [p*p, p*p+2*p..]) ps }
           in 2 : 3 : sieve [5,7..] (tail primes)

numdivs n x | n `rem` x == 0 = 1 + numdivs (n `div` x) x
            | otherwise = 0

prime_factors n (x:xs) ys= case n of
                              1 -> ys
                              _ -> case numdivs n x of
                                        0 -> prime_factors n xs ys
                                        p -> prime_factors (n `div` (x^p)) xs (x:ys)

largestPrimeFactor n = head $  prime_factors n  (take n primes)  []
