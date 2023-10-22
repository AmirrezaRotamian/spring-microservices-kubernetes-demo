#!/bin/bash

modules=("gateway/gateway-service" "auth/auth-service" "user/user-service" "wallet/wallet-service")
pids=()

# Function to stop services when script is terminated
stop_services() {
    for pid in "${pids[@]}"
    do
        if kill -0 $pid 2>/dev/null; then
            echo "Stopping service with PID $pid..."
            kill $pid
        fi
    done
    echo "Stopped"
    exit 0
}

# Trap Ctrl+C and call stop_services() when that happens
trap stop_services SIGINT

for module in "${modules[@]}"
do
    echo "Starting $module..."
    (cd $module && ./../../.mvn/bin/mvn spring-boot:run &) && pids+=($!)
done

echo "All services started! Press Ctrl+C to stop."

# Wait forever, until Ctrl+C is pressed
while true; do
    sleep 1
done
