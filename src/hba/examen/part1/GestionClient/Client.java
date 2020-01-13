package hba.examen.part1.GestionClient;

import hba.examen.part1.GestionCommand.Command;

import java.util.List;

public class Client {
    private long id;
    private String nom;
    private String tel;
    private String login;
    private String pwd;

    private List<Command> commands;

    public Client(long id, String nom, String tel, String login, String pwd) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.login = login;
        this.pwd = pwd;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return nom;
    }
}
