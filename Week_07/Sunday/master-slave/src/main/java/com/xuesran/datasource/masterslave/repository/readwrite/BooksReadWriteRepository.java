package com.xuesran.datasource.masterslave.repository.readwrite;

import com.xuesran.datasource.masterslave.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksReadWriteRepository extends JpaRepository<Books, Long> {
}
