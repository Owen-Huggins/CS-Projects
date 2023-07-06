# This is the provided code for the ray tracing project.
#
# The most important part of this code is the command interpreter, which
# parses the scene description (.cli) files.

from __future__ import division
import traceback

debug_flag = False   # print debug information when this is True
class Light: 
    def __init__ (self, x, y, z, r, g, b): 
        self.pos = PVector(x, y, z)
        self.lightColor = [r, g, b]
        
        
class Sphere: 
    def __init__ (self, x, y, z, r, m): 
        
        self.center =  [x, y, z]
        self.radius = r 
        self.material = currentMaterial
    def __str__ (self): 
        return"%s, radius, center, material.diffuseColor %s" ( self.radius, self.center, self.material.diffuseColor)
        
class Material: 
    def __init__ (self, dr, dg, db, ar, ag, ab, sr, sg, sb, specularPower, kRefi): 
        self.diffuseColor = (dr, dg, db)
        self.ambientColor = (ar, ag, ab)
        self.specularColor = (sr, sg, sb)
        self.specularPower = specularPower
        self.kRefi = kRefi 
        
class Ray: 
    def __init__ (self, origin, direction): 
        
        self.origin = origin  
        self.direction = direction

class Hit: 
    def __init__ (self, Shape, normalVector, tValue, intersectionPoint, ray): 
        self.Shape = Shape 
        self.normalVector = normalVector # normalized(intersectionPoint - center of Sphere) 
        self.tValue = tValue 
        self.intersectionPoint = intersectionPoint #plug tValue into ray eq 
        self.ray = ray
    def __str__ (self): 
        return " tValue is %s,, intersectionPoint is %s," % (self.tValue, self.intersectionPoint)
    
class Triangle: 
    def __init__ (self, a, b, c, m): 
    
        self.A = PVector(a[0], a[1], a[2])
        self.B = PVector(b[0], b[1], b[2])
        self.C = PVector(c[0], c[1], c[2])
        
       
        
        self.ab = PVector.sub(self.B, self.A).normalize() # precompute the sides of the triangle
        self.bc = PVector.sub(self.C, self.B).normalize()
        self.ca = PVector.sub(self.A, self.C).normalize()
        
        self.N = (PVector.cross(self.ab, self.bc)).normalize()
    
    
        
        self.material = currentMaterial
        
    def __str__ (self): 
        return"%s, verticies, , material.diffuseColor %s" ( self.verticies,  self.material.diffuseColor)
    
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
        
    

Lights = [] 
shapes = [] 
uvw = [] 
backgroundColor = color(0, 0, 0)
fov = 0
currentMaterial = 0
eyePos = [] 
verticies = [] 
shadowTerm = 1

def setup():
    size(320, 320) 
    noStroke()
    colorMode(RGB, 1.0)  # Processing color values will be in [0, 1]  (not 255)
    background(0, 0, 0)
    frameRate(30)

# make sure proper error messages get reported when handling key presses
def keyPressed():
    try:
        handleKeyPressed()
    except Exception:
        traceback.print_exc()

# read and interpret a scene description .cli file based on which key has been pressed
def handleKeyPressed():
    if key == '1':
        interpreter("01_one_sphere.cli")
    elif key == '2':
        interpreter("02_three_spheres.cli")
    elif key == '3':
        interpreter("03_shiny_sphere.cli")
    elif key == '4':
        interpreter("04_many_spheres.cli")
    elif key == '5':
        interpreter("05_one_triangle.cli")
    elif key == '6':
        interpreter("06_icosahedron_and_sphere.cli")
    elif key == '7':
        interpreter("07_colorful_lights.cli")
    elif key == '8':
        interpreter("08_reflective_sphere.cli")
    elif key == '9':
        interpreter("09_mirror_spheres.cli")
    elif key == '0':
        interpreter("10_reflections_in_reflections.cli")
    elif key == '-':
        interpreter("11_star.cli")

