package unal.poo.practica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Horacio
 */
public class Parqueadero {
    private long [][] tiempo=new long [3][5];
    private Vehiculo[][] estacionamientos= new Vehiculo [3][5]; 

    
   public void Parqueadero() {
       for(int a=0;a<3;a++){
       for (int z=0;z<5;z++){
           this.tiempo[a][z]=0;
           this.estacionamientos[a][z]=null;
       }
       }
    }

    public long[][] getTiempo() {
        return tiempo;
    }

    public void setTiempo(long[][] tiempo) {
        this.tiempo = tiempo;
    }

    public Vehiculo[][] getEstacionamientos() {
        return estacionamientos;
    }

    public void setEstacionamientos(Vehiculo[][] estacionamientos) {
        this.estacionamientos = estacionamientos;
    }
    public  Posicion posicionesDisponibles(){
       Posicion z=new Posicion(0,0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
               if(this.estacionamientos[i][j]==null){
                    z.setCalle(i);
                    z.setCarrera(j);
                    return z;}
                 }}
            return null;
        }
  public Posicion buscarVehiculos(String k){ 
      
     for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
               if (this.estacionamientos[i][j]!=null){    
                if(this.estacionamientos[i][j].getPlaca().equals(k)){
                       return this.estacionamientos[i][j].getPosicion();
                    }}
                }
           }
       return null ;
   }
    
}
