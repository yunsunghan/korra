package com.ks.code.collector.domain.repository;

import org.springframework.data.document.mongodb.repository.MongoRepository;

import com.ks.code.collector.domain.CodeLog;

public interface CodeLogRepository extends MongoRepository<CodeLog, String> {
}
