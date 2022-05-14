;;=============================================================
;; CS 2110 - Fall 2022
;; Homework 5 - summation
;;=============================================================
;; Name: Owen Huggins 
;;=============================================================

;; Pseudocode (see PDF for explanation)
;;
;;    int result; (to save the summation of x)
;;    int x= -9; (given integer)
;;    int answer = 0;
;;    while (x > 0) {
;;        answer += x;
;;        x--;
;;    }
;;    result = answer;
.orig x3000
    ;; YOUR CODE HERE

    ;; Clear R0
    AND R0, R0, 0
        ;; Load x into R0
        LD R0, x
    ;;Clear R1
    AND R1, R1, 0
    ;; Start of Loop {
    LOOP
    ;; See if R0 is nzp
    ADD R0, R0, #0
        ;; if negative or zero, end loop
    BRnz END_LOOP
    ;; else
        ;;R1 += R0
        ;;R0 --
    ADD R1, R1, R0
    ADD R0, R0, #-1
    ;; loop again
    BR LOOP
    END_LOOP
    ST R1, result

    HALT

    x .fill -9
    result .blkw 1
.end

