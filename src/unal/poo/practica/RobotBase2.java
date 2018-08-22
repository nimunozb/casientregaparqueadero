package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase2
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field2.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,0, 1, Direction.SOUTH,0);
            estudiante.move();
            recoleccion();
            superbobo();
            estudiante.move();
            recoleccion();
            superbobo();
            estudiante.move();
            recoleccion();
            superbobo();
            estudiante.move();
            recoleccion();
            superbobo();
            estudiante.move();
           
            
            
	}
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.move();
        }
        public static void recoleccion(){
            boolean a=true; 
            int derramacion=1;
            while (a==true){
                  a=estudiante.canPickThing();
                if (a==true){derramacion++;
                estudiante.pickThing();}
                else{ a=false;}}}
        public static void superbobo(){
            int b=estudiante.countThingsInBackpack();
           
                estudiante.turnLeft();
           for(int s=1;s<=b;s++){
              estudiante.move();
              estudiante.putThing();
            }   
            estudiante.turnLeft();
            estudiante.turnLeft();
           for(int s=1;s<=b;s++){
           estudiante.move();
           }estudiante.turnLeft();
        }
        public static void carroloco(){
            boolean a=true;
            while(a==true){
                a=estudiante.canPickThing();
                if(a==false){estudiante.move();a=true;}else{a=false;}
                }
            }
            
        }


