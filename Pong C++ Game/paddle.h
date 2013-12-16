#include<SDL/SDL.h>
#ifndef PADDLE_H_INCLUDED
#define PADDLE_H_INCLUDED

#include "ball.h"


class paddle
{ SDL_Surface *image;
   SDL_Rect box;
   int yvel;
   int point;
    public:
   paddle(SDL_Surface* img,int x,int y, int yVel,int h,int w);
   ~paddle();
    SDL_Rect* getrect();
   void moveup();
   void movedown();
   void show();
   void score();
   void back(int x,int y, int yVel,int h,int w);
   int getpoint();
   void cpu(SDL_Rect* rect1,SDL_Rect* rect2);
};


#endif // PADDLE_H_INCLUDED
