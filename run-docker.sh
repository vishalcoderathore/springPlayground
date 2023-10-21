#!/bin/bash

# Navigate to the directory where the script is located
cd "$(dirname "$0")"

# Check if Docker is running
if ! docker info >/dev/null 2>&1; then
    echo "Docker is not running. Please start Docker first."
    exit 1
fi

# Build and run the Docker Compose setup
docker compose build && docker compose up -d

# Echo out the running services once everything is up
echo "Services running:"
docker compose ps

# Provide the user with the frontend's URL
echo -e "\nAccess the frontend application at http://localhost:3000"
