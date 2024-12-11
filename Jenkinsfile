pipeline { 
    agent any
    stages { 
        stage('Checkout') {
            steps { 
                echo 'Checking out code...' 
                git url: 'https://github.com/volhazhukouskaya1/course', branch: 'main'
            }
        }
        stage('Build') { 
            steps { 
                script {
                    echo 'Building...'
                    bat 'mvn clean install' 
                    } 
                }
        } 
        stage('Test') {
            steps { 
                script { 
                    echo 'Testing...'
                    bat 'mvn test' 
                    } 
                    junit '**/target/surefire-reports/*.xml' 
                }
            }
        }
        post { 
            always { 
                echo 'Cleaning up...' 
            } 
            success {
                echo 'Pipeline completed successfully!'
            } 
            failure { 
                echo 'Pipeline failed!' 
            }
        }
}
