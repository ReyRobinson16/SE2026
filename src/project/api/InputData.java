
package project.api;

import java.util.List;

public class InputData {

    private final List<Integer> numbers;

    public InputData(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
