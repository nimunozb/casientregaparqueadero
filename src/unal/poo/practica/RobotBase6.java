package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase6
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field6.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,7, 1, Direction.NORTH,0);
           
        
          recogerCarro(3);
          llevarcarro();
          dejarcarro(3);
           
           
           
            
	}
        public static void voltear(int grados){
            switch(grados){
                case 90:estudiante.turnLeft();break;
                case 180:estudiante.turnLeft();estudiante.turnLeft();break;
                case 270:estudiante.turnLeft();estudiante.turnLeft();estudiante.turnLeft();break;
                default:System.out.println("agulo incorrecto"); ;break;
            } }  
           public static  void correr(int a){
               for (int i = 0; i < a; i++) {
                   estudiante.move();
               }
            
        }  
        
        public static void recogerCarro(int carrosadesplazar){
            
            correr(1);
            voltear(270);
            correr(1);
            voltear(90);
            correr(carrosadesplazar+1);
            voltear(90);
            correr(1);
            voltear(90);
            //pick athing
            
            correr(carrosadesplazar+2);}

   public static void llevarcarro(){
       int a= estudiante.getAvenue();
       voltear(90);
       correr(10-a);
       voltear(90);
       
   }
  public static void dejarcarro(int carrosadespazar){
      correr(2);
      voltear(270);
      correr(carrosadespazar-1);
      voltear(90);
      correr(1);
      voltear(90);
      //
      
      correr(carrosadespazar-1);
      voltear(90);
      correr(3);
      
  }
  
  public static void normativa(int seccion,Vehiculo z){
     Posicion x= z.getPosicion();
     
  }








}
       

       
           
           
           
       











        
            
        


