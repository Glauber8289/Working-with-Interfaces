package entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
   private LocalDate dueDate;
   private Double amount;
   
   private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   public Installment(LocalDate duedate, Double amount) {
	
	this.dueDate = duedate;
	this.amount = amount;
}
public LocalDate getDuedate() {
	return dueDate;
}
public void setDuedate(LocalDate duedate) {
	this.dueDate = duedate;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return dueDate.format(fmt) + " - " + String.format("%.2f", amount);
	}
   
}
