"""
Georgia Institute of Technology - CS1301
HW04 - Strings, Indexing and Lists
"""

#########################################

"""
Function Name: findMax()
Parameters: a caption list of numbers (list), start index (int), stop index (int)
Returns: highest number (int)
"""
def findMax(lists, start, stop):
    pass
    s = start
    n = lists[start]
    for x in range (start, stop):        
        if n >= lists[s+1]:
            if s+1 != stop:
                s +=1
        if n < lists[s+1]:
            n = lists[s + 1]
            if s+1 != stop:
                s += 1
    return(n)

            
            
#########################################

"""
Function Name: fruitPie()
Parameters: list of fruits (list), minimum quantity (int)
Returns: list of fruits (list)
"""
def fruitPie(fruits, quantity):
    pass
    bakable = []
    for (idx, val) in enumerate(fruits):
        if idx % 2 == 1:
            if val >= quantity:
                bakable += [fruits[idx-1]]
    return bakable


            


#########################################

"""
Function Name: replaceWord()
Parameters: initial sentence (str), replacement word (str)
Returns: corrected sentence (str)
"""
def replaceWord(int_sentence, replace):
    pass
    correct = int_sentence.split()    
    for (idx, val) in enumerate (correct):
        if len(val) >= 5:
            correct[idx] = replace
    final = correct 
    aStr = ""
    for (idx, val) in enumerate (final):
        if idx == (len(final)-1):
            aStr += val
        elif True:
            aStr += val + " "
    return(aStr)

        

#########################################

"""
Function Name: highestSum()
Parameters: list of strings (strings)
Returns: index of string with the highest sum (int)
"""
def highestSum(alist):
    pass
    mlist = []
    
    for aStr in alist:
        add = 0
        for char in aStr:
            if char.isdigit():
                add += int(char)
        mlist.append(add)
    biggest_num = max(mlist)
    return(mlist.index(biggest_num))
        
                
#########################################

"""
Function: sublist()
Parameters: alist (list), blist (list)
Returns: True or False (`boolean`)
"""
def sublist(alist, blist):
    pass
    start = 0
    
    for (idx, val) in enumerate(alist):
        if blist == []:
            return(True)
        if val == blist[0]:
            if alist[start:] == blist:
                return(True)
            if alist[start:(len(blist)+1)] != blist:
                return(False)
            else:
                return(True)                    
                
        elif val != blist[0]:
            start += 1
    return(False)
