;;=============================================================
;; CS 2110 - Fall 2022
;; Homework 5 - fourCharacterStrings
;;=============================================================
;; Name: Owen Huggins
;;=============================================================


;; Pseudocode (see PDF for explanation)
;;
;; int count = 0;
;; int chars = 0;
;; int i = 0;
;;
;;  while(str[i] != '\0') {
;;      if (str[i] != ' ') 
;;          chars++;
;;      
;;      else {
;;          if (chars == 4) 
;;              count++;   
;;          chars = 0;
;;      }
;;      i++;
;;  }
;; ***IMPORTANT***
;; - Assume that all strings provided will end with a space (' ').
;; - Special characters do not have to be treated differently. For instance, strings like "it's" and "But," are considered 4 character strings.
;;

.orig x3000
	;; YOUR CODE HERE

	;; Clearing Registers
	AND R0, R0, #0
	AND R1, R1, #0
	AND R2, R2, #0
	AND R3, R3, #0
	AND R4, R4, #0

	LD R0, STRING
	LD R1, SPACE

    ;; While String[i] != Null {
	WHILE1 LDR R5, R0, #0
    BRz ENDW1

    ;; if String [i] != ' '
    ADD R5, R5, R1
    BRz E1
    ;; Chars ++
    ADD R2, R2, #1
    BR ENDIF1

    ;; else
    E1 ADD R2, R2, #-4
    BRnp E2
    ADD R3, R3, #1
    E2 AND R2, R2, #0

    ENDIF1 ADD R4, R4, #1
    ADD R0, R0, #1
    BR WHILE1

    ENDW1 ST R3, ANSWER



	HALT


SPACE 	.fill #-32
STRING	.fill x4000
ANSWER .blkw 1

.end


.orig x4000

.stringz "I love CS 2110 and assembly is very fun! "

.end
