

"""
Georgia Institute of Technology - CS1301
HW02 - Conditionals
"""

#########################################

"""
Function Name: skillLevel()
Parameters: passRate (int)
Returns: "Beginner" or "Moderate" or "Advanced" (str)
"""
def skillLevel(passRate):
    pass
    if passRate > 75:
        return("Advanced")
        
    elif 25 < passRate <= 75:
        return("Moderate")
        
    elif 0 <= passRate <= 25:
        return("Beginner")
        


#########################################

"""
Function Name: bookStore()
Parameters: item (str), walletAmount (float), quantity (int)
Returns: moneyLeftOver (float)
"""
def bookStore(item, walletAmount, quantity,):
    pass
    if item == "Shirt":
        left_over = (walletAmount -(quantity * 15.50))
    elif item == "Lanyard":
        left_over = (walletAmount -(quantity * 4.25))
    elif item == "Sweatshirt":
        left_over = (walletAmount -(quantity * 25.00))
    elif item == "Mug":
        left_over = (walletAmount -(quantity * 10.50))
    
    if left_over < 0:
        return("Not enough money!")
    return(round(left_over, 2))
    


#########################################

"""
Function Name: dinnerPlans()
Parameters: distance (int), hungerLevel (str)
Returns: transportMode (str)
"""
def dinnerPlans(distance, hungerLevel,):
    pass
    if distance > 7:
        return("Uber")
    
    elif 5 < distance <= 7:
        if hungerLevel == "Not Hungry":
            return("Walk")
        return("Uber")
    
    elif 3 < distance <= 5:
        if hungerLevel == "Slightly Hungry":
            return("Walk")
        return("Uber")
    
    elif 1 < distance <= 3:
        if hungerLevel == "Hungry":
            return("Walk")
        return("Uber")
    
    elif distance <= 1:
        return("Walk")
        


#########################################

"""
Function Name: weekendTrip()
Parameters: distance (float), speed (float), freeTime (float)
Returns: transportMode (str)
"""
def weekendTrip(distance, speed, freeTime):
    pass
    if (freeTime - (distance / speed)) >= round(0.8 * freeTime, 2):
        if 2.5 <= speed <= 15:
            transportMode = "walking"
        elif 15 < speed <= 20:
            transportMode = "biking"
        elif 20 < speed:
            transportMode = "driving"
        return(transportMode)
    return("Going to this destination would take too much time.")



#########################################

"""
Function Name: textFriends()
Parameters: distance (float), speed (float), freeTime (float), numSnacks (int), numFriends (int)
Returns: textMsg (str)
"""
def textFriends(distance, speed, freeTime, numSnacks, numFriends):    
    pass
    weekendTrip1 = weekendTrip(distance, speed, freeTime)
    if weekendTrip1 == "Going to this destination would take too much time.":
        return("Going to this destination would take too much time.")
    
    snacks_split = str(numSnacks // numFriends)
    remaining_snacks = str(numSnacks % numFriends)

    textMsg = "If each of us gets " + snacks_split +" snack(s), there will be " + remaining_snacks + " left. I will be " + weekendTrip1 + ", who else is doing the same?"
    return(textMsg)





