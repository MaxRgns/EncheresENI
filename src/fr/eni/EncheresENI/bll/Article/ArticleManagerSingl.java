package fr.eni.EncheresENI.bll.Article;

public class ArticleManagerSingl {

	private static ArticleManager instance;
	
	public static ArticleManager getInstance() {

		if (instance == null) {
			instance = new ArticleManagerImpl();
		}
		return instance;
	}

}
