package org.mayur.Library_Management_System.repository;

import org.mayur.Library_Management_System.models.Txn;
import org.mayur.Library_Management_System.models.TxnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TxnRepository extends JpaRepository<Txn, Integer> {

    public Txn findByStudent_ContactAndBook_BookNoAndTxnStatusOrderByCreatedOnDesc(String studentContact,
                                                                                   String bookNo, TxnStatus status);
    @Transactional
    @Modifying
    @Query(value="update txn set created_on=\"2023-08-23 15:59:53.91200\" where id=2" ,nativeQuery = true)
    public void updateTxnCreatedOn();

}

