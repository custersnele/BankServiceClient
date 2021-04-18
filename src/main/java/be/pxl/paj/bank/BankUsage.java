package be.pxl.paj.bank;

import be.pxl.paj.todo.service.BankService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BankUsage {

	public static void main(String[] args) throws IOException, NamingException {
		Properties props = new Properties();
		props.load(new FileInputStream("src/main/resources/jndi.properties"));
		InitialContext ctx = new InitialContext(props);
		BankService bankService = (BankService) ctx.lookup("ejb:/hello-world-1.0-SNAPSHOT/BankServiceImpl!be.pxl.paj.todo.service.BankService?stateful");

		System.out.println(bankService.getBalance());
		bankService.deposit(500);
		System.out.println(bankService.getBalance());
		bankService.withdraw(200);
		System.out.println(bankService.getBalance());
	}

}
