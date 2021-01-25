#!/bin/bash
mvn clean package test
docker build . -t 676947094948.dkr.ecr.eu-west-1.amazonaws.com/infoaxs-kafka-xml2json-transformer:1.5-SNAPSHOT