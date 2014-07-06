package readablecode;

public class RecipeData {
	private String mRecipeName;
	private long mRecipeId;
	
	public RecipeData(long id, String name) {
		mRecipeName = name;
		mRecipeId = id;
	}
	
	public String getRecipeName() {
		return mRecipeName;
	}
	
	public long getRecipeId() {
		return mRecipeId;
	}
}
