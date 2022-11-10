# Kafka Producer

## Steps to run the project

1. Install the Kafka  
	`cd kafka_2.13-3.3.1`

2. Run the zookeeper & kafka server  
	`bin/zookeeper-server-start.sh config/zookeeper.properties`  
	`bin/kafka-server-start.sh config/server.properties`  

3. Create the topic manually using the kafka cli  
	`bin/kafka-topics.sh --create --topic Mytopic --bootstrap-server localhost:9092`

4. Start the Producer
  `bin/kafka-console-producer.sh --topic Mytopic --bootstrap-server localhost:9092`

5. Start the Consumer
   `bin/kafka-console-consumer.sh --topic Mytopic --bootstrap-server localhost:9092`

