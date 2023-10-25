package component;

import java.io.IOException;
import model.User;
import org.springframework.stereotype.Component;

@Component
public class DefaultContactInitializer implements ContactInitializer{

	@Override
	public void initialize(User user) throws IOException {

	}
}
