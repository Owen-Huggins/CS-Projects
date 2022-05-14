%% Part 1 
v1 = [1;0;-1]
v2 = [2;2;0] 
v3 = [1;1;2] 
eignvalues = [1 0 0;0 .5 0;0 0 0.5]
%% Part a) 
x = [7;5;4]
m1 = [v1 v2 v3 x]
rref(m1)
c = [2;1;3]
%C is the answer from the rref of m1
%% Part b) 
p = [v1 v2 v3]
d = eignvalues
for k = [1 2 3 4 5]
    (p * d^k * inv(p))*x
end 

%% Part c) 
for k = [1:50]
    (p * d^k * inv(p)) * x
end
%If the eignenvalues are less than one, they converge to zero, thus v2 and
%v3 become irrelevant. V1's eignenvalue is 1, so it converges to 1, thus it
%remains as k goes to infinity. The answer then become v1 multiplied by the
%first value in c, because that was the linear combination to get v1 to x. 
%% Part 2 
g1 = [0 0 1 0 1/5;1/3 0 0 1/2 1/5;1/3 0 0 1/2 1/5; 1/3 1/2 0 0 1/5;0 1/2 0 0 1/5] * 0.85
p1 = [1/5 1/5 1/5 1/5 1/5;1/5 1/5 1/5 1/5 1/5;1/5 1/5 1/5 1/5 1/5;1/5 1/5 1/5 1/5 1/5;1/5 1/5 1/5 1/5 1/5] * .15
G1 = g1 + p1
g2 = [1/6 1/2 1/4 0 0 1/6;1/6 0 1/4 0 0 1/6;1/6 1/2 0 1/2 0 1/6;1/6 0 1/4 0 0 1/6;1/6 0 1/4 1/2 0 1/6;1/6 0 0 0 1 1/6] * 0.85
p2 = [1/6 1/6 1/6 1/6 1/6 1/6;1/6 1/6 1/6 1/6 1/6 1/6;1/6 1/6 1/6 1/6 1/6 1/6;1/6 1/6 1/6 1/6 1/6 1/6;1/6 1/6 1/6 1/6 1/6 1/6;1/6 1/6 1/6 1/6 1/6 1/6] * 0.15
G2 = g2 + p2
%Both entries of G1 and G2 (my google matricies) are the values of the
%probability matrix, meaning that at that point, the user will then click
%on a random webite or look something up. The meaning of row three is the
%probability that the user will either stay on that page once they are
%there, and the probability of them clicking on another page. 
G1k = G1^15
G2k = G2^14
%Both entries of G1 and G2 (my google matricies as k goes to infinity) are the values from the
%probability matrix, meaning that at that point, the user will then click
%on a random webite or look something up. The meaning of row three is the
%probability that the user will either stay on that page once they are
%there, and the probability of them clicking on another page.