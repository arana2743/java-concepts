class GenericMethods {
    public static void main(String[] args) {
        // example 1; return any type by method
        System.out.println(GenericFuncs.returnAnyType(10));
        System.out.println(GenericFuncs.returnAnyType(3.14));
        System.out.println(GenericFuncs.returnAnyType("Hello"));

        // example 2: return largest value among 3 values of any type
        System.out.println(GenericFuncs.largestAmong3AnyType(100, 2, 30));
        System.out.println(GenericFuncs.largestAmong3AnyType(10.23, 9.56, 10.25));
        System.out.println(GenericFuncs.largestAmong3AnyType("A", "Z", "M"));
    }
}

class GenericFuncs {
    // method to accept and return anytype
    public static <T> T returnAnyType(T t) {
        return t;
    }
    // method to return largest among 3 parameters of any type
    public static <T extends Comparable<T>> T largestAmong3AnyType(T x, T y, T z) {
        T maxVal = x;
        if (y.compareTo(maxVal) > 0) {
            maxVal = y;
        }
        if (z.compareTo(maxVal) > 0) {
            maxVal = z;
        }
        return maxVal;
    }
}