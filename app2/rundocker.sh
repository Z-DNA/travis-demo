#!/bin/bash
docker run --net=demo-app --ip 172.18.0.3 -p 8081:8081 app2 /bin/bash
