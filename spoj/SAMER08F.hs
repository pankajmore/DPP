squares :: Int -> Int
squares n = sum $ map (\x -> x * x) [1..n]

-- memoization plz
