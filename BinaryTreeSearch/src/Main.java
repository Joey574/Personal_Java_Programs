import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>(Arrays.asList(64, 7, 54, 32, 19, 42, 28, 9));
        List<Integer> left = new ArrayList<>(Arrays.asList(1, 3, 5, 7, null, null, null, null));
        List<Integer> right = new ArrayList<>(Arrays.asList(2, 4, 6, null, null, null, null, null));

        InOrder postOrder = new InOrder(left, right, data);
        postOrder.map();

    }
}