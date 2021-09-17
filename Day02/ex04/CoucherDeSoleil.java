import java.util.*;

class CoucherDeSoleil {
    static enum Direction {
        EST,
        OUEST
    };

    static ArrayList<Integer> whoCanSeeSun(Direction direction, int[] indexes) {
        ArrayList<Integer> list = new ArrayList<>();
        int lastMaxValue = -1;

        if(direction == Direction.OUEST) {
            for (int i = 0; i < indexes.length ; i++) {
                if(indexes[i] > lastMaxValue) {
                    list.add(i);
                    lastMaxValue = indexes[i];
                }
            }
        } else {
            for (int i = indexes.length - 1; i >= 0; i--) {
                if(indexes[i] > lastMaxValue) {
                    list.add(i);
                    lastMaxValue = indexes[i];
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] indexes = {3, 5, 4, 4, 3, 1, 3, 2};
        System.out.println(whoCanSeeSun(Direction.OUEST, indexes));
    }
}