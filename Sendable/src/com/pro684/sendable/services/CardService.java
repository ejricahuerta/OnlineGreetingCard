package com.pro684.sendable.services;

import java.util.ArrayList;
import java.util.List;
import com.pro684.sendable.dtos.CardDto;
import com.pro684.sendable.interfaces.CardInterface;
import data.mock.MockService;
import sendable.entities.Card;

public class CardService implements CardInterface {

	private MockService mockdata = null; //TODO change to database
	private CardDto ret = null;

	public CardService(MockService mock) { 
		this.mockdata = mock;
	}

	@Override
	public List<CardDto> ListCards() {
		ArrayList<CardDto> cardret = new ArrayList<CardDto>();
		for (Card card : mockdata.AllCards()) {

			cardret.add(new CardDto(card.getId(), card.getName(), card.getDescription(), card.getPrice(),
					card.isAvailable(), card.getDateAdded()));
		}

		return cardret;
	}

	@Override
	public List<CardDto> ListCards(String filter) {
		System.out.println("Not Implemented");
		return null;
	}

	@Override
	public CardDto getCard(int id) {
		ret = null;
		ListCards().forEach(c -> 
		{
			if (c.getId() == id) {
				ret = c;
				
			}
		});
		return ret;
	}
}
