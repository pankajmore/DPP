{-# LANGUAGE BangPatterns #-}
import qualified Data.ByteString.Lazy.Char8 as BS

fac0 :: Int -> Int
fac0 n = sum [ n `div` 5^i | i <- [1..floor $ log (fromIntegral n) / log 5]]

fac1 :: Int -> Int -> Int
fac1 0 !acc = acc
fac1 n !acc = fac1 (n `div` 5) (acc + (n `div` 5) )

facR0 n = fac1 n 0

main :: IO ()
main = do
  (_:ws) <- BS.lines `fmap` BS.getContents -- all IO in one go
  --let [n,k] = map readInt (BS.split ' ' l)
  sequence_ $ map ( print . facR0 . readInt ) $ ws

readInt :: BS.ByteString -> Int
readInt x =
  case BS.readInt x of Just (i,_) -> i
                       Nothing    -> error "Unparsable Int"
