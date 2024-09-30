package RestassureHelloworld.RassuredAssured.CRUD.Example_22092024.Verifications;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class verification_02 {
    @Description(" this is assert demo")
    @Owner("Owen Anderson")
    @Link(name= "Website",url= "https://dev.example.com/")
    @Test
    public void test_verification(){
          String response= "Andrew";
          assertThat(response).isEqualTo("Andrew").isNotEmpty().isNotNull();

          List<String> name= Arrays.asList("John", "Jane", "Joe");

          assertThat(name).hasSize(3).isNotNull().isNotEmpty();

          LocalDate date= LocalDate.now();
        System.out.println(date);

        File file= new File("TestData.json");
        assertThat(file).exists().canRead();




    }
}
