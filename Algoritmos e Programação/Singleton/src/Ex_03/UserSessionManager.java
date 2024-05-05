package Ex_03;

import Ex_02.Logger;

import java.util.Date;
import java.util.Random;

public class UserSessionManager {
    private static UserSessionManager instance;
    private int sessionToken;
    private String lastAccess;

    private UserSessionManager() {
    }

    public static UserSessionManager getInstance() {
        if (instance == null) {
            instance = new UserSessionManager();
        }
        instance.sessionToken = new Random().nextInt();
        instance.lastAccess = String.valueOf(System.currentTimeMillis());
        return instance;
    }

    public int getSessionToken() {
        //sessionToken= new Random().nextInt();
        return sessionToken;
    }

    public String getLastAccessTime() {
        return lastAccess;
    }

    public String updateLastAccessTime() {
        lastAccess = String.valueOf(System.currentTimeMillis());
        return lastAccess;
    }
    public void exibirDetalhes(){
        Date date= new Date(getLastAccessTime());
        System.out.println("Token de Acesso:" + getSessionToken());
        System.out.println("Último Acesso: " + date);
    }
}
