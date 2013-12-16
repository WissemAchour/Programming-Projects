#include "player.h"
player::player(SDL_Surface* img)
{image=img;
box.x=10;
box.y=SDL_GetVideoSurface()->clip_rect.h-400;
xvel=0;
yvel=0;
ground=0;
jump=0;
for(int i=0;i<10;i++)
{clips[i].x=i*44;
 clips[i].y=0;
clips[i].h=43;
 clips[i].w=45;
}
//map2=new map;
}
player::~player()
{
    SDL_FreeSurface(image);
}

SDL_Rect* player::getrect()
{
    return &box;
}

int player::getxvel()
{
    return xvel;
}

void player::setxvel(int vel)
{
xvel=vel;
}

void player::showplayer()
{
    SDL_BlitSurface(image,&clips[1],SDL_GetVideoSurface(),&box);
    SDL_SetColorKey(image,SDL_SRCCOLORKEY,SDL_MapRGB(SDL_GetVideoSurface()->format,255,0,255));
}

void player::move()
{bool nc=0;
int carte[16][21]={
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,0 ,1, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 0 ,1 ,1, 0 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{0, 0, 0 ,0 ,0, 1 ,1 ,1, 2 ,0, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{1, 1, 1 ,1 ,1, 1 ,1 ,1, 1 ,1, 1 ,1, 1, 1 ,1 ,1, 1 ,1, 1 ,1, 1}
};

  for(int i=0;i<16;i++)
    for(int j=0;j<21;j++)
        if(carte[i][j]!=0)
     {SDL_Rect destrect={j*tile-base::coord.x,i*tile,tile,tile};
         if(collision(&box,&destrect))
         {

            if(destrect.y>=box.y+box.h-6)
             {nc=1;
                 ground=1;
                 yvel=0;
             }

             else if(destrect.y+destrect.h<=box.y+6)
             {
               box.y=destrect.y+destrect.h;

             }

    if(box.x+box.w>=destrect.x&&box.y+box.h>=destrect.y+5&&box.x+box.w<=destrect.x+2)
    {
        xvel=0;
        box.x--;
    }
    else if(box.x<=destrect.x+destrect.w&&box.y+box.h>=destrect.y+5)
    {xvel=0;
      box.x++;
    }
         }

     }
       if(!nc&&!jump)
          yvel=5;
        if(jump&&box.y<5)
        yvel++;
        else
        jump=0;
     box.x+=xvel;
  box.y+=yvel;

}


void player::setjump()
{
   if(ground&&!jump)
   {
       jump=1;
       ground=0;
       yvel=-50;
       box.y-=5;
   }

}
