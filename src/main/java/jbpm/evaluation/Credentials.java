package jbpm.evaluation;

public class Credentials {

    private String serverUrl = "http://192.168.2.254:8080/kie-server/services/rest/server";

    private String username, password;

    public void login (String user) {
        if (user.equals("bogo")) {
            username = "bogo";
            password = "atiila";
        } else
        if (user.equals("john")) {
            username = "john";
            password= "john";
        } else
        if (user.equals("mary")) {
            username = "mary";
            password = "mary";
        } else {
            username = "";
            password = "";
        }
    }

    public String getServerUrl () {
        return this.serverUrl;
    }

    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }
}
