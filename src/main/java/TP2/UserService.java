package TP2;

// UserService.java
public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        boolean success = utilisateurApi.creerUtilisateur(utilisateur);
        if (!success) {
            throw new ServiceException("Failed to create user");
        }
    }
}


