package com.privalia.services;

import java.util.List;

//con genericos, interfaz generica
public interface CRUDService<T> {
	List<?> listAll();
	
	T getById(Integer id);
	
	T saveOrUpdate(T domainObject);
	
	void delete(Integer id);
}
