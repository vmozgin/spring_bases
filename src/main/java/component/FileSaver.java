package component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileSaver {

	@Value("${file.save}")
	private String filepath;

	public String getFilepath() {
		return filepath;
	}
}
