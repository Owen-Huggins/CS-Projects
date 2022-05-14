;;=============================================================
;; CS 2110 - Fall 2022
;; Homework 5 - buildMaxArray
;;=============================================================
;; Name: Owen Huggins
;;=============================================================


;; Pseudocode (see PDF for explanation)
;;
;;	int A[] = {1,2,3};
;;	int B[] = {-1, 7, 8};
;;	int C[3];
;;
;;	int i = 0;
;;
;;	while (i < A.length) {
;;		if (A[i] < B[i])
;;			C[i] = B[i];
;;		else
;;			C[i] = A[i];
;;
;;		i += 1;
;;	}


.orig x3000
	;; YOUR CODE HERE

	LD R6, LEN
	LD R5, C

	LD R0, A
	LD R2, B
    ;; We take a different approach, instead of subtracting LEN - i, we subtract LEN and see if it's > 0
	WHILE1 ADD R6, R6, #0
	;; if negative or zero END While Loop
	BRnz ENDW1


	;; first if

	;; if (a < b)
	LDR R1, R0, #0
    LDR R3, R2, #0

    NOT R7, R3
    ADD R7, R7, #1
    ADD R7, R1, R7

	BRp EL1

	STR R3, R5, #0



    BR X1

    EL1 STR R1, R5, #0

    X1 NOP
     ADD R0, R0, #1
     ADD R2, R2, #1
     ADD R5, R5, #1
     ADD R6, R6, #-1

    EIF1 NOP




	BR WHILE1
	ENDW1



    HALT

A 	.fill x3200
B 	.fill x3300
C 	.fill x3400
LEN .fill 4

.end

.orig x3200
	.fill -1
	.fill 2
	.fill 7
	.fill -3
.end

.orig x3300
	.fill 3
	.fill 6
	.fill 0
	.fill 5
.end

.orig x3400
	.blkw 4
.end


