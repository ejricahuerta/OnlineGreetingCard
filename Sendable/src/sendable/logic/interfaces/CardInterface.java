package sendable.logic.interfaces;

import java.util.List;

import sendable.logic.dtos.CardDto;

public interface CardInterface {

	List<CardDto> ListCards();
	List<CardDto> ListCards(String filter);
	CardDto getCard(int id);
}
