package FILES;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt {
    String writeFile;
    public WriteTxt(String writeFile) {
        this.writeFile = writeFile;
    }

    /**
     * Un exemple classique de BufferedWriter pour écrire du contenu dans un fichier, créez le fichier s’il n’existe pas, le contenu existant sera remplacé.
     */
    public void writeFileBufferedWriter(){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String content = "This is the content to write into file\n";
            fw = new FileWriter(writeFile);
            bw = new BufferedWriter(fw);
            bw.write(content);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Exemple try-with-resources pour fermer automatiquement le rédacteur de fichier.
     */
    public void writeFileResources(){
        //Pour ajouter du contenu à la fin d’un fichier, transmettez un true à` FileWriter` (FileWriter fw = new FileWriter(FILENAME, true);)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile,true))) {
            String content = "Exemple try-with-resources pour fermer automatiquement le rédacteur de fichier. \n";
            bw.write(content);
            //no need to close it.
            //bw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        WriteTxt writeTxt = new WriteTxt("./testEcriture");
       // writeTxt.writeFileBufferedWriter();
        writeTxt.writeFileResources();
    }
}

