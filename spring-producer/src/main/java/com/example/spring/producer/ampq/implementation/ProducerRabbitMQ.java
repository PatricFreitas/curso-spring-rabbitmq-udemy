package com.example.spring.producer.ampq.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.spring.producer.ampq.AmqpProducer;
import com.example.spring.producer.dto.Message;

@Component
public class ProducerRabbitMQ implements AmqpProducer<Message> {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;
	
	@Value("${spring.rabbitmq.request.exchange.producer}")
	private String exhcange;
	
	@Override
	public void producer(Message message) {
		try {
			rabbitTemplate.convertAndSend(exhcange, queue, message);
			
		} catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);		
		}
		
	}

}
