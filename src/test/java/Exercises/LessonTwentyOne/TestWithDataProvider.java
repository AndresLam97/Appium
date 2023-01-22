package Exercises.LessonTwentyOne;
import Exercises.BaseTest;
import Exercises.LessonNineteen.LoginCredential;
import TestFlow.AllTestFlow.LoginTestFlowWithHardAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestWithDataProvider extends BaseTest {

    @Test(dataProvider = "MyTestFunction")
     void testMethod1(LoginCredential loginCredential) {
        try {
            LoginTestFlowWithHardAssert loginTestFlowWithHardAssert = new LoginTestFlowWithHardAssert(getDriver(),
                    loginCredential.getEmail(),
                    loginCredential.getPassword());
            loginTestFlowWithHardAssert.performLogin();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @DataProvider(name = "MyTestFunction")
    private LoginCredential[] loginCredentialList()
    {
        LoginCredential[] loginCredentialList = new LoginCredential[] {new LoginCredential("","12345678")
        ,new LoginCredential("NguyenVanTeo","12345678")
        /*,new LoginCredential("NguyenVanTeo@abc.com","")
        ,new LoginCredential("NguyenVanTeo@abc.com","1234")*/
        ,new LoginCredential("NguyenVanTeo@abc.com","12345678")};
        return loginCredentialList;
    }



}
