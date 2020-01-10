package api.resource;

public class ResponseDtoBuilder {

	public static Builder builder(){
		return new ResponseDtoBuilder.Builder();
	}

	public static class Builder {

		private ResponseDto responseDto = new ResponseDto();

		private Builder(){

		}

		public Builder withStatus(String status){
			responseDto.setStatus(status);
			return this;
		}

		public Builder withPayload(Object payload){
			responseDto.setPayload(payload);
			return this;
		}

		public  Builder withMessage(String message){
			responseDto.setMessage(message);
			return this;
		}

		public ResponseDto getResponseDto() {
			return responseDto;
		}
	}
}
