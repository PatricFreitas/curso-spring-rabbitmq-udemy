package com.example.spring.consumer.ampq.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.consumer.ampq.AmpqConsumer;
import com.example.spring.consumer.dto.Message;
import com.example.spring.consumer.service.ConsumerService;

@Component
public class RabbitMQConsumer implements AmpqConsumer<Message> {

	@Autowired
	private ConsumerService service;
	
	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void consumer(Message message) {		
		try {
			service.action(message);
		} catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
	}

}
