package ftt.ec.model;

import java.util.ArrayList;

//Refer�ncia: https://cursos.alura.com.br/forum/topico-dao-generica-61881
//Refer�ncia: https://www.guj.com.br/t/generic-dao/105808

//Usando generics: https://www.oracle.com/technical-resources/articles/java/juneau-generics.html
public interface Dao<DomainObject> {
	
	public  void insert(DomainObject obj);
	
	public  void update(DomainObject obj);
	
	public  void delete(DomainObject obj);
	
	public  DomainObject find(DomainObject obj);
	
	public  ArrayList<DomainObject> findAll(DomainObject obj);
}