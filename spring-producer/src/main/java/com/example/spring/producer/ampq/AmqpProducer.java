package com.example.spring.producer.ampq;

public interface AmqpProducer<T>  {

	void producer(T t);
	
}
