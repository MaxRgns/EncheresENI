package fr.eni.EncheresENI.bll;

public class UtilisateurManagerSingl {
<<<<<<< HEAD
	
	private static UtilisateurManager instance;

	public static UtilisateurManager getInstance() {

=======
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
>>>>>>> origin/dev
		if (instance == null) {
			instance = new UtilisateurManagerImpl();
		}
		return instance;
	}
<<<<<<< HEAD

=======
>>>>>>> origin/dev
}
