package scolas.core.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/scolasCoreApplicationContext-properties.xml",		
		"classpath:/META-INF/spring/scolas-CoreAplicationContextDatabase.xml",
		"classpath:/META-INF/spring/scolasCoreApplicationContext-dao.xml",
		"classpath:/META-INF/spring/scolasCoreApplicationContext-service.xml"})

public class SCOLASUnitTest extends TestCase{
	
	@Test
	public void testApp() {
		assert(true);
	}
}
