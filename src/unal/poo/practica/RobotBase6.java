package unal.poo.practica;

import becker.robots.*;
import static becker.robots.Direction.NORTH;
import static becker.robots.Direction.SOUTH;
import java.util.Random;

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
            Vehiculo vehiculo =new Vehiculo();
             Ingresos ingreso=new Ingresos();
            
              
              
          boolean quit=false;
            long tiempodeabertura=0;
            int a=0;
            int numerodeserie=0;
          
       while(!quit){int random=seleccionAleatoria(2)%2;
            if(a<=6){
               vehiculo=asignacionVehiculos(vehiculo,numerodeserie,parqueadero);
                ingresarVehivulo(parqueadero,vehiculo,tiempodeabertura);
                 a++;
             numerodeserie++;}
      else if (random==1){ System.out.println(random);
                vehiculo=asignacionVehiculos(vehiculo,numerodeserie,parqueadero);
                ingresarVehivulo(parqueadero,vehiculo,tiempodeabertura);
                numerodeserie++;
                 if(numerodeserie==15){
                   numerodeserie=0;}
               
      }else if(random==0){
                    System.out.println(random);
                sacarVehiculo(parqueadero,ingreso,numerodeserie,tiempodeabertura);
            }
            tiempodeabertura++;
            }
        
        }
        
   
       
      public static Vehiculo asignacionVehiculos(Vehiculo vehiculo,int numerodeserie,Parqueadero f){
       vehiculo.setPlaca("UQD"+numerodeserie);
       vehiculo.setPosicion(f.posicionesDisponibles());
       return vehiculo;}
           
        public static int seleccionAleatoria(int a){
        Random basealeatorio= new Random();
        int naletorio=basealeatorio.nextInt(a);
        return naletorio;
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
               // System.out.println(estudiante.getDirection());
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
              //  System.out.println(estudiante.getDirection());//no se si funcione
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
        public static void sacarVehiculo(Parqueadero f,Ingresos ingreso,int numerodeserie,long tiempodeabertura){
      String k=null;System.out.println(numerodeserie);
          switch(seleccionAleatoria(numerodeserie)){
               
     case 1: k="UQD1";break; case 11: k="UQD11";break;
         case 2: k="UQD2";break; case 12: k="UQD12";break;
         case 3: k="UQD3";break; case 13: k="UQD13";break;
           case 4: k="UQD4";break; case 14: k="UQD14";break;
            case 5: k="UQD5";break; case 0:k="UQD0";break;
            case 6: k="UQD6";break; 
             case 7: k="UQD7";break; 
                 case 8: k="UQD8";break; 
                  case 9: k="UQD9";break; 
                   case 10: k="UQD10";break; 
             }
        
   if (f.buscarVehiculos(f,k)==null){
            System.out.println("Este vehiculo con placa "+k+" no esta en este parqueadero");
   }else{
      acoplamiento(f.buscarVehiculos(f,k));
      normativa(estudiante.getStreet()-f.buscarVehiculos(f,k).getCarrera(),f.buscarVehiculos(f,k).getCalle());
       ingreso.mostraringresos(f,f.buscarVehiculos(f,k),tiempodeabertura);
       f.setEstacionamientos( f.buscarVehiculos(f,k).getCalle(),f.buscarVehiculos(f,k).getCarrera(),null);
      
      
      }}
        public static void ingresarVehivulo(Parqueadero f,Vehiculo vehiculo,long frecuencia){
       
       if(f.posicionesDisponibles()==null){System.out.println("No hay espacios disponibles para parquear");}
       else{ 
      f.getTiempo()[f.posicionesDisponibles().getCalle()][f.posicionesDisponibles().getCarrera()]=frecuencia;
           System.out.println("Ingreso el vehiculo con placa "+vehiculo.getPlaca()+
                   " a las "+f.getTiempo()[f.posicionesDisponibles().getCalle()][f.posicionesDisponibles().getCarrera()]
                              +" horas de abrir el parqueadero");
        acoplamiento(f.posicionesDisponibles());
        recogerCarro(5-f.posicionesDisponibles().getCarrera(),false);
        f.setEstacionamientos(f.posicionesDisponibles().getCalle(),f.posicionesDisponibles().getCarrera(),vehiculo);
       
       
       }}  
           
               
                 
                 
       
       
       
       
       }   
   
   









       

       
           
           
           
       











        
            
        


