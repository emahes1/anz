Feature: Calculate Loan Amount Feature

  
  Scenario Outline: Calculate Loan Scenario
    Given user is already on Loan borrow Page
    When user Selects Application Type as "<apptype>"
    When user Selects Number of Dependents as <dependents>
    When user Selects Property Type as home to live in
    When user Selects Income as <income>
    When user Selects Other Income as <otherincome>
    When user Selects Living Expenses as <livingexpense>
    When user Selects Current Home Repayments as 0
    When user Selects Other loan Repayments as <loanrepayment>
    When user Selects Other Commitments as 0
    When user Selects Credit Card Limit as <creditlimit>
    When user selects Calculate
    Then the  borrowing estimate of "<estimate>" is shown to user

    Examples: 
      | apptype | dependents | income | otherincome | livingexpense | loanrepayment | creditlimit | estimate |
      | Single  |          0 |  80000 |       10000 |           500 |           100 |       10000 | $479,000 |
      | Single  |          0 |  80000 |       10000 |           500 |           100 |        1000 | $528,000 |

  
  Scenario Outline: Error Message Scenario
    Given user is already on Loan borrow Page
    When user Selects Living Expenses as <livingexpense>
    When user selects Calculate
    Then the "<errormsg>" is shown to user

    Examples: 
      | livingexpense | errormsg                                                                                                                                                        |
      |             1 | Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641. |
      |             2 | Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641. |


  Scenario Outline: Start Over Scenario
    Given user is already on Loan borrow Page
    When user Selects Living Expenses as <livingexpense>
    When user selects Calculate
    When user Selects Start Over
    Then form is cleared

    Examples: 
      | livingexpense |
      |             1 |
