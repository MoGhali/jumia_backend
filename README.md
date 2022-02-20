# Jumia Backend Project
 Jumia testcase backend project
 
 1- Navigate to bin folder using below command.
  cd case/bin
  
 2- Run shell script to create and fill postgres DB using below command.
 
  ./start_postgres.sh 
  
  # OR
  
  1- Run postgres container
  
  docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql postgres
  
  2- Execute SQL files.
  
  execute form any db client the schema.sql and data.sql
 
 3- Create docker network with this name (JumiaNetwork)
 
 docker network create JumiaNetwork
 
 4- Connect Postgres Container to JumiaNetwork
 
 docker network connect JumiaNetwork pg-docker
 
 5- Build backend docker image.
 
 docker build -t jumia-case .
 
 6- Run Backend docker container.
 
 docker run --name jumia --network JumiaNetwork -p 9090:8080 -d jumia-case 
  
# Your project should be now working fine
