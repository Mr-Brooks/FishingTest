package fish;

public class FishAddress {
	private String ocean;
	private String reef;
	private int depth;
	private boolean isHome;
	
	public FishAddress(String ocean, String reef, int depth, boolean isHome){
		this.ocean = ocean;
		this.reef = reef;
		this.depth = depth;
		this.isHome = isHome;
	}
	
	public void setOcean(String ocean){
		this.ocean = ocean;
	}
	
	public void setReef(String reef){
		this.reef = reef;
		
	}
	
	public void setDepth(int depth){
		this.depth = depth;
	}
	
	public void setHome(boolean home){
		this.isHome = home;
	}
	
	public String getOcean(){
		return this.ocean;
	}
	
	public String getReef(){
		return this.reef;
	}
	
	public int getDepth(){
		return this.depth;
	}
	
	public boolean getHome(){
		return this.isHome;
	}

}
