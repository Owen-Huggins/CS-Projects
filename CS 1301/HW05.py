#!/usr/bin/env python3

import calendar

"""
Georgia Institute of Technology - CS1301
HW05 - Lists, Tuples, and Modules
"""

"""
Function Name: maskOrders()
Parameters: list organizations (list), list of members (list), mask price (int)
Returns: list of tuples (list)
"""
def maskOrders(organizations, members, price):
    final = []
    n = 0
    for (idx,val) in enumerate(members):
        members[idx] = val * (price)
    for x in organizations:
        final += (x, members[n]),
        n +=1
    return(final)
        
print(maskOrders(["FTK", "Soccer", "SCPC"], [200, 50, 100], 2))





"""
Function Name: coffeeBreak()
Parameters: list of drinks (list), budget (float)
Returns: name of drink (str)
"""
def coffeeBreak(drink_list, budget):
    most = 0
    fdrink = None
    for num in drink_list:
        (drink, caffine, price) = num
        if price <= budget:            
            if most < caffine:
                most = caffine
                fdrink = drink
           
    return(fdrink)
        

"""
Function Name: myBirthday()
Parameters: gifts (list)
Returns: total balance and gifts (tuple)
"""
def conversion(money):
    if type(money) == str:
        return float(money[1:])
    else: 
        if type(money) == int:
            return '$' + str(money) + '.00'
        else:
            return '$' + str(money) + '0' * (2 - len(str(money).split('.')[1]))

def myBirthday(gifts):
    amount = 0
    presents = ()
    
    for num in gifts:
        if num[0] ==  "$":
            amount += conversion(num)
        else:
            presents +=num,
    final = (("${:,.2f}".format(amount)), )
    for x in presents:
        final  += (x, )
    return(final)

"""
Function Name: roadTrip()
Parameters: state (str), list of tuples (list)
Returns: list of cities (list)
"""
def roadTrip(state, places):
    final = []
    for num in places:
        (city, location) = num
        if location == state:
            if city not in final:
                final += city,
    
    return(final)




"""
Function Name: safeLocation()
Parameters: list of tuples (list)
Returns: safe locations (list)
"""

def safeLocation(places):
    final = []
    for num in places:
        (location, current, total) = (num)
        if current <= (total * .5) and current  != total:
            final += location,
    return(final)


"""
Function Name: eventScheduler()
Parameters: list of tuples (list)
Returns: events (list)
"""
def eventScheduler(events):
    final = []
    year = 20
    c = calendar.TextCalendar(firstweekday = 0)
    for data in events:
        (event, month, date) = data 
        for num in c.itermonthdays2(2020,month):
            if num == (date, 5):
                final.append(event)
            if num == (date, 6)
                final.append(event)
                
    return(final)


