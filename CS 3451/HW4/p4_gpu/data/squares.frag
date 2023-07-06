// Fragment shader

#ifdef GL_ES
precision mediump float;
precision mediump int;
#endif

#define PROCESSING_LIGHT_SHADER

// These values come from the vertex shader
varying vec4 vertColor;
varying vec3 vertNormal;
varying vec3 vertLightDir;
varying vec4 vertTexCoord;

void main() { 
  vec2 center = vec2(0.5, 0.5); 
  float x = abs(vertTexCoord.x - center.x );
  float y = abs(vertTexCoord.y - center.y );
  mat2 rotation = mat2(cos(radians(45)), sin(radians(45)), -sin(radians(45)), cos(radians(45)));
  vec2 temp = rotation * vec2(x, y);
  vec2 coord = vec2(temp.x + center.x, temp.y + center.y);
  x = abs(coord.x - center.x );
  y = abs(coord.y - center.y );
  if (x <= 0.07) {
  if ((y <= 0.07) || (y >= 0.1 && y <= 0.25) || (y >= 0.30 && y <= 0.45)) {
        gl_FragColor = vec4(0.0, 1.0, 1.0, 0);
  } else {
    gl_FragColor = vec4(0.0, 1.0, 1.0, 1);
  }
} else if (x >= 0.1 && x <= 0.25) {
  if ((y <= 0.07) || (y >= 0.1 && y <= 0.25) ) {
        gl_FragColor = vec4(0.0, 1.0, 1.0, 0);
  } else {
    gl_FragColor = vec4(0.0, 1.0, 1.0, 1);
  }
} else if (x >= 0.30 && x <= 0.45) {
  if ((y <= 0.07)) {
        gl_FragColor = vec4(0.0, 1.0, 1.0, 0);
  } else {
    gl_FragColor = vec4(0.0, 1.0, 1.0, 1);
  }
} else {
  gl_FragColor = vec4(0.0, 1.0, 1.0, 1);
}
        
 
}

