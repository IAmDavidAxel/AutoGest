package domain.mission;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissionIdTest {

	private MissionId missionId;

	@Before
	public void setUp(){
		missionId = new MissionId();
	}

	@Test
	public void whenInitialized_thenTheObjectIsNotNull(){

		assertNotNull(missionId);
	}

	@Test
	public void whenGeneratingTwoObjects_thenTheTwoIdsAreDifferent(){
		MissionId firstId = new MissionId();

		MissionId secondId = new MissionId();


		String firstIdValue = firstId.getId();
		String secondIdValue = secondId.getId();

		assertNotEquals(firstIdValue,secondIdValue);
		System.out.println(firstIdValue+ "   and   " +secondIdValue);
	}

}
