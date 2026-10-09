package project.api;

public class ComputeRequest {
    private final int inputNumber;

    public ComputeRequest(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getInputNumber() {
        return inputNumber;
    }
}