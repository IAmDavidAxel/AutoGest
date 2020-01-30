package application.service.mission;

import api.resource.dto.MissionDto;
import domain.mission.Mission;
import domain.mission.MissionId;
import domain.user.driver.Driver;
import domain.vehicle.Vehicle;

import java.time.LocalDate;

public class MissionFactory {


	public Mission create(MissionDto missionDto, Driver driver, Vehicle vehicle) {

		MissionId missionId = new MissionId();


		String location = missionDto.getLocation();
		String missionOrderNumber =missionDto.getOrderNumber();
		LocalDate missionStartDate = LocalDate.parse(missionDto.getMissionStartDate());
		LocalDate missionEndDate = LocalDate.parse(missionDto.getMissionEndDate());
		String missionDescription = missionDto.getMissionDescription();
		String associatedDriverName = missionDto.getAssociatedDriverName();
		String driverCompanion = missionDto.getAccompanantDriverName();


		return new Mission(missionId,location,missionOrderNumber,missionStartDate,missionEndDate,driver,vehicle,missionDescription,associatedDriverName, driverCompanion);
	}
}
