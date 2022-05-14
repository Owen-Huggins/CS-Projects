

"""
Georgia Institute of Technology - CS1301
HW03 - Iteration
"""

#########################################

"""
Function Name: movieNight()
Parameters: a caption (str)
Returns: the fixed caption (str)
"""
def movieNight(caption):
    pass
    fixed_caption = ""
    for letter in caption:
        if letter in "1234567890":
            continue
        fixed_caption += letter
    return(fixed_caption)

    

#########################################

"""
Function Name: iceCream()
Parameters: flavor (str), number of vowels (int)
Returns: a sentence (str)
"""
def iceCream(flavor, vowels):
    pass
    new_flavor = flavor.lower()
    num = 0
    for letter in new_flavor:
        if letter in "aeiou":
            num += 1
    str(vowels)
    if num > vowels:
        vowel = str(vowels)
        return("Yes, " + new_flavor + " ice cream has more than " + vowel + " vowels!") 
    else:
        vowel = str(vowels)
        return("No, " + new_flavor + " ice cream doesn't have more than " + vowel + " vowels!")


#########################################

"""
Function Name: dreamCar()
Parameters: car price (float), bank balance(float), interest rate (float)
Returns: number of years (int)
"""
def dreamCar(price, balance, rate):
    pass
    t = 0
    A = 0
    r = (rate/100)
    while A < price:
        A = round((balance * (1 + r) ** (t)), 2)
        if A >= price:
            break
        t += 1
        
    return(t)



#########################################

"""
Function Name: battleship()
Parameters: board size (int)
Returns: None (NoneType)
"""
def battleship(size):
    pass
    z = 0    
    while z < size:        
        for i in range(size):
            alphabet = "abcdefghijklmnopqrstuvwxyz"
            l = alphabet[i]            
            for i in range(1, size + 1):
                if i == size:
                    print(l+str(i))
                    continue
                print(l+str(i), end = " ")            
            
            z += 1

battleship(26)
#########################################

"""
Function: tennisMatch()
Parameters: player 1 (str), player 2 (str), match record (str)
Returns: winner (str)
"""
def tennisMatch(player_1, player_2, match_record):
    pass
    p1 = 0
    p2 = 0
    p1_score = 0
    p2_score = 0
    
    for num in match_record:
        
        if num == "1":
            p1 +=1            
            
        if num == "2":
            p2 +=1            
            
        if num == "-":
            if p2 < p1:
                p1_score += 1
                p1 = 0
                p2 = 0
                
            elif p1 < p2:
                p2_score += 1
                p1 = 0
                p2 = 0
                
                
            elif p1 == p2:
                p1 = 0
                p2 = 0
                
            
    if p1_score > p2_score:
        return("{} won! The score was {}-{}.".format(player_1, p1_score, p2_score))
    elif p2_score > p1_score:
        return("{} won! The score was {}-{}.".format(player_2, p2_score, p1_score))
    elif p1_score == p2_score:
        return("It's a tie!")


        
        
    




