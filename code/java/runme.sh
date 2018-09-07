#!/bin/bash

docker build -t app -f ./Dockerfile ../.. && \
docker rm -f app
docker run --rm -p 8080:8080 \
  -v $(pwd)/maven:/maven \
  -v $(pwd)/troop:/code \
  --link postgres:postgres \
  --name app \
  app $*


cat <<EOF
To view database logs issue command:

```
docker logs postgres
```

To view application logs issue command:

```
docker logs app
```
EOF
