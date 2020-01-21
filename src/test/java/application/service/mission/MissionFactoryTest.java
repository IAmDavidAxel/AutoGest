package application.service.mission;

import api.resource.dto.MissionDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MissionFactoryTest {

	private MissionFactory missionFactory;
	private MissionDto missionDto;

	private void setUpDto(){
		missionDto = new MissionDto();

	}


	@Before
	public void setUp() throws Exception {

		missionFactory = new MissionFactory();
	}

	@Test
	public void whenCreatingANewMissionObject_thenDelegateIdGenerationToTheMissionIdFactory(){

		missionFactory.create(missionDto);
	}
}
