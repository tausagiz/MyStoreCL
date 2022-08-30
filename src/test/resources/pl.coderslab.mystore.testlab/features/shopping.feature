Feature: Shopping

  Scenario Outline: Checking if an User can add his address
    Given User is on "https://mystore-testlab.coderslab.pl/" website
    And User is logged in with "bkdrpsvjhoixcbfryh@nvhrw.com" as username and "T3$hODqT89R7" as password
    When User clicks on Addresses button
    And User clicks on Create new address
    And User fills the form with "<alias>", "<address>", "<city>", "<zip>", "<country>", "<phone>"
    Then Address with proper data is on this User account page
    And Browser is closed
    Examples:
      | alias | address     | city   | zip      | country        | phone        |
      | new   | 4 Howard St | Batley | WF17 6AB | United Kingdom | 01924 488500 |

  Scenario: Checking if an User can buy Hummingbird Printed Sweater
    Given User is on "https://mystore-testlab.coderslab.pl/" website
    And User is logged in with "bkdrpsvjhoixcbfryh@nvhrw.com" as username and "T3$hODqT89R7" as password
    When User clicks on Clothes category
    And User clicks on "Hummingbird Printed Sweater"
    And User chooses "M" size
    And User chooses "5" quantity
    And User clicks on ADD TO CART button
    And User clicks on PROCEED TO CHECKOUT button
    And User confirms his address
    And User chooses PrestaShop Pick up in-store
    And User chooses Pay by Check
    And User clicks on order with an obligation to pay
    Then Order is confirmed
    And Screenshot of confirmation is taken
    And Browser is closed