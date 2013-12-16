#ifndef BULLET_H
#define BULLET_H
#include <SDL/SDL.h>

class bullet
{
SDL_Rect box;
    int xvel,yvel;
    SDL_Surface* image;

    public:

        bullet(SDL_Surface* img,int x,int y,int xVel,int yVel);
       // ~bullet();
      SDL_Rect* getx();
      void move();
      void show();
};

#endif // BULLET_H
