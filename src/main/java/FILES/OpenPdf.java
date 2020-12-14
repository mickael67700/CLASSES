package FILES;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class OpenPdf {
    String filePdf;

    public OpenPdf(String filePdf) {
        this.filePdf = filePdf;
    }
    public void readPdf (){
    try {

        File pdfFile = new File(filePdf);
        if (pdfFile.exists()) {

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Awt Desktop is not supported!");
            }

        } else {
            System.out.println("File is not exists!");
        }

        System.out.println("Done");

    } catch (Exception ex) {
        ex.printStackTrace();
    }

}
public static void main(String [] args){
        System.out.println("Path and name for the pdf file to open: \n" +
                "example : /temp/file.pdf");
        OpenPdf openPdf = new OpenPdf(new Scanner(System.in).nextLine());
        openPdf.readPdf();
}
}
