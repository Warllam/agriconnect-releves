# agriconnect-releves !

docker run --name ac-releves -p 27020:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -e MONGO_INITDB_DATABASE=ag-releves-db -d mongo:latest