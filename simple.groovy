pipeline {
    agent any
    
    environment {
        GIT_CREDENTIALS = credentials('15eaaf77-b157-4c3d-9574-a88faeea5805')
    }
    stages {
        stage('Build') {
            steps {
                git branch: 'main', credentialsId: GIT_CREDENTIALS, url: 'https://github.com/sushanth-777/JS-in-Jenkins-'
                git 'https://github.com/sushanth-777/JS-in-Jenkins-'
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
            archiveArtifacts 'path/to/artifacts'
        }
    }
}
