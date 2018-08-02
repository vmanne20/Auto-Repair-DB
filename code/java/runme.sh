#!/bin/bash

docker build -t app -f ./Dockerfile ../.. && \
docker run -it --rm -v $(pwd)/maven:/maven --link postgres:postgres app $*
