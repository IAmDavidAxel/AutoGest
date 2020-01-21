package api.resource.mission;

import api.resource.dto.MissionDto;
import application.service.user.manager.ManagerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MissionJsonResourceTest {

	private MissionJsonResource missionJsonResource;

	@Mock
	private ManagerService managerService;
	private MissionDto missionDto;

	@Before
	public void setUp(){
		missionJsonResource = new MissionJsonResource(managerService);
	}

	@Test
	public void whenCreatingANewMission_thenDelegateToManagerService()throws Exception{

		missionJsonResource.createMission(missionDto);

		verify(managerService).createMission(missionDto);
	}
}
