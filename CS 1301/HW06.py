#!/usr/bin/env python3
"""
Georgia Institute of Technology - CS1301
HW06 - Dictionaries and Try/Except
"""

"""
Function Name: vowelCounter()
Parameters: cities (list)
Returns: number of vowels in each city (dict)
"""
def vowelCounter(cities):
    adict = {}
    count = 0 
    for astr in cities:
        for char in astr:
            if char in "AEIOUaeiou":
                count += 1
                
        adict[astr] = count
        count = 0
    return(adict)





"""
Function Name: maskDetector()
Parameters: message (list)
Returns: tuple with the location of the mask (str) and the number of errors (int)
"""

def maskDetector(message):
    errors = 0
    location = ""
    for num in message:
        try:
            type(num) == str
            location += num
           
        except:
            errors +=1
    
    tup = (location, errors)
    return(tup)


"""
Function Name: beautifulDay()
Parameters: dictionary of cities mapped to list of tuples (dict), ideal weather (str), ideal temperature (int)
Returns: a list of places (list)
"""

def beautifulDay(weatherDict, ideal_weather, ideal_temperature):
    
    alist = []
    for key in weatherDict.keys():
        value = weatherDict[key]
        for tup in value:
            (weather, low, high) = tup
            if ideal_weather == weather:
                if ideal_temperature >= low and ideal_temperature <= high:
                    if key not in alist:
                        alist.append(key)
    alist.sort()
    return(alist)
        
    



"""
Function Name: flightFinder()
Parameters: flight prices by month for different cities (dict), city (str)
Returns: the month with the cheapest flight to the customer's desired city (str) or None
"""

def flightFinder(flightInfo, city):
    for key in flightInfo.keys():
        if key == city:
            if flightInfo[key] == {}: 
                return("No Flights")
            cheapest = min(flightInfo[key].values())
            for x in flightInfo[key].keys():
                if flightInfo[key][x] == cheapest:
                    return(x)
    return("No Flights")



"""
Function Name: courseRosters()
Parameters: student info as a list of tuples (list)
Returns: a dictionary containing course rosters (dict)
"""

def courseRosters(students):
    adict = {}
    
    for num in students:
        (student, major, classes) = num

        for periods in classes:
            if periods in adict:
                if major not in adict[periods]:
                    
                    for num in ((adict[periods])):
                        newdict = {}
                        newdict.clear()
                        
                        if len(adict[periods][num]) > 2:
                            newdict[num] = [adict[periods][num]]
                            
                        else:
                            newdict[num] = adict[periods][num]
                        newdict[major] = [student]
                        
                    adict[periods] = newdict
                   
                        
                    
                    
                        
                    
                elif major in adict[periods]:
                    adict[periods] = {major: adict[periods][major] + [student]}
            else:               
                
                adict[periods] = {major: [student]}
                
            
        

    return(adict)






