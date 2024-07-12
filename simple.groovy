pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
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
