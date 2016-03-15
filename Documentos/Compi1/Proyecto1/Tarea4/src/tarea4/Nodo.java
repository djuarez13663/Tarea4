
package tarea4;

import java.util.ArrayList;

public class Nodo {
    
    public String valor;
    public int id,linea,columna,cadena;
    public ArrayList<Nodo> hijos;
    
    public Nodo(){
        
    }
    
    public Nodo(String val){
        this.valor = val;
        this.columna = 0;
        this.hijos = new ArrayList<Nodo>();
        this.id = 0;
        this.linea = 0;
        this.cadena = 0;
        
    }
    
    public Nodo(String val, int lin, int col){
        this.columna = col;
        this.hijos = new ArrayList<Nodo>();
        this.id = 0;
        this.linea = lin;
        this.valor = val;
        this.cadena = 0;
    }
    
    public Nodo(String val, int lin, int col,int cad){
        this.columna = col;
        this.hijos = new ArrayList<Nodo>();
        this.id = 0;
        this.linea = lin;
        this.valor = val;
        this.cadena = cad;
    }
}
