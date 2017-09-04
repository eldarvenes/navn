package project.navn;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class ApplicationTest {

	@Test
	public void test() {
		Application app = new Application();
		
		List<Character> tastaturlinje = new ArrayList<Character>();
		
		tastaturlinje.add('a');
		tastaturlinje.add('c');
		tastaturlinje.add('b');
		
		Assert.assertTrue( Application.sjekkTastaturLinje('B', tastaturlinje));
	}

}
