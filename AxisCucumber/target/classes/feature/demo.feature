Feature: FD calculator
 Calculating rate of Interest retriving data from Excel sheet
Scenario: Rate of Interest for Senoir Citizens 
	Given User is on FD Calculator Home Page 
	When User selects Senoir Citizenship radioBtn 
	Then User selects monthly payout 
	And Data retrived from excel and click someWhere
	Then Capture the rate of interest print on Console
	Then Capture the Screenshot
	 
	