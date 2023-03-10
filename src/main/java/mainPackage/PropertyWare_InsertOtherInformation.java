package mainPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class PropertyWare_InsertOtherInformation 
{
	public static String enrolledInRBPForPMUse = "";
	public static String RBPenrollmentCompleteForSNUseOnly = "";
	public static String renewalStatus="";
	public static String reneWalFollowupNotes = "";
	public static String renewalExecutionDate = "";
	public static String currentMonthlyRent = "";
	public static String priorMonthlyRent = "";
	public static String renewalCoordinatorName = "";
	
	//Related Activities - Lease Renewal
	public static String newStartDate = "";
	public static String newEndDate = "";
	public static String renewalOnDate = "";
	
	
	public static void addingOtherInformation() throws Exception
	{
		
		RunnerClass.driver.navigate().refresh();
		RunnerClass.driver.findElement(Locators.summaryEditButton).click();
		Thread.sleep(2000);
		RunnerClass.js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		try
		{
		//Clear all existing values in variables
		PropertyWare_InsertOtherInformation.clearExistingVariableValues();
		//Adding values to all variables 
		
		enrolledInRBPForPMUse = AppConfig.getEnrolledINRBPForPMUse(RunnerClass.company);
		RBPenrollmentCompleteForSNUseOnly = AppConfig.getRBPenrollmentCompleteForSNUseOnly(RunnerClass.company);
		renewalStatus = "CHARGE+RENEWAL+FEE+-+ANNUAL";
		reneWalFollowupNotes = "Full Lease Executed From "+PDFReader.startDate+" - "+PDFReader.endDate+" - HRG Automation - "; //Need to calculate Month's difference between StartDate and EndDate
		renewalExecutionDate = RunnerClass.getCurrentDate();
		currentMonthlyRent = PDFReader.monthlyRent;
		priorMonthlyRent = PDFReader.previousMonthlyRent;
		renewalCoordinatorName = "HRG - Automation"; 
		newStartDate = PDFReader.startDate;
		newEndDate = PDFReader.endDate;
		renewalOnDate = RunnerClass.getCurrentDate();
		
		if(PDFReader.residentBenefitsPackageAvailabilityCheck==true)
		{
		//Enrolled In RBP For PM Use
		 try
		 {
		 RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.enrolledInRBPForPMUse)).build().perform();
		 Select renewalStatusDropdown = new Select(RunnerClass.driver.findElement(Locators.enrolledInRBPForPMUse));
		 renewalStatusDropdown.selectByValue(enrolledInRBPForPMUse);
		 }
		 catch(Exception e)
		 {
			RunnerClass.statusID=1;
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+","+"Other information - Enrolled In RBP For PM Use";
		    System.out.println("Issue - Other information - Enrolled In RBP For PM Use");
		 }
		
		 //RBP Enrollment Complete For SN Use Only
		 try
		 {
		 RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.RBPEnrollmentCompleteForSNUseOnly)).build().perform();
		 Select renewalStatusDropdown = new Select(RunnerClass.driver.findElement(Locators.RBPEnrollmentCompleteForSNUseOnly));
		 renewalStatusDropdown.selectByValue(RBPenrollmentCompleteForSNUseOnly);
		 }
		 catch(Exception e)
		 {
		 	RunnerClass.statusID=1;
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+","+"Other information - RBP Enrollment Complete For SN Use Only";
			System.out.println("Issue - Other information - RBP Enrollment Complete For SN Use Only");
		 }
		}
		
		//Renewal Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.renewalStatusDropdown)).build().perform();
		Select renewalStatusDropdown = new Select(RunnerClass.driver.findElement(Locators.renewalStatusDropdown));
		renewalStatusDropdown.selectByValue(renewalStatus);
		}
		catch(Exception e)
		{
			RunnerClass.statusID=1;
			 e.printStackTrace();
			 RunnerClass.failedReason = RunnerClass.failedReason+","+"Other information - Renewal Status";
			 System.out.println("Issue - Other information - Renewal Status");
		}
		
		//Renewal Follow - up Notes
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.renewalFollowUpNotes)).build().perform();
		RunnerClass.driver.findElement(Locators.renewalFollowUpNotes).click();
		RunnerClass.driver.findElement(Locators.renewalFollowUpNotes).sendKeys(Keys.chord(Keys.HOME));
		RunnerClass.driver.findElement(Locators.renewalFollowUpNotes).sendKeys(reneWalFollowupNotes);
	    }
	    catch(Exception e)
	    {
	    	RunnerClass.statusID=1;
	    	e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+","+"Other information - Renewal Follow up Notes";
			System.out.println("Issue - Other information - Renewal Follow up Notes");
	    }
		//Renewal Execution Date
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.renewalExecutionDate)).build().perform();
		RunnerClass.driver.findElement(Locators.renewalExecutionDate).click();
		RunnerClass.driver.findElement(Locators.renewalExecutionDate).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.renewalExecutionDate).sendKeys(renewalExecutionDate);
		}
	    catch(Exception e)
	    {
	    	RunnerClass.statusID=1;
	    	e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+","+"Other information - Renewal Execution Date";
			System.out.println("Issue - Other information - Renewal Renewal Execution Date");
	    }
        //Current Monthly Rent
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.currentMonthlyRent)).build().perform();
		RunnerClass.driver.findElement(Locators.currentMonthlyRent).click();
		RunnerClass.driver.findElement(Locators.currentMonthlyRent).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.currentMonthlyRent).sendKeys(currentMonthlyRent);
		}
		catch(Exception e)
		{
			RunnerClass.statusID=1;
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+","+"Other information - Current Monthly Rent";
			System.out.println("Issue - Other information - Current Monthly Rent");
		}
		
		//Prior Monthly Rent
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.priorMonthlyRent)).build().perform();
		RunnerClass.driver.findElement(Locators.priorMonthlyRent).click();
		RunnerClass.driver.findElement(Locators.priorMonthlyRent).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.priorMonthlyRent).sendKeys(priorMonthlyRent);
		}
		catch(Exception e)
		{
			RunnerClass.statusID=1;
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+","+"Other information - Prior Monthly Rent";
			System.out.println("Issue - Other information - Prior Monthly Rent");
		}
		
		//Renewal Coordinator Name
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.renewalCoordinatorName)).build().perform();
		RunnerClass.driver.findElement(Locators.renewalCoordinatorName).click();
		RunnerClass.driver.findElement(Locators.renewalCoordinatorName).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.renewalCoordinatorName).sendKeys(renewalCoordinatorName);
		}
		catch(Exception e)
		{
			RunnerClass.statusID=1;
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+","+"Other information - Renewal Coordinator Name";
			System.out.println("Issue - Other information - Renewal Coordinator Name");		
		}
		
		RunnerClass.js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		try
		{
			if(AppConfig.saveButtonOnAndOff==true)
			RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.saveLease)).click(RunnerClass.driver.findElement(Locators.saveLease)).build().perform();
			else
			RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.cancelLease)).click(RunnerClass.driver.findElement(Locators.cancelLease)).build().perform();
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			RunnerClass.statusID=1;
			e.printStackTrace();
		}
		
	  }
	  catch(Exception e)
	  {
		  RunnerClass.js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  if(AppConfig.saveButtonOnAndOff==true)
			RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.saveLease)).click(RunnerClass.driver.findElement(Locators.saveLease)).build().perform();
		  else
			RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.cancelLease)).click(RunnerClass.driver.findElement(Locators.cancelLease)).build().perform();
	  }
		
		//Related Activities
		PropertyWare_InsertOtherInformation.RelatedActivities();
		
	}
	
	public static boolean RelatedActivities() throws Exception
	{
		
		
				try
				{
				RunnerClass.driver.navigate().refresh();
				RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.relatedActivities_LeaseRenewal)).build().perform();
				RunnerClass.driver.findElement(Locators.relatedActivities_LeaseRenewal).click();
				}
				catch(Exception e)
				{
					RunnerClass.statusID=1;
					e.printStackTrace();
					RunnerClass.failedReason = RunnerClass.failedReason+","+"Issue in adding Related Activities";
					System.out.println("Issue in adding Related Activities");	
				}
				Thread.sleep(2000);
				
				try
				{
				RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.removeLeasingFee)).build().perform();
				RunnerClass.driver.findElement(Locators.removeLeasingFee).click();
				}
				catch(Exception e)
				{
					RunnerClass.statusID=1;
					e.printStackTrace();
					RunnerClass.failedReason = RunnerClass.failedReason+","+"Issue in adding Related Activities";
					System.out.println("Issue in adding Related Activities");	
				}
				
				//Related Activities - New Start Date
				try
				{
				RunnerClass.driver.findElement(Locators.relatedActivities_newStartDate).click();
				RunnerClass.driver.findElement(Locators.relatedActivities_newStartDate).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				RunnerClass.driver.findElement(Locators.relatedActivities_newStartDate).sendKeys(newStartDate);
				//Click this to remove Calendar 
				RunnerClass.driver.findElement(Locators.relatedActivities_newLeaseRenewalPopUpHeading).click();
				}
				catch(Exception e)
				{
					RunnerClass.statusID=1;
					e.printStackTrace();
					RunnerClass.failedReason = RunnerClass.failedReason+","+"Issue in adding Related Activities";
					System.out.println("Issue in adding Related Activities");
					return false;			
				}
				
				try
				{
				//Related Activities - New End Date
				try
				{
				RunnerClass.driver.findElement(Locators.relatedActivities_newEndDate).click();
				RunnerClass.driver.findElement(Locators.relatedActivities_newEndDate).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				RunnerClass.driver.findElement(Locators.relatedActivities_newEndDate).sendKeys(newEndDate);
				}
				catch(Exception e)
				{
					RunnerClass.statusID=1;
					e.printStackTrace();
					RunnerClass.failedReason = RunnerClass.failedReason+","+"Issue in adding Related Activities";
					System.out.println("Issue in adding Related Activities");
					return false;
					
				}
				
				//Related Activities - Renewal On Date
				try
				{
			    RunnerClass.driver.findElement(Locators.relatedActivities_renewalOnDate).click();
				RunnerClass.driver.findElement(Locators.relatedActivities_renewalOnDate).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				RunnerClass.driver.findElement(Locators.relatedActivities_renewalOnDate).sendKeys(renewalOnDate);
				}
				catch(Exception e)
				{
					RunnerClass.statusID=1;
					e.printStackTrace();
					RunnerClass.failedReason = RunnerClass.failedReason+","+"Issue in adding Related Activities";
					System.out.println("Issue in adding Related Activities");
					return false;							
				}
				Thread.sleep(3000);
				try
				{
					if(AppConfig.saveButtonOnAndOff==true)
					RunnerClass.driver.findElement(Locators.relatedActivities_save).click();
					else
					RunnerClass.driver.findElement(Locators.relatedActivities_cancel).click();
					Thread.sleep(3000);
				}
				catch(Exception e)
				{
					RunnerClass.statusID=1;
					e.printStackTrace();
					RunnerClass.failedReason = RunnerClass.failedReason+","+"Issue in adding Related Activities";
					System.out.println("Issue in adding Related Activities");
					e.printStackTrace();
					return false;
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					RunnerClass.failedReason = RunnerClass.failedReason+","+"Issue in adding Related Activities";
					System.out.println("Issue in adding Related Activities");
					RunnerClass.statusID=1;
					try
					{
					if(RunnerClass.driver.findElement(Locators.youMustCorrectTheFollowingErrorMessage).isDisplayed())
					{
						RunnerClass.statusID=1;
						e.printStackTrace();
						RunnerClass.failedReason = RunnerClass.failedReason+","+"Issue in adding Related Activities";
						System.out.println("Issue in adding Related Activities");
						e.printStackTrace();
						RunnerClass.driver.findElement(Locators.relatedActivities_cancel).click();
						return false;
					}
					}
					catch(Exception e2)
					{
						
					}
				}
				return true;
	}
	
	public static void clearExistingVariableValues()
	{
		renewalStatus="";
		reneWalFollowupNotes = "";
		renewalExecutionDate = "";
		currentMonthlyRent = "";
		priorMonthlyRent = "";
		renewalCoordinatorName = "";
		
		//Related Activities - Lease Renewal
		newStartDate = "";
		newEndDate = "";
		renewalOnDate = "";
		
	}

}
