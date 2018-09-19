#!/bin/bash

docker build -t app -f ./Dockerfile ../.. 
docker rm -f app 
cat <<EOF












Starting application...
EOF
docker run -d --rm -p 8080:8080 \
  -v $(pwd)/maven:/maven \
  -v $(pwd)/troop:/code \
  --link postgres:postgres \
  --name app \
  app $*

docker logs -f app
