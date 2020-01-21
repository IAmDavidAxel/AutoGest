package domain.mission;

import api.resource.mission.MissionJsonResource;
import infrastruture.persistence.assembler.mission.MissionAssembler;
import infrastruture.persistence.dao.mission.MissionDao;
import infrastruture.persistence.dto.mission.MissionDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MissionSqliteRepositoryTest {

	private  MissionSqliteRepository missionSqliteRepository;

	@Mock
	private MissionAssembler missionAssembler;
	@Mock
	private MissionDao missionDao;
	private Mission mission;
	private MissionDto missionDto;

	@Before
	public void setUp() throws Exception {

		missionSqliteRepository = new MissionSqliteRepository(missionAssembler,missionDao);
	}

	@Test
	public void whenSaving_thenDelegateTransformationToDomainDBObjectToAssembler()throws Exception{
		missionSqliteRepository.save(mission);

		verify(missionAssembler).assemble(mission);
	}

	@Test
	public void whenSaving_thenDelegateActualSavingToTheDAO()throws Exception{
		willReturn(missionDto).given(missionAssembler).assemble(mission);

		missionSqliteRepository.save(mission);

		verify(missionDao).save(missionDto);
	}




}
