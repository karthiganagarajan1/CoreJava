package com.pkg.date24052024;

public class Employee {

	private String name;
	private String dept;
	private int age;
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee(String name, String dept, int age, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + ", salary=" + salary + "]";
	}

}
