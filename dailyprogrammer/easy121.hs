{-# LANGUAGE BangPatterns #-}

import Data.Function (fix)

f :: (Integer -> Integer) -> Integer -> Integer
f mf 0 = 1
f mf n = mf (div n 2) + mf (div n 3) + mf (div n 4)

data Tree a = Tree (Tree a) a (Tree a)
instance Functor Tree where
    fmap f (Tree l m r) = Tree (fmap f l) (f m) (fmap f r)


index :: Tree a -> Integer -> a
index (Tree _ m _) 0 = m
index (Tree l _ r) n = case (n - 1) `divMod` 2 of
    (q,0) -> index l q
    (q,1) -> index r q

nats :: Tree Integer
nats = go 0 1
    where
        go !n !s = Tree (go l s') n (go r s')
            where
                l = n + s
                r = l + s
                s' = s * 2

toList :: Tree a -> [a]
toList as = map (index as) [0..]

f_tree :: Tree Integer
f_tree = fmap (f fastest_f) nats

fastest_f :: Integer -> Integer
fastest_f = index f_tree

insertCoin 0 = 1
insertCoin n = insertCoin (n `div` 2) + insertCoin (n `div` 3) + insertCoin (n `div` 4)

--main = getContents >>= \x -> return (read x :: Integer) >>= print . fastest_f
