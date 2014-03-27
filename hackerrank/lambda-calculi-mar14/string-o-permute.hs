import Control.Monad
permute s = reverse $ go s []
  where go [] r = r
        go (a:b:xs) r = go xs (a:b:r)

readInt :: IO Int
readInt = do
  t <- getLine
  return (read t :: Int)

main = do
  t <- readInt
  replicateM t $ do
    s <- getLine
    putStrLn $ permute s
