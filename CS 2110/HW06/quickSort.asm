;;=============================================================
;; CS 2110 - Fall 2021
;; Homework 6 - Quick Sort
;;=============================================================
;; Name: Owen Huggins
;;============================================================

;; In this file, you must implement the 'quicksort' and 'partition' subroutines.

;; Little reminder from your friendly neighborhood 2110 TA staff: don't run
;; this directly by pressing 'RUN' in complx, since there is nothing put at
;; address x3000. Instead, load it and use 'Debug' -> 'Simulate
;; Subroutine Call' and choose the 'quicksort' or 'partition' label.


;; Pseudocode:

;; Partition

;;    partition(int[] arr, int low, int high) {
;;        int pivot = arr[high];
;;        int i = low - 1;
;;        for (j = low; j < high; j++) {
;;            if (arr[j] < pivot) {
;;                i++;
;;                int temp = arr[j];
;;                arr[j] = arr[i];
;;                arr[i] = temp;
;;            }
;;        }
;;        int temp = arr[high];
;;        arr[high] = arr[i + 1];
;;        arr[i + 1] = temp;
;;        return i + 1;
;;    }
        
;; Quicksort

;;    quicksort(int[] arr, int left, int right) {
;;        if (left < right) {
;;            int pi = partition(arr, left, right);
;;            quicksort(arr, left, pi - 1);
;;            quicksort(arr, pi + 1, right);
;;        }
;;    }


.orig x3000
    ;; you do not need to write anything here
HALT

partition   ;; please do not change the name of your subroutine

;; Stack Buildup

    ADD	R6, R6, -4; Allocate space rv,ra,fp,lv1
    STR	R7, R6, 2	; Save Ret Addr
    STR	R5, R6, 1	; Save Old FP
    ADD	R5, R6, 0	; Copy SP to FP
    ADD	R6, R6, -8; Make room for saved regs
    STR R0, R6, #4
    STR R1, R6, #3
    STR R2, R6, #2
    STR R3, R6, #1
    STR R4, R6, #0

