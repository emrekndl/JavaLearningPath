#!/bin/bash

podman run -d \
  --name mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -p 3307:3306 \
  -v $(pwd)/db-data/mysql:/var/lib/mysql \
  mysql:latest