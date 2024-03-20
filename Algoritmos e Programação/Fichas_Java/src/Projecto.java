import java.sql.Array;
import java.util.Scanner;

public class Projecto {
    public static int UserType(String username){
        int usertype=0;//0 não encontrado;
        //admin==1;
        //user==2;
        return usertype;
    }
    public static String[] Login(){
        Scanner input = new Scanner(System.in);
        int usertype;
        String username, password, path;
        String[] login = new String[2];
        do {
            System.out.print("username: ");
            username= input.next();
            usertype=UserType(username);
        }while (usertype==0);
        switch (usertype){
            case 1:
                path="";
                break;
            case 1:
                path="";
                break;
        }
        do {
            System.out.print("password: ");
            //pesquisar no csv do path se a pass correspondente ao username é .equal
        }while ();
        login={username,usertype};
        return login;
    }
    public static void main(String[] args) {
        boolean loged=true;
        Scanner input = new Scanner(System.in);

        do {
            String[] user = Login();
            if (user[0]==1)/*menu ADMIN*/{
                do {

                }while ();
            }else if(user[0]==2)/*menu user*/{do{}while ();}



            System.out.print("Quer fazer um novo login(1:sim|2:não): ");
            switch (input.nextInt()){
                case 1:
                    break;
                case 2:
                    loged=false;
                    break;
            }


        }while (loged);

    }
}
