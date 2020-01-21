package application.service.user.driver;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdFactoryTest {

	private IdFactory  idFactory;

	@Before
	public void setUp(){
		idFactory = new IdFactory();
	}

	@Test
	public void whenCreating_thenTheIdValueIsNotNull(){

		UserId userId = idFactory.createNewId();

		assertNotNull(userId);
	}

}
