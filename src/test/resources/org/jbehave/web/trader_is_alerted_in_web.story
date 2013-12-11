Scenario: trader should insert stock data in a web page interface. trader should be alerted above threshold after it has been inserted.

Given trader starts web application
When trader inserts stock STK1 with threshold 5 and trade at 4
Then web page should show an OFF message

Scenario: trader should insert stock data in a web page interface. trader should be not alerted below threshold.

Given trader starts web application
When trader inserts stock STK1 with threshold 5 and trade at 14
Then web page should show an ON message