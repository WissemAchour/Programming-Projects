#include<SDL/SDL.h>
#include<SDL_image.h>
#include<SDL/SDL_ttf.h>
#include<iostream>
#include <fmod.h>
#include "ball.h"
#include "paddle.h"

SDL_Surface* load_image(const char* c,Uint32 colorkey=0)
{
  SDL_Surface* tmp=IMG_Load(c);
  if(colorkey!=0)
  {
      SDL_SetColorKey(tmp,SDL_SRCCOLORKEY,colorkey);
  }
return tmp;
}

int main(int argc, char **argv)
{char c[5];int i;
TTF_Init();
TTF_Font* font=TTF_OpenFont("cap2.ttf",32);
TTF_Font* font1=TTF_OpenFont("digital.ttf",100);
  SDL_Surface* screen,*text,*icon,*fond;
  SDL_Init(SDL_INIT_EVERYTHING);
  icon=IMG_Load("pong_icon.gif");
  SDL_WM_SetIcon(icon,NULL);
  SDL_WM_SetCaption("Pong Game",NULL);

  screen=SDL_SetVideoMode(640,480,NULL,SDL_SWSURFACE|SDL_DOUBLEBUF);
  fond=IMG_Load("pong_field.jpg");
  SDL_Event event;
  bool run=true;
  Uint32 start;
  int FPS=30;
bool b[4]={0,0,0,0};
paddle player1(load_image("paddle.png"),0,100,6,60,20);
paddle player2(load_image("paddle.png"),620,100,8,60,20);
ball ball1( load_image("ball.png",SDL_MapRGB(screen->format,0,255,0)),230,300,10,10,20,20);

FMOD_SYSTEM *systeme;
FMOD_System_Create(&systeme);
FMOD_System_Init(systeme,2,FMOD_INIT_NORMAL,NULL);
FMOD_SOUND *song=NULL;
FMOD_SOUND *one=NULL;
FMOD_SOUND *two=NULL;
FMOD_SOUND *three=NULL;
FMOD_SOUND *laser=NULL;
FMOD_SOUND *space=NULL;
FMOD_System_CreateSound(systeme,"pong.wav",FMOD_CREATESAMPLE,0,&song);
FMOD_System_CreateSound(systeme,"1.wav",FMOD_CREATESAMPLE,0,&one);
FMOD_System_CreateSound(systeme,"2.wav",FMOD_CREATESAMPLE,0,&two);
FMOD_System_CreateSound(systeme,"3.wav",FMOD_CREATESAMPLE,0,&three);
FMOD_System_CreateSound(systeme,"3.wav",FMOD_CREATESAMPLE,0,&three);
FMOD_System_CreateSound(systeme,"laser.wav",FMOD_CREATESAMPLE,0,&laser);
FMOD_System_CreateSound(systeme,"space.wav",FMOD_CREATESAMPLE,0,&space);
start=SDL_GetTicks();
SDL_Rect pos={320-40,240-50};
SDL_Color color1={0,0,0};
  SDL_Color color2={255,255,255};
 FMOD_System_PlaySound(systeme,FMOD_CHANNEL_FREE,three,0,NULL);
 etq2:if(SDL_GetTicks()-start>4000)
 goto etq1;
 else if(SDL_GetTicks()-start<1000)
 {   text=TTF_RenderText_Solid(font1,"3",color2);
     SDL_BlitSurface(text,NULL,screen,&pos);
     SDL_Flip(screen);

 }
  else if(SDL_GetTicks()-start==1000)
  {FMOD_System_PlaySound(systeme,FMOD_CHANNEL_FREE,two,0,NULL);
 text=TTF_RenderText_Solid(font1,"3",color1);
  SDL_BlitSurface(text,NULL,screen,&pos);
  SDL_Flip(screen);
  }
 else if(SDL_GetTicks()-start>1000&&SDL_GetTicks()-start<2000)
  {
      text=TTF_RenderText_Solid(font1,"2",color2);
      SDL_BlitSurface(text,NULL,screen,&pos);
     SDL_Flip(screen);}
else if(SDL_GetTicks()-start==2000)
{   FMOD_System_PlaySound(systeme,FMOD_CHANNEL_FREE,one,0,NULL);
     text=TTF_RenderText_Solid(font1,"2",color1);
      SDL_BlitSurface(text,NULL,screen,&pos);
     SDL_Flip(screen);}

else if(SDL_GetTicks()-start>2000&&SDL_GetTicks()-start<3000)
  {
      text=TTF_RenderText_Solid(font1,"1",color2);
      SDL_BlitSurface(text,NULL,screen,&pos);
     SDL_Flip(screen);}
else if(SDL_GetTicks()-start==3000)
{FMOD_System_PlaySound(systeme,FMOD_CHANNEL_FREE,space,0,NULL);
      text=TTF_RenderText_Solid(font1,"1",color1);
      SDL_BlitSurface(text,NULL,screen,&pos);
     SDL_Flip(screen);}
     else if(SDL_GetTicks()-start<4000)
  {SDL_Rect pos={320-70,240-50};
      text=TTF_RenderText_Solid(font1,"GO!!!",color2);
      SDL_BlitSurface(text,NULL,screen,&pos);
     SDL_Flip(screen);}

 goto etq2;
 while(run)
 {start=SDL_GetTicks();
     etq1:
     while(SDL_PollEvent(&event))
       {
           switch(event.type)
           {case SDL_QUIT:
             run=false;
             break;
             case  SDL_KEYDOWN:
             switch(event.key.keysym.sym)
             {
              case  SDLK_UP:
             b[0]=1;
              break;
               case  SDLK_DOWN:
             b[1]=1;
              break;
            case  SDLK_q:
             b[2]=1;
              break;
              case  SDLK_e:
             b[3]=1;
              break;
              case SDLK_p:
              ball1.stop();
               break;
             }
            break;
             case  SDL_KEYUP:
             switch(event.key.keysym.sym)
             {
              case  SDLK_UP:
             b[0]=0;
              break;
               case  SDLK_DOWN:
             b[1]=0;
              break;
            case  SDLK_q:
             b[2]=0;
              break;
              case  SDLK_e:
             b[3]=0;
              break;

             }
           break;
           }
           }
if(b[0])
player1.moveup();
if(b[1])
player1.movedown();
if(b[2])
player2.moveup();
if(b[3])
player2.movedown();

player2.cpu(player2.getrect(),ball1.getrect());
ball1.move(player1.getrect(),player2.getrect(),song,systeme);

switch(ball1.out(laser,systeme))
{
    case 1:

     player2.score();
     player1.back(0,100,6,60,20);
     ball1.back(230,300,10,10,20,20);
     player2.back(620,100,8,60,20);

     break;

     case 2:

     player1.score();
     player1.back(0,100,6,60,20);
     ball1.back(230,300,10,10,20,20);
     player2.back(620,100,8,60,20);

     break;

}
//SDL_FillRect(screen,&screen->clip_rect,SDL_MapRGB(screen->format,255,255,255));

 //SDL_SetAlpha(fond,SDL_SRCALPHA,20);
SDL_BlitSurface(fond,NULL,screen,NULL);
player1.show();
player2.show();
ball1.show();
SDL_Rect tmp={5,5};
sprintf(c,"%d",player1.getpoint());
text=TTF_RenderText_Solid(font,c,color1);
SDL_BlitSurface(text,NULL,screen,&tmp);
tmp={620,5};
sprintf(c,"%d",player2.getpoint());
color1={0,0,0};
text=TTF_RenderText_Solid(font,c,color1);
SDL_BlitSurface(text,NULL,screen,&tmp);
SDL_Flip(screen);


if(1000/FPS>(SDL_GetTicks()-start))
SDL_Delay(1000/FPS-(SDL_GetTicks()-start));
       }
SDL_FreeSurface(text);
SDL_FreeSurface(icon);
TTF_CloseFont(font);
TTF_Quit();
SDL_QUIT;

}
