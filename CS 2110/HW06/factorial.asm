;;=============================================================
;; CS 2110 - Fall 2021
;; Homework 6 - Factorial
;;=============================================================
;; Name: Owen Huggins
;;============================================================

;; In this file, you must implement the 'factorial' and "mult" subroutines.

;; Little reminder from your friendly neighborhood 2110 TA staff: don't run
;; this directly by pressing 'RUN' in complx, since there is nothing put at
;; address x3000. Instead, load it and use 'Debug' -> 'Simulate
;; Subroutine Call' and choose the 'factorial' or 'mult' label.

;; Pseudocode

;; Factorial

;;    factorial(int n) {
;;        int ret = 1;
;;        for (int x = 2; x < n+1; x++) {
;;            ret = mult(ret, x);
;;        }
;;        return ret;
;;    }

;; Multiply
         
;;    mult(int a, int b) {
;;        int ret = 0;
;;        int copyB = b;
;;        while (copyB > 0):
;;            ret += a;
;;            copyB--;
;;        return ret;
;;    }


.orig x3000
    ;; you do not need to write anything here
HALT

factorial   ;; please do not change the name of your subroutine

;; Stack BuildUp
   ADD R6, R6, -4          ;make room for return value, return address, old frame pointer, and 1 local
   STR R7, R6, 2           ;save return address in the space we made it
   STR R5, R6, 1           ;save R5 in space for the old frame pointer
   ADD R5, R6, 0           ;save R5 to the frame pointer of the activation record
   ADD R6, R6, -6         ;make room for saving registers
   STR R0, R6, 4
   STR R1, R6, 3
   STR R2, R6, 2
   STR R3, R6, 1
   STR R4, R6, 0

   AND R0, R0, 0
   ADD R0, R0, 1 ;; R0 = ret
   STR R0, R5, 0

   AND R1, R1, 0
   ADD R1, R1, 2 ;; R1 = x
   STR R1, R5, -1


   LDR R3, R5, 4
   ADD R3, R3, 1 ;; R3 = n + 1


   FOR
   NOT R3, R3
   ADD R3, R3, 1

   ADD R4, R1, R3

   BRzp ENDFOR
   LDR R3, R5, 4
   ADD R3, R3, 1 ;; Restore N + 1
   AND R4, R4, 0 ;; Restore R4 = 0


   ADD R6, R6, -2
   STR R0, R6, 0
   STR R1, R6, 1
   JSR mult
   LDR R2, R6, 0
   ADD R0, R2, #0
   ADD R6, R6, 3
   ADD R1, R1, 1
   BR FOR

   ENDFOR

   STR R0, R5, 3







;;Stack TearDown

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


    
mult        ;; please do not change the name of your subroutine

;; Stack BuildUp

    ADD R6, R6, #-4; set up stack frame storage
       STR R7, R6, #2
       STR R5, R6, #1
       ADD R5, R6, #0
       ADD R6, R6, #-6; store registers onto stack, leave space for two local vars
       STR R0, R6, #4
       STR R1, R6, #3
       STR R2, R6, #2
       STR R3, R6, #1
       STR R4, R6, #0

   AND R0, R0, 0 ; ret = 0;
   LDR R1, R5, 5
   LDR R2, R5, 4
   WHILE
   ADD R1, R1, 0
   BRnz ENDWHILE
   ADD R0, R0, R2
   ADD R1, R1, -1
   BR WHILE



   ENDWHILE
   STR R0, R5, 0
   STR R1, R5, -1
   STR R0, R5, 3






;;Stack TearDown

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
