package component;

import java.io.IOException;
import model.User;

public interface ContactInitializer {

	public void initialize(User user) throws IOException;
}
