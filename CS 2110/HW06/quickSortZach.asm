;;=============================================================
;; CS 2110 - Fall 2021
;; Homework 6 - Quick Sort
;;=============================================================
;; Name:
;;============================================================

;; In this file, you must implement the 'quicksort' and 'partition' subroutines.

;; Little reminder from your friendly neighborhood 2110 TA staff: don't run
;; this directly by pressing 'RUN' in complx, since there is nothing put at
;; address x3000. Instead, load it and use 'Debug' -> 'Simulate
;; Subroutine Call' and choose the 'quicksort' or 'partition' label.


;; Pseudocode:

;; Partition

;;    partition(arr[], int low, int high):
;;        pivot = arr[high]
;;        i = low - 1
;;        for (j = low; j < high - 1; j++)
;;            if (arr[j] < pivot):
;;                i++
;;                temp = arr[j]
;;                arr[j] = arr[i]
;;                arr[i] = temp
;;        temp = arr[high]
;;        arr[high] = arr[i + 1]
;;        arr[i + 1] = temp
;;        return i + 1

;; Quicksort

;;    quicksort(int[] arr, int left, int right):
;;        if (left < right):
;;            pi = partition(arr, left, right)
;;            quicksort(arr, left, pi - 1)
;;            quicksort(arr, pi + 1, right)


.orig x3000
    ;; you do not need to write anything here
HALT

partition   ;; please do not change the name of your subroutine
    ;; insert your implementation for partition subroutine
    ADD R6, R6, #-4; set up stack frame storage
    STR R7, R6, #2
    STR R5, R6, #1
    ADD R5, R6, #0
    ADD R6, R6, #-8; store registers onto stack, leave space for 4 local var
    STR R0, R6, #4
    STR R1, R6, #3
    STR R2, R6, #2
    STR R3, R6, #1
    STR R4, R6, #0

    LDR R0, R5, #4 ; R0 <- arr[]
    LDR R1, R5, #6 ; R1 <- high

    ADD R0, R0, R1 ; R0 <- arr[high] address
    LDR R0, R0, #0 ; R0 <- arr[high] value
    STR R0, R5, #0 ; pivot = arr[high]

    LDR R2, R5, #5 ; R2 <- low
    ADD R3, R2, #-1 ; R3 <- low - 1
    STR R3, R5, #-1 ; i = low - 1
    STR R2, R5, #-2 ; j = low

    FOR1 LDR R0, R5, #-2 ; R0 <- j
    LDR R1, R5, #6 ; R1 <- high
    ;ADD R1, R1, #-1 ; R1 <- high - 1
    NOT R1, R1
    ADD R1, R1, #1 ; R1 <- -(high-1)


    ADD R1, R0, R1 ; R1 <- j - (high - 1)
    BRzp ENDF1

    LDR R1, R5, #4 ; R1 <- arr[]
    ADD R2, R1, R0

    LDR R3, R2, #0 ; R3 <- arr[j] value
    LDR R4, R5, #0 ; R4 <- pivot

    NOT R4, R4
    ADD R4, R4, #1 ; R4 <- -pivot
    ADD R4, R3, R4 ; R4 <- arr[j] - pivot < 0
    BRzp EIF1

    LDR R4, R5, #-1 ; R4 <- i
    ADD R4, R4, #1 ; i++
    STR R4, R5, #-1

    AND R2, R2, #0
    ADD R2, R2, R3 ; R2 <- R3 = arr[j]
    STR R2, R5, #-3 ; temp = arr[j]

    ADD R2, R1, R4 ; R2 <- arr[] + i
    LDR R2, R2, #0 ; R2 <- arr[i] value

    LDR R4, R5, #-2 ; R3 <- j
    ADD R4, R1, R4 ; R3 <- arr[j] address
    STR R2, R4, #0 ; arr[j] = arr[i]

    LDR R2, R5, #-3 ; R2 <- temp
    LDR R4, R5, #-1 ; R4 <- i
    ADD R1, R1, R4 ; arr[i] address

    STR R2, R1, #0 ; arr[i] = temp



    EIF1 NOP
    LDR R2, R5, #-2 ;
    ADD R2, R2, #1 ;
    STR R2, R5, #-2
    BR FOR1
    ENDF1 NOP

    LDR R0, R5, 4
    LDR R1, R5, 6
    ADD R1, R1, R0
    LDR R0, R1, 0 ; R0 val arr[high]

    STR R0, R5, #-3; temp = arr[high]

    LDR R1, R5, #-1 ; R1 <- i
    LDR R2, R5, #6 ; R2 <- high
    LDR R3, R5, #4 ; R3 <- arr[]

    ADD R1, R3, R1; R0 <- arr[i] address
    ADD R2, R3, R2; R2 <- arr[high] address
    ADD R1, R1, #1

    LDR R0, R1, #0
    STR R0, R2, #0 ; arr[high] = arr[i+1]

    LDR R0, R5, #-3
    STR R0, R1, #0 ; arr[i+1] = temp

    LDR R0, R5, #-1 ; i
    ADD R0, R0, #1
    STR R0, R5, #3 ; RV = i+1

    LDR R0, R6, #4
    LDR R1, R6, #3
    LDR R2, R6, #2
    LDR R3, R6, #1
    LDR R4, R6, #0

    ADD R6, R5, #0

    LDR R5, R6, #1

    LDR R7, R6, #2
    ADD R6, R6, #3

    RET

quicksort   ;; please do not change the name of your subroutine
    ;; insert your implementation for quicksort subroutine
    ADD R6, R6, #-4; set up stack frame storage
    STR R7, R6, #2
    STR R5, R6, #1
    ADD R5, R6, #0
    ADD R6, R6, #-5; store registers onto stack, leave space for one local var
    STR R0, R6, #4
    STR R1, R6, #3
    STR R2, R6, #2
    STR R3, R6, #1
    STR R4, R6, #0

    LDR R0, R5, #4 ; R0 <- arr[]
    LDR R1, R5, #5 ; R1 <- left
    LDR R2, R5, #6 ; R2 <- right

    NOT R3, R2
    ADD R3, R3, #1

    IF2 ADD R3, R1, R3
    BRzp EIF2

    ADD R6, R6, -3
    STR R0, R6, 0 ;
    STR R1, R6, 1 ;
    STR R2, R6, 2

    JSR partition

    LDR R3, R6, #0 ; R3 <- RV
    ADD R6, R6, 4
    STR R3, R5, #0 ; pi = RV

    ADD R6, R6, -3
    STR R0, R6, 0 ;
    STR R1, R6, 1 ;

    ADD R3, R3, #-1
    STR R3, R6, 2

    JSR quicksort

    ADD R6, R6, 4

    ADD R6, R6, -3
    STR R0, R6, 0 ;

    ADD R3, R3, #2
    STR R3, R6, 1 ;
    STR R2, R6, 2

    JSR quicksort

    ADD R6, R6, 4

    EIF2 NOP

    LDR R0, R6, #4
    LDR R1, R6, #3
    LDR R2, R6, #2
    LDR R3, R6, #1
    LDR R4, R6, #0

    ADD R6, R5, #0

    LDR R5, R6, #1

    LDR R7, R6, #2
    ADD R6, R6, #3


    RET

STACK .fill xF000
.end
.orig x4000
	.fill 1
	.fill 3
	.fill 2
	.fill 5
.end


;; Assuming the array starts at address x4000, here's how the array [1,3,2,5] represents in memory
;; Memory address           Data
;; x4000                    1
;; x4001                    3
;; x4002                    2
;; x4003                    5