# You should add code for each command that calls routines that you write.
# Some of the commands will not be used until Part B of this project.
def interpreter(fname):
    global Lights, shapes, uvw, backgroundColor, fov, currentMaterial, eyePos, verticies, triangles 
    reset_scene()  # you should initialize any data structures that you will use here
    
    fname = "data/" + fname
    # read in the lines of a file
    with open(fname) as f:
        lines = f.readlines()

    # parse the lines in the file in turn
    for line in lines:
        words = line.split()  # split up the line into individual tokens
        if len(words) == 0:   # skip empty lines
            continue
        if words[0] == 'sphere':
            x = float(words[2])
            y = float(words[3])
            z = float(words[4])
            radius = float(words[1])
            newSphere = Sphere(x, y, z, radius, currentMaterial) 
            shapes.append(newSphere) 
            
        elif words[0] == 'fov':
            fov = float(words[1]) 
            
        elif words[0] == 'eye':
            eyePos = [float(words[1]), float(words[2]), float(words[3])] 
            
        elif words[0] == 'uvw':
            uvw = [[float(words[1]), float(words[2]), float(words[3])], [float(words[4]), float(words[5]), float(words[6])] , [float(words[7]), float(words[8]), float(words[9])] ] 
            
        elif words[0] == 'background':
            backgroundColor = [float(words[1]), float(words[2]), float(words[3])] 
            
        elif words[0] == 'light':
            l1 = Light(float(words[1]), float(words[2]), float(words[3]), float(words[4]), float(words[5]), float(words[6]))
            Lights.append(l1)
            
        elif words[0] == 'surface':
            currentMaterial = Material(float(words[1]), float(words[2]), float(words[3]), float(words[4]), float(words[5]), float(words[6]), float(words[7]), float(words[8]), float(words[9]), float(words[10]), float(words[11]) )
            
        elif words[0] == 'begin':
            verticies = []
        elif words[0] == 'vertex':
             verticies.append((float(words[1]), float(words[2]), float(words[3])))
        elif words[0] == 'end':
            newTriangle = Triangle(verticies[0], verticies[1], verticies[2], currentMaterial)
            shapes.append(newTriangle) 
        elif words[0] == 'render':
            render_scene()    # render the scene (this is where most of the work happens)
        elif words[0] == '#':
            pass  # ignore lines that start with the comment symbol (pound-sign)
        else:
            print ("unknown command: " + word[0])

# render the ray tracing scene
def render_scene():
    global debug_flag, Lights, shapes, uvw, backgroundColor, fov, currentMaterial, eyePos
    d = float( 1 / tan(radians(fov / 2)))
    for j in range(height):
        for i in range(width):
            
            U = float(((2 * i) / width) - 1)
            V = -float(((2 * j) / height) - 1)
            
            x1 = (-d * uvw[2][0])
            x2 = (-d * uvw[2][1])
            x3 = (-d * uvw[2][2])
            x = [x1, x2, x3] 
            
          
            y1 = (V * uvw[1][0])
            y2 = (V * uvw[1][1])
            y3 = (V * uvw[1][2])
            y = [y1, y2, y3]
           
           
            z1 = (U * uvw[0][0])
            z2 = (U * uvw[0][1])
            z3 = (U * uvw[0][2])
            z = [z1, z2, z3]
            
            
            
            rayDirection = PVector(x1 + y1 + z1, x2 + y2 + z2, x3 + y3 + z3).normalize()
            pos = PVector(eyePos[0], eyePos[1], eyePos[2])
            r1 = Ray(pos, rayDirection)            
            sceneHit = rayIntersectScene(r1)
            shades = backgroundColor 
            if sceneHit != None: 
                shades = (shade(sceneHit, sceneHit.ray, 10))
            
            pix_color = color(shades[0], shades[1], shades[2])
            
            # Maybe set a debug flag to true for ONE pixel.
            # Have routines (like ray/sphere intersection)print extra information if this flag is set.
            debug_flag = False
            if i == 208 and j == 254:
                debug_flag = True
                


            # create an eye ray for pixel (i,j) and cast it into the scene
            
            
            set (i, j, pix_color)         # draw the pixel with the calculated color
    

