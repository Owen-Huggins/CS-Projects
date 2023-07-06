# Provided code for Subdivison and Geodesic Spheres

from __future__ import division
import traceback

# parameters used for object rotation by mouse
mouseX_old = 0
mouseY_old = 0
rot_mat = PMatrix3D()
vTable = [] 
gTable = []
oTable = {}
currentCorner = 0
showCurrentCorner = False 
showRandomColors = False

class PVector:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    def __repr__(self):
        return "PVector(%f, %f, %f)" % (self.x, self.y, self.z)

    def __add__(self, other):
        return PVector.add(self, other)

    def __mul__(self, n):
        return PVector.mult(self, n)

    def __rmul__(self, n):
        return PVector.mult(self, n)

    def mag(self):
        return sqrt(self.x * self.x + self.y * self.y + self.z * self.z)

    def magSq(self):
        return self.x * self.x + self.y * self.y + self.z * self.z

    def copy(self):
        return PVector(self.x, self.y, self.z)

    def div(self, n):
        return PVector(
            self.x / n,
            self.y / n,
            self.z / n,
        )

    @staticmethod
    def dist(a, b):
        return PVector.sub(a, b).mag()

    @staticmethod
    def add(a, b):
        return PVector(
            a.x + b.x,
            a.y + b.y,
            a.z + b.z,
        )

    @staticmethod
    def sub(a, b):
        return PVector(
            a.x - b.x,
            a.y - b.y,
            a.z - b.z,
        )

    @staticmethod
    def mult(a, n):
        return PVector(
            n * a.x,
            n * a.y,
            n * a.z,
        )

    @staticmethod
    def pairwise_mult(a, b):
        return PVector(
            a.x * b.x,
            a.y * b.y,
            a.z * b.z,
        )

    @staticmethod
    def dot(a, b):
        return a.x * b.x + a.y * b.y + a.z * b.z

    @staticmethod
    def cross(a, b):
        return PVector(
            a.y * b.z - a.z * b.y,
            a.z * b.x - a.x * b.z,
            a.x * b.y - a.y * b.x,
        )

    def normalize(self):
        mag = sqrt(self.x * self.x + self.y * self.y + self.z * self.z)
        self.x /= mag
        self.y /= mag
        self.z /= mag
        return self
    
def print_mesh():
    global vTable, oTable, gTable
    print "Vertex table (maps corner num to vertex num):"
    print "corner num\tvertex num:"
    for c, v in enumerate(vTable):
        print c, "\t\t", v
    print ""

    print "Opposite table (maps corner num to opposite corner num):"
    print "corner num\topposite corner num"
    for c, o in oTable.iteritems():
        print c, "\t\t", o
    print ""

    print "Geometry table (maps vertex num to position): "
    print "vertex num\tposition:"
    for v, g in enumerate(gTable):
        print v, "\t\t", g
    print ""

    print ""
    print ""

def nextCorner(cornerNum): 
    triangleNum = cornerNum // 3
    return 3 * triangleNum + ((cornerNum + 1) % 3) 

def previousCorner(cornerNum): 
    triangleNum = cornerNum // 3
    return 3 * triangleNum + ((cornerNum - 1) % 3) 

def oppositeCorner(cornerNum): 
    global oTable
    return oTable[cornerNum]

def swingCorner(cornerNum): 
    return  nextCorner(oppositeCorner(nextCorner(cornerNum)))

def computeOTable(G, V): 
    global oTable
    temp = []
    
    for i in range(0, len(V)): 
        temp.append([min(V[nextCorner(i)], V[previousCorner(i)]), max(V[nextCorner(i)], V[previousCorner(i)]), i])
    print(temp)
    
    sortedTriplets = sorted(temp)
    
    print(sortedTriplets)
    for i in range(0, len(sortedTriplets), 2): 
        cornerA = sortedTriplets[i][2]
        cornerB = sortedTriplets[i + 1][2]
        oTable[cornerA] = cornerB 
        oTable[cornerB] = cornerA
        
def inflate(): 
    #Then, in keyPressed section, when the inflate key is pressed, update G table by calling this function
    global gTable
    for i in range(len(gTable)): 
        (gTable[i].normalize()) 
    return gTable

def subdivision(): 
    global vTable, oTable, gTable
    numEdges = len(vTable) // 2
    newGTable = gTable
    newVTable = []
    midPoints = {} 
    for a, b in oTable.items(): 
        endPoint1 = gTable[vTable[previousCorner(a)]]
        endPoint2 = gTable[vTable[nextCorner(a)]]
        midPoint = PVector.mult(PVector.add(endPoint1, endPoint2), 0.5) #use PVector Mult 
        midPointIndex = len(newGTable) 
        newGTable.append(midPoint) 
        midPoints[a] = midPointIndex
        
        endPoint1 = gTable[vTable[previousCorner(b)]]
        endPoint2 = gTable[vTable[nextCorner(b)]]
        midPoint = PVector.mult(PVector.add(endPoint1, endPoint2), 0.5) #use PVector Mult 
        midPointIndex = len(newGTable) 
        newGTable.append(midPoint) 
       
        midPoints[b] = midPointIndex
   
    for i in range(0, len(vTable), 3): 
        y = i + 1 
        z = i + 2 
        newVTable.extend([vTable[i], midPoints[z], midPoints[y]])
        newVTable.extend([midPoints[z], vTable[y], midPoints[i]])
        newVTable.extend([midPoints[y], midPoints[i], vTable[z]])
        newVTable.extend([midPoints[i], midPoints[z], midPoints[y]])
    gTable = newGTable 
    vTable = newVTable 
    computeOTable(gTable, vTable)
    

