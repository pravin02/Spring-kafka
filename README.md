Spring kakfa application to produce and consume messages from durable stream.

** If expecting to create topic using spring KafkaAdmin class then edit zookeeper.properties file 
** admin.enableServer=true

1. Start Zookeepr or kkraft

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

2. Run kafka server
.\bin\windows\kafka-server-start.bat .\config\server.properties

3. Develop spring-kafka producer application

kafka-server = localhost:9092
topic-name = test

once user hits rest URI to push message for above topic we can view using





Spring kakfa producer application to produce messages to durable stream.

1. Start Zookeepr or kkraft

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

2. Run kafka server
.\bin\windows\kafka-server-start.bat .\config\server.properties

3. Develop spring-kafka producer application

kafka-server = localhost:9092
topic-name = test

once user hits rest URI to push message for above topic we can view using

4. To see queue message
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --<topic-name> test --from-beginning

