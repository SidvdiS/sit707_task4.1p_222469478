package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "222469478";
		Assert.assertNotNull("Student ID is 222469478", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Siddharth";
		Assert.assertNotNull("Student name is Siddharth", studentName);
	}
	
	@Test
	public void testNoUsernameOrPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertTrue( status.isLoginSuccess() == false );
    }

    @Test
    public void testInvalidPassword() {
        LoginStatus status = LoginForm.login("sid", "121");
        Assert.assertTrue( status.isLoginSuccess() == false );
    }

    @Test
    public void testNoUsernameProvided() {
        LoginStatus status = LoginForm.login(null, "sid_pass");
        Assert.assertTrue( status.isLoginSuccess() == false );
    }

    @Test
    public void testInvalidUsername() {
        LoginStatus status = LoginForm.login("asa", "sid_pass");
        Assert.assertTrue( status.isLoginSuccess() == false );
    }

    @Test
    public void testInvalidUsernameAndPassword() {
        LoginStatus status = LoginForm.login("xwz", "avc");
        Assert.assertTrue( status.isLoginSuccess() == false );
    }


    @Test
    public void testNoPasswordProvided() {
        LoginStatus status = LoginForm.login("sid", null);
        Assert.assertTrue( status.isLoginSuccess() == false );
    }


    @Test
    public void testNoValidationCodeProvided() {
        LoginStatus status = LoginForm.login("sid", "sid_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertTrue(LoginForm.validateCode(null)==false);
    }

    @Test
    public void testValidationCodeDoesNotMatch() {
        LoginStatus status = LoginForm.login("sid", "sid_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertTrue(LoginForm.validateCode("2222")==false);
    }

    @Test
    public void testValidLogin() {
        LoginStatus status = LoginForm.login("sid", "sid_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}
