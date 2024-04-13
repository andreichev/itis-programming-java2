package ru.itis.stream_api.model;

public class Student {
    private String firstName;
    private String lastName;
    private int score;

    public Student(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(score > 100 || score < 0) {
            System.out.println("Wrong score");
            return;
        }
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public String getScoreDescription() {
        if (score < 56) {
            return "Неуд";
        } else if(score < 71) {
            return "Удовлетворительно";
        } else if(score < 87) {
            return "Хорошо";
        } else {
            return "Отлично";
        }
    }

    public void setScore(int score) {
        if(score > 100 || score < 0) {
            System.out.println("Wrong score");
            return;
        }
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student {" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", score=" + score +
                " }";
    }
}
