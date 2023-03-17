package aplication;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Services.ContractService;
import Services.PaypalService;
import entities.Contract;
import entities.Installment;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Digite o numero do contrato");
		int number = sc.nextInt();
		System.out.println("Digite a data inicial do contrato");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.println("Digite o valor do seu contrato");
		double totalValue= sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(obj, n);
		
		System.out.println("Parcelas:");
		for ( Installment installment : obj.getInstallments()) {
			System.out.println(installment);
			System.out.println("Ctd");
		}
		
		sc.close();	
		//System.out.println("O numero do seu contrato é "+number+"A data inicial e "+ date+ "E o valor do contrato é "+totalValue );
	}

}
