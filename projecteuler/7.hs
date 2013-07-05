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

main = print $ primes !! 10000
