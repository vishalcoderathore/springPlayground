#!/bin/bash

# Function to build the Docker image
build_image() {
    echo "Building Docker image..."
    docker build -t my-spring-app .
    echo "Build complete."
}

# Function to run a specified number of Docker containers
run_containers() {
    read -p "Enter the number of containers you want to run: " num_containers

    echo "Running $num_containers Docker containers..."
    for i in $(seq 1 $num_containers)
    do
        # Note: Adjusting port mapping for each container.
        port=$((8080 + $i))
        echo "Starting container $i on port $port..."
        docker run -d -p $port:8080 my-spring-app
    done
}

# Function to view all running containers
view_running_containers() {
    echo "Viewing running containers..."
    docker ps
}

# Function to view all containers (including stopped)
view_all_containers() {
    echo "Viewing all containers..."
    docker ps -a
}

# Function to clear everything (nuke mode)
clear_everything() {
    echo "Stopping all containers..."
    docker stop $(docker ps -aq)
    
    echo "Removing all containers..."
    docker rm $(docker ps -aq)

    echo "Removing all images..."
    docker rmi -f $(docker images -q)
}

# Function to rebuild and start from scratch
rebuild_and_dev() {
    clear_everything
    build_image
    echo "Starting a fresh container instance..."
    docker run -d -p 8081:8080 my-spring-app
    view_running_containers
}

# Menu to select an operation
echo "Select an option:"
echo "1) Build Docker Image"
echo "2) Run Docker Containers"
echo "3) View Running Containers"
echo "4) View All Containers"
echo "5) Clear Everything (Nuke Mode)"
echo "6) Rebuild & Dev"
read -p "Enter your choice (1/2/3/4/5/6): " choice

case $choice in
    1) build_image ;;
    2) run_containers ;;
    3) view_running_containers ;;
    4) view_all_containers ;;
    5) clear_everything ;;
    6) rebuild_and_dev ;;
    *) echo "Invalid choice!" ;;
esac
