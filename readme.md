# ![KAFKA](https://kafka.apache.org/logos/kafka_logo--simple.png)

# My notes on Kafka
#### source
* [Java point](https://www.javatpoint.com/kafka-topics)

## Kafka APIs

* _**Producer API**_ :
  This API allows/permits an application to publish streams of records to one or more topics.

* _**Consumer API**_ : This API allows an application to subscribe one or more topics and process the stream of records
  produced to them.

* _**Streams API**_ : This API allows an application to effectively transform the input streams to the output streams.
  It permits an application to act as a stream processor which consumes an input stream from one or more topics, and
  produce an output stream to one or more output topics.

* _**Connector API**_ : This API executes the reusable producer and consumer APIs with the existing data systems or
  applications.

### Partitions

A **topic** is split into several parts which are known as the **partitions** of the topic. These partitions are
separated in an order. The data content gets stored in the partitions within the topic. Therefore, while creating a
topic, we need to specify the number of partitions(the number is arbitrary and can be changed later). Each message gets
stored into partitions with an incremental id known as its Offset value. The order of the offset value is guaranteed
within the partition only and not across the partition. The offsets for a partition are infinite

> **NOTE :** The data once written to a partition can never be changed. It is immutable. The offset value always remains in an incremental state, it never goes back to an empty space. Also, the data is kept in a partition for a limited time only.

![](https://static.javatpoint.com/tutorial/kafka/images/kafka-topics.png)
