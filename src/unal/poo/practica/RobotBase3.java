package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase3
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        public static  boolean matriz [][] = new boolean[5][5];
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field3.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,6, 1, Direction.NORTH,0);
           
            
           comienzo();
           normativa();
           batalla();
           comienzo();
           farc();
           
            
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
        public static void cambio(){
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.move();
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
           }
        public static void cambio2(){
        estudiante.turnLeft();
           estudiante.move();
            estudiante.turnLeft();
        
        }
        public static void regreso(){
              estudiante.turnLeft();  estudiante.turnLeft();
        for (int m=0;m<4;m++){estudiante.move();}
        estudiante.turnLeft();
        estudiante.move();
        estudiante.turnLeft();
        }
        public static void batalla(){
        for(int l=0;l<6;l++){
        estudiante.move();}
         estudiante.turnLeft();
        }
        public static void normativa(){
            
             boolean d;
           for(int a=0;a<5;a++){
               for(int b=0;b<5;b++){
                   matriz[a][b]=false;}}
           
            boolean z=estudiante.canPickThing();
               if(z==true){matriz[0][0]=true;estudiante.pickThing();}
           for(int c=1;c<5;c++){
                d=estudiante.canPickThing();
               if(d==true){estudiante.pickThing();matriz[0][c]=true;estudiante.move();}
               else{estudiante.move();}}
              z=estudiante.canPickThing();
               if(z==true){matriz[1][4]=true;estudiante.pickThing();}
           cambio();
            
           
            for(int c=3;c>=0;c--){
                d=estudiante.canPickThing();
               if(d==true){matriz[1][c]=true;estudiante.pickThing();estudiante.move();}
               else{estudiante.move();}}
            z=estudiante.canPickThing();
               if(z==true){matriz[2][0]=true;estudiante.pickThing();}
            cambio2();
            
            
           for(int c=1;c<5;c++){
                d=estudiante.canPickThing();
               if(d==true){estudiante.pickThing();matriz[2][c]=true;estudiante.move();}
               else{estudiante.move();}}
             z=estudiante.canPickThing();
               if(z==true){matriz[3][4]=true;estudiante.pickThing();} 
           cambio();
            
           
            for(int c=3;c>=0;c--){
                d=estudiante.canPickThing();
               if(d==true){matriz[3][c]=true;estudiante.pickThing();estudiante.move();}
               else{estudiante.move();}}
            z=estudiante.canPickThing();
               if(z==true){matriz[4][0]=true;estudiante.pickThing();}
            cambio2();
            
            
           for(int c=1;c<5;c++){
                d=estudiante.canPickThing();
               if(d==true){estudiante.pickThing();matriz[4][c]=true;estudiante.move();}
               else{estudiante.move();}}
            z=estudiante.canPickThing();
               if(z==true){matriz[4][4]=true;estudiante.pickThing();}
           
           regreso();
           
        }
        public static void farc(){
            
            for (int a=0;a<4;a++){
               if( matriz[0][a]==true){estudiante.putThing();estudiante.move();}
               else{estudiante.move();}}
            if (matriz [0][4]==true){estudiante.putThing();}
         
            cambio();
            
              for (int a=4;a>=1;a--){
               if( matriz[1][a]==true){estudiante.putThing();estudiante.move();}
              else{estudiante.move();}}
            if (matriz [1][0]==true){estudiante.putThing();}
            
            cambio2();
            
             
            for (int a=0;a<4;a++){
               if( matriz[2][a]==true){estudiante.putThing();estudiante.move();}
               else{estudiante.move();}}
            if (matriz [2][4]==true){estudiante.putThing();}
         
            cambio();
        
            for (int a=4;a>=1;a--){
               if( matriz[3][a]==true){estudiante.putThing();estudiante.move();}
              else{estudiante.move();}}
            if (matriz [3][0]==true){estudiante.putThing();}
            
            cambio2(); 
            
            for (int a=0;a<4;a++){
               if( matriz[4][a]==true){estudiante.putThing();estudiante.move();}
               else{estudiante.move();}}
            if (matriz [4][4]==true){estudiante.putThing();}
         
           regreso();
            
            
            
        
        
        
        }
        }
            
        


