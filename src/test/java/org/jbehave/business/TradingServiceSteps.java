package org.jbehave.business;

import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@Steps
public class TradingServiceSteps {

	@Autowired
	private TradingService tradingService = null;
	
	private Stock stock;
	
	@Given("a stock of symbol $symbol and a threshold of $threshold")
	public void aStock(@Named("symbol")String symbol, @Named("threshold")double threshold) {
		stock = tradingService.addNewStock(threshold, 0);
	}
	
	@When("the stock is traded at $price")
	public void theStockIsTradedAt(@Named("price")double price) {
		stock.setTradeAt(price);
	}
	
	@Then("the alert status should be $status")
	public void theAlertStatusShouldBe(@Named("status")StockAlertStatus status) {
		assertThat(stock.getStatus(), equalTo(status));
	}
	
}
