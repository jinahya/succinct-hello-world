#!/bin/sh
mvn --quiet clean package && java -jar target/succinct-hello-world-0.0.5-SNAPSHOT.jar
