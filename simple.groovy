pipeline {
    agent {
        docker {
            image 'node:14'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    stages {
        // stage('Checkout') {
        //     steps {
        //         // Pull code from GitHub
        //         git branch: 'main', url: 'https://github.com/sushanth-777/JS-in-Jenkins-.git'
        //         // List files to verify the checkout
        //         sh 'ls -al'
        //     }
        // }

        stage('Build') {
            steps {
                echo 'Building the project...'
                git branch: 'main', url: 'https://github.com/sushanth-777/JS-in-Jenkins-.git'
                sh 'ls -al'
                sh 'npm install'
                sh 'npm run build'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'npm run test'
                // If you have tests, include them here
                // For static files, this might be empty
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the project...'
                // Serve the static files using a simple HTTP server
                sh 'docker build -t calculator-js .'
                sh 'docker run -p 8081:80 calculator-js'
            }
        }
    }
}
