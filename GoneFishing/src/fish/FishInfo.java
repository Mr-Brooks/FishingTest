package fish;

import java.time.LocalDate;

public class FishInfo {
	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate dateOfBirth;
	private FishType classification;
	public LocalDate currentDate;
	
	public FishInfo(String first, String middle, String last, LocalDate dob, FishType classification){
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
		this.dateOfBirth = dob;
		this.classification = classification;
		currentDate = LocalDate.now();
	}
	
	public void setFirst(String name){
		this.firstName = name;
	}
	
	public void setMiddle(String name){
		this.middleName = name;
	}
	
	public void setLast(String name){
		this.lastName = name;
	}
	
	public void setDob(LocalDate date){
		this.dateOfBirth = date;
	}
	
	public void setClassification(FishType classification){
		this.classification = classification;
	}
	
	public String getFirst(){
		return this.firstName;
	}

	public String getMiddle(){
		return this.middleName;
	}
	
	public String getLast(){
		return this.lastName;
	}
	
	public LocalDate getDob(){
		return this.dateOfBirth;
	}
	
	public int getAge(){
		int age = currentDate.getYear() - this.dateOfBirth.getYear();
		if(currentDate.getMonthValue() < this.dateOfBirth.getMonthValue()){
			age--;
		}
		return age;
	}
	
	public FishType getClassification(){
		return this.classification;
	}
}
