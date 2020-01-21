package domain.user.driver;

@SuppressWarnings("serial")
public class VehicleAlreadyAssignedException extends Exception{

	public VehicleAlreadyAssignedException(){
		super("Vehicule déja assigné");
	}
}
