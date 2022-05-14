#!/usr/bin/env python3
"""
Georgia Institute of Technology - CS1301
HW09 - Recursion
"""

"""
Function Name: pickyEater()
Parameters: food list (list)
Returns: number of food items that can be eaten (int)
"""
def pickyEater(flist):
    if len(flist) == 0:
        return 0
    else:
        if flist[0] == "":
            return pickyEater(flist[1:])
            
        if len(flist[0]) % 2 == 0:
            return 1 + pickyEater(flist[1:])
        else:
            return pickyEater(flist[1:])  

print(pickyEater(["Apple Pie", "Turkey", "Cranberry Sauce", "Mac and cheese"]) )

"""
Function Name: inviteFriends()
Parameters: list of invitees (list)
Returns: flattened list of all invitees (list)
"""
def inviteFriends(friendsList):
    if len(friendsList) == 0:
        return []
    else:
        if friendsList[0] == [] :
            return inviteFriends(friendsList[1:])
        if friendsList[0] == "":
            return inviteFriends(friendsList[1:])
        elif type(friendsList[0]) == list:
            if type(friendsList[0][0]) == list:
                return[friendsList[0][0][0]] + inviteFriends(friendsList[0][0][1:]) + inviteFriends(friendsList[0][1:]) + inviteFriends(friendsList[1:])
            return [friendsList[0][0]] + inviteFriends(friendsList[0][1:]) + inviteFriends(friendsList[1:])
        
        return [friendsList[0]] + inviteFriends(friendsList[1:])



"""
Function Name: friendsgiving()
Parameters: stores (list), budget (float), maxDistance (int)
Returns: price of sauce at each store (dict)
"""
def friendsgiving(stores, budget, maxDistance):
    
    
    if len(stores) == 0:
        return {}
        
    else:
        adict = friendsgiving(stores[1:],budget, maxDistance)
        (store, price, distance) = stores[0]
        
        if price < budget and distance < maxDistance:
            adict[store] = price
        
        return adict
    


"""
Function Name: palindrome()
Parameters: string (str), guess (int)
Returns: Whether the string contains a number of palindromes (bool)
"""


def palindrome(aStr, guess):
    if guess ==0 and len(aStr) < 3:
        return True
    if guess != 0 and len(aStr) < 3:
        return False 
        
    else:
       
        if aStr[0] == aStr[2] and aStr[0] != aStr[1]:
            
           
            return  (palindrome(aStr[1:],guess-1)) 
        else:
            return palindrome(aStr[1:],guess)
    
    
    

        



