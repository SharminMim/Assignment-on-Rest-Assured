package testRunner;

import com.github.javafaker.Faker;
import controller.UserController;
import io.restassured.path.json.JsonPath;
import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class UserTestRunner extends Setup {


    @Test(priority = 1,description = "Login with Invalid Credentials")
    public void doLoginWithInvalidCredential() throws IOException, ConfigurationException {
        UserController userController=new UserController();
        userController.doInvalidLogin("invalid@123.net","invalidPassword");
    }

    @Test(priority = 2,enabled = true, description = "Login with Valid Credentials")
    public void doLogin() throws IOException, ConfigurationException {
        UserController userController=new UserController();
        userController.doLogin("admin@roadtocareer.net","1234");
    }


    @Test(priority = 3,enabled = true, description = "Create new user with valid details")
    public void createNewUser() throws IOException, ConfigurationException, InterruptedException, ParseException {
        Faker faker=new Faker();
        UserController userController=new UserController();
        //create model-->manual user create
        UserModel model=new UserModel();

        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword("1234");
        String phoneNumber="01354"+ Utils.generateRandomId(100000,999999);
        model.setPhone_number(phoneNumber);
        model.setNid(String.valueOf(Utils.generateRandomId(100000000,999999999)));
        model.setRole("Customer");


        //Store UserId
        JsonPath jsonPath= userController.createUser(model);
        int  userId= jsonPath.get("user.id");
        Utils.setEvnVar("userId", String.valueOf(userId));


        //JsonPath jsonPath=res.jsonPath();
        String message = jsonPath.get("message");
        phoneNumber=jsonPath.get("user.phone_number");
        System.out.println(message);
        Assert.assertTrue(message.contains("User created"));

        String createdUserName = jsonPath.get("user.name");
        String createdUserPassword = jsonPath.get("user.password");
        String createdUserPhone = jsonPath.get("user.phone_number");
        String createdUserEmail = jsonPath.get("user.email");
        String createdUserNid = jsonPath.get("user.nid");
        String createdUserRole = jsonPath.get("user.role");
        Utils.addJsonList(createdUserName,createdUserPassword,createdUserPhone,createdUserEmail,createdUserNid,createdUserRole);

        Utils.setEvnVar("createdUserPhone",phoneNumber );

    }

    @Test(priority = 4,enabled = true, description = "Create new second user with valid details")
    public void createSecondUser() throws IOException, ConfigurationException, InterruptedException, ParseException {
        Faker faker=new Faker();
        UserController userController=new UserController();
        //create model-->manual user create
        UserModel model=new UserModel();

        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword("1234");
        String phoneNumber="01354"+ Utils.generateRandomId(100000,999999);
        model.setPhone_number(phoneNumber);
        model.setNid(String.valueOf(Utils.generateRandomId(100000000,999999999)));
        model.setRole("Customer");


        //Store UserId
        JsonPath jsonPath= userController.createUser(model);
        int  userId= jsonPath.get("user.id");
        Utils.setEvnVar("userId", String.valueOf(userId));


        //JsonPath jsonPath=res.jsonPath();
        String message = jsonPath.get("message");
        phoneNumber=jsonPath.get("user.phone_number");
        System.out.println(message);
        Assert.assertTrue(message.contains("User created"));

        String createdUser2Name = jsonPath.get("user.name");
        String createdUser2Password = jsonPath.get("user.password");
        String createdUser2Phone = jsonPath.get("user.phone_number");
        String createdUser2Email = jsonPath.get("user.email");
        String createdUser2Nid = jsonPath.get("user.nid");
        String createdUser2Role = jsonPath.get("user.role");
        Utils.addJsonList2(createdUser2Name,createdUser2Password,createdUser2Phone,createdUser2Email,createdUser2Nid,createdUser2Role);

        Utils.setEvnVar("createdUser2Phone",phoneNumber );

    }

    @Test(priority = 5,enabled = true, description = "Search new created user details")
    public void searchUser() throws IOException {
        UserController userController=new UserController();
        JsonPath jsonPath= userController.searchUser(prop.getProperty("userId"));
        String message= jsonPath.get("message");

        Assert.assertTrue(message.contains("User found"));
    }

    @Test(priority = 6,enabled = true, description = "Create new agent with valid details")
    public void createAgent() throws IOException, ConfigurationException, InterruptedException, ParseException {
        Faker faker=new Faker();
        UserController userController=new UserController();
        //create model-->manual user create
        UserModel model=new UserModel();

        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword("1234");
        String phoneNumber="01354"+ Utils.generateRandomId(100000,999999);
        model.setPhone_number(phoneNumber);
        model.setNid(String.valueOf(Utils.generateRandomId(100000000,999999999)));
        model.setRole("Agent");


        JsonPath jsonPath= userController.createUser(model);

        String message = jsonPath.get("message");
        phoneNumber=jsonPath.get("user.phone_number");
        System.out.println(message);
        Assert.assertTrue(message.contains("User created"));

        String createdAgentName = jsonPath.get("user.name");
        String createdAgentPassword = jsonPath.get("user.password");
        String createdAgentPhone = jsonPath.get("user.phone_number");
        String createdAgentEmail = jsonPath.get("user.email");
        String createdAgentNid = jsonPath.get("user.nid");
        String createdAgentRole = jsonPath.get("user.role");
        Utils.addAgent(createdAgentName,createdAgentPassword,createdAgentPhone,createdAgentEmail,createdAgentNid,createdAgentRole);

        Utils.setEvnVar("createdAgentPhone",phoneNumber );

    }
}
