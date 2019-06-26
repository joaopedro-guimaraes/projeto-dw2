#!/bin/bash
cd ../data
java -classpath ../lib/hsqldb.jar org.hsqldb.server.Server -database.0 ../data/jpatable -dbname.0 jpadb
