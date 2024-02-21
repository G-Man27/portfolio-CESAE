import java.util.Scanner;

public class Extra_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String w, r= "resposta inválida";

        while (!r.equals("resposta válida")){
            System.out.print("Está a chover?: ");
            w = input.next();
            if (w.equals("yes") || w.equals("Yes") || w.equals("y")) {
                System.out.println("Traga um guarda-chuva");
                r="resposta válida";
            } else if (w.equals("no") || w.equals("No") || w.equals("n")){
                System.out.println("Não necessita de guarda-chuva.");
                r="resposta válida";
            } else System.out.println(r);
        }
    }
}
