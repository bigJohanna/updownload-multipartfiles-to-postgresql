package se.big.johanna.downupload.downupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.big.johanna.downupload.downupload.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
