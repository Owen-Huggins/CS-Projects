;;=============================================================
;; CS 2110 - Fall 2022
;; Homework 5 - binaryStringToInt
;;=============================================================
;; Name: Owen Huggins
;;=============================================================

;; Pseudocode (see PDF for explanation)
;;
;;    int result = x4000; (given memory address to save the converted value)
;;    String binaryString= "01000000"; (given binary string)
;;    int length = 8; (given length of the above binary string)
;;    int base = 1;
;;    int value = 0;
;;    while (length > 0) {
;;        int y = binaryString.charAt(length - 1) - 48;
;;        if (y == 1) {
;;            value += base;
;;        }     
;;            base += base;
;;            length--;
;;    }
;;    mem[result] = value;
.orig x3000
    ;; YOUR CODE HERE

    ;; Clear all registers
    AND R0, R0, #0
    AND R1, R1, #0
    AND R2, R2, #0
    AND R3, R3, #0
    AND R4, R4, #0
    LD R0, binaryString
    LD R1, length

    ;; R0 = BinaryString + Length - 1
    ;; R1 = Length
    ADD R0, R0, R1
    ADD R0, R0, #-1

    ;; R2 = base = 1
    AND R2, R2, #0
    ADD R2, R2, #1

    ;; Start of While, while Length > 0
    WHILE1 ADD R1, R1, #0
    ;; if neg or 0, end while
    BRnz ENDW1

    ;; R4 = R0 (BinaryString + Length - 1)
    ;; R4 = BinaryString + Length - 1   - 48
    LDR R4, R0, #0
    ADD R4, R4, #-16
    ADD R4, R4, #-16
    ADD R4, R4, #-16

    ;; if R4 negative or z -> ENDI
    BRnz ENDI1

    ;; if R4 is positive, R3 (value) += R2 (base)
    ADD R3, R3, R2
    ENDI1 ADD R2, R2, R2
    ;;Both if / else statements follow this

    ADD R1, R1, #-1
    ADD R0, R0, #-1
    BR WHILE1

    ENDW1
    ;; at the end of the while loop
    LD R2, result
    STR R3, R2, #0


    HALT

    binaryString .fill x5000
    length .fill 8
    result .fill x4000
.end 

.orig x5000
    .stringz "010010100"
.end
