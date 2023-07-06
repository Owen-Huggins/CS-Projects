# The routine below should draw your initials in perspective

from matrix_stack import *
from drawlib import *

def persp_initials():
    gtInitialize()
    gtPerspective(60,-100,100)
    gtPushMatrix()
    gtTranslate(0, 0, -4)
    gtRotateX(50)
    gtRotateY(70)
    O() 
    H() 
    gtPopMatrix()
    
    
def O(): 
    gtBeginShape()
    gtVertex(-1.0, 1.0, 0)
    gtVertex(0.0, 1.0, 0) 
    
    gtVertex(0.0, 1.0, 0)
    gtVertex(0.0, -1.0, 0)
    
    gtVertex(0.0, -1.0, 0)
    gtVertex(-1.0, -1.0, 0)
    
    gtVertex(-1.0, -1.0, 0)
    gtVertex(-1.0, 1.0, 0)
    gtEndShape()
    
def H(): 
    gtBeginShape()
    gtVertex(1.0, 1.0, 0) 
    gtVertex(1.0, 0.0, 0) 
    
    gtVertex(2.0, 1.0, 0) 
    gtVertex(2.0, 0.0, 0) 
    
    gtVertex(1.0, .5, 0) 
    gtVertex(2.0, .5, 0)


    gtEndShape()
