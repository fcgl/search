# Search Microservices

**Note:** 
  * You will only need docker installed on your computer to run this app

## Git Steps
1. Fork Branch
2. Open terminal and clone **forked branch**: `git clone https://github.com/<YOUR USERNAME>/search.git`
3. Go inside search directory: `cd search`
3. Add upstream repo: `git remote add upstream https://github.com/fcgl/search.git`
4. Confirm that you have an origin and upstream repos: `git remote -v`

## Build & Run App

This build should work for both macOS and Linux

1. Download docker for your operating system
2. From project root run the following command (this will build containers for service and db):
   docker-compose up --build

## Health Endpoint

Confirm everything was ran correctly by going to the following endpoint: 
  * http://localhost:8084/health/v1/marco
  
## Elastic Search
Elastic Search info endpoint: http://localhost:9200
Elastic Search health endpoint: http://localhost:9200/_cat/health
Kibana: http://localhost:5601

**Reference:** http://codingfundas.com/setting-up-elasticsearch-6-8-with-kibana-and-x-pack-security-enabled/index.html

