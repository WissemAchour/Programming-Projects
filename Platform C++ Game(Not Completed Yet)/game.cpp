#include "game.h"
SDL_Rect base::coord;
game::game()
{
    SDL_Init(SDL_INIT_EVERYTHING);
    screen=SDL_SetVideoMode(640,480,32,SDL_SWSURFACE|SDL_DOUBLEBUF);
    block=load("brick_f.png");
    back=load("level.png");
    fire=load("bullet.png");
     base::coord.x=camera.x=0;
     base::coord.y=camera.y=0;
     base::coord.h=camera.h=480;
     base::coord.w=camera.w=640;
     frame1=5;
     frame2=0;
      player player1(IMG_Load("megaman.gif"));
  direction[2]=direction[0]=direction[1]=0;
    gun=0;
    run=true;
}

SDL_Surface* game::load(const char* filename)
{
    SDL_Surface* tmp=IMG_Load(filename);
    SDL_Surface* tmp2=SDL_DisplayFormat(tmp);
    SDL_FreeSurface(tmp);
    return tmp2;
}

game::~game()
{
    SDL_FreeSurface(back);
    SDL_FreeSurface(block);
    SDL_FreeSurface(fire);
    delete bullets;
    SDL_Quit();
}

void game::handle_events()
{player player1(IMG_Load("megaman.gif"));
    SDL_Event event;
while(SDL_PollEvent (&event))
{ switch(event.type)
    {
        case SDL_QUIT:
        run=false;
        break;
        case SDL_KEYDOWN:
        switch(event.key.keysym.sym)
        {case SDLK_LEFT:
            direction[0]=1;
            break;

            case SDLK_RIGHT:
            direction[1]=1;
            break;

            case SDLK_SPACE:
            direction[2]=1;
            break;

            case SDLK_e:

           gun=1;
           break;
        }
        break;

        case SDL_KEYUP:
        switch(event.key.keysym.sym)
        {case SDLK_LEFT:
            direction[0]=0;
            break;

            case SDLK_RIGHT:
            direction[1]=0;
            break;

            case SDLK_SPACE:
            direction[2]=0;
            break;

            case SDLK_e:
            gun=0;
           break;
        }
        break;


    }

}

}

void game::showmap()
{int carte[16][21]={
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
{0, 0, 0 ,0 ,0, 1 ,1 ,1, 2 ,1, 0 ,0, 0, 0 ,0 ,0, 0 ,0, 0 ,0, 0},
{1, 1, 1 ,1 ,1, 1 ,1 ,1, 1 ,1, 1 ,1, 1, 1 ,1 ,1, 1 ,1, 1 ,1, 1}
};
for(int i=0;i<16;i++)
for(int j=0;j<21;j++) //coz they are the same (lines)
    if(carte[i][j]!=0)
    {
       SDL_Rect blockrect={(carte[i][j]-1)*tile,0,tile,tile}; //choisir la pièce
        SDL_Rect destrect={j*tile-base::coord.x,i*tile,tile,tile};
        SDL_BlitSurface (block,&blockrect,screen,&destrect);
    }
}



void game::start()
{int i=0;
     player player1(IMG_Load("megaman.gif"));
    Uint32 start;
   while(run)
    {start=SDL_GetTicks();
        handle_events();

       if(direction[2])
       {
           player1.setjump();
       }
       if(direction[0])
       {if(player1.getrect()->x>0)
        player1.setxvel(-1);
        else
        {
           camera.x--;
       base::coord.x--;
        }
       if(camera.x<=0)
       {camera.x++;base::coord.x++;}
       }
        else if(direction[1])
       {
           {if(player1.getrect()->x<60)
        player1.setxvel(1);
        else
        { player1.setxvel(0);
           camera.x++;
       base::coord.x++;
        }
       if(camera.x>1280-640)
       camera.x=0;
       }
       }
    else
    player1.setxvel(0);
        SDL_BlitSurface(back,&camera,screen,NULL);
         player1.move();
      if(gun)

          bullets=(new bullet(fire,player1.getrect()->x+player1.getrect()->w-11,player1.getrect()->y+15,10,0));

          bullets->move();
        player1.showplayer();
        showmap();
        bullets->show();
     SDL_Flip(screen);

     if(1000/30>(SDL_GetTicks()-start))
     SDL_Delay(1000/30-(SDL_GetTicks()-start));
    }

}
