import com.sun.jdi.event.ExceptionEvent;

import java.util.List;

public class PostOrder {


    List<Integer> left;
    List<Integer> right;
    List<Integer> data;

    PostOrder(List<Integer> left, List<Integer> right, List<Integer> data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public int find(int target) {
        int out = -1;
        int loc = 0;

        try {
            if (left.get(loc) != null) {
                int temp = find(target, left.get(loc));
                if (temp != -1) {
                    return temp;
                }
            }
            if (right.get(loc) != null) {
                int temp = find(target, right.get(loc));
                if (temp != -1) {
                    return temp;
                }
            }

            if (data.get(loc).equals(target)) {
                return loc;
            }

        } catch(Exception e) {
            System.out.println(e);
        }
        return out;
    }

    private int find(int target, int loc) {
        int out = -1;

        try {
            if (left.get(loc) != null) {
                int temp = find(target, left.get(loc));
                if (temp != -1) {
                    return temp;
                }
            }
            if (right.get(loc) != null) {
                int temp = find(target, right.get(loc));
                if (temp != -1) {
                    return temp;
                }
            }
            if (data.get(loc).equals(target)) {
                return loc;
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        return out;
    }

    public void map() {
        int loc = 0;

        try {
            if (left.get(loc) != null) {
                map(left.get(loc));
            }
            if (right.get(loc) != null) {
               map(right.get(loc));
            }

            System.out.print(data.get(loc) + " ");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private void map(int loc) {
        try {
            if (left.get(loc) != null) {
                map(left.get(loc));
            }
            if (right.get(loc) != null) {
                map(right.get(loc));
            }

            System.out.print(data.get(loc) + " ");

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
