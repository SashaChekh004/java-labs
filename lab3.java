import java.util.ArrayList;
import java.util.List;

//7 VARIANT

public class lab3 {

    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);
        numbers.add(5.0);
        numbers.add(6.0);
        numbers.add(7.0);
        numbers.add(8.0);
        numbers.add(9.0);
        numbers.add(10.0);

        double result = pairwiseSum(numbers);

        System.out.println("Pair sum result: " + result);
    }

    private static double pairwiseSum(List<Double> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        while (numbers.size() > 1) {
            numbers = pairwiseSumStep(numbers);
            System.out.println(numbers);
        }

        return numbers.get(0);
    }

    private static List<Double> pairwiseSumStep(List<Double> numbers) {
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i += 2) {
            result.add(numbers.get(i) + numbers.get(i + 1));
        }

        if (numbers.size() % 2 != 0) {
            result.add(numbers.get(numbers.size() - 1));
        }

        return result;
    }
}