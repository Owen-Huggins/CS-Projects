#!/usr/bin/env python3
"""
Georgia Institute of Technology - CS1301
HW07 - File I/O & CSV
"""

"""
Function Name: findCuisine()
Parameters: filename (str), cuisine (str)
Returns: list of restaurants (list)
"""
def findCuisine(aFile, cuisine):
    aList = []
    file = open(aFile, "r")
    lines = file.readlines()
    for idx, val in enumerate(lines):
        if cuisine in val:
            aList += lines[(idx-1)].strip(),
    file.close
    return(aList)
    
    


"""
Function Name: restaurantFilter()
Parameters: filename (str)
Returns: dictionary that maps cuisine type (str) to a 
list of restaurants of the same cuisine type (list)
"""
def restaurantFilter(aFile):
    newDict = {}
    newList = []
    file = open(aFile, "r")
    for x in file.readlines():
        newList += x.strip("\n"),
        if x == "\n":
            newList.remove("")
        if len(newList) == 3:
        
            if newList[1] not in newDict:
                newDict[newList[1]] = [newList[0]]
            else:
                newDict[newList[1]] += [newList[0]]
            
            newList = []
            
    file.close()
      
    return(newDict)

"""
Function Name: createDirectory()
Parameters: filename (str), output filename (str)
Returns: None (NoneType)
"""

def createDirectory(aFile, directory1):
    directory = open(directory1, "w")
    newList = []
    fast = []
    sitdown = []
    file = open(aFile, "r")
    for x in file.readlines():
        newList +=x.strip("\n"),
        if x == "\n":
            newList.remove("")
        if len(newList) == 3:
            if newList[2] == "Fast Food":
                fast.append("{} {} {}\n".format(newList[0], "-", newList[1]))
            else:
                sitdown.append("{} {} {}\n".format(newList[0], "-", newList[1]))
            newList = []
    
    fast.sort()
    sitdown.sort()
    
    last = sitdown[-1].strip()
    sitdownfixed = sitdown[:-1]
    sitdownfixed.append(last)
    
    
    directory.write("{}\n".format("Restaurant Directory"))
    directory.write("\n")
    directory.write("Fast Food\n")
    
    for x in range(len(fast)):
        directory.write("{}. {}".format((x+1), fast[x]))
        
    directory.write("\n")
    directory.write("Sit-down\n")
    for x in range(len(sitdownfixed)):
        directory.write("{}. {}".format((x+1), sitdownfixed[x]))

    directory.close()
    
   

"""
Function Name: infectedPercentage()
Parameters: country list(list), filename(str)
Returns: country and percentage (tuple)
"""
def infectedPercentage(country_list, aFile):
    file = open(aFile, "r")
    tup = ("test", 0)
    header = file.readline()
    lines = file.readlines()
    (tup_Country, tup_percent) = tup
    if country_list == []:
        return(None)
    for line in lines:
        for x in country_list:
            pieces = line.split(",")
            if x in pieces:        
                per = (float(pieces[2]) /float(pieces[1].strip()))
                percent = round((per *100),2)
                
                (tup_Country, tup_percent) = tup
                if percent > tup_percent:
                    tup = (x, percent)
                
    file.close()
    
   
        
    return(tup)


"""
Function Name: countryStatus()
Parameters: country list (list), filename(str)
Returns: risk dictionary (dict)
"""
def countryStatus(country_list, aFile):
    file = open(aFile, "r")
    low = []
    med = []
    high = []
    aDict = {"Low risk": low, "Medium risk": med, "High risk": high}
    
    header = file.readline()
    lines = file.readlines()
    
    for line in lines:
        for x in country_list:
            pieces = line.split(",")
            if x in pieces:
                per = (float(pieces[2]) /float(pieces[1].strip()))
                percent = round((per * 100),2)
                if percent <= 25:
                    low.append(x)
                elif percent > 25 and percent <= 65:
                    med.append(x)
                elif percent > 65:
                    high.append(x)
    file.close()
    return(aDict)

"""
Function Name: compareRisk()
Parameters: country to compare (str), country list (list), filename(str)
Returns: compared countries (list)
"""
def compareRisk(compare_country, country_list, aFile):
    file = open(aFile, "r")
    aList = []
    total_pop = 0
    header = file.readline()
    lines = file.readlines()
    for line in lines:
        
        for x in [compare_country]:
            pieces = line.split(",")
            if x in pieces:
                total_pop = float(pieces[1])
                total_infected = float((pieces[2].strip()))
                
    for line in lines:
        
        for y in country_list:
            pieces = line.split(",")
            if y in pieces:
                
                if float(pieces[1]) < total_pop and float((pieces[2].strip())) > total_infected:
                    aList.append(y)
    if aList == []:
        return("No countries")
    
    return(aList)
