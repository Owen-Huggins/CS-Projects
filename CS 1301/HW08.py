#!/usr/bin/env python3
"""
Georgia Institute of Technology - CS1301
HW08 - APIs
"""

"""
Function Name: meetNewPeople()
Parameters: house (str)
Returns: list of people (list)
"""
def meetNewPeople(house):
    import requests
    baseUrl = "https://www.potterapi.com/v1/"
    url = baseUrl + "characters" + "?key=" +  "$2a$10$TuKeJXdhhlWTTtROpVzSxulXrVlfFGcw1NWFzvoXtgMcfx8TgIYiS"
    apiKeyr = requests.get(url)
    people_list = apiKeyr.json()
    
    rList = []
    for x in people_list:
        try:
            if x["house"] == house:
                if x["deathEater"] == False:
                    if x["bloodStatus"] == "pure-blood":
                        rList.append(x["name"])
        except:
            continue
                      
    return(rList)



"""
Function Name: matchingStudents()
Parameters: character name (str)
Returns: list of students (list)
"""
def matchingStudents(name):
    import requests
    baseUrl = "https://www.potterapi.com/v1/"
    url = baseUrl + "characters" + "?key=" +  "$2a$10$TuKeJXdhhlWTTtROpVzSxulXrVlfFGcw1NWFzvoXtgMcfx8TgIYiS"
    apiKeyr = requests.get(url)
    people_list = apiKeyr.json()
    
    name_characteristics = []
    rList = []
    
    for x in people_list:
        try:
            if x["name"] == name:
                name_characteristics.append(x["bloodStatus"])
                name_characteristics.append(x["house"])
        except:
            continue
        
    for x in people_list:
        try:
            if x["role"] == "student":
                if x["bloodStatus"] == name_characteristics[0]:
                    if x["house"] == name_characteristics[1]:
                        if x["name"] != name:
                            rList.append(x["name"])
        except:
            continue
    
                
    
    return(rList)


"""
Function Name: similarCharacters()
Parameters: movieID1 (str), movieID2 (str)
Returns: number of people (int)
"""
def similarCharacters(movieID1, movieID2):
    import requests
    baseUrl = "https://swapi.dev/api/"
    url = baseUrl + "films/" + movieID1 + "/"
    url2 = baseUrl + "films/" + movieID2 + "/"
    
    apiKeyr = requests.get(url)
    apiKeyr2 = requests.get(url2)
    
    adict = apiKeyr.json()
    adict2 = apiKeyr2.json()
    
    rList = []
    cList = []
    C2List = []
    num = 0
    try:
        for x in adict["characters"]:
            apiKey1 = requests.get(x)
            adict1 = apiKey1.json()
            cList.append(adict1["name"])
    
    
        for y in adict2["characters"]:
            apiKey2 = requests.get(y)
            adict3 = apiKey2.json()
            C2List.append(adict3["name"])
        
    
        for z in cList:
            if z in C2List:
                rList.append(z)
                num += 1
        
    except:
       return(0)
    
    return(num)
    

    


"""
Function Name: spaceDrifting()
Parameters: passengers(int), max price(int)
Returns: list of valid starships (list)
"""

def spaceDrifting(passengers, max_price):
    import requests
    baseUrl = "https://swapi.dev/api/"
    url = baseUrl + "starships/"

    apiKeyr = requests.get(url)
    adict = apiKeyr.json()
    rList = []
    for x in (adict["results"]):
        try:
            if int(x["passengers"]) >= passengers and int(x["cost_in_credits"]) <= max_price:
                rList.append((x["name"], x["manufacturer"]))
        except:
            continue
    return(rList)



"""
Function Name: perfectMatch()
Parameters: list of candidates (list)
Returns: list of potential matches (list)
"""
def perfectMatch(candidates):
    import requests
    baseUrl = "https://swapi.dev/api/"
    url = baseUrl + "people/"
    apiKeyr = requests.get(url)
    adict = apiKeyr.json()
    rList = []
    try:
        for x in adict["results"]:
            if x["name"] in candidates: 
                if x["name"] != "Luke Skywalker" and x["name"] != "Darth Vader":
                    if int(x["height"]) >= 180 and x["gender"] == "male":
                        rList.append(x["name"])
    except:
        return([])
    rList.sort()
    return(rList)
        
                             
                             
    
    







