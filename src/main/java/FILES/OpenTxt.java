package FILES;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class OpenTxt {
    String openFile;
    public OpenTxt() {
    }

    public OpenTxt(String openFile) {
        this.openFile = openFile;
    }

    /**
     * présente le moyen le plus simple de lire un petit fichier. Puisqu’il s’agit d’un petit fichier,
     * nous allouons directement la mémoire requise à ByteBuffer en utilisant la taille de` FileChannel`.
     */
    public void LireFichierJavaNio() throws IOException {
        RandomAccessFile file = new RandomAccessFile(openFile, "r");
        FileChannel channel = file.getChannel();
        System.out.println("File size is: " + channel.size());
        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
        channel.read(buffer);
        buffer.flip();//Restore buffer to position 0 to read it
        System.out.println("Reading content and printing ... ");
        for (int i = 0; i < channel.size(); i++) {
            System.out.print((char) buffer.get());
        }
        channel.close();
        file.close();
    }

    /**
     * Lire txt en utilisant BufferReader.
     * BufferedReader est une classe qui simplifie la lecture de texte à partir d’un flux de saisie de caractères.
     * Il met les caractères en mémoire tampon afin de permettre une lecture efficace des données de texte.
     * En général, BufferedReader est pratique si nous voulons lire du texte à partir de n’importe quel type de source d’entrée, qu’il s’agisse de fichiers,
     * de sockets ou de quelque chose d’autre.
     * En termes simples, cela nous permet de réduire le nombre d’opérations d’E/S en lisant des morceaux de caractères et en les stockant dans un tampon interne.
     * Tant que le tampon contient des données, le lecteur les lira au lieu de le regarder directement dans le flux sous-jacent.
     */
    public void LireFichierBufferReader(){
        try {

            File f = new File(openFile);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            System.out.println("Reading file using Buffered Reader");
            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Lire fichier txt en utilisant apache commons io.
     */
    public void LireFichierApacheCommon(){
        try {
            File f = new File(openFile);
            System.out.println("Reading files using Apache IO:");
            List<String> lines = FileUtils.readLines(f, "UTF-8");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static void main(String[] args) throws IOException {
        OpenTxt txt = new OpenTxt("./test");
        txt.LireFichierJavaNio();
        txt.LireFichierBufferReader();
        txt.LireFichierApacheCommon();
}
}


