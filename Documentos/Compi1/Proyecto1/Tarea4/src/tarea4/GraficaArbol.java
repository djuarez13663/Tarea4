

package tarea4;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GraficaArbol {
    
    int contador;
    
    public void graficarAST(Nodo Raiz){
        String ruta_dot = "/home/DanielJ/SalidasDot/tarea4.dot"; 
        String ruta_png = "/home/DanielJ/SalidasDot/tarea4.png"; 
        
        this.ArmarCuerpo(Raiz, ruta_dot);
        
        this.CrearGrafo(ruta_dot, ruta_png);
        
        this.Abrir(ruta_png);
    }
    
    private void ArmarCuerpo(Nodo Raiz, String ruta_dot){
        contador = 0;
        StringBuffer buffer = new StringBuffer();
        buffer.append("\ndigraph G {\r\nnode [shape=box, style=filled, color=khaki1, fontcolor=black];\n");
        this.ListarNodos(Raiz, buffer);
        this.EnlazarNodos(Raiz, buffer);
        buffer.append("}");
        this.CrearArchivo(ruta_dot, buffer.toString());
    }
    
    private void ListarNodos(Nodo praiz, StringBuffer buffer){
        if(praiz.cadena == 1){
            buffer.append("node").append(contador).append("[label=\"").append("\"" + praiz.valor + "\"").append("\"];\n");
        }else{
            buffer.append("node").append(contador).append("[label=\"").append(praiz.valor).append("\"];\n");
        }
        praiz.id = contador;
        contador++;
        for(Nodo temp:praiz.hijos){
            ListarNodos(temp, buffer);
        }
    }
    
    private void EnlazarNodos(Nodo praiz, StringBuffer buffer){
        for(Nodo temp:praiz.hijos){
            String relacion = "\"node"+praiz.id+"\"->";
            relacion += "\"node"+temp.id+"\";\n";
            buffer.append(relacion);
            EnlazarNodos(temp,buffer);
        }
    }
    
    private void CrearArchivo(String fichero, String contenido){
        FileWriter archivo = null;
        
        try{
            archivo = new FileWriter(fichero);
            
        }catch (IOException ex){
            
        }
        
        File a = new File(fichero);
        if(!a.exists()){
            return;
        }
        try(PrintWriter printwriter = new PrintWriter(archivo)){
            printwriter.print(contenido);
            printwriter.close();
        }
    }
 
    private void CrearGrafo(String rutadot, String rutapng){
        String tparam = "-Tpng";
        String tOparam = "-o";
        String[] cmd = new String[5];
        cmd[0] = "dot";
        cmd[1] = tparam;
        cmd[2] = rutadot;
        cmd[3] = tOparam;
        cmd[4] = rutapng;
        
        Runtime rt = Runtime.getRuntime();
        
        try{
            rt.exec(cmd);
        }catch (IOException ex){
            
        }
    }
    
    private void Abrir(String ruta){
        try
        {
            if(new File(ruta).exists())
            {
                String cmd = new String();
                cmd = "gnome-open /home/DanielJ/SalidasDot/tarea4.png";
                System.out.println(cmd);
                Runtime rt = Runtime.getRuntime();
                rt.exec(cmd);
            }
        }
        catch (IOException ex) 
        {
        
        }
    }
}
