#include<SDL/SDL.h>
#include<iostream>
#include<fstream>
#include<SDL_image.h>
#include<vector>
#include "base.h"
#include "player.h"
#include "bullet.h"
#ifndef GAME_H
#define GAME_H


class game:base
{
SDL_Surface* screen,*back,*block,*fire;
SDL_Rect camera;
bool direction[3];
bool gun;
void showmap();
SDL_Surface* load(const char* filename);
void handle_events();
bool run;
void load_map(const char* file);
int frame1;
int frame2;

bullet* bullets;
    public:
        game();
        ~game();
        void start();

};

#endif // GAME_H
