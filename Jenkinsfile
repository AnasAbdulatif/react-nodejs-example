#!/usr/bin/env groovy

library identifier: 'jenkins-shared-library@master', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://gitlab.com/AnasAbdulatif/jenkins-shared-library.git',
         credentialsId: 'gitlab-credentials'
        ]
)


def gv

pipeline {
    agent any
    tools {
        nodejs 'nodejs'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build App") {
            steps {
                script {
                    buildApp()
                }
            }
        }
        stage("build and push image") {
            steps {
                script {
                buildImage 'anas99anas/react-nodejs-example:1.0'

                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    deployApp'anas99anas/react-nodejs-example:1.0'
                }
            }
        }
    }
}
