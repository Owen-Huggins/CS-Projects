#!/usr/bin/env python3
"""
Georgia Institute of Technology - CS1301
HWEC - Extra Credit Problems
"""

"""
Function Name: validParentheses()
Parameters: a string with parentheses (str)
Returns: valid or not (bool)
"""
def validParentheses(aStr):
    opens = 0
    closes = 0
    for idx, val in enumerate(aStr):
        if val in "([":
            opens +=1
        elif val in ")]":
            closes +=1
    return opens == closes
            
            
                




"""
Function Name: bubbleSort()
Parameters: a list (list), the list's length (int)
Returns: None (NoneType)
"""
def bubbleSort(aList, length):
    print(aList)
    x = 0
    if length == 1:
        return aList
    if len(aList) == 0:
        return []
    else:
        if aList[x] > aList[x+1]:
            print([aList[x+1]] + [aList[x]].append(aList[2:]))
            return [aList[x+1]] + [aList[x]].append(bubbleSort(aList[2:], length))
        else:
            x +=1
            return [aList[x]] + [aList[x+1]].append(bubbleSort(aList[2:], length))
print(bubbleSort([1,3,2,5], 4))

"""
Function Name: groupAnagrams()
Parameters: list of strings (list)
Returns: grouped anagrams (dict)
"""

#######################################
######### Write Function Here #########
#######################################

"""
Problem Name: Winter Break
"""

class Friend:
    def __init__(self):
        pass

class Planner:
    def __init__(self):
        pass

