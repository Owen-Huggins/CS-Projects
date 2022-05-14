%% Question 1: Addition in Matlab 
41 + 57
% adds 41 to 57 and prints it 

%% Question 2: Solving a Linear system with no Free Variables 
A = [1 2 3 ; 2 -1 3 ; 4 -1 12]
%Assigns "A" to the coefficient matrix 
b = [115; 1421; 4214]
% Assigns "b" to the solutions of A 
A\b
%Finds the unique solution to Question 2 
M = [1 2 3 115; 2 -1 3 1421; 4 -1 12 4214]
rref(M)
%Finds the RREF of the system of equations in question 2 
%This finds the solution to the system above 
%% Question 3: Another Linear system  
S = [4 -7 -33; -3 8 44; -3 7 37]
rref(S)

%Finds the RREF of the system of equations in question 3
%The solution to this consistent system is x1 = 4, x2 =7,
    
%% Question 4: Linear system with free variables 
D = [1 2 3; 2 -1 3]
%Assigns "D" to the coefficient matrix of the first two rows from question 2
c = [115; 1421]
%Assigns "c" to the solution vector from question 2 
D\c
%Tries to find a solution to the set of linear equations 
%We know that if a solution like this one, is consistant and has a free
%variable, then there will be an infinite amount of solutions. As the
%solution set 
D\c
E = [1 2 3 115; 2 -1 3 1421]
rref(E)
%Puts question 4 in rref 
v = [1; 0; 591.4; -1.8]
%Assigns the first vector to "v"
w = [0; 1; -238.2; -.6]
%Assigns the second vector to "w"
a = "x3" 
x = "v + aw"
%Details what form this should be in 
