#!/bin/bash

# Function to build the Docker image for Spring Boot application
build_image() {
    echo "Building Docker image for Spring Boot application..."
    docker build -t my-spring-app .
    echo "Build complete."
}

# Function to start the MySQL container
start_mysql() {
    echo "Starting MySQL container..."
    docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=social-media-database -e MYSQL_USER=social-media-user -e MYSQL_PASSWORD=dummypassword -d mysql:8.0
    echo "MySQL container started."
}

# Function to stop all running containers
stop_all_containers() {
    echo "Stopping all containers..."
    docker stop $(docker ps -aq)
}

# Function to remove all containers
remove_all_containers() {
    echo "Removing all containers..."
    docker rm $(docker ps -aq)
}

# Function to remove all images
remove_all_images() {
    echo "Removing all images..."
    docker rmi -f $(docker images -q)
}

# Function to start the app
start_app() {
    stop_all_containers
    remove_all_containers
    build_image
    start_mysql
    echo "Starting a fresh Spring Boot container instance..."
    docker run -d --link mysql-container:mysql -p 8081:8080 my-spring-app
}

# Function to show the current status of all Docker containers
view_all_containers() {
    echo "Current status of all Docker containers:"
    docker ps -a
}

# Function to restart the app
restart_app() {
    echo "Restarting the app..."
    stop_all_containers
    remove_all_containers
    start_app
}

# Menu to select an operation
echo "Select an option:"
echo "1) Start the App"
echo "2) Stop the App"
echo "3) Current Status"
echo "4) Restart the App"
echo "5) Nuke Mode (Delete Everything)"
read -p "Enter your choice (1/2/3/4/5): " choice

case $choice in
1) start_app ;;
2) stop_all_containers ;;
3) view_all_containers ;;
4) restart_app ;;
5)
    stop_all_containers
    remove_all_containers
    remove_all_images
    ;;
*) echo "Invalid choice!" ;;
esac
