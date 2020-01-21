package domain.mission;

import infrastruture.persistence.assembler.mission.MissionAssembler;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dao.mission.MissionDao;
import infrastruture.persistence.dto.mission.MissionDto;
import infrastruture.persistence.exception.PersistenseInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MissionSqliteRepository implements MissionRepository {


	private MissionAssembler missionAssembler;
	private MissionDao missionDao;

	public MissionSqliteRepository(MissionAssembler missionAssembler, MissionDao missionDao) {

		this.missionAssembler = missionAssembler;
		this.missionDao = missionDao;
	}

	@Override
	public void save(Mission mission) throws PersistenseInternalException {

		MissionDto missionDto = createDtoFromAssembler(mission);
		saveMission(missionDto);
	}

	private void saveMission(MissionDto missionDto) throws PersistenseInternalException {
		try{
			missionDao.save(missionDto);
		}catch (DaoInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw  new PersistenseInternalException();
		}
	}

	private MissionDto createDtoFromAssembler(Mission mission) {
		return missionAssembler.assemble(mission);
	}
}
