/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportespdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;


/**
 *
 * @author Manuel
 */
public class PlantillaPDF {
    
    public void plantillaPdfPersonal(JTable tabla){
        
        try {
            
            /*Creo el archivo temporal junto con las instancias Document y pdfWritter
            para poder trabajar con el archivo PDF*/
            File pdfTemporal = File.createTempFile("Reporte", ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(pdfTemporal));
            documento.open(); //Abimos el documento para trabajar con el 
        
            //Parrafo del fecha junto con su tamaño, tipo de letra fuente y alienacion
            Paragraph fecha = new Paragraph();
            fecha.setFont(new Font(Font.FontFamily.TIMES_ROMAN,14));
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha " + new SimpleDateFormat("dd-MM-YYYY").format(date)+"\n\n\n\n\n");
            fecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(fecha);
         
            //Parrafo del titulo junto con su tamaño, tipo de letra fuente y alienacion
            Paragraph titulo = new Paragraph();
            Font fuente = new Font(FontFamily.TIMES_ROMAN, 30);
            titulo.setFont(fuente);
            titulo.add("INFORME OFICIAL \n\n\n");
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setFont(fuente);
            documento.add(titulo);
        
            /*Parrafo del titulo de la tabla de la consulta con la que estamos trabajando 
            junto con su tamaño,tipo de letra fuente y alienacion*/
            Paragraph nombreTabla = new Paragraph();
            nombreTabla.add("Personal de la compañia \n");
            nombreTabla.setFont(new Font(Font.FontFamily.TIMES_ROMAN,14));
            nombreTabla.setAlignment(Element.ALIGN_CENTER);
            documento.add(nombreTabla);
        
            //Creamos la tabla en el PDF con sus caractrísticas
            PdfPTable tablaPdf = new PdfPTable(tabla.getColumnCount());
            // La tabla ocupará el 80% del ancho de la página
            tablaPdf.setWidthPercentage(100); 
            // Agrego 30 puntos de espacio antes de la tabla
            tablaPdf.setSpacingBefore(30);
            // Agrega 10 puntos de espacio después de la tabla
            tablaPdf.setSpacingAfter(10); // Agrega 10 puntos de espacio después de la tabla

            // Añadimos el margen izquierdo, margen derecho, margen superior, margen inferior 
            float[] margins = new float[]{40, 40, 70, 50}; 
            //Establecemos los márgenes del documento
            documento.setMargins(margins[0], margins[1], margins[2], margins[3]);
        
            /*Recorremos la tabla de la interfaz, para obtener los encabezados de 
            la tabla y así agregarlos, junto con el tipo de letra, el tamano, y 
            la alineacion*/
            for(int i=0; i<tabla.getColumnCount();i++){
                PdfPCell tituloColumna = new PdfPCell(new Phrase(tabla.getColumnName(i),
                    new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
                tituloColumna.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaPdf.addCell(tituloColumna);
           
            }
            
            /*Recorremos la tabla de la interfaz, para obtener los datos de la 
            tabla y así agregarlos, junto con el tipo de letra, el tamano, y 
            la alineacion*/
            Font tamanoDatos = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
            
            for(int i=0;i<tabla.getRowCount();i++){
                for(int j=0; j<tabla.getColumnCount();j++){
                    tablaPdf.addCell(new Phrase(tabla.getValueAt(i, j).toString(), tamanoDatos));
                }
            
            }
            
            //Las celdas de la tabla se redimensionan en funcion del tamano del dato
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            //Agregamos la tabla al documento y lo cerramos
            documento.add(tablaPdf);
            documento.close(); 
            //Abrimos el documento creado
            Desktop.getDesktop().open(pdfTemporal);
        
            }catch(DocumentException | IOException ex) {
              
                JOptionPane.showMessageDialog(null, "No ha sido posible "
                        + "generar el archivo Pdf");
                    
            } 
        
    }

    public void plantillaArmamento(JTable tabla){
        
        try {
            
            /*Creo el archivo temporal junto con las instancias Document y pdfWritter
            para poder trabajar con el archivo PDF*/
            File pdfTemporal = File.createTempFile("Reporte", ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(pdfTemporal));
            documento.open(); //Abimos el documento para trabajar con el 
        
            //Parrafo del fecha junto con su tamaño, tipo de letra fuente y alienacion
            Paragraph fecha = new Paragraph();
            fecha.setFont(new Font(Font.FontFamily.TIMES_ROMAN,14));
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha " + new SimpleDateFormat("dd-MM-YYYY").format(date)+"\n\n\n\n\n");
            fecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(fecha);
         
            //Parrafo del titulo junto con su tamaño, tipo de letra fuente y alienacion
            Paragraph titulo = new Paragraph();
            Font fuente = new Font(FontFamily.TIMES_ROMAN, 30);
            titulo.setFont(fuente);
            titulo.add("INFORME OFICIAL \n\n\n");
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setFont(fuente);
            documento.add(titulo);
        
            /*Parrafo del titulo de la tabla de la consulta con la que estamos trabajando 
            junto con su tamaño,tipo de letra fuente y alienacion*/
            Paragraph nombreTabla = new Paragraph();
            nombreTabla.add("Armamento de la compañia \n");
            nombreTabla.setFont(new Font(Font.FontFamily.TIMES_ROMAN,14));
            nombreTabla.setAlignment(Element.ALIGN_CENTER);
            documento.add(nombreTabla);
        
            //Creamos la tabla en el PDF con sus caractrísticas
            PdfPTable tablaPdf = new PdfPTable(tabla.getColumnCount());
            // La tabla ocupará el 80% del ancho de la página
            tablaPdf.setWidthPercentage(100); 
            // Agrego 30 puntos de espacio antes de la tabla
            tablaPdf.setSpacingBefore(30);
            // Agrega 10 puntos de espacio después de la tabla
            tablaPdf.setSpacingAfter(10); // Agrega 10 puntos de espacio después de la tabla

            // Añadimos el margen izquierdo, margen derecho, margen superior, margen inferior 
            float[] margins = new float[]{40, 40, 70, 50}; 
            //Establecemos los márgenes del documento
            documento.setMargins(margins[0], margins[1], margins[2], margins[3]);
        
            /*Recorremos la tabla de la interfaz, para obtener los encabezados de 
            la tabla y así agregarlos, junto con el tipo de letra, el tamano, y 
            la alineacion*/
            for(int i=0; i<tabla.getColumnCount();i++){
                PdfPCell tituloColumna = new PdfPCell(new Phrase(tabla.getColumnName(i),
                    new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
                tituloColumna.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaPdf.addCell(tituloColumna);
           
            }
            
            /*Recorremos la tabla de la interfaz, para obtener los datos de la 
            tabla y así agregarlos, junto con el tipo de letra, el tamano, y 
            la alineacion*/
            Font tamanoDatos = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
            
            for(int i=0;i<tabla.getRowCount();i++){
                for(int j=0; j<tabla.getColumnCount();j++){
                    tablaPdf.addCell(new Phrase(tabla.getValueAt(i, j).toString(), tamanoDatos));
                }
            
            }
            
            //Las celdas de la tabla se redimensionan en funcion del tamano del dato
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            //Agregamos la tabla al documento y lo cerramos
            documento.add(tablaPdf);
            documento.close(); 
            //Abrimos el documento creado
            Desktop.getDesktop().open(pdfTemporal);
        
            }catch(DocumentException | IOException ex) {
              
                JOptionPane.showMessageDialog(null, "No ha sido posible "
                        + "generar el archivo Pdf");
                    
            } 
        
    }
    
    public void plantillaVehiculos(JTable tabla){
        
        try {
            
            /*Creo el archivo temporal junto con las instancias Document y pdfWritter
            para poder trabajar con el archivo PDF*/
            File pdfTemporal = File.createTempFile("Reporte", ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(pdfTemporal));
            documento.open(); //Abimos el documento para trabajar con el 
        
            //Parrafo del fecha junto con su tamaño, tipo de letra fuente y alienacion
            Paragraph fecha = new Paragraph();
            fecha.setFont(new Font(Font.FontFamily.TIMES_ROMAN,14));
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha " + new SimpleDateFormat("dd-MM-YYYY").format(date)+"\n\n\n\n\n");
            fecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(fecha);
         
            //Parrafo del titulo junto con su tamaño, tipo de letra fuente y alienacion
            Paragraph titulo = new Paragraph();
            Font fuente = new Font(FontFamily.TIMES_ROMAN, 30);
            titulo.setFont(fuente);
            titulo.add("INFORME OFICIAL \n\n\n");
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setFont(fuente);
            documento.add(titulo);
        
            /*Parrafo del titulo de la tabla de la consulta con la que estamos trabajando 
            junto con su tamaño,tipo de letra fuente y alienacion*/
            Paragraph nombreTabla = new Paragraph();
            nombreTabla.add("Vehiculos de la compañia \n");
            nombreTabla.setFont(new Font(Font.FontFamily.TIMES_ROMAN,14));
            nombreTabla.setAlignment(Element.ALIGN_CENTER);
            documento.add(nombreTabla);
        
            //Creamos la tabla en el PDF con sus caractrísticas
            PdfPTable tablaPdf = new PdfPTable(tabla.getColumnCount());
            // La tabla ocupará el 80% del ancho de la página
            tablaPdf.setWidthPercentage(100); 
            // Agrego 30 puntos de espacio antes de la tabla
            tablaPdf.setSpacingBefore(30);
            // Agrega 10 puntos de espacio después de la tabla
            tablaPdf.setSpacingAfter(10); // Agrega 10 puntos de espacio después de la tabla

            // Añadimos el margen izquierdo, margen derecho, margen superior, margen inferior 
            float[] margins = new float[]{40, 40, 70, 50}; 
            //Establecemos los márgenes del documento
            documento.setMargins(margins[0], margins[1], margins[2], margins[3]);
        
            /*Recorremos la tabla de la interfaz, para obtener los encabezados de 
            la tabla y así agregarlos, junto con el tipo de letra, el tamano, y 
            la alineacion*/
            for(int i=0; i<tabla.getColumnCount();i++){
                PdfPCell tituloColumna = new PdfPCell(new Phrase(tabla.getColumnName(i),
                    new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
                tituloColumna.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaPdf.addCell(tituloColumna);
           
            }
            
            /*Recorremos la tabla de la interfaz, para obtener los datos de la 
            tabla y así agregarlos, junto con el tipo de letra, el tamano, y 
            la alineacion*/
            Font tamanoDatos = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
            
            for(int i=0;i<tabla.getRowCount();i++){
                for(int j=0; j<tabla.getColumnCount();j++){
                    tablaPdf.addCell(new Phrase(tabla.getValueAt(i, j).toString(), tamanoDatos));
                }
            
            }
            
            //Las celdas de la tabla se redimensionan en funcion del tamano del dato
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            //Agregamos la tabla al documento y lo cerramos
            documento.add(tablaPdf);
            documento.close(); 
            //Abrimos el documento creado
            Desktop.getDesktop().open(pdfTemporal);
        
            }catch(DocumentException | IOException ex) {
              
                JOptionPane.showMessageDialog(null, "No ha sido posible "
                        + "generar el archivo Pdf");
                    
            } 
        
    }
    
    public void plantillaTransmisiones(JTable tabla){
        
        try {
            
            /*Creo el archivo temporal junto con las instancias Document y pdfWritter
            para poder trabajar con el archivo PDF*/
            File pdfTemporal = File.createTempFile("Reporte", ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(pdfTemporal));
            documento.open(); //Abimos el documento para trabajar con el 
        
            //Parrafo del fecha junto con su tamaño, tipo de letra fuente y alienacion
            Paragraph fecha = new Paragraph();
            fecha.setFont(new Font(Font.FontFamily.TIMES_ROMAN,14));
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha " + new SimpleDateFormat("dd-MM-YYYY").format(date)+"\n\n\n\n\n");
            fecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(fecha);
         
            //Parrafo del titulo junto con su tamaño, tipo de letra fuente y alienacion
            Paragraph titulo = new Paragraph();
            Font fuente = new Font(FontFamily.TIMES_ROMAN, 30);
            titulo.setFont(fuente);
            titulo.add("INFORME OFICIAL \n\n\n");
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setFont(fuente);
            documento.add(titulo);
        
            /*Parrafo del titulo de la tabla de la consulta con la que estamos trabajando 
            junto con su tamaño,tipo de letra fuente y alienacion*/
            Paragraph nombreTabla = new Paragraph();
            nombreTabla.add("Transmisiones de la compañia \n");
            nombreTabla.setFont(new Font(Font.FontFamily.TIMES_ROMAN,14));
            nombreTabla.setAlignment(Element.ALIGN_CENTER);
            documento.add(nombreTabla);
        
            //Creamos la tabla en el PDF con sus caractrísticas
            PdfPTable tablaPdf = new PdfPTable(tabla.getColumnCount());
            // La tabla ocupará el 80% del ancho de la página
            tablaPdf.setWidthPercentage(100); 
            // Agrego 30 puntos de espacio antes de la tabla
            tablaPdf.setSpacingBefore(30);
            // Agrega 10 puntos de espacio después de la tabla
            tablaPdf.setSpacingAfter(10); // Agrega 10 puntos de espacio después de la tabla

            // Añadimos el margen izquierdo, margen derecho, margen superior, margen inferior 
            float[] margins = new float[]{40, 40, 70, 50}; 
            //Establecemos los márgenes del documento
            documento.setMargins(margins[0], margins[1], margins[2], margins[3]);
        
            /*Recorremos la tabla de la interfaz, para obtener los encabezados de 
            la tabla y así agregarlos, junto con el tipo de letra, el tamano, y 
            la alineacion*/
            for(int i=0; i<tabla.getColumnCount();i++){
                PdfPCell tituloColumna = new PdfPCell(new Phrase(tabla.getColumnName(i),
                    new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
                tituloColumna.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaPdf.addCell(tituloColumna);
           
            }
            
            /*Recorremos la tabla de la interfaz, para obtener los datos de la 
            tabla y así agregarlos, junto con el tipo de letra, el tamano, y 
            la alineacion*/
            Font tamanoDatos = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
            
            for(int i=0;i<tabla.getRowCount();i++){
                for(int j=0; j<tabla.getColumnCount();j++){
                    tablaPdf.addCell(new Phrase(tabla.getValueAt(i, j).toString(), tamanoDatos));
                }
            
            }
            
            //Las celdas de la tabla se redimensionan en funcion del tamano del dato
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            //Agregamos la tabla al documento y lo cerramos
            documento.add(tablaPdf);
            documento.close(); 
            //Abrimos el documento creado
            Desktop.getDesktop().open(pdfTemporal);
        
            }catch(DocumentException | IOException ex) {
              
                JOptionPane.showMessageDialog(null, "No ha sido posible "
                        + "generar el archivo Pdf");
                    
            } 
        
    }
    
}
