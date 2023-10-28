#!/bin/bash

# Function to build and run the Docker Compose setup
restart_app() {
    echo "Restarting the app..."
    # Stop and remove all containers
    docker compose down
    # Remove all images related to the app
    docker rmi -f $(docker images | grep 'springplayground-backend\|springplayground-frontend' | awk '{print $3}')
    # Build and run the Docker Compose setup
    ./run-docker.sh
}

# Function to nuke everything (delete all containers and images)
nuke_mode() {
    echo "Nuking everything..."
    # Stop and remove all containers
    docker compose down
    # Remove all images
    docker rmi -f $(docker images -q)
    echo "Nuke mode complete."
}

# Menu to select an operation
echo "Select an operation:"
echo "1) Restart the App"
echo "2) Nuke Mode (Delete Everything)"
read -p "Enter your choice (1/2): " choice

case $choice in
1) restart_app ;;
2) nuke_mode ;;
*) echo "Invalid choice!" ;;
esac
