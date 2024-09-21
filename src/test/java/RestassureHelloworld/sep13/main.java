package RestassureHelloworld.sep13;

public class main {
    public static void main(String[] args) {

        // maven: dependencies manager and take care of the project
        // testNG: to run our test cases
        // Reporting: Allure report
        // data: excel, apache poi
        // manage payload: json, xml,
        // reuse component: inheritence, abstraction, config
        // CI/CD: to run project on git, github, and Jenkins
        // utils:
        NonbuilderPattern non= new NonbuilderPattern();
        non.groundfloor();
        non.firstfloor();
        non.secondfloor();
        builderPattern bp= new builderPattern();
        bp.groundfloor().firstfloor().secondfloor();// function chaining;

    }
}
