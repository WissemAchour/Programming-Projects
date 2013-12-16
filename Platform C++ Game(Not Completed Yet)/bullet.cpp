#include "bullet.h"

bullet::bullet(SDL_Surface* img,int x,int y,int xVel,int yVel)
{
   image=img;
   box.x=x;
   box.y=y;
   box.w=image->w;
   box.h=image->h;
   xvel=xVel;
   yvel=yVel;
}

void bullet::move()
{
    box.x+=xvel;
    box.y+=yvel;
}

void bullet::show()
{
    SDL_BlitSurface(image,NULL,SDL_GetVideoSurface(),&box);
}

SDL_Rect* bullet::getx()
{
    return &box;
}
