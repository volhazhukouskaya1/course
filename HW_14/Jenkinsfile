pipeline { 
    agent any
    stages { 
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
        