def rayIntersectScene(ray): 
    global shapes, backgroundColor
    mInt = 999999999999
    nearestHit = None
    
    for Shape in shapes: 
        if isinstance(Shape, Sphere): 
            
            dx = ray.direction.x
            dy = ray.direction.y
            dz = ray.direction.z
            ux = ray.origin.x - Shape.center[0]
            uy = ray.origin.y - Shape.center[1]
            uz = ray.origin.z - Shape.center[2]
            
            A = ((dx ** 2) + (dy ** 2) + (dz ** 2))
            B = (( 2 * dx * ux) + (2 * dy * uy) + (2 * dz * uz))
            C = ((ux ** 2) + (uy ** 2) + (uz ** 2) - (Shape.radius ** 2))
            
            if (sqrt((B ** 2) - (4 * A * C)) < 0): 
                continue
        
            t2 = (((-1 * B) - sqrt((B ** 2) - (4 * A * C))) / (2 * A))
            
            if t2 < mInt and t2 > 0:
                mInt = t2 
                intersectionPoint = [(ray.origin.x + (mInt * dx)), (ray.origin.y + (mInt * dy)), (ray.origin.z + (mInt * dz))]
                x = intersectionPoint[0] - Shape.center[0]
                y = intersectionPoint[1] - Shape.center[1]
                z = intersectionPoint[2] - Shape.center[2]
                intersectionPoint = PVector(intersectionPoint[0], intersectionPoint[1], intersectionPoint[2])
                normalVector = PVector(x, y, z).normalize()
                h1 = Hit(Shape, normalVector, mInt, intersectionPoint, ray)
                nearestHit = h1   
                
                    
        if isinstance(Shape, Triangle):             
            
            num = PVector.dot(Shape.N, PVector.sub(Shape.A, ray.origin))
            dem = PVector.dot(Shape.N, ray.direction)
            if dem != 0: 
                t = num / dem               
                
                if t > 0  and t < mInt:
                    P = PVector.add(ray.origin, PVector.mult(ray.direction, t ))
                    triple1 = PVector.dot(PVector.cross(PVector.sub(P, Shape.A),   PVector.sub(Shape.B, Shape.A)), Shape.N)
                    triple2 = PVector.dot(PVector.cross(PVector.sub(P, Shape.B),   PVector.sub(Shape.C, Shape.B)), Shape.N)
                    triple3 = PVector.dot(PVector.cross(PVector.sub(P, Shape.C),   PVector.sub(Shape.A, Shape.C)), Shape.N)                 
                    
                                            
                    if (triple1 > 0) == (triple2 > 0) == (triple3 > 0): 
                        mInt = t
                        hitNormal = Shape.N
                        if PVector.dot(Shape.N, ray.direction) >= 0: 
                            hitNormal = PVector.mult(Shape.N, -1)
                    
                        h1 = Hit(Shape, hitNormal, mInt, P, ray)
                        nearestHit = h1
    return (nearestHit)
    
    
