class ZAHLEN
{
    int verx;
    int very;
    int q;
    int GridZHoehe;
    int GridZBreite;
    RECHTECK pixel;
    RECHTECK Grid;
    ZEICHENFLAECHE dummy;
    ZAHLEN()
    {
        dummy = new ZEICHENFLAECHE();
        verx = dummy.X();
        very = dummy.Y();
        if (verx>very)
        {
            q=very;
        }
        else
        {
            q=verx;
        }
        GridZBreite=q/90*4;
        GridZHoehe=q/90*8;
    }
    void pixel (int x,int y)
    {
        pixel = new RECHTECK();
        pixel.PositionSetzen(x,Y(y));
    }
    int Y(int komischesY)
    {
        if (komischesY>very)
        {
            System.out.println("Y out of bounds");
            return 0;
        }
        return very-komischesY;
    }
    void Bogen(int x,int y,int Breite,int Hoehe)
    {
        for(int X=0;X<Breite;X++)
        {
            pixel(X+x,(int)(Hoehe*Math.sin(X*Math.PI/Breite))+y);
        }
    }
    void Bogen90(int x,int y,int Breite,int Hoehe)
    {
        for(int Y=0;Y<Hoehe;Y++)
        {
            pixel(x+(int)(Breite*Math.sin(Y*Math.PI/Hoehe)),Y+y);
        }
    }
    void eins(int x,int y,int Breite,int Hoehe)
    {
        int a=(int)(Hoehe/Breite);
        for(int d=0;d<Breite/2;d++)
        {
            pixel(d+x,a*d+y+Hoehe/2);
        }
        for (int d=0;d<Hoehe;d++)
        {
            pixel(Breite/2+x,y+d);
        }
    }
    void zwei(int x,int y,int Breite,int Hoehe)
    {
        Bogen(x,y+Hoehe/4*3,Breite,Hoehe/4);
        double a=Hoehe*0.75/Breite;
        for(int d=0;d<Breite;d++)
        {
            pixel(d+x,(int)(a*d)+y);
        }
        for(int d=0;d<Breite;d++)
        {
            pixel(x+d,y);
        }
    }
    void drei(int x,int y,int Breite,int Hoehe)
    {
        Bogen90(x+Breite/2,y,Breite/2,Hoehe/2);
        for (int d=0;d<Breite/2;d++)
        {
            pixel(x+d,y);
        }
        for (int d=0;d<Breite/4;d++)
        {
            pixel(x+d+Breite/4,y+Hoehe/2);
        }
        for (int d=0;d<Breite/2;d++)
        {
            pixel(x+d,y+Hoehe);
        }
        Bogen90(x+Breite/2,y+Hoehe/2,Breite/2,Hoehe/2);
    }
    void vier(int x,int y,int Breite,int Hoehe)
    {
        for (int d=0;d<Breite;d++)
        {
            pixel(x+d,y+(int)(Hoehe/4));
        }
        double a=(Hoehe*0.75/(Breite*0.75));
        for (int d=0;d<Breite*0.75;d++)
        {
            pixel(d+x,y+(int)(a*d+Hoehe/4));
        }
        for (int d=0;d<Hoehe;d++)
        {
            pixel((int)(Breite/4*3)+x,d+y);
        }
    }
    void fuenf(int x,int y,int Breite,int Hoehe)
    {
        for(int d=0;d<Breite;d++)
        {
            pixel(x+d,y+Hoehe);
        }
        for(int d=0;d<Hoehe/2;d++)
        {
            pixel(x,y+(int)(Hoehe/2)+d);
        }
        Bogen(x,y+Hoehe/2,Breite/4*3,Hoehe/8);
        Bogen90(x+Breite/4*3,y+Hoehe/8,Breite/4,Hoehe/8*3);
        Bogen(x,y+Hoehe/8,Breite/4*3,Hoehe/-8);
    }
    void sechs(int x,int y,int Breite,int Hoehe)
    {
        Bogen(x,Hoehe/4*3+y,Breite,Hoehe/4);
        for (int d=0;d<Hoehe/2;d++)
        {
            pixel(x,y+Hoehe/4+d);
        }
        Bogen(x,y+Hoehe/4,Breite,Hoehe/4);
        Bogen(x,y+Hoehe/4,Breite,-Hoehe/4);
    }
    void sieben(int x,int y,int Breite,int Hoehe)
    {
        double a=Hoehe*1.0/Breite;
        for(int d=0;d<Breite;d++)
        {
            pixel(d+x,(int)(a*d)+y);
        }
        for (int d=0;d<=Breite;d++)
        {
            pixel(x+d,y+Hoehe);
        }
    }
    void acht(int x,int y,int Breite,int Hoehe)
    {
        Bogen(x,(int)(Hoehe/4)+y,Breite,(int)(Hoehe/-4));
        Bogen(x,(int)(Hoehe/4)+y,Breite,(int)(Hoehe/4));
        Bogen(x,(int)(Hoehe/4*3-1)+y,Breite,(int)(Hoehe/-4));
        Bogen(x,(int)(Hoehe/4*3-1)+y,Breite,(int)(Hoehe/4));
    }
    void neun(int x,int y,int Breite,int Hoehe)
    {
        Bogen(x,Hoehe/4+y,Breite,-Hoehe/4);
        for (int d=0;d<Hoehe/2;d++)
        {
            pixel(x+Breite,y+Hoehe/4+d);
        }
        Bogen(x,y+Hoehe/4*3,Breite,Hoehe/4);
        Bogen(x,y+Hoehe/4*3,Breite,-Hoehe/4);
    }
    void nul(int x,int y,int Breite,int Hoehe)
    {
        Bogen(x+Breite/8,y+Hoehe/8,Breite/4*3,-Hoehe/8);
        Bogen(x+Breite/8,y+Hoehe/8*7,Breite/4*3,Hoehe/8);
        Bogen90(x+Breite/8,y+Hoehe/8,-Breite/8,Hoehe/4*3);
        Bogen90(x+Breite/8*7,y+Hoehe/8,Breite/8,Hoehe/4*3);
    }
    void ZahlGrid(int x,int y,int Zahl)
    {
        x=x*q/9+q/90*3+1;
        y=y*q/9+q/90*9+1;
        y=GridY(y);
        switch(Zahl)
        {
            case 0:
            
            break;
            case 1:
            eins(x,y,GridZBreite,GridZHoehe);
            break;
            case 2:
            zwei(x,y,GridZBreite,GridZHoehe);
            break;
            case 3:
            drei(x,y,GridZBreite,GridZHoehe);
            break;
            case 4:
            vier(x,y,GridZBreite,GridZHoehe);
            break;
            case 5:
            fuenf(x,y,GridZBreite,GridZHoehe);
            break;
            case 6:
            sechs(x,y,GridZBreite,GridZHoehe);
            break;
            case 7:
            sieben(x,y,GridZBreite,GridZHoehe);
            break;
            case 8:
            acht(x,y,GridZBreite,GridZHoehe);
            break;
            case 9:
            neun(x,y,GridZBreite,GridZHoehe);
            break;
        }
    }
    int GridY(int y)
    {
        return very-y;
    }
    void Grid()
    {
        for(int d=0;d<10;d++)
        {
            Grid = new RECHTECK();
            Grid.PositionSetzen(d*q/9,0);
            if (d==3||d==6)
            {
                Grid.GroesseSetzen(2,q);
            }
            else
            {
                Grid.GroesseSetzen(1,q);
            }
        }
        for(int d=0;d<10;d++)
        
        {
            Grid = new RECHTECK();
            Grid.PositionSetzen(0,d*q/9);
            if(d==3||d==6)
            {
                Grid.GroesseSetzen(q,2);
            }
            else
            {
                Grid.GroesseSetzen(q,1);
            }
        }
    }
    void clear()
    {
        Grid = new RECHTECK();
        Grid.GroesseSetzen(verx,very);
        Grid.PositionSetzen(0,0);
        Grid.FarbeSetzen("weiss");
    }
}