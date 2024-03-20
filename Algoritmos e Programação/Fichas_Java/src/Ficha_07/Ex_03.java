package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex_03 {
    public static void FazerCopiaFicheiro(String path_origem,String path_destino) throws FileNotFoundException {

        //Instanciar um Scanner para o ficheiro que foi passado por parâmetro
        Scanner fileReader = new Scanner(new File(path_origem));
        PrintWriter maquinaEscrever = new PrintWriter(new File(path_destino));

        while (fileReader.hasNextLine()) {
            String linha = fileReader.nextLine();
            maquinaEscrever.println(linha);
            // ou sem usar variavel linha: maquinaEscrever.println(fileReader.nextLine());
        }
        maquinaEscrever.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Escreva o nome do ficheiro:");
        String  filename = input.nextLine(); //exercicio_03
        System.out.print("Qual é a extensão:");
        String  ext = "."+input.nextLine(); //exercicio_03
        try {
            FazerCopiaFicheiro(("Files/"+filename+ext),("Files/"+filename+"_copia"+ext));
        } catch (FileNotFoundException e) {
            System.out.println("file not found...");
        }
    }
}
