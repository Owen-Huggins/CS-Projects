# Object Modeling Example Code
# I am duplicating the stars 

from __future__ import division
import traceback

time = 0   # time is used to move objects from one frame to another

def setup():
    size (800, 800, P3D)
    try:
        frameRate(120)       # this seems to be needed to make sure the scene draws properly
        perspective (60 * PI / 180, 1, 0.1, 1000)  # 60-degree field of view
    except Exception:
        traceback.print_exc()

def draw():
    try:
        global time 
        time += 0.01
        

        

        background (0, 0, 0)  # clear screen and set background to light blue
        
        # set up the lights
        ambientLight(50, 50, 50);
        lightSpecular(255, 255, 255)
        directionalLight (100, 100, 100, -0.3, 0.5, -1)
        
        # set some of the surface properties
        noStroke()
        
        
        
        
        def Mario(): 
            
            # Mario's Face 
            fill (255, 217, 135)
            pushMatrix()
        # translate (0, 8 * sin(4 * time), 0)  # move up and down
            scale(2, 2.3, 2) 
            translate(0, 0, -5)
            sphereDetail(60)  # this controls how many polygons make up each sphere
            sphere(15)
            popMatrix()
            
            #Eyes 
            fill(255, 255, 255) 
            pushMatrix() 
            translate (-7, -6, 10)
            scale(.8, 1, 1)
            sphereDetail(60) 
            sphere(10) 
            popMatrix() 
            
            fill(255, 255, 255) 
            pushMatrix() 
            translate (7, -6, 10)
            scale(.8, 1, 1)
            sphereDetail(60) 
            sphere(10) 
            popMatrix() 
            
            #Color of Eyes 
            fill(0, 1, 252) 
            pushMatrix() 
            translate (-7.5, -7, 16)
            scale(.8, 1, 1)
            sphereDetail(60) 
            sphere(5) 
            popMatrix()
            
            fill(0, 1, 252) 
            pushMatrix() 
            translate (7.5, -7, 16)
            scale(.8, 1, 1)
            sphereDetail(60) 
            sphere(5) 
            popMatrix()
            
            #Iris 
            fill(0, 0, 0) 
            pushMatrix() 
            translate (-7.5, -7, 18)
            scale(.8, 1, 1.1)
            sphereDetail(60) 
            sphere(3) 
            popMatrix()
            
            fill(0, 0, 0) 
            pushMatrix() 
            translate (7.5, -7, 18)
            scale(.8, 1, 1.1)
            sphereDetail(60) 
            sphere(3) 
            popMatrix()
            
            
            
            #Nose 
            fill (255, 217, 135)
            pushMatrix()
            scale(1.8, 1.3, 1.5) 
            translate(0, 3, 17) 
            sphereDetail(60)  # this controls how many polygons make up each sphere
            sphere(7)
            popMatrix()
            
            #Ears 
            fill (255, 217, 135)
            pushMatrix()
            rotate(-10)
            scale(2.7, 2, 1) 
            translate(-9, -8, -1)   
            
            sphereDetail(60)  # this controls how many polygons make up each sphere
            sphere(5)
            popMatrix()
            
            fill (255, 217, 135)
            pushMatrix()
            rotate(10)
            scale(2.7, 2, 1) 
            translate(9, -8, -1) 
            sphereDetail(60)  # this controls how many polygons make up each sphere
            sphere(5)
            popMatrix()
            
            
            #Hat 
            fill(254, 0, 2) 
            pushMatrix()
            translate(0, -18, 1) 
            box(45, 5, 45)
            popMatrix()
            
            pushMatrix() 
            translate(0, -20, -14) 
            scale(1.3, .9, 1.2)
            sphereDetail(60)  # this controls how many polygons make up each sphere
            sphere(25)
            popMatrix() 
            
            
            #Mustache 
            fill(106, 4, 0) 
            pushMatrix()
            translate(0, 12, 18)
            scale(1.4, .5, .2)
            box(15)
            popMatrix() 
            
            #RM 
            fill(106, 4, 0) 
            pushMatrix()
            translate(12, 11.5, 18.3)
            scale(1, .9, .2)
            rotate(-5)
            box(8.2)
            popMatrix() 
            
            #LM 
            fill(106, 4, 0) 
            pushMatrix()
            translate(-12, 11.5, 18.3)
            scale(1, .9, .2)
            rotate(5)
            box(8.2)
            popMatrix() 
            
            
            #Left Eyebrow 
            fill(106, 4, 0) 
            pushMatrix() 
            rotate(-10)
            translate(3, 18, 15) 
            scale(1.2, .2, .2) 
            rotate(5)
            box(8.2) 
            popMatrix() 
            
            
            
            #right Eyebrow 
            fill(106, 4, 0) 
            pushMatrix() 
            rotate(10)
            translate(-3, 18, 15) 
            scale(1.2, .2, .2) 
            rotate(-5)
            box(8.2) 
            popMatrix() 
            
        def Star():
            #Star 
            fill (252, 207, 0)
            pushMatrix() 
            translate(20, 30, 30) 
            scale(1, 1, 0.01)
            scale(15, 15, 15)
            cone() 
            popMatrix()
            
            
                
            fill (252, 207, 0)
            pushMatrix() 
            translate(40, 45, 30) 
            scale(1, 1, 0.01)
            scale(15, 15, 15)
            rotate(radians(90))
            cone() 
            popMatrix()
            
            
            fill (252, 207, 0)
            pushMatrix() 
            translate(0, 45, 30) 
            scale(1, 1, 0.01)
            scale(15, 15, 15)
            rotate(radians(-90))
            cone() 
            popMatrix()
            
            
            
            fill (252, 207, 0)
            pushMatrix() 
            translate(10, 60, 30) 
            scale(1, 1, 0.01)
            scale(15, 15, 15)
            rotate(radians(-160))
            cone() 
            popMatrix()
            
            fill (252, 207, 0)
            pushMatrix() 
            translate(30, 60, 30) 
            scale(1, 1, 0.01)
            scale(15, 15, 15)
            rotate(radians(160))
            cone() 
            popMatrix()
        
            fill(252, 207, 0) 
            pushMatrix() 
            translate(20, 50, 30) 
            scale(1, 1, 0.01) 
            box(10) 
            popMatrix() 
            
            
        
        
       
        
        
        
        if time <= 2.0: 
            pushMatrix()
            Mario()
            popMatrix()
            
            camera (0, -150 + (time * 75), 25 + (time * 100), 0, 0, 0, 0,  1, 0)
            
        if time > 2.0 and time <= 3.0: 
            pushMatrix() 
            rotateX(radians(15 * (time - 2))) 
            rotateY(radians(30 * (time - 2))) 
            Mario()
            popMatrix()
            
        if time > 3.0 and time <= 4.0: 
            pushMatrix() 
            directionalLight(252, 207, 0, -1, 1, 0)
            rotateX(radians(15)) 
            rotateY(radians(30)) 
            Mario() 
            popMatrix()
            
        if time > 4.0 and time <= 7: 
            pushMatrix() 
            directionalLight(252, 207, 0, -1, 1, 0)
            rotateX(radians(15 + (time * 4))) 
            rotateY(radians(30 - (time * 4))) 
            Mario() 
            popMatrix()
            
            pushMatrix() 
            pointLight(252, 207, 0, 400 - (75 * time), -150, -30)
            translate(400 - (75 * time), -150, -30) 
            Star() 
            popMatrix()
            
            pushMatrix() 
            pointLight(252, 207, 0, 500 - (75 * time), -150, -30)
            translate(500 - (75 * time), -150, -30) 
            Star() 
            popMatrix()
            
            pushMatrix() 
            pointLight(252, 207, 0, 600 - (75 * time), -150, -30)
            translate(600 - (75 * time), -150, -30) 
            Star() 
            popMatrix()
            
        if time > 7 and time <= 10: 
            pushMatrix() 
            directionalLight(252, 207, 0, -1, 1, 0)
            rotateX(radians(15 + (7 * 4))) 
            rotateY(radians(30 - (7 * 4))) 
            Mario() 
            popMatrix()
            
            pushMatrix() 
            pointLight(252, 207, 0, 400 - (75 * 7), -150, -30)
            translate(400 - (75 * 7), -150, -30) 
            Star() 
            popMatrix()
            
            pushMatrix() 
            pointLight(252, 207, 0, 500 - (75 * 7), -150, -30)
            translate(500 - (75 * 7), -150 + ((time - 7) * 25), -30) 
            rotateY(radians(360 * time))
            Star() 
            popMatrix()
            
            pushMatrix() 
            pointLight(252, 207, 0, 600 - (75 * 7), -150, -30)
            translate(600 - (75 * 7), -150, -30) 
            Star() 
            popMatrix()
            
        if time > 10 and time <= 11: 
            pushMatrix() 
            rotateX(radians(45 - (45 * (time - 10))))
            Mario() 
            popMatrix()
            
        if time > 11 and time <= 13: 
            pushMatrix() 
            
            r1 = random(255) 
            r2 = random(255) 
            r3 = random(255) 
            background(r1, r2, r3)
            rotateY(radians(720 * time)) 
            translate(0, 0 -((time - 11) * 75), -5) 
            Mario() 
            popMatrix() 
            
        
        
        
       
        
        
   
    except Exception:
        traceback.print_exc()
        
        
        
    # cylinder with radius = 1, z range in [-1,1]
