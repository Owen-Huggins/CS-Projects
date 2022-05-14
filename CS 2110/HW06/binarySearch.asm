;;=============================================================
;; CS 2110 - Fall 2021
;; Homework 6 - Binary Search
;;=============================================================
;; Name: Owen Huggins
;;============================================================

;; In this file, you must implement the 'binarySearch' subroutine.

;; Little reminder from your friendly neighborhood 2110 TA staff: don't run
;; this directly by pressing 'RUN' in complx, since there is nothing put at
;; address x3000. Instead, load it and use 'Debug' -> 'Simulate
;; Subroutine Call' and choose the 'binarySearch' label.


;; Pseudocode:

;; Nodes are blocks of size 3 in memory:

;; The data is located in the 1st memory location
;; The node's left child address is located in the 2nd memory location
;; The node's right child address is located in the 3rd memory location

;; Binary Search

;;    binarySearch(Node root (addr), int data) {
;;        if (root == 0) {
;;            return 0;
;;        }
;;        if (data == root.data) {
;;            return root;
;;        }
;;        if (data < root.data) {
;;            return binarySearch(root.left, data);
;;        }
;;        return binarySearch(root.right, data);
;;    }

.orig x3000
    ;; you do not need to write anything here
HALT

binary_search   ;; please do not change the name of your subroutine
;; Stack Buildup
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


       LDR R0, R5, 4 ; L0 = root
       LDR R1, R5, 5 ; L1 = data

       ADD R0, R0, 0
       BRz IF1
       BR COMPARE

       COMPARE

       LDR R2, R0, 0 ; R2 = root.data
       NOT R2, R2
       ADD R2, R2, 1
       ADD R2, R2, R1
       BRz IF2
       BRn IF3
       BRp IF4





       IF2
       STR R0, R5, 3
       BR TEAR


       IF3
       LDR R2, R0, 0
       LDR R3, R0, 1
       ADD R6, R6, -2
       STR R3, R6, 0
       STR R1, R6, 1
       JSR binary_search
       LDR R4, R6, 0
       STR R4, R5, 0
       ADD R6, R6, 3
       STR R4, R5, 3

       BR TEAR


       IF4
              LDR R2, R0, 0
              LDR R3, R0, 2
              ADD R6, R6, -2
              STR R3, R6, 0
              STR R1, R6, 1
              JSR binary_search
              LDR R4, R6, 0
              STR R4, R5, 0
              ADD R6, R6, 3
              STR R4, R5, 3

              BR TEAR







       IF1
       STR R0, R5, 3
       BR TEAR







;; Stack Teardown
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

;; Assuming the tree starts at address x4000, here's how the tree (see below and in the pdf) represents in memory
;;
;;              4
;;            /   \
;;           2     8 
;;         /   \
;;        1     3 
;;
;; Memory address           Data
;; x4000                    4
;; x4001                    x4004
;; x4002                    x4008
;; x4003                    Don't Know
;; x4004                    2
;; x4005                    x400C
;; x4006                    x4010
;; x4007                    Don't Know
;; x4008                    8
;; x4009                    0(NULL)
;; x400A                    0(NULL)
;; x400B                    Don't Know
;; x400C                    1
;; x400D                    0(NULL)
;; x400E                    0(NULL)
;; x400F                    Dont't Know
;; x4010                    3
;; x4011                    0(NULL)
;; x4012                    0(NULL)
;; x4013                    Dont't Know
;;
;; *note: 0 is equivalent to NULL in assembly