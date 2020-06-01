package com.example.spring.producer.service;

import com.example.spring.producer.dto.Message;

public interface AmpqService {

	void sendToConsumer(Message message);
}
