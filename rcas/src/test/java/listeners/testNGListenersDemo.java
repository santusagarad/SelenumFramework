package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listeners.TestNGListeners.class)
public class testNGListenersDemo {

	@Test
	public void test1() {
		System.out.println("test 1");

	}

	@Test
	public void test2() {
		System.out.println("test2");
		Assert.assertTrue(false);

	}

	@Test
	public void test3() {
		System.out.println("test3");
		throw new SkipException("Skipmessage"); 
	}

}
