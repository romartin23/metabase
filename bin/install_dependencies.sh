#!/usr/bin/env sh
mvn install:install-file -Dfile=./bin/lib/stratio-crossdata-mesosphere-jdbc4-1.11.0-SNAPSHOT.jar -DgroupId=com.stratio.jdbc -DartifactId=stratio-crossdata-mesosphere-jdbc4 -Dversion=1.11.0-SNAPSHOT -Dpackaging=jar
