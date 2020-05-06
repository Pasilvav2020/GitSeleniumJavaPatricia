package DataProviders;

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

public class DataProviders3 {
	private static ArrayList<Object> getGsonCountryAndEnvironment() {
		Gson gson = new Gson();
		String country = System.getProperty("dlx.country");
		String environment = System.getProperty("dlx.environment");
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(gson);
		arrayList.add(country);
		arrayList.add(environment);
		return arrayList;
	}

	private static Object matchJsonAndEntity(String clase, String nameJson)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object instancia = Class.forName(clase).newInstance();
		instancia = ((Gson) getGsonCountryAndEnvironment().get(0)).fromJson(
				FileDataProvider.asString(String.format("src/test/resources/data/%s/%s/" + nameJson + ".json",
						getGsonCountryAndEnvironment().get(1), getGsonCountryAndEnvironment().get(2))),
				instancia.getClass());
		return instancia;
	}

	private static Object matchXmlAndEntity(String clase, String nameXml)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, JAXBException {
		Object instancia = Class.forName(clase).newInstance();
		File file = new File(String.format("src/test/resources/data/%s/%s/xml/" + nameXml + ".xml",
				getGsonCountryAndEnvironment().get(1), getGsonCountryAndEnvironment().get(2)));
		instancia = JAXBContext.newInstance(instancia.getClass()).createUnmarshaller().unmarshal(file);
		return instancia;
	}

	@DataProvider
	public static Object[][] datatest() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object busqueda = matchJsonAndEntity(
				com.falabella.templateautomationfront.entity.Busqueda.class.getCanonicalName(), "busqueda");
		return new Object[][] { { busqueda } };
	}
	
	@DataProvider
	public static Object[][] loginData() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object userdata = matchJsonAndEntity(
				com.falabella.templateautomationfront.entity.UserCredentials.class.getCanonicalName(), "userCredentials");
		return new Object[][] { { userdata } };
	}
	
	@DataProvider
	public static Object[][] paginaFalabella() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object userdata = matchJsonAndEntity(
				com.falabella.templateautomationfront.entity.PaginaFalabella.class.getCanonicalName(), "paginaFalabella");
		return new Object[][] { { userdata } };
	}
	
}
