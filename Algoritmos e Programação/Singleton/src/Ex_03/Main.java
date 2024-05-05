package Ex_03;

public class Main {
    public static void main(String[] args) {
        UserSessionManager sessionManager = UserSessionManager.getInstance( );
        System.out.println("Token de Acesso:" + sessionManager.getSessionToken( ));
        System.out.println("Último Acesso: " + sessionManager.getLastAccessTime( ));
        sessionManager.updateLastAccessTime();
        System.out.println("Token de Acesso:" + sessionManager.getSessionToken());
        System.out.println("Último Acesso: " + sessionManager.getLastAccessTime());

        UserSessionManager sessionManager2 = UserSessionManager.getInstance( );
        sessionManager.updateLastAccessTime();
        System.out.println("Token de Acesso:" + sessionManager2.getSessionToken());
        System.out.println("Último Acesso: " + sessionManager2.getLastAccessTime());
        System.out.println("Token de Acesso:" + sessionManager.getSessionToken());
        System.out.println("Último Acesso: " + sessionManager.getLastAccessTime());
        sessionManager.exibirDetalhes();
    }
}
