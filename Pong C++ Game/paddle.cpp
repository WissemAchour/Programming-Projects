#include "paddle.h"
#include "ball.h"
#include <time.h>

paddle::paddle(SDL_Surface* img,int x,int y, int yVel,int h,int w)
{
   box.x=x;
   box.y=y;
   box.h=h;
   box.w=w;
   yvel=yVel;
   image=img;
   point=0;

}
paddle::~paddle()
{
    SDL_FreeSurface(image);
}

void paddle::moveup()
{if(box.y>0)
 box.y-=yvel;

}
void paddle::movedown()
{if(box.y+box.h<SDL_GetVideoSurface()->clip_rect.h)
 box.y+=yvel;

}
 void paddle::show()
 {
SDL_BlitSurface(image,NULL,SDL_GetVideoSurface(),&box);
 }

   SDL_Rect* paddle::getrect()
   {
     return &box;
   }

   void paddle::score()
   {
       point++;
   }
void paddle::back(int x,int y, int yVel,int h,int w)
{
    box.x=x;
   box.y=y;
   box.h=h;
   box.w=w;
   yvel=yVel;
}

int paddle::getpoint()
{
    return point;
}
void paddle::cpu(SDL_Rect* rect1,SDL_Rect* rect2)
{int nbr;
    if(((rect2->x+rect2->w)>210)&&rect2->x+rect2->w<rect1->x  )
     {if(rect1->y<rect2->y)
         {rect1->y+=yvel;

         if(rect1->y+rect1->h>SDL_GetVideoSurface()->clip_rect.h)
         rect1->y-=yvel;
         }
        if(rect1->y>rect2->y)
        rect1->y-=yvel;

   /* else if((rect2->x+rect2->w)<380)
    rect1->y=rect1->y;*/
     }
}





