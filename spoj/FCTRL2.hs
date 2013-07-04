{-# LANGUAGE BangPatterns #-}
import qualified Data.ByteString.Lazy.Char8 as BS

fac 0 = 1
fac n = n * fac (n-1)

main :: IO ()
main = do
  (_:ws) <- BS.lines `fmap` BS.getContents -- all IO in one go
  sequence_ $ map ( print . fac . readInteger ) $ ws

readInteger x =
  case BS.readInteger x of
    Just (i,_) -> i
    Nothing    -> error "Unparsable Int"
