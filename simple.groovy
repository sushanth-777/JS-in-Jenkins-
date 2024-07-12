pipeline {
    agent any

    environment {
        GIT_CREDENTIALS = credentials('your-credentials-id')
    }

    stages {
        stage('Build') {
            steps {
                git branch: 'main', credentials: GIT_CREDENTIALS, url: 'https://github.com/sushanth-777/JS-in-Jenkins-'
                sh 'npm install'
                sh 'npm run build'
            }
        }

        stage('Test') {
            steps {
                sh 'npm run test'
            }
        }
    }

    post {
        always {
            archiveArtifacts 'path/to/artifacts/**'
        }
    }
}
