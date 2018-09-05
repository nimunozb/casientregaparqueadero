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
        Parqueadero parqueadero=new Parqueadero(); 
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field6.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,7, 1, Direction.NORTH,0);
           
        
          recogerCarro(3);
          //llevarcarro();
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
        
        public static void acoplamiento(Posicion bobo){
            if(estudiante.getAvenue()==bobo.getCarrera()){
                voltear(180);
            }
            if (estudiante.getAvenue()>bobo.getCarrera()){
                voltear(270);
                correr(estudiante.getAvenue()-bobo.getCarrera());
                voltear(270);
             if (estudiante.getAvenue()<bobo.getCarrera()) {
               voltear(90);
               correr(bobo.getCarrera()-estudiante.getAvenue());
               voltear(90);
            }
        }
        }
   public static void llevarcarro(int c,boolean l){
       if(estudiante.getAvenue()==10&&l==true&&c==1){
       voltear(270);
       correr(9);
       voltear(270);}
       if(estudiante.getAvenue()==10&&l==true&&c==2){
       voltear(270);
       correr(6);
       voltear(270);}
       if(estudiante.getAvenue()==10&&l==true&&c==3){
       voltear(270);
       correr(3);
       voltear(270);}
       
       
       if (l==false){
       int a= estudiante.getAvenue();
       voltear(90);
       correr(10-a);
       voltear(90);}
       
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
  
  public static void normativa(int delta,int celda){
      switch(celda){
          case 1: celda=1;break;
          case 4:celda=2;break;
          case 7:celda=3;break;
         }
      switch(delta){
          case 6:
          recogerCarro(1);llevarcarro(0,false);dejarcarro(4);
          llevarcarro(celda,true);
           recogerCarro(2);llevarcarro(0,false);dejarcarro(3);
          llevarcarro(celda,true);
           recogerCarro(3);llevarcarro(0,false);dejarcarro(2);
          llevarcarro(celda,true);
          recogerCarro(4);llevarcarro(0,false);dejarcarro(1);
          llevarcarro(celda,true);break;
          
          case 5:recogerCarro(2);llevarcarro(0,false);dejarcarro(4);
          llevarcarro(celda,true);
           recogerCarro(3);llevarcarro(0,false);dejarcarro(3);
          llevarcarro(celda,true);
          recogerCarro(4);llevarcarro(0,false);dejarcarro(2);
          llevarcarro(celda,true);break;
          
          case 4:
           recogerCarro(3);llevarcarro(0,false);dejarcarro(4);
          llevarcarro(celda,true);
          recogerCarro(4);llevarcarro(0,false);dejarcarro(3);
          llevarcarro(celda,true);break;
          
          case 3:recogerCarro(4);llevarcarro(0,false);dejarcarro(4);
          llevarcarro(celda,true);break;
      
      
      }
          
      
      
  }
  
  public  void sacarVehiculo(int seccion,String k){
    Posicion z = this.parqueadero.posicionesDisponibles();
    Posicion ubicacion = null;
     if(z==null){System.out.println("No hay espacios disponibles para parquear");}
      for (int i = 0; i < 10; i++) {
          for (int j = 0; j < 10; j++) {
           if(parqueadero.estacionamientos[i][j].getPlaca().equals(k)){
               ubicacion= parqueadero.estacionamientos[i][j].getPosicion();
           }}}
      if (ubicacion.getCarrera()==estudiante.getAvenue()){
       voltear(180);
       recogerCarro(estudiante.getStreet()-ubicacion.getCalle());
      }
      acoplamiento(ubicacion);
      normativa(estudiante.getStreet()-ubicacion.getCalle(),ubicacion.getCarrera());
              
    
  
  
  
  
  }

   








}
       

       
           
           
           
       











        
            
        


