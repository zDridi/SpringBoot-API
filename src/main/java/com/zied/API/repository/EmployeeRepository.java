package com.zied.API.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zied.API.model.Employee;

// @Repository : une annotation Spring pour indiquer que la classe est un bean et que son rôle est de communiquer avec une source de données
// En réalité, @Repository est une spécialisation de @Component. Par son nom, on fournit au développeur une indication sémantique sur le rôle de la classe..
// CrudRepository  : est une interface fournie par Spring. Elle fournit des méthodes pour manipuler l'entité.
// CrudRepository utilise la généricité pour que son code soit applicable à n’importe quelle entité, d’où la syntaxe “CrudRepository<Employee, Long>”
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}