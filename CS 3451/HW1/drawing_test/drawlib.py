# Drawing Routines that are similar to those in OpenGL

from matrix_stack import *
gleft = 0 
gright = 0
gbot = 0
gtop = 0
vertices = []   
gortho = False 
gfov = 0 

def gtOrtho(left, right, bottom, top, near, far):
    global gleft, gright, gbot, gtop, gortho 
    gleft = left 
    gright = right 
    gbot = bottom 
    gtop = top 
    gortho = True 

def gtPerspective(fov, near, far):
    global gfov, gortho  
    gfov = fov  
    gortho = False

def gtVertex(x, y, z):
    global vertices 
    ctm = get_ctm() 
    temp = [x, y, z, 1]
    asdf = vectorAndMatrixMultiplication(temp, ctm) 
    x1 = asdf[0] 
    y2 = asdf [1]
    z3 = asdf[2]    
    
    vertices.append((x1, y2, z3)) 

def gtBeginShape():
    pass
        

def gtEndShape():
    global vertices, gleft, gright, gbot, gtop,  gortho, fov

    if (gortho): 
        i = 0
        while (i < len(vertices) - 1): 
            
            
            x1 = (vertices[i][0] - gleft) * (width / (float(gright - gleft)))
            y1 = height - (vertices[i][1] - gbot)  * (width / (float(gtop - gbot)))
            
            
            x2 = (vertices[i + 1][0] - gleft)  * (width / (float(gright - gleft)))
            y2 = height - (vertices[i + 1][1] - gbot)  * (width / (float(gtop - gbot)))
        
            i += 2
            
            line(x1, y1, x2, y2) 
    else: 
        i = 0
        while (i < len(vertices) - 1):
            theta = radians(gfov)
            k = tan(theta / 2) 
            x1prime = vertices[i][0] / float(abs(vertices[i][2]))
            y1prime = vertices[i][1] / float(abs(vertices[i][2]))
            x2prime = vertices[i + 1][0] / float(abs(vertices[i + 1][2]))
            y2prime = vertices[i + 1][1] / float(abs(vertices[i + 1][2]))
            
            x1 = (float(x1prime + k)) * (width / (float(2 * k)))
            y1 = height - (float(y1prime + k))  * (height / (float(2 * k)))
    
            
            x2 = (float(x2prime + k))  * (width / (float(2 * k)))
            y2 = height - (float(y2prime + k))  * (height / (float(2 * k)))
            
            i += 2
            
            line(x1, y1, x2, y2)
        
    vertices = [] 

        
    
    
def vectorAndMatrixMultiplication (vector, ctm): 
    temp = []
    for i in range(4):
        temp.append(ctm[i][0]*vector[0] + ctm[i][1]*vector[1] + ctm[i][2]*vector[2] + ctm[i][3]*vector[3])
    return temp
