package com.filters.services;

import com.filters.entities.Log;
import com.filters.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    @Override
    public void create(Log log) {
        this.logRepository.saveAndFlush(log);
    }
}
