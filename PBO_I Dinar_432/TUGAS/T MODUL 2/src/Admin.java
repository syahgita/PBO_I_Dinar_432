public class Admin {
    private String username = "Dinar Syahgita";
    private String password = "432";

    public boolean login(String inputUser, String inputPass) {
        return this.username.equals(inputUser) && password.equals(inputPass);
    }
}
