pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Pull code from GitHub
                git branch: 'main', url: 'https://github.com/sushanth-777/JS-in-Jenkins-.git'
                // List files to verify the checkout
                sh 'ls -al'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                // If there's a build step, include it here
                // For static files, this might be empty
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // If you have tests, include them here
                // For static files, this might be empty
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the project...'
                // Serve the static files using a simple HTTP server
                sh '''
                    python3 -m http.server 1234 &
                    while ! curl -s http://localhost:1234; do
                        echo "Waiting for server to start..."
                        sleep 1
                    done
                    echo "Deployment successful, application is running"
                '''
            }
        }
    }
}
