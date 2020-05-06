package DataProviders;

import org.testng.annotations.DataProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.testng.annotations.DataProvider;
import com.dyslexicon.dataprovider.FileDataProvider;
import com.falabella.templateautomationfront.entity.UserCredentials;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DataProviders {
	
	@DataProvider
	public static Object[][] loginData() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object userdata = matchJsonAndEntity(entity.UserCredentials.class.getCanonicalName(), "userCredentials");
		return new Object[][] { { userdata } };
	}
	
	
}
