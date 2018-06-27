package com.pro684.sendable.interfaces;

import java.util.List;

import com.pro684.sendable.dtos.CardDto;

public interface CardInterface {

	List<CardDto> ListCards();
	List<CardDto> ListCards(String filter);
	CardDto getCard(int id);
}
