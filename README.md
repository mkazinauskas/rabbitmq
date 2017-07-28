# RabbitMQ example

## How to run
* Install `docker` and `docker-compose`
* `sudo docker-compose up` will start container from `docker-compose.yml` file. If you want to see management console visit `http://localhost:15672`. Username and password `guest`
* Go to to producer and execute command: `gradlew bootRun`. It will start producer on port 8080
* Go to consumer and execute command: `gradlew bootRun`. It will start consumer on port 8081
That's it. Messages are logged in console.

