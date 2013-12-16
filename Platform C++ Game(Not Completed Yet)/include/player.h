#ifndef PLAYER_H
#define PLAYER_H
#include<SDL/SDL.h>
#include<SDL_image.h>
#include<iostream>
#include "base.h"
#include "game.h"
#include "map.h"
class player:base
{
    SDL_Rect box;
    SDL_Surface* image;
    int xvel,yvel;
    SDL_Rect clips[10];
    bool ground;
    bool jump;
    public:
    player(SDL_Surface* img);
    ~player();
    SDL_Rect* getrect();
    void move();
    void showplayer();
    void setjump();
//    map* map2;
    int getxvel();
    void setxvel(int vel);

};

#endif // PLAYER_H