def shade(h1, rr, maxDepth): 
    global Lights
    r = 0 
    g = 0 
    b = 0
    if h1 == None: 
        return backgroundColor
    if maxDepth > 0 and h1.Shape.material.kRefi > 0:
        
        offset = PVector.mult(h1.normalVector, 0.001)
        reflectOrigin = PVector.add(h1.intersectionPoint, offset)
        reflectDirection = PVector.add(rr.direction, PVector.mult(h1.normalVector, (PVector.dot(h1.normalVector, rr.direction) * -2) )).normalize()
        reflectRay = Ray(reflectOrigin, reflectDirection)
        reflectHit = rayIntersectScene(reflectRay)
        reflectColor = shade(reflectHit, reflectRay, maxDepth -1) 
        r += reflectColor[0]* h1.Shape.material.kRefi
        g += reflectColor[1]* h1.Shape.material.kRefi
        b += reflectColor[2]* h1.Shape.material.kRefi
    for light in Lights: 
        shadowTerm = 1
        if h1 != None: 
            offset = PVector.mult(h1.normalVector, 0.0001)
            shadowOrigin = PVector.add(h1.intersectionPoint, offset)
            shadowDirection = PVector.sub(light.pos, h1.intersectionPoint).normalize()
            temp = Ray(shadowOrigin, shadowDirection)
            shadow = rayIntersectScene(temp)
            if shadow != None: 
                if debug_flag:
                    print(h1.intersectionPoint)
                    print(shadowOrigin)
                    print "checking shadow for light with position: ", light.pos
                    print "hit position: ", h1.intersectionPoint
                    print "shadow ray origin (should be the hit position slightly offset away from the surface): ", h1.ray.origin 
                    print "shadow ray direction: ", h1.ray.direction
                    
                    print "distance from light to original hit:", PVector.dist(light.pos, h1.intersectionPoint)
                    print ""
            if shadow != None and h1.tValue < PVector.dist(light.pos, h1.intersectionPoint) and h1.tValue > 0: 
                shadowTerm = 0
                
        if isinstance(h1.Shape, Sphere): 
            N = PVector(h1.intersectionPoint.x - h1.Shape.center[0], h1.intersectionPoint.y - h1.Shape.center[1], h1.intersectionPoint.z - h1.Shape.center[2]).normalize()
            L = PVector(light.pos.x - h1.intersectionPoint.x, light.pos.y - h1.intersectionPoint.y, light.pos.z - h1.intersectionPoint.z).normalize()
            
        if isinstance(h1.Shape, Triangle): 
            N = h1.normalVector.normalize()
            L = PVector(light.pos.x - h1.intersectionPoint.x, light.pos.y - h1.intersectionPoint.y, light.pos.z - h1.intersectionPoint.z).normalize()
            
        nDotL = max(PVector.dot(N, L), 0)
        D = h1.ray.direction
        H = (PVector.sub(L, D)).normalize()
            
        
        r += (((h1.Shape.material.diffuseColor[0] * light.lightColor[0] * nDotL) + (h1.Shape.material.specularColor[0] * light.lightColor[0] * (max(0, PVector.dot(H, N)** h1.Shape.material.specularPower)))) * shadowTerm)
        g += (((h1.Shape.material.diffuseColor[1] * light.lightColor[1] * nDotL) + (h1.Shape.material.specularColor[1] * light.lightColor[1] * (max(0, PVector.dot(H, N)** h1.Shape.material.specularPower)))) * shadowTerm)
        b += (((h1.Shape.material.diffuseColor[2] * light.lightColor[2] * nDotL) + (h1.Shape.material.specularColor[2] * light.lightColor[2] * (max(0, PVector.dot(H, N)** h1.Shape.material.specularPower)))) * shadowTerm)
    
    r += h1.Shape.material.ambientColor[0]  
    g += h1.Shape.material.ambientColor[1]  
    b += h1.Shape.material.ambientColor[2]  
            
    shades = [r, g, b]
    return shades



def dotProduct(v1, v2):
    num = 0.0
    for x in range(len(v1)): 
        num += float(v1[x] * v2[x])
    return num
    

def normalizeVector(x, y, z): 
    dem = sqrt((x ** 2) + (y ** 2) + (z ** 2))
    final = [float(x / dem), float(y / dem), float(z / dem)]
    return final 
    

# here you should reset any data structures that you will use for your scene (e.g. list of spheres)
def reset_scene():
    global Lights, shapes, uvw, backgroundColor, fov, currentMaterial, eyePos 
    Lights = [] 
    shperes = [] 
    uvw = [] 
    backgroundColor = 0
    fov = 0
    currentMaterial = 0 
    eyePos = []

# prints mouse location clicks, for help debugging
def mousePressed():
    print ("You pressed the mouse at " + str(mouseX) + " " + str(mouseY))

# this function should remain empty for this assignment
def draw():
    pass
