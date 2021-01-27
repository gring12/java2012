package com.example.Lesson240;

import org.springframework.data.repository.CrudRepository;

//user 레코드 보관하는 인터페이스
public interface UserRepository extends CrudRepository<User, Integer> {

}
