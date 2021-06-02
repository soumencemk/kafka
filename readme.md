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
Suppose, a topic containing three partitions 0,1 and 2. Each partition has different offset numbers. The data is
distributed among each offset in each partition where data in offset 1 of Partition 0 does not have any relation with
the data in offset 1 of Partition1. But, data in offset 1of Partition 0 is inter-related with the data contained in
offset 2 of Partition0.

### Broker and Topics

A **broker** is a container that holds several topics with their multiple partitions

![](https://static.javatpoint.com/tutorial/kafka/images/kafka-topics-2.png)

Each broker is holding a topic, namely Topic-x with three partitions 0,1 and 2. Remember, all partitions do not belong
to one broker only, it is always distributed among each broker (depends on the quantity). Broker 1 and Broker 2 contains
another topic-y having two partitions 0 and 1. Thus, Broker 3 does not hold any data from Topic-y. It is also concluded
that no relationship ever exists between the broker number, and the partition number

### Topic Replication

A _**replication factor**_ is the number of copies of data over multiple brokers. The replication factor value should be
greater than 1 always (between 2 or 3)

* It chooses one of the broker's partition as a leader, and the rest of them becomes its followers.

* The followers(brokers) will be allowed to synchronize the data. But, in the presence of a leader, none of the
  followers is allowed to serve the client's request. These replicas are known as ISR(in-sync-replica). So, Apache Kafka
  offers multiple ISR(in-sync-replica) for the data.

> only the leader is allowed to serve the client request. The leader handles all the read and writes operations of data for the partitions. The leader and its followers are determined by the **zookeeper**

* If the broker holding the leader for the partition fails to serve the data due to any failure, one of its respective
  ISR replicas will take over the leadership. Afterward, if the previous leader returns, it tries to acquire its
  leadership again.

### Producer

A producer uses following strategies to write data to the cluster:

* **Message Keys**
    * If the value of `key=NULL`, it means that the data is sent without a key. Thus, it will be distributed in a
      round-robin manner (i.e., distributed to each partition).
    * If the value of the `key!=NULL`, it means the key is attached with the data, and thus all messages will always be
      delivered to the same partition.

* **Acknowledgment**
    * `acks=0`: Producer doesn't wait for acknowledgement, data loss can happen
    * `acks=1`: Producer will wait for the leader's acknowledgement
    * `acks=ALL`: Acknowledgment is done by both the leader and its followers 