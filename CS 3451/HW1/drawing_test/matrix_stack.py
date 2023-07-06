#by Owen Huggins 

class myStack(object):
    def __init__(self): 
        self.stack = [] 
    def gtPop(self): 
        if (len(self.stack) == 1): 
            print ("Error, gtPop only has one matrix")
        self.stack.pop() 
        
    def gtPush(self, item): 
        self.stack.append(item)
        
    def gtPeek(self):  
        return (self.stack[- 1])
    
    def gtUpdate(self, new): 
        self.stack[-1] = new
        
    def gtClear(self): 
        self.stack = [] 
        

gtStack = myStack() 


def matrixMultiplication(old, transformation): 
    temp = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
    for x in range(4): 
        for y in range(4): 
            for z in range(4): 
                temp[x][y] += old[x][z] * transformation[z][y]
    return temp


def gtInitialize():
    gtStack.gtClear()
    gtStack.gtPush([[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]])

def gtPopMatrix():
    gtStack.gtPop()

def gtPushMatrix():
    temp = gtStack.gtPeek()
    newArray = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
    for i in range(4): 
        for j in range(4): 
            newArray[i][j] = temp[i][j]
    gtStack.gtPush(newArray)

def gtScale(x,y,z):
    s = [[x, 0, 0, 0], [0, y, 0, 0], [0, 0, z, 0], [0, 0, 0, 1]]
    temp = gtStack.gtPeek() 
    copyArray = matrixMultiplication(temp, s) 
    gtStack.gtUpdate(copyArray)
    
def gtTranslate(x,y,z):
    t = [[1, 0, 0, x], [0, 1, 0,   y], [0, 0, 1, z], [0, 0, 0, 1]]
    temp = gtStack.gtPeek() 
    copyArray = matrixMultiplication(temp, t) 
    gtStack.gtUpdate(copyArray)

def gtRotateX(theta):
    theta = radians(theta) 
    temp = gtStack.gtPeek()
    rx = [[1, 0, 0, 0], [0, cos(theta), -sin(theta), 0], [0, sin(theta), cos(theta), 0], [0, 0, 0, 1]]
    copyArray = matrixMultiplication(temp, rx) 
    gtStack.gtUpdate(copyArray)

def gtRotateY(theta):
    theta = radians(theta) 
    temp = gtStack.gtPeek()
    ry = [[cos(theta), 0, sin(theta), 0], [0, 1, 0, 0], [-sin(theta), 0, cos(theta), 0], [0, 0, 0, 1]]
    copyArray = matrixMultiplication(temp, ry) 
    gtStack.gtUpdate(copyArray) 

def gtRotateZ(theta):
    theta = radians(theta) 
    temp = gtStack.gtPeek()
    rz = [[cos(theta), -sin(theta), 0, 0], [sin(theta), cos(theta), 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]]
    copyArray = matrixMultiplication(temp, rz) 
    gtStack.gtUpdate(copyArray)

def print_ctm():
    temp = gtStack.gtPeek() 
    for i in range(4): 
        print temp[i] 
        print("")

def get_ctm(): 
    return gtStack.gtPeek() 
