package infrastruture.persistence.assembler.mission;

import domain.mission.Mission;
import infrastruture.persistence.dto.mission.MissionDto;

public class MissionAssembler {
	public MissionDto assemble(Mission mission) {
		MissionDto missionDto = new MissionDto();

		missionDto.setMissionId(mission.getMissionId().getId());
		missionDto.setOrderNumber(mission.getMissionOrderNumber());
		missionDto.setLocation(mission.getLocation());
		missionDto.setMissionDescription(mission.getMissionDescription());
		missionDto.setMissionEndDate(mission.getMissionEndDate().toString());
		missionDto.setMissionStartDate(mission.getMissionStartDate().toString());
		missionDto.setMeanOfTransport(mission.getMeanOfTransport());
		missionDto.setVehiclePlateNumber(mission.getVehicle().getPlateNumber());
		missionDto.setAssociatedDriverName(mission.getDriverAssigned().getFirstName());
		missionDto.setDriverCompanion(mission.getDriverCompanion());


		return missionDto;
	}
}
