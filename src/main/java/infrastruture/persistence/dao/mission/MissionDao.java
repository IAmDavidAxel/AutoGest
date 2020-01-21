package infrastruture.persistence.dao.mission;

import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.mission.MissionDto;

public interface MissionDao {
	void save(MissionDto missionDto) throws DaoInternalException;
}
