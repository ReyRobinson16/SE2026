package project;

public class TestFailure {
    public void badMethod(){
        int x = 5 // Missing semicolon fails Gradle; bad spacing fails Checkstyle
    }
}