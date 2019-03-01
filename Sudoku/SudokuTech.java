class SudokuTech
{
   int[][][] Feld;
   int[][] Quadrat;
   int[][]Reihe;
   int[][]Spalte;
   int z;
   int q;
   int p;
   ZAHLEN Zahl;
   SudokuTech ()
   {
       Zahl=new ZAHLEN();
       Feld = new int[9][9][9];
       Quadrat = new int[9][9];
       Reihe = new int[9][9];
       Spalte=new int[9][9];
   }
   void formatieren()
   {
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[0][z] = Feld[y][x][0];
               z++;
           }
       }
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[1][z] = Feld[y][x+3][0];
               z++;
           }
       }
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[2][z] = Feld[y][x+6][0];
               z++;
           }
       }
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[3][z] = Feld[y+3][x][0];
               z++;
           }
       }
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[4][z] = Feld[y+3][x+3][0];
               z++;
           }
       }
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[5][z] = Feld[y+3][x+6][0];
               z++;
           }
       }
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[6][z] = Feld[y+6][x][0];
               z++;
           }
       }
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[7][z] = Feld[y+6][x+3][0];
               z++;
           }
       }
       z=0;
       for (int y = 0;y<3;y++)
       {
           for (int x = 0;x<3;x++)
           {
               Quadrat[8][z] = Feld[y+6][x+6][0];
               z++;
           }
       }
       z=0;
    }
   int getQuadrat(int x,int y)
   {
        p=3;
        q=3;
        for (int d=0;d<3;d++)
        {
           if (y<p)
           {
               for (int k=0;k<3;k++)
               {
                   if (x<q)
                   {
                       q=d*3+k;
                       return q;
                   }
                   else
                   {
                       q+=3;
                    }
                }
            }
           else
           {
               p+=3;
            }
        }
        return 9;
    }
    int getposQuadrat(int x,int y)
    {
        if (y==0 || y==3 || y==6)
        {
           if(x==0||x==3||x==6)
           {
               return 0;
            }
            else if( x==1||x==4||x==7)
            {
                return 1;
            }
            else
            {
                return 2;
            }
         }
         else if (y==1||y==4||y==7)
         {
            if(x==0||x==3||x==6)
           {
               return 3;
            }
            else if( x==1||x==4||x==7)
            {
                return 4;
            }
            else
            {
                return 5;
            }
         }
         else
         {
            if(x==0||x==3||x==6)
           {
               return 6;
            }
            else if( x==1||x==4||x==7)
            {
                return 7;
            }
            else
            {
                return 8;
            }
        }
    }
    int xQuadrat(int q,int p)
    {
        if (q==0||q==3||q==6)
        {
            while (p>2)
            {
                p-=3;
            }
            return p;
        }
        else if(q==1||q==4||q==7)
        {
            while (p>2)
            {
                p-=3;
            }
            return 3+p;
        }
        else 
        {
            while (p>2)
            {
                p-=3;
            }
            return 6+p;
        }
    }
    int yQuadrat(int q,int p)
    {
        if (q==0||q==1||q==2)
        {
            return (int)(p/3);
        }
        else if (q==3||q==4||q==5)
        {
            return 3+(int)(p/3);
        }
        else
        {
            return 6+(int)(p/3);
        }
    }
   boolean istEinzigeReihe(int x,int y,int Wert)
   {
       for (int d=0;d<9;d++)
       {
           if (d!=x)
           {
               if (Feld[y][d][0]==Wert)
               {
                   return false;
                }
               for(int p=0;p<9;p++)
               {
                   if(Wert==Reihe[x][p])
                   {
                       return false;
                    }
                }
            }
        }
       return true;
   }
   boolean istEinzigeSpalte(int x,int y,int Wert)
   {
       for (int d=0;d<9;d++)
       {
           if (d!=y)
           {
               if (Feld[d][x][0]==Wert)
               {
                   return false;
                }
               for(int p=0;p<9;p++)
               {
                   if(Wert==Spalte[x][p])
                   {
                       return false;
                    }
                }
            }
        }
       return true;
    }
    boolean istEinzigeQuadrat (int x,int y,int Wert)
   {    
        for (int d=0;d<9;d++)
        {
           if (d!=getposQuadrat(x,y))
           {
               if (Quadrat[getQuadrat(x,y)][d]==Wert)
               {
                   p=0;
                   q=0;
                   return false;
                }
            }
        }
        return true;
    }
    boolean istEinzige(int x,int y,int Wert)
    {
        if (istEinzigeQuadrat(x,y,Wert)&&istEinzigeReihe(x,y,Wert)&&istEinzigeSpalte(x,y,Wert))
        {
            return true;
        }
        return false;
    }
    boolean istEinzigeMoeglichkeitReihe(int x,int y,int Wert)
    {
        if (istEinzige(x,y,Wert))
        {
            for (int d=0;d<9;d++)
            {
                if (d!=x)
                {
                    if(Feld[y][d][0]==0)
                    {
                        if (istEinzige(d,y,Wert))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }
    boolean istEinzigeMoeglichkeitSpalte(int x,int y,int Wert)
    {
        if (istEinzige(x,y,Wert))
        {
            for (int d=0;d<9;d++)
            {
                if (d!=y)
                {
                    if(Feld[d][x][0]==0)
                    {
                        if (istEinzige(x,d,Wert))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }
    boolean istEinzigeMoeglichkeitQuadrat(int x,int y,int Wert)
    {
        if (istEinzigeReihe(x,y,Wert)&&istEinzigeSpalte(x,y,Wert)&&istEinzigeQuadrat(x,y,Wert))
        {
            for (int d=0;d<9;d++)
            {
                if (d!=getposQuadrat(x,y))
                {
                    if(Quadrat[getQuadrat(x,y)][d]==0)
                    {
                        if (istEinzige(xQuadrat(getQuadrat(x,y),d),yQuadrat(getQuadrat(x,y),d),Wert))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }
    boolean istEinzigeMoeglichkeit(int x,int y,int Wert)
    {
        if(istEinzigeMoeglichkeitReihe(x,y,Wert)||istEinzigeMoeglichkeitSpalte(x,y,Wert)||istEinzigeMoeglichkeitQuadrat(x,y,Wert))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    void MöglicheZahlen()
    {   
        for (int x=0;x<9;x++)
        {
            for(int y=0;y<9;y++)
            {
                for(int d=1;d<9;d++)
                {
                    Feld[y][x][d]=0;
                }
            }
        }
        int count =0; 
        for (int x=0;x<9;x++)
        {
            for(int y=0;y<9;y++)
            {
                if (Feld[y][x][0]==0)
                {
                    for(int d=1;d<=9;d++)
                    {
                        if (istEinzige(x,y,d))
                        {
                            Feld[y][x][count+1]=d;
                            count++;
                        }
                    }
                    count=0;
                }
            }
        }
    }
    boolean istGeloest()
    {
        for (int x=0;x<9;x++)
        {
            for(int y=0;y<9;y++)
            {
                if (Feld[y][x][0]==0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    void loesen()
    {
        int counter =0;
        int counter2 =0;
        potZahlen();
        while(!istGeloest()&&counter2<3)
        {
            while(counter<3)
            {
                for (int y=0;y<9;y++)
                {
                    for(int x=0;x<9;x++)
                    {
                        if (Feld[y][x][0]==0)
                        {
                            for (int d=1;d<=9;d++)
                            {
                                if(istEinzigeMoeglichkeit(x,y,d))
                                {
                                    Feld[y][x][0]=d;
                                    formatieren();
                                    potZahlen();
                                    counter=0;
                                    break;
                                }
                            }
                        }
                    }
                }
                counter++;
            }
            
            if(!istGeloest())
            {
                MöglicheZahlen();
                for (int y=0;y<9;y++)
                {
                    for(int x=0;x<9;x++)
                    {
                        if (Feld[y][x][0]==0&&Feld[y][x][2]==0)
                        {
                            Feld[y][x][0]=Feld[y][x][1];
                            formatieren();
                        }
                    }
                }
            }
            
            counter2++;
        }
        anzeigenGrafik();
    }
    void Input(int W1,int W2,int W3,int W4,int W5,int W6,int W7,int W8,int W9)
    {
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[0][p][0]=(int)(W1/x);
           z=(int)(W1/x)*x;
           W1-=z;
           p++;
       }
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[1][p][0]=(int)(W2/x);
           z=(int)(W2/x)*x;
           W2-=z;
           p++;
       }
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[2][p][0]=(int)(W3/x);
           z=(int)(W3/x)*x;
           W3-=z;
           p++;
       }
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[3][p][0]=(int)(W4/x);
           z=(int)(W4/x)*x;
           W4-=z;
           p++;
       }
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[4][p][0]=(int)(W5/x);
           z=(int)(W5/x)*x;
           W5-=z;
           p++;
       }
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[5][p][0]=(int)(W6/x);
           z=(int)(W6/x)*x;
           W6-=z;
           p++;
       }
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[6][p][0]=(int)(W7/x);
           z=(int)(W7/x)*x;
           W7-=z;
           p++;
       }
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[7][p][0]=(int)(W8/x);
           z=(int)(W8/x)*x;
           W8-=z;
           p++;
       }
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[8][p][0]=(int)(W9/x);
           z=(int)(W9/x)*x;
           W9-=z;
           p++;
       }
       formatieren();
    }
    void InputZeile (int Zeile,int Werte)
    {
       p=0;
       z=0;
       for (int x=100000000;x>=1;x/=10)
       {
           Feld[Zeile-1][p][0]=(int)(Werte/x);
           z=(int)(Werte/x)*x;
           Werte-=z;
           p++;
       }
       formatieren();
    }
    /*
    void anzeigen()
    {
        System.out.println("Sudoku:");
        System.out.println(""+Feld[0][0]+""+""+Feld[0][1]+""+""+Feld[0][2]+""+""+Feld[0][3]+""+""+Feld[0][4]+""+""+Feld[0][5]+""+""+Feld[0][6]+""+""+Feld[0][7]+""+""+Feld[0][8]+"");
        System.out.println(""+Feld[1][0]+""+""+Feld[1][1]+""+""+Feld[1][2]+""+""+Feld[1][3]+""+""+Feld[1][4]+""+""+Feld[1][5]+""+""+Feld[1][6]+""+""+Feld[1][7]+""+""+Feld[1][8]+"");
        System.out.println(""+Feld[2][0]+""+""+Feld[2][1]+""+""+Feld[2][2]+""+""+Feld[2][3]+""+""+Feld[2][4]+""+""+Feld[2][5]+""+""+Feld[2][6]+""+""+Feld[2][7]+""+""+Feld[2][8]+"");
        System.out.println(""+Feld[3][0]+""+""+Feld[3][1]+""+""+Feld[3][2]+""+""+Feld[3][3]+""+""+Feld[3][4]+""+""+Feld[3][5]+""+""+Feld[3][6]+""+""+Feld[3][7]+""+""+Feld[3][8]+"");
        System.out.println(""+Feld[4][0]+""+""+Feld[4][1]+""+""+Feld[4][2]+""+""+Feld[4][3]+""+""+Feld[4][4]+""+""+Feld[4][5]+""+""+Feld[4][6]+""+""+Feld[4][7]+""+""+Feld[4][8]+"");
        System.out.println(""+Feld[5][0]+""+""+Feld[5][1]+""+""+Feld[5][2]+""+""+Feld[5][3]+""+""+Feld[5][4]+""+""+Feld[5][5]+""+""+Feld[5][6]+""+""+Feld[5][7]+""+""+Feld[5][8]+"");
        System.out.println(""+Feld[6][0]+""+""+Feld[6][1]+""+""+Feld[6][2]+""+""+Feld[6][3]+""+""+Feld[6][4]+""+""+Feld[6][5]+""+""+Feld[6][6]+""+""+Feld[6][7]+""+""+Feld[6][8]+"");
        System.out.println(""+Feld[7][0]+""+""+Feld[7][1]+""+""+Feld[7][2]+""+""+Feld[7][3]+""+""+Feld[7][4]+""+""+Feld[7][5]+""+""+Feld[7][6]+""+""+Feld[7][7]+""+""+Feld[7][8]+"");
        System.out.println(""+Feld[8][0]+""+""+Feld[8][1]+""+""+Feld[8][2]+""+""+Feld[8][3]+""+""+Feld[8][4]+""+""+Feld[8][5]+""+""+Feld[8][6]+""+""+Feld[8][7]+""+""+Feld[8][8]+"");
    }
    */
    void anzeigenGrafik()
    {
        Zahl.clear();
        Zahl.Grid();
        for (int y=0;y<9;y++)
        {
            for(int x=0;x<9;x++)
            {
                Zahl.ZahlGrid(x,y,Feld[y][x][0]);
            }
        }
    }
    void loeschen()
    {
        for (int y=0;y<9;y++)
        {
            for(int x=0;x<9;x++)
            {
                for(int z=0;z<9;z++)
                {
                    Feld[y][x][z]=0;
                }
            }
        }
    }
    /*void SudokuErstellen()
    {
        int g=0;
        while(!istGeloest())
        {
            for (int x=0;x<9;x++)
            {
                for(int y=0;y<9;y++)
                {
                    if (Feld[y][x][0]==0)
                    {
                        while (!istEinzige(x,y,g))
                        {
                            g=(int)(Math.random()*9)+1;
                        }
                        Feld[y][x][0]=g;
                        formatieren();
                    }
                }
            }
        }
    }*/
    void potZahlen()
    {
        for(int x=0;x<9;x++)
        {
            for(int y=0;y<9;y++)
            {
                potZahlenSpalte(x,y);
                potZahlenReihe(x,y);
            }
        }
    }
    void potZahlenSpalte(int x,int y)
    {
        while(getposQuadrat(x,y)>2)
        {
            y-=1;
        }
        for(int W=1;W<9;W++)
        {
            for(int b=1;b<9;b++)
            {
                for(int p=0;p<9;p+=3)
                {
                    if(Feld[y][x][W]==Feld[yQuadrat(getQuadrat(x,y),getposQuadrat(x,y)+p)][xQuadrat(getQuadrat(x,y),getposQuadrat(x,y)+p)][b])
                    {
                        if(!isPotLeftSpalte(x,y,Feld[y][x][W]))
                        {
                            for(int d=0;d<9;d++)
                            {
                                if(Reihe[d][y]==Feld[y][x][W])
                                {
                                    break;
                                }
                                else
                                {
                                    if(Spalte[x][y]==0)
                                    {
                                        Spalte[x][y]=Feld[y][x][W];
                                    }
                                    else
                                    {
                                        Spalte[xQuadrat(getQuadrat(x,y),getposQuadrat(x,y)+p)][yQuadrat(getQuadrat(x,y),getposQuadrat(x,y)+p)]=Feld[y][x][W];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }
    boolean isPotLeftSpalte(int x,int y,int Wert)
    {
        for(int p=0;p<9;p++)
        {
            if (xQuadrat(getQuadrat(x,y),p)!=x)
            {
                for(int d=1;d<9;d++)
                {
                    if (Feld[yQuadrat(getQuadrat(x,y),p)][xQuadrat(getQuadrat(x,y),p)][d]==Wert)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    void potZahlenReihe(int x,int y)
    {
        while(getposQuadrat(x,y)!=0&&getposQuadrat(x,y)!=3&&getposQuadrat(x,y)!=6)
        {
            x-=1;
        }
        for(int W=1;W<9;W++)
        {
            for(int b=1;b<9;b++)
            {
                for(int p=0;p<3;p++)
                {
                    if(Feld[y][x][W]==Feld[y][x+p][b])
                    {
                        if(!isPotLeftReihe(x,y,Feld[y][x][W]))
                        {
                            for(int d=0;d<9;d++)
                            {
                                if(Reihe[x][d]==Feld[y][x][W])
                                {
                                    break;
                                }
                                else
                                {
                                    if(Reihe[x][y]==0)
                                    {
                                        Reihe[x][y]=Feld[y][x][W];
                                    }
                                    else
                                    {
                                        Reihe[x+p][y]=Feld[y][x][W];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    boolean isPotLeftReihe(int x,int y,int Wert)
    {
        for(int p=0;p<9;p++)
        {
            if (yQuadrat(getQuadrat(x,y),p)!=y)
            {
                for(int d=1;d<9;d++)
                {
                    if (Feld[yQuadrat(getQuadrat(x,y),p)][xQuadrat(getQuadrat(x,y),p)][d]==Wert)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
