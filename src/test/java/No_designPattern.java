public class No_designPattern {

    public void test1(){

        System.out.println("this is test1");
    }
    public void test2(){

        System.out.println("this is test2");
    }
    public void test3(){

        System.out.println("this is test3");
    }
    public void test4(String name ){

        System.out.println("this is test4");

    }

    public static void main(String[] args) {
        No_designPattern noDesignPattern= new No_designPattern();
        noDesignPattern.test1();
        noDesignPattern.test2();
        noDesignPattern.test3();
        noDesignPattern.test4("kiran");
    }




}
