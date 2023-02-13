Feature: Testing TFL


  Scenario: To verify that a valid journey can be planned using the Journey Plan
    Given I have arrived at the TFL page
    And I enter the following postcode "SE10 0ES" into the FROM search bar of the plan journey widget
    And  I enter the following postcode "SW1E 5NN" into the TO search bar of the plan journey widget
    And I click on the plan journey button
    Then I see the journey results page
    And I close the website


  Scenario: To verify that the widget is unable to plan a journey when there is one invalid location
    Given I have arrived at the TFL page
    And I enter the following postcode "SE10 0ES" into the FROM search bar of the plan journey widget
    And  I enter the following postcode "bzbzbzb" into the TO search bar of the plan journey widget
    And I click on the plan journey button
    Then I see the journey results page
    And  I see the "Sorry, we can't find a journey matching your criteria" error dialog
    And I close the website


  Scenario: To verify that the widget is unable to plan a journey when there are two invalid locations
    Given I have arrived at the TFL page
    And I click on the plan journey button
    Then I see an error message within the to search stating "The To field is required."
    And I see an error message within the from search stating "The From field is required."
    And I close the website



  Scenario: To verify the user can edit journey via the journey results page
    Given I have arrived at the TFL page
    And I enter the following postcode "SE10 0ES" into the FROM search bar of the plan journey widget
    And  I enter the following postcode "SW1E 5NN" into the TO search bar of the plan journey widget
    And I click on the plan journey button
    And I see the journey results page
    Then I select the edit journey button
    And  I enter the following postcode "SW1P 2AW" into the TO journey search bar of the plan journey widget
    And I click on the plan journey button
    And I see the journey results page
    And I close the website



  Scenario: To verify the Recents tab on the widget displays a list of recently planned journeys
    Given I have arrived at the TFL page
    And I enter the following postcode "SE10 0ES" into the FROM search bar of the plan journey widget
    And  I enter the following postcode "SW1E 5NN" into the TO search bar of the plan journey widget
    And I click on the plan journey button
    And I see the journey results page
    And I click on the home widget button
    And I enter the following postcode "SE10 0ES" into the FROM search bar of the plan journey widget
    And  I enter the following postcode "SW1E 5NN" into the TO search bar of the plan journey widget
    And I click on the plan journey button
    And I see the journey results page
    And I click on the home widget button
    And I click on the Recents tab
    And i see in the "SE10 0ES to SW1E 5NN" as the first entry in the first recent journey
    And I close the website
