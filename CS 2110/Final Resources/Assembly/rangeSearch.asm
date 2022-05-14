;;=============================================================
;; CS 2110 - Spring 2022
;; Final Exam - Range Search
;;=============================================================
;; Name: Owen Huggins
;;=============================================================

;; Pseudocode (see PDF for additional information)
;;     int list = [2, 1, 1, 0, 4, 2, 9, 0];
;;     int size = 8;
;;     int target = 10;
;;     int range = 2;
;;     int answer;
;;
;;     int index = -1;
;;     for (int i = 0; i < size; i++) {
;;         if (target - range <= list[i] <= target + range) {
;;             index = i;
;;             break;
;;         }
;;     }
;;     answer = index;
;;     
;; 
.orig x3000

AND R0, R0, #0
ADD R0, R0, -1

AND R1, R1, 0
LD R2, SIZE

FOR

NOT R1, R1
ADD R1, R1, #1

ADD R3, R2, R1
BRzp BREAK
NOT R1, R1
ADD R1, R1, #1
ADD R1, R1, #1

LD R3, TARGET
LD R4, RANGE
NOT R4, R4
ADD R4, R4, #1
ADD R3, R3, R4

LD R5, TARGET
ADD R5, R5, R1
LDR R4, R5, #0

NOT R4, R4
ADD R4, R4, #1

ADD R5, R3, R4
BRp IF1

LD R5, TARGET
LD R6, RANGE
ADD R5, R5, R6
ADD R6, R5, R4
BRzp IF1

BRn FOR




IF1
AND R0, R0, #0
ADD R0, R1, #0

BR BREAK







BREAK
ST R0, ANSWER

HALT

LIST    .fill x4000
SIZE    .fill 8
TARGET  .fill 10
RANGE   .fill 2
ANSWER  .blkw 1

.end

.orig x4000
    .fill 2
    .fill 1
    .fill 1
    .fill 0
    .fill 4
    .fill 2
    .fill 9
    .fill 0
.end