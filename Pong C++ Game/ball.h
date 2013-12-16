#include <SDL/SDL.h>
#ifndef BALL_H_INCLUDED
#define BALL_H_INCLUDED
#include <fmod.h>

class ball
{int xvel,yvel;
  SDL_Surface* image;
  SDL_Rect box;
  bool collision1(SDL_Rect* rect1,SDL_Rect* rect2);
  bool collision2(SDL_Rect* rect1,SDL_Rect* rect2);
  public:
 ball(SDL_Surface* img,int x, int y, int xVel,int yVel,int h, int w);
 ~ball();
  void show();
   void move(SDL_Rect* player1,SDL_Rect* player2,FMOD_SOUND*,FMOD_SYSTEM* );
   void stop();
   int out(FMOD_SOUND*,FMOD_SYSTEM*);
  SDL_Rect* getrect();
   void back(int x, int y, int xVel,int yVel,int h, int w);
};
#endif // BALL_H_INCLUDED
