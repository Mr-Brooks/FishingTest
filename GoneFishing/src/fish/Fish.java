package fish;

import java.time.LocalDate;

public class Fish {
	private FishAddress address;
	private FishInfo	info;
	
	public Fish(){
		
	}
	
	public void loadFish(String first, String middle, String last, LocalDate dob, FishType classification
			, String ocean, String reef, int depth, boolean isHome){
		this.info = new FishInfo(first, middle, last, dob, classification);
		this.address = new FishAddress( ocean, reef, depth, isHome);
	}
	
	public String returnFullName(){
		return this.info.getFirst() + "" + this.info.getMiddle() +
				"" + this.info.getLast();
	}
	
	public LocalDate returnDate(){
		return this.info.getDob();
	}
	
	public FishType returnType(){
		return this.info.getClassification();
	}
	
	public String returnOcean(){
		return this.address.getOcean();
	}
	
	public String returnReef(){
		return this.address.getReef();
	}
	
	public int returnDepth(){
		return this.address.getDepth();
	}
	
	public Boolean returnHome(){
		return this.address.getHome();
	}
	
	public FishInfo getFishInfo(){
		return this.info;
	}
	
	public FishAddress getFishAddress(){
		return this.address;
	}
}
