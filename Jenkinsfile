pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/khaleelclark/PipelineProject'
            }
        }

       stage('Build with Maven') {
           steps {
               bat 'mvn clean package -DskipTests'
           }
       }

       stage('Run Unit Tests') {
           steps {
               bat 'mvn test'
           }
       }

       stage('Build Docker Image') {
           steps {
               bat 'docker build -t task-manager .'
           }
       }

       stage('Verify Docker Image') {
           steps {
               bat 'docker images | findstr task-manager'
           }
       }

    }
}
