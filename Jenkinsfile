pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'branch2', url: 'https://github.com/Alison0309/simple-java-maven-app.git'
            }
        }
        stage('Build') {
            steps { bat 'start gradlew build'}
        }
        stage('Test') {
            steps { bat 'start gradlew test'}
        }
        stage('Deploy') {
            steps { bat 'java -jar /target/my-app-1.0-SNAPSHOT.jar'}
        }
    }
    post {
        always {
            echo 'Cleaning up workspace'
            deleteDir() // Clean up the workspace after the build
        }
        success {
            echo 'Build succeeded!!!'
            // You could add notification steps here
        }
        failure {
            echo 'Build failed!'
            // You could add notification steps here
        }
    }
}