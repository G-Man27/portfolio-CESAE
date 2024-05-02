package Ex_02;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private String nome_do_ficheiro;
    private Logger(String nome_do_ficheiro) {
        this.nome_do_ficheiro = "src/Ex_02/"+nome_do_ficheiro;
    }
    public static synchronized Logger getInstance(String nome_do_ficheiro) {
        if (instance == null) {
            instance = new Logger(nome_do_ficheiro);
        }return instance;
    }
    public void log(String message) throws IOException {
        FileWriter MessageLogger = new FileWriter(nome_do_ficheiro,true);
        MessageLogger.append(message + "\n" );
        MessageLogger.close();
    }

}
