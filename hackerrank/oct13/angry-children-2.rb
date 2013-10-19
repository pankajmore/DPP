# Enter your code here. Read input from STDIN. Print output to STDOUT
N = STDIN.gets.strip.to_i
K = STDIN.gets.strip.to_i
A = Array.new
S = Array.new
1.upto(N) do
  x = STDIN.gets.strip.to_i
  A.push(x)
end
A.sort!
#puts A
S.push(A[0])
sum=A[0]
1.upto(N-1) do |i|
  sum += A[i]
  S.push(sum)
end
#puts S
sum=0
1.upto(K-1) do |i|
  sum+=(A[i]*i) - S[i-1]
end
min=sum
curr=min
#puts min
1.upto(N-K) do |i|
  csum = S[i+K-2]-S[i-1]
  curr+=(K-1)*(A[i+K-1]+A[i-1]) - 2*(S[i+K-2]-S[i-1])
  #puts curr
  if(min>curr) then min=curr end
end
puts min
