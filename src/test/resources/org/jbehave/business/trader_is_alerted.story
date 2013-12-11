Scenario:  trader should be not alerted below threshold
 
Given a stock of symbol STK1 and a threshold of 5
When the stock is traded at 4
Then the alert status should be OFF

Scenario:  trader should be alerted above threshold

Given a stock of symbol STK1 and a threshold of 5
When the stock is traded at 14
Then the alert status should be ON