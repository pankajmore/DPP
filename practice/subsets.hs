subsets :: [a] -> [[a]]
subsets [] = [[]]
subsets (x:xs) = [x:y | y <- subsets(xs)] ++ subsets xs

foo :: Char -> [Char] -> [[Char]]
permutations  c = [c]
permutations (x:xs) = concat $ map foo $ subsets xs
