package com.examportal.payload;

public class QuizResults {
	
	private int totalQuestions;
	private int attempted;
	private int totalMarks;
	private int obtainedMarks;
	private int correctAnswers;
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public int getAttempted() {
		return attempted;
	}
	public void setAttempted(int attempted) {
		this.attempted = attempted;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	public QuizResults(int totalQuestions, int attempted, int totalMarks, int obtainedMarks, int correctAnswers) {
		super();
		this.totalQuestions = totalQuestions;
		this.attempted = attempted;
		this.totalMarks = totalMarks;
		this.obtainedMarks = obtainedMarks;
		this.correctAnswers = correctAnswers;
	}
	public QuizResults() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Results [totalQuestions=" + totalQuestions + ", attempted=" + attempted + ", totalMarks=" + totalMarks
				+ ", obtainedMarks=" + obtainedMarks + ", correctAnswers=" + correctAnswers + "]";
	}
	
	

}
