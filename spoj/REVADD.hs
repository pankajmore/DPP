lsToTuple :: [a] -> [(a,a)]
lsToTuple [] = []
lsToTuple (x:y:xs) = (x,y):lsToTuple xs

sumTuple :: (Int,Int) -> Int
sumTuple (x,y) = x + y

readInt :: String -> Int
readInt = read

truncate0 :: String -> String
truncate0 = reverse . dropWhile (== '0') . reverse . dropWhile (== '0')

reverse' :: Int -> Int
reverse' = readInt . reverse . truncate0 . show

main :: IO ()
main = do
  (_:ws) <- words `fmap` getContents
  sequence_ $ map (print . reverse' . sumTuple) $ lsToTuple $ map (reverse' . readInt) ws
