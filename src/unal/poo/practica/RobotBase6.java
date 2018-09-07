package unal.poo.practica;

import becker.robots.*;
import static becker.robots.Direction.NORTH;
import static becker.robots.Direction.SOUTH;

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
            estudiante = new Robot(objetos,7, 1, Direction.NORTH,1999);
            Parqueadero parqueadero=new Parqueadero();
           Vehiculo veiculo1=new Vehiculo("UQD2");
            Vehiculo veiculo2=new Vehiculo("UQD8");
             Vehiculo veiculo3=new Vehiculo("UQD81");
          long k=0;
             ingresarVehivulo(parqueadero,veiculo1,k);
          ingresarVehivulo(parqueadero,veiculo2,k);
          ingresarVehivulo(parqueadero,veiculo3,k);
           // sacarVehiculo(parqueadero,1,"UQD2");
         
           
           
            
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
        public static void recogerCarro(int carrosadesplazar,boolean k){
            
            correr(1);
            voltear(270);
            correr(1);
            voltear(90);
            correr(carrosadesplazar);
            voltear(90);
            correr(1);
            voltear(90);
            //pick athing
            if (k==true){estudiante.pickThing();}
            else{estudiante.putThing();}
            correr(carrosadesplazar+1);}
        public static void acoplamiento(Posicion bobo){
            
           switch(bobo.getCalle()){
               case 0: bobo.setCalle(bobo.getCalle()+1);break;
               case 1: bobo.setCalle(bobo.getCalle()+3);break;
               case 2: bobo.setCalle(bobo.getCalle()+5);break;
               default: System.out.println("no es reconocible la posicion");break;}
            
            if(estudiante.getDirection().equals(NORTH)){
                System.out.println(estudiante.getDirection());
                 if(estudiante.getAvenue()==bobo.getCalle()){}
                else{ if (estudiante.getAvenue()>bobo.getCalle()){
                voltear(90);
                correr(estudiante.getAvenue()-bobo.getCalle());
                voltear(270);}
                else { if (estudiante.getAvenue()<bobo.getCalle()) {
                         voltear(270);
                           correr(bobo.getCalle()-estudiante.getAvenue());
                              voltear(90);
            }}}}
            if (estudiante.getDirection().equals(SOUTH)){
                System.out.println(estudiante.getDirection());//no se si funcione
               if(estudiante.getAvenue()==bobo.getCalle()){
                voltear(180);}
               else { if (estudiante.getAvenue()>bobo.getCalle()){
                     voltear(270);
                      correr(estudiante.getAvenue()-bobo.getCalle());
                       voltear(270);}
               else{ if (estudiante.getAvenue()<bobo.getCalle()) {
                          voltear(90);
                            correr(bobo.getCalle()-estudiante.getAvenue());
                              voltear(90);
                              }}}}}
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
          recogerCarro(1,true);llevarcarro(0,false);dejarcarro(4);
          llevarcarro(celda,true);
           recogerCarro(2,true);llevarcarro(0,false);dejarcarro(3);
          llevarcarro(celda,true);
           recogerCarro(3,true);llevarcarro(0,false);dejarcarro(2);
          llevarcarro(celda,true);
          recogerCarro(4,true);llevarcarro(0,false);dejarcarro(1);
          llevarcarro(celda,true);break;
          
          case 5:recogerCarro(2,true);llevarcarro(0,false);dejarcarro(4);
          llevarcarro(celda,true);
           recogerCarro(3,true);llevarcarro(0,false);dejarcarro(3);
          llevarcarro(celda,true);
          recogerCarro(4,true);llevarcarro(0,false);dejarcarro(2);
          llevarcarro(celda,true);break;
          
          case 4:
           recogerCarro(3,true);llevarcarro(0,false);dejarcarro(4);
          llevarcarro(celda,true);
          recogerCarro(4,true);llevarcarro(0,false);dejarcarro(3);
          llevarcarro(celda,true);break;
          
          case 3:recogerCarro(4,true);llevarcarro(0,false);dejarcarro(4);
          llevarcarro(celda,true);break;
      
      
      }
          
      
      
  }
        public static void sacarVehiculo(Parqueadero f,int seccion,String k){
    
      //acoplamiento(f.getEstacionamientos()[z][h].getPosicion());
      //normativa(estudiante.getStreet()-f.getEstacionamientos()[z][h].getPosicion().getCalle(),f.getEstacionamientos()[z][h].getPosicion().getCarrera());
      
      }

   public static void ingresarVehivulo(Parqueadero f,Vehiculo c,long frecuencia){
       
       if(f.posicionesDisponibles()==null){System.out.println("No hay espacios disponibles para parquear");}
       else{ 
       System.out.println("Ingreso el vehiculo con placa "+c.getPlaca());
           System.out.println(f.posicionesDisponibles().getCalle());
           System.out.println(f.posicionesDisponibles().getCarrera());
        acoplamiento(f.posicionesDisponibles());
        recogerCarro(5-f.posicionesDisponibles().getCarrera(),false);
        f.getEstacionamientos()[f.posicionesDisponibles().getCalle()][f.posicionesDisponibles().getCarrera()]=c;
         
       
       }}  
          
               
                 
                 
       
       
       
       
       }   
   
   









       

       
           
           
           
       











        
            
        


