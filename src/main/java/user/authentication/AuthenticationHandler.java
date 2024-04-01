package user.authentication;

public class AuthenticationHandler {
    private AuthenticationDAO authenticationDAO;

    public AuthenticationHandler(AuthenticationDAO authenticationDAO) {
        this.authenticationDAO = authenticationDAO;
    }
}
