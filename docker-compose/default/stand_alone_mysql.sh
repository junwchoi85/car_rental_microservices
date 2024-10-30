docker run --name mysql-container \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=car_rental_db \
  -v car_rental_db_data:/var/lib/mysql \
  -d mysql:latest