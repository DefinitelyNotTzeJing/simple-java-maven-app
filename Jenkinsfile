pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'branch3', url: 'https://github.com/Vanny253/simple-java-maven-app.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'  // This will show test results in Jenkins
                }
            }
        }
        stage('Deliver') {
            steps {
                bat 'jenkins\\scripts\\deliver.bat'
            }
        }
    }
    post {
        always {
            echo 'Cleaning up workspace'
            deleteDir() // Clean up the workspace after the build
        }
        success {
            echo 'Build succeeded!!!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}


