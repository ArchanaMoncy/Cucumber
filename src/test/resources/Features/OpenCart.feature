Feature: Register Feature

  Scenario Outline: Register scenario with different set of data
    Given user navigates to Register Page
    When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on coutinue
    Then it shows accout is register succesfull

    Examples: 
      | SheetName | RowNumber |
      | Register  |         0 |
