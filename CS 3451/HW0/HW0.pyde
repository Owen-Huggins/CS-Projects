def setup(): 
    size(600, 600)
    
def draw(): 
    background(255, 255, 255)
    noStroke() 
    baseWidth = width / 3
    base = rect(baseWidth, baseWidth, baseWidth, baseWidth)
    fill(250, 0, 0)
    level = 0 
    baseWidth2 = float(baseWidth / 2)
    s =  baseWidth2
    t = baseWidth2
    x = 300
    y = 300
    print(mouseX, mouseY)
    
    fractal(x, y, s, t, baseWidth2, 2, "a")
    s = s / 2
    t = t / 2
    baseWidth2 = baseWidth2 / 2
    fractal (300, 150, s, t, baseWidth2, 3, "t")
    fractal (450, 300, s, t, baseWidth2, 3, "r")
    fractal(300, 450, s, t, baseWidth2, 3, "b")
    fractal(150, 300, s, t, baseWidth2, 3, "l")
    
    
    s = s / 2
    t = t / 2
    baseWidth2 = baseWidth2 / 2
    fractal (300, 75, s, t, baseWidth2, 4, "t")
    fractal (300, 375, s, t, baseWidth2, 4, "bt")
    fractal (525, 300, s, t, baseWidth2, 4, "r")
    fractal(225, 300, s, t, baseWidth2, 4, "lr")
    fractal(75, 300, s, t, baseWidth2, 4, "l")
    fractal(375, 300, s, t, baseWidth2, 4, "rl")
    fractal(300, 525, s, t, baseWidth2, 4, "b")
    fractal(300, 225, s, t, baseWidth2, 4, "tb")
    fractal(375, 150, s, t, baseWidth2, 4, "tr")
    fractal(225, 150, s, t, baseWidth2, 4, "tl")
    fractal(450, 225, s, t, baseWidth2, 4, "rt")
    fractal(450, 375, s, t, baseWidth2, 4, "rb")
    fractal(375, 450, s, t, baseWidth2, 4, "br")
    fractal(225, 450, s, t, baseWidth2, 4, "bl")
    fractal(150, 225, s, t, baseWidth2, 4, "lt")
    fractal(150, 375, s, t, baseWidth2, 4, "lb")
    
    s = s / 2
    t = t / 2
    baseWidth2 = baseWidth2 / 2
    fractal(300, 37.5, s, t, baseWidth2, 5, "t")
    
   
    
