package Braille_Español;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Letras implements Inter {

    private String character;
    private char[] arreglo;

    public Letras(String ca) {
        this.character = ca;
    }

    public void setCadena(String cad) {
        this.character = cad;
    }

    public String getWord() {
        return character;
    }

    public char[] getCharacter() {
        arreglo = character.toCharArray();
        return arreglo;
    }

    public void PDFnuevo() {
        Document PDFcreation = new Document();
        try {
            
            PdfWriter.getInstance(PDFcreation, new FileOutputStream("Documento.pdf"));
            PDFcreation.open();
            Paragraph Linea = new Paragraph("Traducción Español-Braille");
            Linea.setAlignment(Element.ALIGN_LEFT);
            PDFcreation.add(Linea);
            int x = 25;
            int y = 600;
            String direccion = "C:\\Users\\atlacoNET\\Desktop\\Programacion orientada a objetos\\Braile\\Letras\\";
            String letter = "";
            Paragraph Linea2 = new Paragraph("\nMensaje: "+character+"\" ");
            Linea2.setAlignment(Element.ALIGN_CENTER);
            PDFcreation.add(Linea2);
            char[] arreglo = getCharacter();
            for (int i = 0; i < arreglo.length; i++) {
                if (Character.isUpperCase(arreglo[i]) == true) {
                    Image imane = Image.getInstance(direccion + "mayus.png");
                    imane.setAbsolutePosition(x, y);
                    PDFcreation.add(imane);
                    x = x + 50;
                }

                if (Character.isDigit(arreglo[i]) == true) {
                    Image icono = Image.getInstance(direccion + "number.png");
                    icono.setAbsolutePosition(x, y);
                    PDFcreation.add(icono);
                    x = x + 50;
                }
                for (int l = 0; l < arreglo[i]; l++) {
                    if (arreglo[i] == l) {
                        Image icon = Image.getInstance(arreglo[i] + ".png");
                        icon.setAbsolutePosition(x, y);
                        PDFcreation.add(icon);
                        x = x + 50;
                    }
                }
                for (char q = '0'; q<='9';q++){
                    if (arreglo[i] == q) {
                        letter = q + ".png";
                    }
                }
                for (char j = 'A'; j <= 'Z'; j++) {
                    if (arreglo[i] == j) {
                        String temp = Character.toString(j);
                        temp = temp.toLowerCase();
                        letter = temp + ".png";
                    }
                }
                for (char k = 'a'; k <= 'z'; k++) {
                    if (arreglo[i] == k) {
                        letter = k + ".png";
                    }
                }
                if (arreglo[i] == ' ') {
                    letter = "espacio.png";
                }
                if (arreglo[i] == '&') {
                    letter = "&.png";
                }
                if (arreglo[i] == '*') {
                    letter = "asterisco.png";
                }
                if (arreglo[i] == ',') {
                    letter = "coma.png";
                }
                if (arreglo[i] == '"') {
                    letter = "comillas.png";
                }
                if (arreglo[i] == '¡' || arreglo[i] == '!') {
                    letter = "exclamacion.png";
                }
                if (arreglo[i] == '-') {
                    letter = "guion.png";
                }
                if (arreglo[i] == '¿' || arreglo[i] == '?') {
                    letter = "interrogacion.png";
                }
                if (arreglo[i] == '.') {
                    letter = "punto.png";
                }
                if (arreglo[i] == ';') {
                    letter = "puntocoma.png";
                }

                Image im = Image.getInstance(direccion + letter);
                im.setAbsolutePosition(x, y);
                PDFcreation.add(im);
                if (arreglo[i] == ' ') {
                    y = y - 90;
                    if(y==60){
                        PDFcreation.newPage();
                        y=690;
                    }
                    x = 25;
                } else {
                    x = x + 50;
                }
            }

            PDFcreation.close();
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
