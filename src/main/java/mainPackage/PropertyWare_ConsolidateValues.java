package mainPackage;

public class PropertyWare_ConsolidateValues 
{
	public static void decideAutoCharges()
	{
		String autoCharges ="";
		String query ="";
		if(RunnerClass.portfolioType=="MCH")
		{
			if(PDFReader.petFlag==false)
			{
				if(PDFReader.residentBenefitsPackageAvailabilityCheck==true)
				{
					if(PDFReader.incrementRentFlag == true)
					autoCharges = "2,3,4";
					else autoCharges = "2,4";
				}
			   else
			    {
				if(PDFReader.incrementRentFlag == true)
				autoCharges = "2,3,5";
				else autoCharges = "2,5";
				}
				query = "update automation.LeaseReneWalsAutoChargesConfiguration Set Flag = 1 where ID in ("+autoCharges+")";
                DataBase.updateTable(query);				
		     }
			else
			{
				if(PDFReader.petFlag==true&&PDFReader.petSecurityDepositFlag==false)
				{
					if(PDFReader.residentBenefitsPackageAvailabilityCheck==true)
					{
					if(PDFReader.incrementRentFlag == true)
					autoCharges = "2,3,4,6";
					else autoCharges = "2,4,6";
					}
					else
					{
						if(PDFReader.incrementRentFlag == true)
						autoCharges = "2,3,5,6";
						else autoCharges = "2,5,6";
					}
					query = "update automation.LeaseReneWalsAutoChargesConfiguration Set Flag = 1 where ID in ("+autoCharges+")";
				}
	         }
      }
		
		//Other Portfolios
		if(RunnerClass.portfolioType=="Other")
		{
			if(PDFReader.petFlag==false)
			{
				if(PDFReader.residentBenefitsPackageAvailabilityCheck==true)
				{
					if(PDFReader.incrementRentFlag == true)
					autoCharges = "1,2,3,4";
					else autoCharges = "1,2,4";
				}
			   else
			    {
				if(PDFReader.incrementRentFlag == true)
				autoCharges = "1,2,3,5";
				else autoCharges = "1,2,5";
				}
				query = "update automation.LeaseReneWalsAutoChargesConfiguration Set Flag = 1 where ID in ("+autoCharges+")";
		     }
			else
			{
				if(PDFReader.petFlag==true&&PDFReader.petSecurityDepositFlag==false)
				{
					if(PDFReader.residentBenefitsPackageAvailabilityCheck==true)
					{
					if(PDFReader.incrementRentFlag == true)
					autoCharges = "1,2,3,4,6";
					else autoCharges = "1,2,4,6";
					}
					else
					{
						if(PDFReader.incrementRentFlag == true)
						autoCharges = "1,2,3,5,6";
						else autoCharges = "1,2,5,6";
					}
					query = "update automation.LeaseReneWalsAutoChargesConfiguration Set Flag = 1 where ID in ("+autoCharges+")";
				}
	         }
      }
		DataBase.updateTable(query);
	}
	
	public static void updateDates()
	{
		if(RunnerClass.portfolioType=="MCH")
		{
			
		}
	}
}