;; Main Code

    ;; Assignment

        LDR R0, R5, 4 ;; R0 = Arr
        LDR R1, R5, 5 ;; R1 = low
        LDR R2, R5, 6 ;; R2 = high
        ADD R0, R0, R2
        LDR R3, R0, 0 ; R3 = Arr[high]
        LDR R0, R5, 4 ;; restore array
        ADD R4, R1, -1 ;; R4 = i = low - 1

    ;; Store Values into R5 (We're gonna run out of registers)

        STR R3, R5, 0 ;; Pivot = arr[high]
        STR R4, R5, -1 ;; i = low - 1
        STR R1, R5, -2 ;; j = low

    ;; FOR Loop
        FOR
        LDR R0, R5, -2 ; R0 = J
        LDR R2, R5, 6
        ADD R2, R2, -1 ; high - 1
        NOT R2, R2
        ADD R2, R2, 1 ; - (high -1 )

        ADD R2, R0, R2
        BRzp ENDFOR

        ;; IF Statement
            ;; getting arr[j]
            LDR R1, R5, 4 ; R1 = array
            LDR R0, R5, -2 ; R0 = j
            ADD R1, R1, R0 ; arr[j]
            LDR R0, R1, 0 ; val of arr[j]

            ;; arr[j] < pivot
            LDR R2, R5, 0 ; R2 = pivot
            NOT R2, R2
            ADD R2, R2, 1
            ADD R2, R0, R2 ; arr[j] - pivot
            BRzp IF1

            ;; i++
            LDR R3, R5, -1 ; R3 = i
            ADD R3, R3, 1
            STR R3, R5, -1

            ;; temp = arr[j]
            LDR R1, R5, 4 ; R1 = arr
            LDR R2, R5, -2 ; R2 = j
            ADD R1, R1, R2 ; R1 = @ Arr[j]
            STR R1, R5, -3 ; Temp = R5, -3



            ;; getting to arr[i]
            LDR R3, R5, 4 ; R3 = arr
            LDR R1, R5, -1 ; R1 = i
            ADD R1, R1, R3 ; R3 = @ arr[i]
            LDR R4, R1, 0 ; R4 = val arr[i]

            ;; arr[j] = arr[i]
            LDR R1, R5, 4 ; R1 = array
            LDR R2, R5, -2 ; R2 = j
            ADD R1, R1, R2
            STR R4, R1, 0



            ;; Arr[i] = temp
            LDR R1, R5, 4 ; R1 = array
            LDR R2, R5, -1 ; R2 = i
            LDR R3, R5, -3 ; R3 = temp
            ADD R1, R1, R2
            ST R3, R1, 0



        IF1 NOP
        LDR R2, R4, -2
        ADD R2, R2, 1
        STR R2, R5, -2
        BR FOR





    ;;Out of FOR LOOP
        ENDFOR NOP

        ;; temp = arr[high]
        LDR R0, R5, 4 ; R0 = array
        LDR R1, R5, 6 ; R1 = high
        ADD R0, R0, R1 ; R0 = @ arr[high]
        LDR R1, R0, 0 ; R1 = temp = value at arr[high]
        STR R1, R5, -3

        ;; arr[high] = arr[i + 1]
        LDR R2, R5, -1 ; R2 = i
        ADD R2, R2, 1 ; R2 = i + 1
        LDR R3, R5, 4
        ADD R3, R3, R2 ; R3 = @ arr[i + 1]
        LDR R4, R3, 0 ;; val at arr[i + 1]
        LDR R0, R5, 4 ; R0 = arr
        LDR R1, R5, 6 ; R1 = high
        ADD R1, R1, R0 ; R1 = @ arr[high]
        STR R4, R1, 0

        ;; arr[i + 1] = temp
        LDR R1, R5, -3; R1 = temp
        STR R1, R3, 0

        LDR R0, R5, -1
        ADD R0, R0, 1
        STR R0, R5, 3






;;Stack Teardown

    LDR	R0, R6, 4; Restore R0
    LDR	R1, R6, 3; Restore R1
    LDR R2, R6, 2
    LDR R3, R6, 1
    LDR R4, R6, 0
    ADD	R6, R5, 0	; Restore SP
    LDR	R5, R6, 1	; Restore FP
    LDR	R7, R6, 2	; Restore RA
    ADD	R6, R6, 3	; Pop ra,fp,lv1



    RET

quicksort   ;; please do not change the name of your subroutine

;; initial buildup
    ADD	R6, R6, -4; Allocate space rv,ra,fp,lv1
    		STR	R7, R6, 2	; Save Ret Addr
    		STR	R5, R6, 1	; Save Old FP
    		ADD	R5, R6, 0	; Copy SP to FP
    		ADD	R6, R6, -5  ; Make room for saved regs
    		STR R0, R6, 4
    		STR R1, R6, 3
    		STR R2, R6, 2
    		STR R3, R6, 1
    		STR R4, R6, 0

;; Main Code
    LDR R0, R5, 4 ;; R0 = array
    LDR R1, R5, 5 ;; R1 = Left
    LDR R2, R5, 6 ;; R2 = Right


    NOT R2, R2,
    ADD R2, R2, 1

    ADD R3, R1, R2 ;; left - right
    BRzp TEAR
    NOT R2, R2,
    ADD R2, R2, 1 ;; restore right (R2)

    ;; partition(arr, left, right)
    ADD R6, R6, -3
    STR R0, R6, 0
    STR R1, R6, 1
    STR R2, R6, 2
    JSR partition
    LDR R3, R6, 0  ;; R3 = pi = partition (arr, left, right)
    ADD R6, R6, 4
    STR R3, R5, 0


    ;; quicksort(arr, left, pi - 1)

    ADD R6, R6, -3
    STR R0, R6, 0
    STR R1, R6, 1
    ADD R3, R3, -1
    STR R3, R6, 2
    JSR quicksort
    ADD R6, R6, 4


    ;; quicksort (arr, pi + 1, right)
    ADD R6, R6, -3
    STR R0, R6, 0
    ADD R3, R3, 2
    STR R3, R6, 1
    STR R2, R6, 2
    JSR quicksort
    ADD R6, R6, 4

    BR TEAR





;; tear down
TEAR
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


;; Assuming the array starts at address x4000, here's how the array [1,3,2,5] represents in memory
;; Memory address           Data
;; x4000                    1
;; x4001                    3
;; x4002                    2
;; x4003                    5
