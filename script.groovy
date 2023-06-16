def buildApp() {
    echo "building the application... ANAS"

} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh ' docker build -t anas99anas/java-maven-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh ' docker push anas99anas/java-maven-app:jma-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
    sh ' docker run --name javamaven anas99anas/java-maven-app:jma-2.0'
    sh ' docker logs javamaven'
} 

return this
