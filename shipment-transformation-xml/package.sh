#!/bin/bash

aws ecr get-login-password --region eu-west-1 | docker login --username AWS --password-stdin 676947094948.dkr.ecr.eu-west-1.amazonaws.com
docker push 676947094948.dkr.ecr.eu-west-1.amazonaws.com/infoaxs-kafka-xml2json-transformer:1.5-SNAPSHOT