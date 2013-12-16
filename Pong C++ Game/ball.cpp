#include "ball.h"

ball::ball(SDL_Surface* img,int x, int y, int xVel,int yVel,int h, int w)
{
  image=img;
  box.x=x;
  box.y=y;
  xvel=xVel;
  yvel=yVel;
  box.h=h;
  box.w=w;
}
ball::~ball()
{
     SDL_FreeSurface(image);
}
void ball::show()
{
 SDL_BlitSurface(image,NULL,SDL_GetVideoSurface(),&box);//car on n'a pas le screen

}

void ball::move(SDL_Rect* player1,SDL_Rect* player2,FMOD_SOUND* song,FMOD_SYSTEM* systeme)
{
  box.x+=xvel;
  box.y+=yvel;

  if(box.y+box.h>=SDL_GetVideoSurface()->clip_rect.h+10)
  yvel=-yvel;
if(box.y<=0)
yvel=-yvel;
if(collision1(&box,player1))
    {
        xvel=-xvel;
  FMOD_System_PlaySound(systeme,FMOD_CHANNEL_FREE,song,0,NULL);

    }
if(collision2(&box,player2))
   {
       xvel=-xvel;
   FMOD_System_PlaySound(systeme,FMOD_CHANNEL_FREE,song,0,NULL);

   }

}
bool ball::collision1(SDL_Rect* rect1,SDL_Rect* rect2)
{
  if(rect1->y>=rect2->y+rect2->h)
  return 0;
  if(rect1->x-3>=rect2->x+rect2->w)
  return 0;
  if(rect1->x+rect1->w<=rect2->x)
  return 0;
  if(rect1->y+rect1->h<=rect2->y)
  return 0;
  return 1;
}

bool ball::collision2(SDL_Rect* rect1,SDL_Rect* rect2)
{
  if(rect1->y>=rect2->y+rect2->h)
  return 0;
  if(rect1->x>=rect2->x+rect2->w)
  return 0;
  if(rect1->x+rect1->w+3<=rect2->x)
  return 0;
  if(rect1->y+rect1->h<=rect2->y)
  return 0;
  return 1;
}
void ball::stop()
{
  SDL_Delay(200);
}

int ball::out(FMOD_SOUND* laser,FMOD_SYSTEM* systeme)
{if(box.x<=-10)
{FMOD_System_PlaySound(systeme,FMOD_CHANNEL_FREE,laser,0,NULL);return 1; }
if(box.x>=SDL_GetVideoSurface()->clip_rect.w-10)
{FMOD_System_PlaySound(systeme,FMOD_CHANNEL_FREE,laser,0,NULL);return 2;}
return 0;
}

void ball::back(int x, int y, int xVel,int yVel,int h, int w)
{
     box.x=x;
  box.y=y;
  xvel=xVel;
  yvel=yVel;
  box.h=h;
  box.w=w;
  SDL_Delay(700);
}
SDL_Rect* ball::getrect()
   {
     return &box;
   }
