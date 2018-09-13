package _01_basic.homework;

public class Exam01_Board_vo {
	private String cityName;
	private String employeeName;
	private int salary;
	
	public Exam01_Board_vo() {
		super();
	}
	public Exam01_Board_vo(String cityName, String employeeName, int salary) {
		super();
		this.cityName = cityName;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
} // end class
