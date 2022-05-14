#!/usr/bin/env python3
"""
Georgia Institute of Technology - CS1301
HW10 - Object Oriented Programming
"""

class Room: # entire class provided
    def __init__(self, name): 
        self.name = name

    def __eq__(self, other):
        return self.name == other.name
        
    def __repr__(self): 
        return "Room(name: {})".format(self.name)

class Task:
    def __init__(self,name, isCompleted=False):
        self.name = name
        self.isCompleted = isCompleted
    def __eq__(self, other):
        return self.name ==  other.name and self.isCompleted == other.isCompleted

    def __repr__(self): # provided
        return "Task(name: {}, isCompleted: {})".format(self.name, self.isCompleted)

class Crewmate:
    def __init__(self, name, color, accessories=()):
        self.name = name
        self.color = color
        self.accessories = accessories
        self.isAlive = True
        self.tasksDone = 0
    def doTask(self, Task):
        if Task.isCompleted != True:
            Task.isCompleted = True
            self.tasksDone +=1
        return "Nothing to do here"
    
    def vote(self, AmongUs):
        for x in AmongUs.crewmates:
            if self.name[0] == x.name[0] and self.name != x.name and x.isAlive == True:
                return x
        for y in AmongUs.impostors:
            if self.name[0] == y.name[0] and self.name != y.name and y.isAlive == True:
                return y
    
    def callMeeting(self, AmongUs):
        voted = []
        max_voted = {}
        counter = 0 
        voted_out = ""
        for person in AmongUs.crewmates:
            add = (person.vote(AmongUs)).name
            voted.append(add)
        for imp in AmongUs.impostors:
            add = (imp.vote(AmongUs)).name
            voted.append(add)
        for x in voted:
            if x in max_voted:
                max_voted[x] += 1
            else:
                max_voted[x] =1
        for key in max_voted:
            if max_voted[key] > counter:
                counter = max_voted[key]
                voted_out = key

                
        for people in AmongUs.crewmates:
            if voted_out == people.name: 
                people.isAlive = False
        for person in AmongUs.impostors:
            if voted_out == person.name:
                person.isAlive = False
        
        
    
        
        
 
    def __repr__(self): # provided 
        return "Crewmate(name: {}, color: {})".format(self.name, self.color)

    def __eq__(self, other): # provided
        return (self.name, self.color, self.accessories) == (other.name, other.color, other.accessories)

class Impostor:
    def __init__(self, name, color, accessories =()):
        self.name = name
        self.color = color
        self.accessories = accessories
        self.isAlive = True
        self.eliminateCount = 0
    def eliminate(self, killed):
        self.killed = killed
        if isinstance(killed, Crewmate) == False:
            return "They're on your team -_-"
        else:
            killed.isAlive = False
            self.eliminateCount += 1
    def vote(self, AmongUs):
        for x in AmongUs.crewmates:
            if self.name[0] == x.name[0] and self.name != x.name and x.isAlive == True:
                return x
        for y in AmongUs.impostors:
            if self.name[0] == y.name[0] and self.name != y.name and y.isAlive == True:
                return y
    def __str__(self):
        return "My name is {} and I'm an impostor.".format(self.name)
    

    def __repr__(self): # provided
        return "Impostor(name: {}, color: {})".format(self.name, self.color)

    def __eq__(self, other): # provided 
        return (self.name, self.color, self.accessories) == (other.name, other.color, other.accessories)

class AmongUs:
    def __init__(self, maxPlayers, rooms ={}, crewmates =[], impostors=[]):
        self.maxPlayers = maxPlayers
        self.rooms = rooms
        self.crewmates = crewmates
        self.impostors = impostors
        
    def registerPlayer(self, player):
        self.player = player
        if self.maxPlayers == 0:
            return "Lobby is full."
        if len(self.crewmates) + len(self.impostors) == self.maxPlayers:
            return "Lobby is full."
        if player in self.crewmates:
            return "Player with name: {} exists.".format(player.name)
        if player in self.impostors:
            return "Player with name: {} exists.".format(player.name)
        if isinstance(player, Crewmate) == True:
            self.crewmates.append(player)
        if isinstance(player, Impostor) == True:
            self.impostors.append(player)
    
    def registerTask(self, Task, Room):
        for x in self.rooms.values():
            if [Task] == x:
                return "This task has already been registered."
        else:
            self.rooms[Room.name] = [Task]
        
    

        
    def gameOver(self):
        total_alive = 0
        total_impostors = 0
        for x in self.crewmates:
            if x.isAlive == True:
                total_alive +=1
        for y in self.impostors:
            if y.isAlive == True:
                total_impostors +=1
        if total_alive == 0:
            return "Defeat! All crewmates have been eliminated."
        if total_impostors == 0:
            return "Victory! All impostors have been eliminated."
        else:
            return "Game is not over yet!"
                
            
        
    

    def __repr__(self): # provided
        return "AmongUs(maxPlayers: {})".format(self.maxPlayers)



print(Crewmate callMeeting: among_us.crewmates = [Crewmate("a", "b"), Crewmate("ab", "b"), Crewmate("abc", "b"), Crewmate("d", "b"), , Crewmate("db", "b")], among_us.impostors = [Impostor("lc", "b"), sol.Impostor("l", "b")])

