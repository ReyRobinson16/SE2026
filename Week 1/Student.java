// Make all fields private
// Update the `updateGpa` method to remove the unused `reason` parameter.

public class Student {
    public String fullName;
    public int rollNumber;
    public double gradePointAverage;

    public Student(String fullName, int rollNumber, double gradePointAverage) {
        this.fullName = fullName;
        this.rollNumber = rollNumber;
        this.gradePointAverage = gradePointAverage;
    }

    public void updateGpa(double newGpa, String reason) {
        this.gradePointAverage = newGpa;
    }
}