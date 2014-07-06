package readablecode;

public class RecipeData {
	private String mRecipeName;
	private long mRecipeId;
	private String mUrl;
	
	@Deprecated
	public RecipeData(long id, String name) {
		mRecipeName = name;
		mRecipeId = id;
	}
	
	public RecipeData(long id, String name,String url){
		mRecipeName = name;
		mRecipeId = id;
		mUrl = url;
		
	}
	
	public String getRecipeName() {
		return mRecipeName;
	}
	
	public long getRecipeId() {
		return mRecipeId;
	}

	public String getUrl() {
		return mUrl;
	}
}
