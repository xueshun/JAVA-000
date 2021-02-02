package com.xuesran.datasource.masterslave.repository.readonly;

import com.xuesran.datasource.masterslave.annotation.ReadOnlyRepository;
import com.xuesran.datasource.masterslave.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ReadOnlyRepository
public interface BooksReadOnlyRepository extends JpaRepository<Books, Long> {
}
