package hw.translator;

public class TranslateResult {
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}

class Message{
	private String type;
	private String service;
	private String version;
	private Result result;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
}

class Result{
	private String srcLangType;
	private String tarLangType;
	private String translatedText;
	
	public String getSrcLangType() {
		return srcLangType;
	}
	public void setSrcLangType(String srcLangType) {
		this.srcLangType = srcLangType;
	}
	public String getTarLangType() {
		return tarLangType;
	}
	public void setTarLangType(String tarLangType) {
		this.tarLangType = tarLangType;
	}
	public String getTranslatedText() {
		return translatedText;
	}
	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}
}
		