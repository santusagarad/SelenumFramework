package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class testNGListenersDemo2 {

	@Test
	public void test4() {
		System.out.println("test 4");

	}

	@Test
	public void test5() {
		System.out.println("test5");
		Assert.assertTrue(false);

	}

	@Test
	public void test6() {
		System.out.println("test6");
		throw new SkipException("Skipmessage"); 
	}

}
