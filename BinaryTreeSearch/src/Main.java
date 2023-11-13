import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Integer> CreateLeft(List<Integer> data) {
        List<Integer> left = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            if (i % 2 != 0) {
                left.add(i);
            }
        }

        for (int i = left.size(); i < data.size(); i++) {
            left.add(null);
        }

        return left;
    }

    public static List<Integer> CreateRight(List<Integer> data) {
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            if (i % 2 == 0) {
                right.add(i);
            }
        }

        for (int i = right.size(); i < data.size(); i++) {
            right.add(null);
        }

        return right;
    }

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>(Arrays.asList(64, 7, 54, 32, 19, 42, 28, 9, 73, 82, 11, 17, 40, 93, 64, 27));

        List<Integer> left = CreateLeft(data);
        List<Integer> right = CreateRight(data);

        System.out.println("Left: " + left);
        System.out.println("Right: " + right);
        System.out.println("Data: " + data);

        PreOrder preOrder = new PreOrder(left, right, data);
        InOrder inOrder = new InOrder(left, right, data);
        PostOrder postOrder = new PostOrder(left, right, data);

        System.out.print("PreOrder: ");
        preOrder.map();
        System.out.print("\nInOrder: ");
        inOrder.map();
        System.out.print("\nPostOrder: " );
        postOrder.map();

    }
}