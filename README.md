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

**Note:** Might have to increase the memory in your Docker preferences in order to get Elastic Search, and as a result the app,
to work. Works properly on 4.5GB of memory but could work on lower. 

**Reference:** http://codingfundas.com/setting-up-elasticsearch-6-8-with-kibana-and-x-pack-security-enabled/index.html

**Create Index Api:** https://www.elastic.co/guide/en/elasticsearch/reference/current/indices-create-index.html
    * Can do it through typical http request (curl, postman)
    * Or, http://localhost:5601/app/kibana#/dev_tools/console
    
#### Configuration
Sometimes the node address changes... TODO: Figure out where to set the host to avoid this manual step
1. After you run the command `docker-compose up --build` if your requests to elasticsearch don't work you need to do
the following:
    * Make this request: `curl http://localhost:9200/_nodes`
    * Should return something similar to this: 
    `{"_nodes":{"total":1,"successful":1,"failed":0},"cluster_name":"docker-cluster","nodes":{"amcNzpPYS-u5eNw0eHXDPg":{"name":"amcNzpP","transport_address":"192.168.112.2:9300"`
    * Copy the transport_address and change the variables `TRANSPORT_ADDRESS` in `config/ElasticConfiguration` to it
    * Build and run again `docker-compose up --build`


## Populate Data

1. To populate data into the database and elasticsearch make an api request to the following endpoint:
    * `http://localhost:8084/dev/populate`
