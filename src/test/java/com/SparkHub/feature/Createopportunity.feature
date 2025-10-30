Feature: Create Opportunity

@TC_101

Scenario: Verify Create opportunity 

Given I am logged in BrokerHub
When I click "createOpportunity" on "opportunity" page
When I enter "ANNE" in "customer" on "createOpportunity" page
And I select "ANNE TESTA" in "customerList" for "customerSearchBox" on "createOpportunity" page
And I select radio button "gas" on "createOpportunity" page
And I enter and select "DTH" in "UOM" on "createOpportunity" page
And I enter and select "Dinesh Choudhary" in "salesperson" on "createOpportunity" page
And I enter and select "New York" in "state" on "createOpportunity" page
And I enter and select "Brijesh Tiwari" in "salesSupport" on "createOpportunity" page
And I select "startDate" after "days" of current date