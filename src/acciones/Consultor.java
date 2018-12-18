/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import objetosUtileria.Estudiante;

/**
 *
 * @author rafaelm
 */
public class Consultor {
    
    List<Estudiante> estudiantes;
    onConsultorInterface laSecre;
    
    
    public Consultor(onConsultorInterface secre){
        this.laSecre=secre;
        estudiantes=new ArrayList<Estudiante>();
    }
    
    
    public void agregarEstudianteALista(Estudiante estudiante){
        estudiantes.add(estudiante);
        laSecre.onCreateEstudiante(); 
    }
    
    public void buscar(String nombre){
        boolean bandera = true;
        for(Estudiante estudianteARevisar:estudiantes){
            //System.out.println("Estudiante iterado "+estudianteARevisar.getNombre());
            if(nombre.equals(estudianteARevisar.getNombre())){
                laSecre.onEstudianteEncontrado(estudianteARevisar);
                bandera = false;
                break;
            }
        }if(bandera){
            laSecre.onError();
        }
    }
    
    public void borrar (String nombre){
        boolean bandera = true;
        for(Estudiante estudianteABorrar:estudiantes){
            //System.out.println("(Estudiante iterado" + estudianteABorrar.getNombre());
            if(nombre.equals(estudianteABorrar.getNombre())){
                estudiantes.remove(estudianteABorrar);
                laSecre.onEstudianteBorrado(nombre);
                bandera = false;
                break;
            }
        }if(bandera){
            laSecre.onError();
        }
    }
    
    public void muestra(){
        for(Estudiante estudianteARevisar:estudiantes){
            System.out.println("Estudiante iterado "+estudianteARevisar.getNombre()+" "+estudianteARevisar.getPaterno()+" "+estudianteARevisar.getMaterno());
            
        }
    }
    
    public void BusquedaActualizar(String nombre){
        boolean bandera = true;
        for(Estudiante estudianteAActualizar:estudiantes){
            //System.out.println("Estudiante iterado " + estudianteAActualizar.getNombre());
            if(nombre.equals(estudianteAActualizar.getNombre())){
                int index = estudiantes.indexOf(estudianteAActualizar);
                //System.out.println(index);
                laSecre.onEstudianteIndexActualizar(index);
                bandera = false;
                break;
            }
        }if(bandera){
            laSecre.onError();
        }
    }
    
    public void Actualizando(Estudiante estudiante, int index){
        estudiantes.set(index, estudiante);
        laSecre.onEstudianteActulizado();
    }
    
    public interface onConsultorInterface{
        public void onConsulta();
        public void onError();
        public void onCreateEstudiante();
        public void onEstudianteEncontrado(Estudiante estudiante);
        public void onEstudianteBorrado(String data);
        public void onEstudianteIndexActualizar(int index);
        public void onEstudianteActualizado(String data);
        public void onEstudianteActulizado ();
    }
    
}
