package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks){
        this.possibleMarks = possibleMarks;

    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        return calculateLetterGrade();
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String calculateLetterGrade(){
        double numberGrade = (earnedMarks / (double) possibleMarks) * 100;

        if(numberGrade >= 90){
            return "A";
        }else if(numberGrade > 79 && numberGrade < 90){
            return "B";
        }else if(numberGrade > 69 && numberGrade < 80){
            return "C";
        }else if(numberGrade > 59 && numberGrade < 70){
            return "D";
        }else{
            return "F";
        }
    }
}
