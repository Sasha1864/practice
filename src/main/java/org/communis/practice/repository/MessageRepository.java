package org.communis.practice.repository;

import org.communis.practice.entity.Message;
import org.communis.practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message>
{
    Message findById(Long id);

}
