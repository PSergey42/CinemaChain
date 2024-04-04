package com.example.cinemachain.repository.base;

import com.example.cinemachain.entity.base.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.Collection;

@NoRepositoryBean
public interface BaseRepository <T extends CommonEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    @Query("UPDATE #{#entityName} e SET e.deletedAt = ?2 WHERE e.id = ?1")
    @Modifying
    void deleteSoft(Long id, LocalDateTime deletedAt);

    @Query("UPDATE #{#entityName} e SET e.deletedAt = ?2 WHERE e.id IN (?1)")
    @Modifying
    void deleteSoft(Collection<Long> ids, LocalDateTime deletedAt);

    @Query("DELETE FROM #{#entityName} e WHERE e.id IN (?1)")
    @Modifying
    void deleteHard(Collection<Long> ids);
}