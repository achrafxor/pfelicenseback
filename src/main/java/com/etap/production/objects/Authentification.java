package com.etap.production.objects;

public class Authentification {
        private  String Login;
    private String Mdp;

    public Authentification(String Login,String mdp){
        this.Login=Login;
        this.Mdp=Mdp;
    }
    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String mdp) {
        this.Mdp = mdp;
    }
}
