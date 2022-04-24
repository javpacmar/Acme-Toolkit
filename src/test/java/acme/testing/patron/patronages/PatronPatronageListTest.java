package acme.testing.patron.patronages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/patronage.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10) 
	public void positiveTest(final int recordIndex, final String status, final String code, 
		final String legalStuff, final String budget, final String creationMoment, final String startDate, 
		final String finishDate, final String link,  final String inventorFullName, final String name, final String surname, final String email ) {
		
		super.signIn("patron01", "patron01");
		
		super.clickOnMenu("Patron","Patronages list");
		super.checkListingExists();
		super.sortListing(1, "asc"); 
		
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, legalStuff);
		super.checkColumnHasValue(recordIndex, 2, budget);
		super.checkColumnHasValue(recordIndex, 3, creationMoment);
		super.checkColumnHasValue(recordIndex, 4, startDate);
		super.checkColumnHasValue(recordIndex, 5, finishDate);
		super.checkColumnHasValue(recordIndex, 6, link);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("finishDate", finishDate);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("inventorFullName", inventorFullName);
		super.checkInputBoxHasValue("inventorName", name);
		super.checkInputBoxHasValue("inventorSurname", surname);
		super.checkInputBoxHasValue("inventorEmail", email);
		
		super.signOut();
	}
	
	

}