def cylinder(sides = 50):
    # first endcap
    beginShape()
    for i in range(sides):
        theta = i * 2 * PI / sides
        x = cos(theta)
        y = sin(theta)
        vertex ( x,  y, -1)
    endShape(CLOSE)
    # second endcap
    beginShape()
    for i in range(sides):
        theta = i * 2 * PI / sides
        x = cos(theta)
        y = sin(theta)
        vertex ( x,  y, 1)
    endShape(CLOSE)
    # round main body
    x1 = 1
    y1 = 0
    for i in range(sides):
        theta = (i + 1) * 2 * PI / sides
        x2 = cos(theta)
        y2 = sin(theta)
        beginShape()
        normal (x1, y1, 0)
        vertex (x1, y1, 1)
        vertex (x1, y1, -1)
        normal (x2, y2, 0)
        vertex (x2, y2, -1)
        vertex (x2, y2, 1)
        endShape(CLOSE)
        x1 = x2
        y1 = y2
        
def cone(sides=50):
    sides = int(sides)

    # draw triangles making up the sides of the cone
    for i in range(sides):
        theta = 2.0 * PI * i / sides
        theta_next = 2.0 * PI * (i + 1) / sides
        
        beginShape()
        normal(cos(theta), 0.6, sin(theta))
        vertex(cos(theta), 1.0, sin(theta))
        normal(cos(theta_next), 0.6, sin(theta_next))
        vertex(cos(theta_next), 1.0, sin(theta_next))
        normal(0.0, -1.0, 0.0)
        vertex(0.0, -1.0, 0.0)
        endShape()

    # draw the cap of the cone
    beginShape()
    for i in range(sides):
        theta = 2.0 * PI * i / sides
        vertex(cos(theta), 1.0, sin(theta))
    endShape()
