#!/bin/bash
docker run -i --net=demo-app --ip 172.18.0.2 -p 127.0.0.1:8080:8080 -t app1 /bin/bash
