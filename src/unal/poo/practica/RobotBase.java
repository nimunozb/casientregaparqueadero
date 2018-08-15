package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,1, 2, Direction.SOUTH,10);
            for (int a=0;a<3;a++){
               estudiante.turnLeft(); }
	    estudiante.move();
            estudiante.turnLeft();
            estudiante.move();
            estudiante.turnLeft();
            estudiante.move();
           boolean a= estudiante.canPickThing();
             
            if(a==true){
                
         estudiante.pickThing();
        }
             for (int b=0;b<2;b++){
               estudiante.turnLeft(); }
             estudiante.move();
              for (int c=0;c<3;c++){
               estudiante.turnLeft(); }
              estudiante.move();
               for (int d=0;d<3;d++){
               estudiante.turnLeft(); }
            estudiante.move();
             for (int e=0;e<3;e++){
               estudiante.turnLeft(); }
            
            
	}
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.move();
        }

}

