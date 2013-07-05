triplet a b = a^2 + b^2 == (1000 - a - b)^2

ls = [(x*y*(1000-x-y)) | x <- [100..1000], y <- [x..1000], x + y < 1000, triplet x y == True]

main = print $ head $ ls
