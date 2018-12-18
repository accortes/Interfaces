/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.util.Scanner;
import objetosUtileria.Estudiante;

/**
 *
 * @author rafaelm
 */
public class Capturista {
    
    onCapturistaAction laSecre;
     
    public Capturista(onCapturistaAction  secre){
        this.laSecre=secre;
    }
    
 
    
    public Estudiante capturar(){
        laSecre.onCaptura();
        Scanner sc=new Scanner(System.in);
        Estudiante estudiante=new Estudiante();
        System.out.println("Ingresa nombre");
        String nombre=sc.nextLine();
        System.out.println("Ingresa paterno");
        String paterno=sc.nextLine();
        System.out.println("Ingresa materno");
        String materno=sc.nextLine();
        estudiante.setNombre(nombre);
        estudiante.setMaterno(materno);
        estudiante.setPaterno(paterno);
        laSecre.onCapturaTerminada(estudiante);
        return estudiante;
    }
    
    public void ingresoDeNombre(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingresa el nombre de la persona a buscar");
        String data=scanner.nextLine();
        laSecre.onNombreABuscarIngresado(data);
    }
    
    public void ingresoDeNombreBorrado(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la persona a borrar");
        String data = scan.nextLine();
        laSecre.onIngresadoParaBorrar(data);
    }
    
    public void ingresoDeNombreActualizar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la persona a Actualizar");
        String data = scanner.nextLine();
        laSecre.onIngresadoParaActualizar(data);
    }
    
    public Estudiante ActualizandoCaptura (int index){
        laSecre.onCaptura();
        Scanner sc=new Scanner(System.in);
        Estudiante estudiante=new Estudiante();
        System.out.println("Ingresa nombre del nuevo estudiante");
        String nombre=sc.nextLine();
        System.out.println("Ingresa paterno del nuevo estudiante");
        String paterno=sc.nextLine();
        System.out.println("Ingresa materno del nuevo estudiante");
        String materno=sc.nextLine();
        estudiante.setNombre(nombre);
        estudiante.setMaterno(materno);
        estudiante.setPaterno(paterno);
        laSecre.onActualizando(estudiante, index);
        return estudiante;
    }
    
    public interface onCapturistaAction{
        public void onCaptura();
        public void onErrorOnCaptura();
        public void onNombreABuscarIngresado(String ingresado);
        public void onCapturaTerminada(Estudiante estudiante);
        public void onIngresadoParaBorrar(String ingresado);
        public void onIngresadoParaActualizar(String ingresado);
        public void onActualizando(Estudiante estudiante, int index);
        
    }
    
}
