package application.service.user.driver;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserIdTest {

	private UserId userId;

	@Before
	public void setUp(){
		userId = new UserId();
	}

	@Test
	public void whenInitialized_thenNotNull(){
		assertNotNull(userId);
	}

	@Test
	public void twoGeneratedUserIdAreNotEquals(){
		UserId  secondUserId = new UserId();

		assertNotEquals(secondUserId.getIdValue(),userId.getIdValue());
	}



}
