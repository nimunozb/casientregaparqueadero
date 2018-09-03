package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase4
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        public static  boolean matriz [][] = new boolean[5][4];
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field5.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,6, 1, Direction.NORTH,0);
           
            
           comienzo();
           normativa();
           adivinador();
           regreso();
           batalla();
            comienzo();
           normativa();
           adivinador();
           regreso();
           batalla();
            comienzo();
           normativa();
           adivinador();
           regreso();
           
           
           
            
	}
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.move();
        }
        public static void comienzo(){
            estudiante.move();
             estudiante.move();
              estudiante.move();
               estudiante.move();
                 estudiante.move();
              estudiante.turnLeft();
               estudiante.turnLeft();
                estudiante.turnLeft();
             
        }
        public static void cambio(boolean a){
           if (a==false){
           estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
           estudiante.move();
           estudiante.turnLeft();
            estudiante.turnLeft();
             estudiante.turnLeft();
            
            }
           if(a==true){
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();}
           }
        public static void cambio2(){
      
            estudiante.turnLeft(); 
        estudiante.move();
        estudiante.turnLeft();
        }
        
        
        public static void regreso(){
              estudiante.turnLeft();  estudiante.turnLeft();
        for (int m=0;m<3;m++){estudiante.move();}
        estudiante.turnLeft();
        estudiante.move();
        estudiante.turnLeft();
        }
        public static void batalla(){
        for(int l=0;l<5;l++){
        estudiante.move();}
         estudiante.turnLeft();
        }
        public static void tdveces(int g){
          if(g%2==0) { for(int a=0;a<4;a++){ boolean z=estudiante.canPickThing();
          if(z==false&&a==3){matriz[g][a]=false;} else{ 
          if(z==true&&a==3){matriz[g][a]=true;estudiante.pickThing();}
            else {if (z==true){matriz[g][a]=true;estudiante.pickThing();estudiante.move();}
            else {estudiante.move();}}}}}
          else{
          for(int b=3;b>=0;b--){ boolean z=estudiante.canPickThing();
          if(z==false&&b==0){matriz[g][b]=false;cambio2();}else{
                   if(z==true&&b==0){matriz[g][b]=true;estudiante.pickThing();cambio2();}
                   else{ if (z==true){matriz[g][b]=true;estudiante.pickThing();estudiante.move();}
                  else {estudiante.move();}}}}}
        }
          public static void  adivinador(){
          boolean z=false;
           int x [] = new int[9];
            for (int a=0;a<9;a++){x[a]=0;}
        for (int a=0;a<5;a++){
          if(matriz[a][0]==true){x[0]++;}
           if(matriz[a][1]==true){x[1]++;}
            if(matriz[a][2]==true){x[2]++;}
             if(matriz[a][3]==true){x[3]++;}}
        for (int a=0;a<4;a++){
             if(matriz[0][a]==true){x[4]++;}
              if(matriz[1][a]==true){x[5]++;}
               if(matriz[2][a]==true){x[6]++;}
                if(matriz[3][a]==true){x[7]++;}
                  if(matriz[4][a]==true){x[8]++;}}
        
           if (x[0]==0&&x[1]==0&&x[2]==0&&x[3]==5&&x[4]==1&&x[5]==1&&x[6]==1&&x[7]==1&&x[8]==1)   
           {System.out.print("1");}else{
           if (x[0]==4&&x[1]==3&&x[2]==3&&x[3]==4&&x[4]==4&&x[5]==1&&x[6]==4&&x[7]==1&&x[8]==4)   
           {System.out.print("2");}else{
           if (x[0]==3&&x[1]==3&&x[2]==3&&x[3]==5&&x[4]==4&&x[5]==1&&x[6]==4&&x[7]==1&&x[8]==4)   
           {System.out.print("3");}else{
           if (x[0]==3&&x[1]==1&&x[2]==1&&x[3]==5&&x[4]==2&&x[5]==2&&x[6]==4&&x[7]==1&&x[8]==4)   
           {System.out.print("4");}else{
           if (x[0]==4&&x[1]==3&&x[2]==3&&x[3]==4&&x[4]==4&&x[5]==1&&x[6]==4&&x[7]==1&&x[8]==4)   
           {System.out.print("5");}else{
           if (x[0]==5&&x[1]==3&&x[2]==3&&x[3]==4&&x[4]==4&&x[5]==1&&x[6]==4&&x[7]==2&&x[8]==4)   
           {System.out.print("6");}else{
           if (x[0]==1&&x[1]==1&&x[2]==1&&x[3]==5&&x[4]==4&&x[5]==1&&x[6]==1&&x[7]==1&&x[8]==1)   
           {System.out.print("7");}else{    
            if (x[0]==5&&x[1]==3&&x[2]==3&&x[3]==5&&x[4]==4&&x[5]==2&&x[6]==4&&x[7]==2&&x[8]==4)   
           {System.out.print("8");}else{       
           if (x[0]==3&&x[1]==2&&x[2]==2&&x[3]==5&&x[4]==4&&x[5]==2&&x[6]==4&&x[7]==1&&x[8]==1)   
           {System.out.print("9");}else{   
            if (x[0]==5&&x[1]==2&&x[2]==2&&x[3]==5&&x[4]==4&&x[5]==2&&x[6]==2&&x[7]==2&&x[8]==4)   
           {System.out.print("0");}else{System.out.print("no es reconocible el numero");
           }}}}}}}}}}}
        
        public static void normativa(){
           
             boolean d;
           for(int a=0;a<5;a++){
               for(int b=0;b<4;b++){
                   matriz[a][b]=false;}}
           tdveces(0);
           boolean c=estudiante.canPickThing();
           cambio(c);
           tdveces(1);
           
           tdveces(2);
            c=estudiante.canPickThing();
           cambio(c);
           tdveces(3);
            tdveces(4);

          
           
           }
        public static void farc(int g){
            
            if(g%2==0) { for(int a=0;a<5;a++){ 
          if(matriz[g][a]==true&&a==4){estudiante.putThing();} else{ 
          if(matriz[g][a]==true){estudiante.putThing();estudiante.move();}
            else {if (matriz[g][a]==false&&!(a==4)){estudiante.move();}
            }}}}
          else{
          for(int b=4;b>=0;b--){ 
          if(matriz[g][b]==true&&b==0){estudiante.putThing();}else{
           if(matriz[g][b]==true){estudiante.putThing();estudiante.move();}
                   else{ if (matriz[g][b]==false&&!(b==0)){estudiante.move();}
                  }}}}
            }
        public static void eln(){
            farc(0);
            cambio(false);
            farc(1);
            cambio2();
            
            farc(2);
            cambio(false);
             farc(3);
              cambio2();
              
              farc(4);
              regreso();
        }



}
            
        


