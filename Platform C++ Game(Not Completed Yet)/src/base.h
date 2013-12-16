#ifndef BASE_H_INCLUDED
#define BASE_H_INCLUDED
#include<SDL/SDL.h>
#include<iostream>
class base{

    public:
    bool collision(SDL_Rect* rect1,SDL_Rect* rect2);
    static SDL_Rect coord;
    static  const int tile=30;
};

#endif // BASE_H_INCLUDED
