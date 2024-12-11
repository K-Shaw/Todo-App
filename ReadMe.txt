Run these commands to spin up MySql and Adminer Containers:
Later will make Docker-Compose

docker network create todo-network
docker run --name todo-mysql --network todo-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=todo-app -p 3306:3306 -d mysql:latest
docker run --name adminer --network todo-network -d -p 8082:8080 adminer


