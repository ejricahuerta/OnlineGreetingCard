package com.pro684.sendable.repository;

import java.util.ArrayList;

public interface RepositoryInterface<T> {

	ArrayList<T> ListAll();
	
	T Get(int id);
	
	void Insert(T obj);
	
	void Remove(int id);
}
