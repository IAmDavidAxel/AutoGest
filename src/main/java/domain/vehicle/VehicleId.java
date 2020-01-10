package domain.vehicle;

import org.junit.Before;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.scene.input.KeyCode.F;

public class VehicleId {

	private String id;

	public VehicleId(String aPlateNumber) {
	this.id =	generateFromString(aPlateNumber);
	}

	public String generateFromString(String aPlateNumber) {

		try{
			MessageDigest messageDigest =MessageDigest.getInstance("MD5");
			byte plateNumberByte[] = aPlateNumber.getBytes();
			byte plateHashed[] = messageDigest.digest(plateNumberByte);

			StringBuffer stringBuffer = new StringBuffer();
			for (int i =0;i< plateNumberByte.length;i++){
				stringBuffer.append(Integer.toHexString((plateHashed[i] & 0xFF) | 0x100).substring(1,3));
			}
			return stringBuffer.toString();
		}catch (NoSuchAlgorithmException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
		}

		return "error";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public boolean equals(String id) {
		return this.id.equals(id);
	}
}
