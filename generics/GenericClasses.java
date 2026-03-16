class GenericClasses {
    public static void main(String[] args) {
        GenericCls<Integer> intObj = new GenericCls<Integer> (10);
        System.out.println(intObj.getObject());
        GenericCls<String> strObj = new GenericCls<String> ("Hello World");
        System.out.println(strObj.getObject());
    }
}

class GenericCls <T> {
    private T obj;
    public GenericCls(T obj) {
        this.obj = obj;
    }
    public T getObject() {
        return this.obj;
    }
}