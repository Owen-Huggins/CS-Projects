#ifndef MAIN_H
#define MAIN_H

#include "gba.h"
#include <time.h>


typedef struct player {
  int row;
  int col;

} Player;

typedef enum {
  START,
  STARTTEXT,
  PLAYCLEAR,
  PLAY,
  WIN,
  LOSE,

} GBASTATE;




void playMaze(GBASTATE *state);
void setObstacles(void);

#endif
