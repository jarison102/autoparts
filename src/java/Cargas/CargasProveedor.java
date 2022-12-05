///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Cargas;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// *
// * @author asus
// */
//public class CargasProveedor{
//    
//    public static void main(String[] args) throws IOException, FileNotFoundException, SQLException{
//        crearArchivo();
////leerArchivo();
////cargarDatos();
////modificarArchivo();
//
//    }
//    public static void crearArchivo(){
//        Workbook libro = new XSSFWorkbook();
//        org.apache.poi.ss.usermodel.Sheet hoja =  libro.createSheet("Datos");
//      
//        try{
//            FileOutputStream archivo = new FileOutputStream(new File("Datos.xlsx"));
//            libro.write(archivo);
//            archivo.close();
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,"Error :" + e);    
//        }     
//    }
//    
//    public static void leerArchivo() throws FileNotFoundException, IOException{
//        FileInputStream archivo = new FileInputStream("C:\\Productos.xlsx");
//        XSSFWorkbook libro = new XSSFWorkbook(archivo);
//        XSSFSheet hoja = libro.getSheetAt(0);
//        
//        int numero_filas = hoja.getLastRowNum();
//        for(int i=0; i<= numero_filas; i++){ 
//            Row  fila = hoja.getRow(i);
//            
//        int numero_columnas = fila.getLastCellNum();
//        
//        for(int j=0; j< numero_columnas; j++){
//            Cell celda = fila.getCell(j);
//            
//            switch((celda.getCellTypeEnum()).toString()){
//                case "NUMERIC":
//                    System.out.print(celda.getNumericCellValue() + " ");
//                    break;
//                case "STRING":
//                    System.out.print(celda.getStringCellValue() + " ");
//                    break;   
//                }
//            }
//            System.out.println("");
//        }     
//    }
//    
//    public static void  cargarDatos() throws FileNotFoundException, IOException, SQLException{
//        FileInputStream archivo = new FileInputStream("C:\\Proveedores.xlsx");
//        XSSFWorkbook libro = new XSSFWorkbook(archivo);
//        XSSFSheet hoja = libro.getSheetAt(0);
//        
//        int numero_filas = hoja.getLastRowNum();
//        for(int i=0; i <=numero_filas; i++){
//            
//            Row fila = hoja.getRow(i);
//            ConexionBD conexion = new ConexionBD();
//            Connection conectar = conexion.obtenerConexion();
//            
//            PreparedStatement insertar = conectar.prepareStatement("insert into proveedor(nombre_proveedor,telefono_proveedor,correo_proveedor)values(?,?,?)");
//            insertar.setString(1,fila.getCell(0).getStringCellValue());
//            insertar.setString(2,fila.getCell(1).getStringCellValue());
//            insertar.setString(3,fila.getCell(2).getStringCellValue());
//            insertar.executeUpdate();
//        }
//    }
//    public static void modificarArchivo() throws FileNotFoundException, IOException{
//        FileInputStream archivo = new FileInputStream("C:\\Proveedores.xlsx");
//        XSSFWorkbook libro = new XSSFWorkbook(archivo);
//        XSSFSheet hoja = libro.getSheetAt(0);
//        
//        XSSFRow fila = hoja.getRow(1);
//        if(fila == null){
//            fila = hoja.createRow(1);
//        }
//        
//        XSSFCell celda = fila.createCell(1);
//        if(celda == null){
//            celda = fila.createCell(1);
//        }
//        
//        celda.setCellValue("Modificacion");
//        archivo.close();
//        
//        FileOutputStream output = new FileOutputStream("C:\\Nuevo.xlsx");
//        libro.write(output);
//        output.close();
//    } 
//}
