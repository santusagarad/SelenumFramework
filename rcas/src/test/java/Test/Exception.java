package Test;

import java.io.IOException;

public class Exception {

	public static void main(String[] args) {
		demo();
	}
	public static void demo()
	{
		try {
			System.out.println("dUDE");
			int i = 1/0;
			System.out.println("dOUBLE DUDE ");
		}
		catch(java.lang.Exception exp){
			System.out.println("the message is :" +exp.getMessage());
			System.out.println("the cause is :"+exp.getCause());


		}
	}
}