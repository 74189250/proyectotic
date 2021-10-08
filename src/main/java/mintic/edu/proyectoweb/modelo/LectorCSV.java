
package mintic.edu.proyectoweb.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LectorCSV {
    
    private char separador;
    private char comillas;

    public LectorCSV(char separador, char comillas) {
        this.separador = separador;
        this.comillas = comillas;
    }
    
    public List<Producto> leerCSVsimple(String path) throws IOException{
        
        BufferedReader bufferLectura = new BufferedReader(new FileReader(path));
        String linea = bufferLectura.readLine();
        List<Producto> productos = new ArrayList<>();
        ProductoDAO productoDao = new ProductoDAO();
        boolean creado;
        try{
            while (linea != null){
                String[] campos = linea.split(String.valueOf(this.separador));
                Producto pro = new Producto();
                pro.setCodigo(Integer.parseInt(campos[0]));
                pro.setNombre(campos[1]);
                pro.setNitProveedor(Integer.parseInt(campos[2]));
                pro.setPrecioCompra(Double.parseDouble(campos[3]));
                pro.setIva(Double.parseDouble(campos[4]));
                pro.setPrecioVenta(Double.parseDouble(campos[5]));
                creado = productoDao.agregarProducto(pro);
                if (creado){
                    System.out.println("Producto AGREGADO a la Base de Datos: "+ pro.toString());
                }else{
                    System.out.println("No se puede insertar el producto");
                }
                productos.add(pro);
                System.out.println(Arrays.toString(campos));
                linea = bufferLectura.readLine();
                
            }
            if(bufferLectura != null){
                bufferLectura.close();
            }
            
        }catch (Exception e){
            System.out.println("Error: "+e);            
        }
        return productos;
    }
    
}
