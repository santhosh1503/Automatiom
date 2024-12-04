package Registered_Private_car;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utilities.RegCarXLData;
import Z_Base.Base_Agent;

public class Private_car extends Base_Agent{

	
	private int rowNum = 1;
       
	@Test(dataProviderClass=RegCarXLData.class, dataProvider="dp")
	public void RegisteredCar(Hashtable<String,String> data, Method m)throws InterruptedException {
		
		
		// QMS Tile	
		Thread.sleep(5000);
		Baseclick("QMSTile_XPATH");
		output("Qms Tile Click successfully");
		Thread.sleep(5000);
		
		// Dash board	
		Baseclick("NewQute_XPATH");
		output("New Quote Button clicked successfully");
		
		// Select New Business Insurance Type
		Thread.sleep(5000);
		Baseclick("MotorTile_XPATH");
		output("Motor Tile clicked successfully");
		Thread.sleep(5000);
		Baseclick("RegVechl_XPATH");
		output("Registerd Vechile Selected Successfully");
		Thread.sleep(5000);
		Baseclick("nxtbtn_XPATH");
		output("Next Button Clicked successfully");
		
		// Motor Coverage(s) Screen
		// Vehicle Search and Vehicle Details tab
		Thread.sleep(5000);
		Enter("VeclregNo_XPATH",data.get("Vechcle Reg"));
		output("Vechile Number Enterd successfully");
		Thread.sleep(5000);
		click("POUDrpDon_XPATH");
		output("Place Of Use Drop Down Clicked successfully");
		Thread.sleep(5000);
		Enter("StateEntr_XPATH",data.get("Place Of Use"));
		output("state Enterd successfully");
		Thread.sleep(5000);
		click("Statesel_XPATH");
		output("Place Of Use selected successfully");
		Thread.sleep(5000);
		click("VeclsrcBtn_XPATH");
		output("Vechile search button clicked successfully");
		output("Vechile Data retrived from IRBM successfully");

		//Coverage Details Tab	
		Thread.sleep(5000);
		click("CovTpeDrpDon_XPATH");
		output("Coverage Type Drop Down Clicked successfully");
		Thread.sleep(5000);
		Enter("CovrvaleEntr_XPATH",data.get("Coverage Type"));
		output("Coverage Type Given successfully");
		Thread.sleep(5000);
		click("CovrTypSel_XPATH");
		output("Coverage Type clicked successfully");
		Thread.sleep(5000);
		Enter("PHID_XPATH",data.get("PH ID"));
		output("Policy Holder id Given successfully");
		Thread.sleep(5000);
		Enter("nmeofID_XPATH",data.get("Name As Per ID"));
		output("Policy Holder name Given successfully");
		Thread.sleep(5000);
		click("VldOnrISMBtn_XPATH");
		output("Validate as per Ownor button clicked successfullsy");
		Thread.sleep(5000);
		click("SaveBtn_XPATH");
		output("Save Button clicked successfully");

		// Motor Additional Information 
		// Additional Details of Proposer
		Thread.sleep(5000);
		click("DrvExpDrpDwn_XPATH");
		output("Driving Experience DropDown clicked successfully");
		Thread.sleep(5000);
		Enter("DrvExpGvn_XPATH",data.get("Driving Experience"));
		output("Driving Experience Given clicked successfully");
		Thread.sleep(5000);
		click("DrvExpDrpDwnSel_XPATH");
        output("Driving Experience selected successfully");
		
		// Rebate
		Thread.sleep(5000);
		click("Rebate_id");
		// PIAM Analysis Code
		// Garage Type
		Thread.sleep(5000);
		click("GrgTypDrpdwn_XPATH");
		output("Garage Type Drop Down was Click successfully");
		Thread.sleep(5000);
		Enter("GrgTypGivn_XPATH",data.get("Garage Type"));
		output("Garage Type Given successfully");
		Thread.sleep(5000);
		click("GrgTypSect_XPATH");
		output("Garage Type Drop Down was selected successfully");
		// Anti Theft
		Thread.sleep(5000);
		click("AntThtDrpdwn_XPATH");
		output("Anti Theft Drop Down was Click successfully");
		Thread.sleep(5000);
		Enter("AntThtGivn_XPATH",data.get("Anti Theft"));
		output("Anti Theft Given successfully");
		Thread.sleep(5000);
		click("AntThtSect_XPATH");
		output("Anti Theft Drop Down was selected successfully");
		// Safety Features
		Thread.sleep(5000);
		click("SafFeuDrpdwn_XPATH");
		output("Safety Features Drop Down was Click successfully");
		Thread.sleep(5000);
		Enter("SafFeuGivn_XPATH",data.get("Safety Features"));
		output("Safety Features Given successfully");
		Thread.sleep(5000);
		click("SafFeuSect_XPATH");
        output("Safety Features Drop Down was selected successfully");		
		
		// Policy Issuance
		Thread.sleep(15000);
		click("PolicyBtn_XPATH");
		output("Proceed to Policy Issuance Button Clicked successfully");
		Thread.sleep(15000);
		click("IssPolicy_XPATH");
		output("Issue Policy Button Clicked successfully");
		output("Policy was Issued successfully");
		
		// Print
		Thread.sleep(5000);
		String QuoteNumber = driver.findElement(By.xpath(loc.getProperty("QuoteNumber_XPATH"))).getText();
		output(QuoteNumber);		
		write(QuoteNumber, m, 12, rowNum);
		Thread.sleep(5000);
		String QuoteStatus = driver.findElement(By.xpath(loc.getProperty("QuoteStatus_XPATH"))).getText();
		output(QuoteStatus);		
		write(QuoteStatus, m, 13, rowNum);
		Thread.sleep(5000);
		String PloicyNumber = driver.findElement(By.xpath(loc.getProperty("PloicyNumber_XPATH"))).getText();
		output(PloicyNumber);		
		write(PloicyNumber, m, 14, rowNum);
		Thread.sleep(5000);
		String VehicleSumInsured = driver.findElement(By.xpath(loc.getProperty("VehicleSumInsured_XPATH"))).getText();
		output(VehicleSumInsured);		
		write(VehicleSumInsured, m, 15, rowNum);
		Thread.sleep(5000);
		String ActPremium = driver.findElement(By.xpath(loc.getProperty("ActPremium_XPATH"))).getText();
		output(ActPremium);		
		write(ActPremium, m, 16, rowNum);
		Thread.sleep(5000);
		String BasicPremium = driver.findElement(By.xpath(loc.getProperty("BasicPremium_XPATH"))).getText();
		output(BasicPremium);		
		write(BasicPremium, m, 17, rowNum);
		Thread.sleep(5000);
		String NCD = driver.findElement(By.xpath(loc.getProperty("NCD_XPATH"))).getText();
		output(NCD);		
		write(NCD, m, 18, rowNum);
		Thread.sleep(5000);
		String PremiumafterNCD = driver.findElement(By.xpath(loc.getProperty("PremiumafterNCD_XPATH"))).getText();
		output(PremiumafterNCD);		
		write(PremiumafterNCD, m, 19, rowNum);
		Thread.sleep(5000);
		String ExtraBenefitsTotal = driver.findElement(By.xpath(loc.getProperty("ExtraBenefitsTotal_XPATH"))).getText();
		output(ExtraBenefitsTotal);		
		write(ExtraBenefitsTotal, m, 20, rowNum);
		Thread.sleep(5000);
		String GrossPremium = driver.findElement(By.xpath(loc.getProperty("GrossPremium_XPATH"))).getText();
		output(GrossPremium);		
		write(GrossPremium, m, 21, rowNum);
		Thread.sleep(5000);
		String Rebate = driver.findElement(By.xpath(loc.getProperty("Rebate_XPATH"))).getText();
		output(Rebate);		
		write(Rebate, m, 22, rowNum);
		Thread.sleep(5000);
		String SST = driver.findElement(By.xpath(loc.getProperty("SST_XPATH"))).getText();
		output(SST);		
		write(SST, m, 23, rowNum);
		Thread.sleep(5000);
		String StampDuty = driver.findElement(By.xpath(loc.getProperty("StampDuty_XPATH"))).getText();
		output(StampDuty);		
		write(StampDuty, m, 24, rowNum);
		Thread.sleep(5000);
		String TotalPayablePremium = driver.findElement(By.xpath(loc.getProperty("TotalPayablePremium_XPATH"))).getText();
		output(TotalPayablePremium);		
		write(TotalPayablePremium, m, 25, rowNum);		
		rowNum++;
		
		
		// Navigating to Home Screen
		Thread.sleep(15000);
		Baseclick("Home_XPATH");
		output("home Button clicked successfully");
		
	}
	}