# initalize things
def setup():
    size (800, 800, OPENGL)
    frameRate(30)
    noStroke()

# draw the current mesh (you will modify parts of this routine)
def draw():
    randomSeed(0)
    global vTable, gTable, showRandomColors, currentCornerVisible, oTable, currentCorner
    background (100, 100, 180)    # clear the screen to black
   
    perspective (PI*0.2, 1.0, 0.01, 1000.0)
    camera (0, 0, 6, 0, 0, 0, 0, 1, 0)    # place the camera in the scene
    
    # create an ambient light source
    ambientLight (102, 102, 102)

    # create two directional light sources
    lightSpecular (202, 202, 202)
    directionalLight (100, 100, 100, -0.7, -0.7, -1)
    directionalLight (152, 152, 152, 0, 0, -1)
    
    pushMatrix();

    stroke (0)                    # draw polygons with black edges
    fill (200, 200, 200)          # set the polygon color to white
    ambient (200, 200, 200)
    specular (0, 0, 0)            # turn off specular highlights
    shininess (1.0)
    
    applyMatrix (rot_mat)   # rotate the object using the global rotation matrix

    # THIS IS WHERE YOU SHOULD DRAW YOUR MESH
    if showCurrentCorner: 
        pushMatrix()
        currentVertex = gTable[vTable[currentCorner]]
        translate(currentVertex.x, currentVertex.y, currentVertex.z)
        sphere(0.1) 
        popMatrix()
    
    
    
    for c in range(0, len(vTable), 3): 
        if showRandomColors: 
            fill(random(255), random(255), random(255))
        else: 
            fill(255, 255, 255)
        beginShape()
        
       
        vertex (gTable[vTable[c]].x, gTable[vTable[c]].y, gTable[vTable[c]].z)
        vertex (gTable[vTable[c + 1]].x, gTable[vTable[c + 1]].y, gTable[vTable[c + 1]].z)
        vertex (gTable[vTable[c + 2]].x, gTable[vTable[c + 2]].y, gTable[vTable[c + 2]].z)
        
        endShape(CLOSE)
       
    
    popMatrix()

# read in a mesh file (this needs to be modified)
def read_mesh(filename):
    global gTable, vTable, oTable
    fname = "data/" + filename
    # read in the lines of a file
    with open(fname) as f:
        lines = f.readlines()

    # determine number of vertices (on first line)
    words = lines[0].split()
    num_vertices = int(words[1])
    print "number of vertices =", num_vertices

    # determine number of faces (on first second)
    words = lines[1].split()
    num_faces = int(words[1])
    print "number of faces =", num_faces

    # read in the vertices
    for i in range(num_vertices):
        words = lines[i+2].split()
        x = float(words[0])
        y = float(words[1])
        z = float(words[2])
        p1 = PVector(x, y, z)
        gTable.append(p1)
        print "vertex: ", x, y, z

    # read in the faces
    for i in range(num_faces):
        j = i + num_vertices + 2
        words = lines[j].split()
        nverts = int(words[0])
        if (nverts != 3):
            print "error: this face is not a triangle"
            exit()

        index1 = int(words[1])
        index2 = int(words[2])
        index3 = int(words[3])
        vTable.extend([index1, index2, index3])
        print "triangle: ", index1, index2, index3
    computeOTable(gTable, vTable)
    print_mesh()
# make sure proper error messages get reported when handling key presses
def keyPressed():
    try:
        handleKeyPressed()
    except Exception:
        traceback.print_exc()

# process key presses (call your own routines!)
def handleKeyPressed():
    global currentCorner, showRandomColors, showCurrentCorner, gTable, vTable, oTable
    if key == '1':
        read_mesh ('tetra.ply')
    elif key == '2':
        read_mesh ('octa.ply')
    elif key == '3':
        read_mesh ('icos.ply')
    elif key == '4':
        read_mesh ('star.ply')
    elif key == 'n': # next
        currentCorner = nextCorner(currentCorner)
    elif key == 'p': # previous
        currentCorner = previousCorner(currentCorner)
    elif key == 'o': # opposite
        currentCorner = oppositeCorner(currentCorner)
    elif key == 's': # swing
        currentCorner = swingCorner(currentCorner)
    elif key == 'd': # subdivide mesh
        subdivision()
        print_mesh()
    elif key == 'i': # inflate mesh
        inflate()
    elif key == 'r': # toggle random colors
        showRandomColors = not showRandomColors
    elif key == 'c': # toggle showing current corner
        showCurrentCorner = not showCurrentCorner
    elif key == 'q': # quit the program
        exit()

# remember where the user first clicked
def mousePressed():
    global mouseX_old, mouseY_old
    mouseX_old = mouseX
    mouseY_old = mouseY

# change the object rotation matrix while the mouse is being dragged
def mouseDragged():
    global rot_mat
    global mouseX_old, mouseY_old
    
    if (not mousePressed):
        return
    
    dx = mouseX - mouseX_old
    dy = mouseY - mouseY_old
    dy *= -1

    len = sqrt (dx*dx + dy*dy)
    if (len == 0):
        len = 1
    
    dx /= len
    dy /= len
    rmat = PMatrix3D()
    rmat.rotate (len * 0.005, dy, dx, 0)
    rot_mat.preApply (rmat)

    mouseX_old = mouseX
    mouseY_old = mouseY


    
