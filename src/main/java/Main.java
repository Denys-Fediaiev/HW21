import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        MyMath myMath = new MyMath();
        try {
            newValue(myMath);
        } catch (IllegalAccessException e) {
            System.out.println("you can't do this!");
        }

    }


    public static void newValue(MyMath myMath) throws IllegalAccessException {
        Field[] fields = myMath.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Pow.class)) {
                Object value = field.get(myMath);
                if (value instanceof Number) {
                    if (value instanceof Byte) {
                        Byte byte1 = (Byte) value;
                        field.set(myMath, (byte) (byte1 ^ 2));
                    }
                    if (value instanceof Float) {
                        Float float1 = (Float) value;
                        field.set(myMath, (float1 * float1));
                    }
                    if (value instanceof Short) {
                        Short short1 = (Short) value;
                        field.set(myMath, (short) (short1 ^ 2));
                    }
                    if (value instanceof Double) {
                        Double double1 = (Double) value;
                        field.set(myMath, (double1 * double1));
                    }
                    if (value instanceof Long) {
                        Long long1 = (Long) value;
                        field.set(myMath, (long1 ^ 2));
                    }
                    if (value instanceof Integer) {
                        Integer int1 = (Integer) value;
                        field.set(myMath, (int1 ^ 2));
                    }
                    field.set(myMath, value);
                    System.out.println(field.get(myMath));
                }
            }
            field.setAccessible(false);
        }
    }
}