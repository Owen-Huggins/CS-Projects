%% Question A 
C=[.1588  .0064  .0025  .0304  .0014  .0083  .1594 ;
 .0057  .2645  .0436  .0099  .0083  .0201  .3413 ; 
 .0264  .1506  .3557  .0139  .0142  .0070  .0236 ; 
 .3299  .0565  .0495  .3636  .0204  .0483  .0649 ; 
 .0089  .0081  .0333  .0295  .3412  .0237  .0020 ; 
 .1190  .0901  .0996  .1260  .1722  .2368  .3369 ;
 .0063  .0126  .0196  .0098  .0064  .0132  .0012 ]
v1 = [1 1 1 1 1 1 1]
v1 * C
%This proves that this is a consumption matrix, because all of the columns
%sumn to less than one. 

%% Question B
d=[74000 ; 56000 ; 10500  ; 25000 ; 17500 ; 196000 ;  5000 ]
I = eye(7)
Cx = I - C
rref([Cx d])
%Sets up a matrix and solves for x, in the form x = Cx + d
compare = rref([Cx d])
%Establishes a variable to compare the answer to in the next question

%% Question C 
inv(Cx) * d
e8 = compare(1:end,8)
%Proves that the method we are solving for x is correct, because the
%answers match in part C and B
%% Question D 
L = I + C + C^2 + C^3 + C^4 + C^5 + C^6 + C^7 + C^8 + C^9 + C^10 + C^11 + C^12 + C^13 + C^14 + C^15 + C^16
L*d
%The lowest number that k can be such that L*d equals a correct
%approximation for x is 16 
%% Question B2
d2=[ 99640 ; 75548 ; 14444 ; 33501 ; 23527 ; 263985 ; 6526 ]
I = eye(7)
Cx = I - C
rref([Cx d2])
%Sets up a matrix and solves for x, in the form x = Cx + d2
compare = rref([Cx d2])
%Establishes a variable to compare the answer to in the next question
%% Question C2
inv(Cx) * d2
e8 = compare(1:end,8)
%Proves that the method we are solving for x is correct, because the
%answers match in part C2 and B2

%% Question D2 
L = I + C + C^2 + C^3 + C^4 + C^5 + C^6 + C^7 + C^8 + C^9 + C^10 + C^11 + C^12 + C^13 + C^14 + C^15 + C^16 + C^17 + C^18
L*d2
%The lowest number that k can be such that L*d2 equals a correct
%approximation for x is 18 
