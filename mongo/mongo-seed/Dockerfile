FROM mongo

COPY mongodbarchive /mongodbarchive

RUN sleep 5

CMD mongorestore --archive=./mongodbarchive --db search -v --gzip
