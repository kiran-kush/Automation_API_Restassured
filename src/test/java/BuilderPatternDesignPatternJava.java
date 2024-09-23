public class BuilderPatternDesignPatternJava {

    public BuilderPatternDesignPatternJava floor1(){
        System.out.println("this is floor1");
        return this;

    }
    public BuilderPatternDesignPatternJava floor2(String name){
        System.out.println("this is floor2");

        return this;


    }
    public BuilderPatternDesignPatternJava floor3(){
        System.out.println("this is floor3");
        return this;

    }

    public static void main(String[] args) {
        BuilderPatternDesignPatternJava bp= new BuilderPatternDesignPatternJava();
        bp.floor1().floor2("Kiran").floor3();
    }

}
