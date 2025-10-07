@EditCaseDetails
Feature: Edit Case Details and Program Type
#Author Name: All Xpaths are detected by Ram and File generic coding is done by Shweta

  Background:
   Given User login to Appian application as "CaseManager"
   Then User navigates to Home category

  @EditPopupGeneric
  Scenario Outline: Edit and save case details using the edit pop-up
   	When  User opens a contract case from the Assigned Programs "<testCaseID>"
   	And User click on Edit button
    And the user updates client information:
      | Field   | Value              |
      | Name    | <ClientName>     |
      | Address | <ClientAddress>  |

    And the user updates broker information:
      | Field   | Value              |
      | Name    | <BrokerName>     |
      | Address | <BrokerAddress>  |

    #And the user selects "<CorrespondenceMethod>" as the primary correspondence method
    #And the user sets remuneration contribution to "<ContributionPercentage>"

    And the user updates client contact details:
    	| Field       | Value                     |
      | Name        | <ClientContactName>     |
      | Phone       |  <ClientPhone>           |
      | Email       | <ClientEmail>           |
      | Designation | <ClientDesignation>     |

    And the user updates broker contact details:
   		| Field       | Value                     |
      | Name        | <BrokerContactName>     |
      | Phone       | <BrokerPhone>           |
      | Email       | <BrokerEmail>           |
      | Designation | <BrokerDesignation>     |

    And the user updates program type "<ProgramType>" with the following details:
    	| Field       | Value                     |
      | Business Type | <BusinessType>         |
      | Start Date    | <StartDate>            |
      | Expiry Date   | <ExpiryDate>           |
      | Deadline      | <Deadline>             |
      | SER/VAL       | <SerVal>               |

   # Then the user clicks "SAVE CHANGES"
    #And the user verifies that the changes are saved successfully

  Examples:
    | testCaseID | ClientName | ClientAddress | BrokerName | BrokerAddress | CorrespondenceMethod | ContributionPercentage | ClientContactName | ClientPhone | ClientEmail | ClientDesignation | BrokerContactName | BrokerPhone | BrokerEmail | BrokerDesignation | ProgramType | BusinessType | StartDate | ExpiryDate | Deadline | SerVal |
    | TC_010 | New Test InsuranceN   | 123 Street    | Greenfield Associates| 456 Avenue    | Email                | 10.00                  | John Doe          | 9876543210  | john@abc.com | Manager          | Jane Smith        | 9123456789  | jane@xyz.com | Director         | Cat XoL     | Commercial   | 09/01/2025 | 08/31/2026 | 07/15/2025 | 25.00 |
