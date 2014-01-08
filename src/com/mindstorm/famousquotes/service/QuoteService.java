package com.mindstorm.famousquotes.service;

import java.util.ArrayList;
import java.util.List;

import com.google.api.server.spi.response.NotFoundException;
import com.mindstorm.famousquotes.entity.Quote;

public class QuoteService {

	public static List<Quote> quotes = new ArrayList<Quote>();

	public Quote addQuote(Integer id, String author, String message) throws NotFoundException {
		//Check for already exists
		int index = quotes.indexOf(new Quote(id));
		if (index != -1) throw new NotFoundException("Quote Record already exists");
		Quote q = new Quote(id, author, message);
		quotes.add(q);
		return q;
	}

	public Quote updateQuote(Quote q) throws Exception {
		int index = quotes.indexOf(q);
		if (index == -1)
			throw new Exception("Quote Record does not exist");
		quotes.add(index,q);
		return q;
	}

	public void removeQuote(Integer id) throws Exception {
		int index = quotes.indexOf(new Quote(id));
		if (index == -1)
			throw new Exception("Quote Record does not exist");
		quotes.remove(index);
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public List<Quote> getQuotesByAuthor(String author) {
		List<Quote> results = new ArrayList<Quote>();
		for (Quote quote : quotes) {
			if (quote.getAuthor().indexOf(author) != -1) {
				results.add(quote);
			}
		}
		return results;
	}

	public Quote getQuote(Integer id) throws Exception {
		int index = quotes.indexOf(new Quote(id));
		if (index == -1)
			throw new Exception("Quote Record does not exist");
		return quotes.get(index);
	}

}
