package com.pro684.sendable.repository;

import java.util.ArrayList;

import com.pro684.sendable.entities.Card;

import data.seed.Seed;

public class CardRepository implements RepositoryInterface<Card> {

	
	private Seed seed = new Seed();
	@Override
	public ArrayList<Card> ListAll() {
		// TODO Auto-generated method stub
		return seed.AllCards();
	}

	@Override
	public Card Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(Card obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Remove(int id) {
		// TODO Auto-generated method stub
		
	}

}
