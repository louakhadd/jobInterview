package com.job.interview.Repository;

import com.job.interview.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query(value = "Select * from transaction where id_sender=id_reciever and id_sender=Id ORDER BY transaction_date ", nativeQuery = true)
    List<Operation> getAllOperations(Long Id);
}
