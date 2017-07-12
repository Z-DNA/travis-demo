#!/bin/bash
docker run -i --net=demo-app --ip 172.18.0.3 -p 8081:8081 -t app2 /bin/bash
