package com.pro684.sendable.repository;

import java.util.ArrayList;

public interface RepositoryInterface<BaseEntity> {

	ArrayList<BaseEntity> ListAll();
	
	BaseEntity Get(int id);
	
	void Insert(BaseEntity obj);
	
	void Remove(int id);
}
