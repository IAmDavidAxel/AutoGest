package domain.mission;

import infrastruture.persistence.exception.ObjectNotFoundException;
import infrastruture.persistence.exception.PersistenseInternalException;

public interface MissionRepository {

	void save(Mission missionDto) throws PersistenseInternalException;
}
