package com.project.entity;

public class Comment {
	private int convenient;
	private int quiet;
	private int walkable;
	private int safe;
	private int transportation;
	private int rating;
	private int total;
	
	public Comment() {
		super();
	}
	
	public Comment(int convenient, int quiet, int walkable, int safe, int transportation, int rating, int total) {
		super();
		this.convenient = convenient;
		this.quiet = quiet;
		this.walkable = walkable;
		this.safe = safe;
		this.transportation = transportation;
		this.rating = rating;
		this.total = total;
	}

	public int getConvenient() {
		return convenient;
	}

	public void setConvenient(int convenient) {
		this.convenient = convenient;
	}

	public int getQuiet() {
		return quiet;
	}

	public void setQuiet(int quiet) {
		this.quiet = quiet;
	}

	public int getWalkable() {
		return walkable;
	}

	public void setWalkable(int walkable) {
		this.walkable = walkable;
	}

	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}

	public int getTransportation() {
		return transportation;
	}

	public void setTransportation(int transportation) {
		this.transportation = transportation;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Comment [convenient=" + convenient + ", quiet=" + quiet + ", walkable=" + walkable
				+ ", safe=" + safe + ", transportation=" + transportation + ", rating=" + rating + ", total=" + total
				+ "]";
	}

}
