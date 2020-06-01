package com.example.spring.producer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.producer.ampq.AmqpProducer;
import com.example.spring.producer.dto.Message;
import com.example.spring.producer.service.AmpqService;

@Service
public class RabbitMQServiceImpl implements AmpqService {

	@Autowired
	private AmqpProducer<Message> ampq;
	
	@Override
	public void sendToConsumer(Message message) {
		ampq.producer(message);		
	}

}
