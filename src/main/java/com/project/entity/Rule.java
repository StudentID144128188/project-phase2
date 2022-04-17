package com.project.entity;

public class Rule {
	private boolean pet;
	private boolean smoke;
	
	public Rule() {
		super();
	}

	public Rule(boolean pet, boolean smoke) {
		super();
		this.pet = pet;
		this.smoke = smoke;
	}

	public boolean isPet() {
		return pet;
	}

	public void setPet(boolean pet) {
		this.pet = pet;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}

	@Override
	public String toString() {
		return "Rule [pet=" + pet + ", smoke=" + smoke + "]";
	}
	
}
