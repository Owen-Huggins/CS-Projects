

"""
Georgia Institute of Technology - CS1301
HW01 - Functions and Expressions
"""

#########################################

"""
Function Name: listen()
Parameters: N/A
Returns: None
"""




def listen():
    pass
    songs = int(input("how many songs did you listen to?" ))
    num_songs = songs
    podcasts = int(input("how many podcast did you listen to?" ))
    num_podcasts = podcasts

    minuntes = (3*songs) + (25*podcasts)

    hours = minuntes // 60
 
    remaining_minuntes = ((minuntes/60) - hours) *60
    remaining_minuntes = int(round(remaining_minuntes, 1))
    
    print("By listening to", num_songs, "songs and", num_podcasts,"podcasts,", "you have spent", hours, "hours and", remaining_minuntes, "minutes on Spotify.")
   
listen()


#########################################

"""
Function Name: dominosTime()
Parameters: N/A
Returns: None
"""


def dominosTime():
    pass
    pizzas = int(input("how many pizzas would you like?" ))
    pasta = int(input("how many orders of pasta would you like?" ))
    wings = int(input("how many orders of chicken wings would you like?" ))

    price = (12*pizzas) + (6*pasta) + (8*wings)
    string_price = str(price)

    print("By ordering", pizzas, "pizzas,", pasta, "orders of pasta, and", wings, "orders of chicken wings, your order total comes to", "$" + string_price + ".")

dominosTime()
#########################################

"""
Function Name: tipAndSplit()
Parameters: N/A
Returns: None
"""


def tipAndSplit():
    pass
    order_total = int(input("What was the order total?" ))
    tip_percent = int(input("What percentage would you like to tip?" ))
    split = int(input("How many people are splitting the tip?" ))

    tip = order_total * (tip_percent /100)
    person_paid = (order_total + tip) / split    
    
    
    string_tip = str(tip)
    string_person_paid = str(round(person_paid,2))
    
    print("The driver got a tip of $" + string_tip + ". Each person paid $" + string_person_paid + ".")
    
    
tipAndSplit()

#########################################

"""
Function Name: youtuber()
Parameters: N/A
Returns: None
"""



def youtuber():
    pass
    videos = int(input("How many videos have you made?" ))
    ads = float(input("How much do you get paid per view?" ))
    views = int(input("How many views do your videos get?" ))

    money = videos * ads * views
    round(money, 2)
    
    string_money = str(money)

    print("You have made $" + string_money, "by making YouTube videos!")

youtuber()

#########################################

"""
Function Name: bathBomb()
Parameters: N/A
Returns: None
"""


def bathBomb():
    pass
    radius = float(input("What is the radius of the bath bomb?" ))
    volume = (radius**3) *(4/3) * 3.14

    volume = round(volume, 2)
    string_volume = str(volume)   

    
    print("The volume of a bath bomb with radius", radius, "is", string_volume+ ".")
    
bathBomb()
