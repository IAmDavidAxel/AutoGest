package api.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status","payload","message"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

	@JsonProperty(value = "status", access = JsonProperty.Access.READ_ONLY)
	private String status;

	@JsonProperty(value = "payload", access = JsonProperty.Access.READ_ONLY)
	private Object payload;

	@JsonProperty(value = "message", access = JsonProperty.Access.READ_ONLY)
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