def fractal(x, y, s, t, baseWidth2, level, side): 
    if (level == 1): 
        fill(225, 0 , 0)
    if (level == 2): 
        fill (0, 225, 0)
    if (level == 3): 
        fill (0, 0, 225)
    if (level == 4): 
        fill(20, 75, 100)
    if (level == 5): 
        fill(0, 100, 0)
    if (level == 6): 
        fill(100, 0, 0)

    if (level == 2):
    
        
        
        rect(x - (s / 2) - ((300 - mouseX) * 1),   y - 2 * t, baseWidth2, baseWidth2)
        rect(x + t, y - (t / 2) - ((300 - mouseX) * 1), baseWidth2, baseWidth2)
        rect(x - (2 * s), y - (t / 2) + ((300 - mouseX) * 1), baseWidth2, baseWidth2)
        rect(x - (s / 2) + ((300 - mouseX) * 1), y +  t , baseWidth2, baseWidth2)
    
    
    if (level== 3 ):
        if (side == "t"):
            rect(x - (s / 2) - ((300 - mouseX) * 1.5),   y - 2 * t, baseWidth2, baseWidth2)
            rect(x + t - (300 - mouseX), y - (t / 2) - ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x - (2 * s) - ((300 - mouseX)), y - (t / 2) + ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x - (s / 2) - ((300 - mouseX) * .5), y +  t , baseWidth2, baseWidth2) 
            
        if (side == "r"): 
            rect(x - (s / 2) - ((300 - mouseX) * 0.5),   y - (2 * t) - ((300 - mouseX) * 1), baseWidth2, baseWidth2)
            rect(x + t, y - (t / 2) - ((300 - mouseX) * 1.5), baseWidth2, baseWidth2)
            rect(x - (2 * s) , y - (t / 2) - ((300 - mouseX) * .5), baseWidth2, baseWidth2) 
            rect(x - (s / 2) + ((300 - mouseX) * .5), y +  t - ((300 - mouseX) * 1 ) , baseWidth2, baseWidth2)
            
            
        if (side == "b"): 
            rect(x - (s / 2) + ((300 - mouseX) * 1.5),   y - 2 * t, baseWidth2, baseWidth2)
            rect(x + t + (300 - mouseX), y - (t / 2) + ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x - (2 * s) + ((300 - mouseX)), y - (t / 2) - ((300 - mouseX) * .5), baseWidth2, baseWidth2)  
            rect(x - (s / 2) + ((300 - mouseX) * .5), y +  t , baseWidth2, baseWidth2)
            
            
        if (side == "l"): 
            rect(x - (s / 2) - ((300 - mouseX) * 0.5),   y - (2 * t) + ((300 - mouseX) * 1 ), baseWidth2, baseWidth2)
            rect(x + t, y - (t / 2) + ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x - (2 * s) , y - (t / 2) + ((300 - mouseX) * 1.5), baseWidth2, baseWidth2)
            rect(x - (s / 2) + ((300 - mouseX) * .5), y +  t + ((300 - mouseX) * 1 ) , baseWidth2, baseWidth2)
            
            
            
    if (level == 4): 
        if (side == "t"): 
            rect(x - (s / 2) - ((300 - mouseX) * 1.75),   y - 2 * t, baseWidth2, baseWidth2)
            rect(x + t - ((300 - mouseX) * 1.5), y - (t / 2) - ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (2 * s) - ((300 - mouseX) * 1.5), y - (t / 2) + ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (s / 2) - ((300 - mouseX) * 1.25), y +  t , baseWidth2, baseWidth2)
            
        if (side == "bt"): 
            rect(x - (s / 2) + ((300 - mouseX) * 1.25),   y - 2 * t, baseWidth2, baseWidth2)
            rect(x + t + ((300 - mouseX) * 1.5), y - (t / 2) - ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (2 * s) + ((300 - mouseX) * 1.5), y - (t / 2) + ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (s / 2) + ((300 - mouseX) * 1.75), y +  t , baseWidth2, baseWidth2)
            
            
        if (side == "r"): 
            rect(x - (s / 2) - ((300 - mouseX) * 0.25),   y - (2 * t) - ((300 - mouseX) * 1.5), baseWidth2, baseWidth2)
            rect(x + t, y - (t / 2) - ((300 - mouseX) * 1.75), baseWidth2, baseWidth2)
            rect(x - (2 * s) , y - (t / 2) - ((300 - mouseX) * 1.25), baseWidth2, baseWidth2) 
            rect(x - (s / 2) + ((300 - mouseX) * .25), y +  t - ((300 - mouseX) * 1.5 ) , baseWidth2, baseWidth2)
            
        if (side == "lr"): 
            rect(x - (s / 2) - ((300 - mouseX) * 0.25),   y - (2 * t) + ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x + t, y - (t / 2) + ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (2 * s) , y - (t / 2) + ((300 - mouseX) * .75), baseWidth2, baseWidth2) 
            rect(x - (s / 2) + ((300 - mouseX) * .25), y +  t + ((300 - mouseX) * .5 ) , baseWidth2, baseWidth2)
            
        if (side =="l"): 
            rect(x - (s / 2) - ((300 - mouseX) * 0.25),   y - (2 * t) + ((300 - mouseX) * 1.5 ), baseWidth2, baseWidth2)
            rect(x + t, y - (t / 2) + ((300 - mouseX) * 1.25), baseWidth2, baseWidth2)
            rect(x - (2 * s) , y - (t / 2) + ((300 - mouseX) * 1.75), baseWidth2, baseWidth2)
            rect(x - (s / 2) + ((300 - mouseX) * .25), y +  t + ((300 - mouseX) * 1.5 ) , baseWidth2, baseWidth2)
            
        if (side == "rl"): 
            rect(x - (s / 2) - ((300 - mouseX) * 0.25),   y - (2 * t) - ((300 - mouseX) * .5 ), baseWidth2, baseWidth2)
            rect(x + t, y - (t / 2) - ((300 - mouseX) * .75), baseWidth2, baseWidth2)
            rect(x - (2 * s) , y - (t / 2) - ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (s / 2) +((300 - mouseX) * .25), y +  t - ((300 - mouseX) * .5 ) , baseWidth2, baseWidth2)
            
        if (side == "b"): 
            rect(x - (s / 2) + ((300 - mouseX) * .25),   y - 2 * t, baseWidth2, baseWidth2)
            rect(x + t + ((300 - mouseX) * .5), y - (t / 2) - ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (2 * s) + ((300 - mouseX) * .5), y - (t / 2) + ((300 - mouseX) * .25), baseWidth2, baseWidth2)  
            rect(x - (s / 2) + ((300 - mouseX) * .75), y +  t , baseWidth2, baseWidth2)
            
            
        if (side == "tb"): 
            rect(x - (s / 2) - ((300 - mouseX) * .75),   y - 2 * t, baseWidth2, baseWidth2)
            rect(x + t - ((300 - mouseX) * .5), y - (t / 2) - ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (2 * s) -((300 - mouseX) * .5), y - (t / 2) + ((300 - mouseX) * .25), baseWidth2, baseWidth2)  
            rect(x - (s / 2) - ((300 - mouseX) * .25), y +  t , baseWidth2, baseWidth2)
            
        if (side == "tr"): 
            rect(x - (s / 2) - ((300 - mouseX) * 1.25),   y - (2 * t) - ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x + t - ((300 - mouseX) * 1), y - (t / 2) - ((300 - mouseX) * .75), baseWidth2, baseWidth2)
            rect(x - (2 * s) - ((300 - mouseX) * 1), y - (t / 2) - ((300 - mouseX) * .25), baseWidth2, baseWidth2) 
            rect(x - (s / 2) - ((300 - mouseX) * .75), y +  t - ((300 - mouseX) * .5 ) , baseWidth2, baseWidth2)
            
            
        if (side =="tl"): 
            rect(x - (s / 2) - ((300 - mouseX) * 1.25),   y - (2 * t) + ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x + t - ((300 - mouseX) * 1), y - (t / 2) + ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (2 * s) - ((300 - mouseX) * 1), y - (t / 2) + ((300 - mouseX) * .75), baseWidth2, baseWidth2) 
            rect(x - (s / 2) - ((300 - mouseX) * .75), y +  t + ((300 - mouseX) * .5 ) , baseWidth2, baseWidth2)
            
        if (side == "rt"): 
            rect(x - (s / 2) - ((300 - mouseX) * .75),   y - (2 * t) - ((300 - mouseX) * 1), baseWidth2, baseWidth2)
            rect(x + t - ((300 - mouseX) * .5), y - (t / 2) - ((300 - mouseX) * 1.25), baseWidth2, baseWidth2)
            rect(x - (2 * s) - ((300 - mouseX) * .5), y - (t / 2) - ((300 - mouseX) * .75), baseWidth2, baseWidth2) 
            rect(x - (s / 2) - ((300 - mouseX) * .25), y +  t - ((300 - mouseX) * 1 ) , baseWidth2, baseWidth2)
            
        if (side == "rb"): 
            rect(x - (s / 2) + ((300 - mouseX) * .25),   y - (2 * t) - ((300 - mouseX) * 1), baseWidth2, baseWidth2)
            rect(x + t + ((300 - mouseX) * .5), y - (t / 2) - ((300 - mouseX) * 1.25), baseWidth2, baseWidth2)
            rect(x - (2 * s) + ((300 - mouseX) * .5), y - (t / 2) - ((300 - mouseX) * .75), baseWidth2, baseWidth2) 
            rect(x - (s / 2) + ((300 - mouseX) * .75), y +  t - ((300 - mouseX) * 1 ) , baseWidth2, baseWidth2)
            
            
        if (side == "br"): 
            rect(x - (s / 2) + ((300 - mouseX) * 0.75),   y - (2 * t) + ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x + t + ((300 - mouseX) * 1), y - (t / 2) + ((300 - mouseX) * .25), baseWidth2, baseWidth2)
            rect(x - (2 * s) + ((300 - mouseX) * 1) , y - (t / 2) + ((300 - mouseX) * .75), baseWidth2, baseWidth2) 
            rect(x - (s / 2) + ((300 - mouseX) * 1.25), y +  t + ((300 - mouseX) * .5 ) , baseWidth2, baseWidth2)
            
            
        if (side == "bl"): 
            rect(x - (s / 2) + ((300 - mouseX) * 0.75),   y - (2 * t) - ((300 - mouseX) * .5), baseWidth2, baseWidth2)
            rect(x + t + ((300 - mouseX) * 1), y - (t / 2) - ((300 - mouseX) * .75), baseWidth2, baseWidth2)
            rect(x - (2 * s) + ((300 - mouseX) * 1) , y - (t / 2) - ((300 - mouseX) * .25), baseWidth2, baseWidth2) 
            rect(x - (s / 2) + ((300 - mouseX) * 1.25), y +  t - ((300 - mouseX) * .5 ) , baseWidth2, baseWidth2)
            
            
        if (side == "lt"): 
            rect(x - (s / 2) - ((300 - mouseX) * .75),   y - 2 * t +((300 - mouseX) * 1), baseWidth2, baseWidth2)
            rect(x + t - ((300 - mouseX) * .5), y - (t / 2) + ((300 - mouseX) * .75), baseWidth2, baseWidth2)
            rect(x - (2 * s) - ((300 - mouseX) * .5), y - (t / 2) + ((300 - mouseX) * 1.25), baseWidth2, baseWidth2)
            rect(x - (s / 2) - ((300 - mouseX) * .25), y +  t  + ((300 - mouseX) * 1), baseWidth2, baseWidth2)
            
        if (side == "lb"): 
            rect(x - (s / 2) + ((300 - mouseX) * .25),   y - 2 * t +((300 - mouseX) * 1), baseWidth2, baseWidth2)
            rect(x + t + ((300 - mouseX) * .5), y - (t / 2) + ((300 - mouseX) * .75), baseWidth2, baseWidth2)
            rect(x - (2 * s) + ((300 - mouseX) * .5), y - (t / 2) + ((300 - mouseX) * 1.25), baseWidth2, baseWidth2)
            rect(x - (s / 2) + ((300 - mouseX) * .75), y +  t  + ((300 - mouseX) * 1), baseWidth2, baseWidth2)
            
    if (level == 5): 
        if (side == "t"): 
            rect(x - (s / 2) - ((300 - mouseX) * 1.875),   y - 2 * t, baseWidth2, baseWidth2)
            rect(x + t - ((300 - mouseX) * 1.75), y - (t / 2) - ((300 - mouseX) * .125), baseWidth2, baseWidth2)
            rect(x - (2 * s) - ((300 - mouseX) * 1.75), y - (t / 2) + ((300 - mouseX) * .125), baseWidth2, baseWidth2)
            rect(x - (s / 2) - ((300 - mouseX) * 1.625), y +  t , baseWidth2, baseWidth2)
            
    
