
package investwise.user;

public abstract class User {
    protected String name;
    protected String email;
    protected String username;
    protected String password;

    public abstract boolean login(String email, String password);
    public abstract boolean signup(String name, String email, String username, String password);


    public String getName() {
        return name;
    }

    public String getEmail() { 
        return email;
    }

    public String getUsername() {
        return username;
    }

}
