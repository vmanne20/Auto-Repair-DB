#!/bin/bash

docker build -t app -f ./Dockerfile ../.. && \
docker run -it --rm -p 8080:8080 \
  -v $(pwd)/maven:/maven \
  -v $(pwd)/troop:/code \
  --link postgres:postgres \
  app $*
