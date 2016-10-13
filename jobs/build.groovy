node {
    stage ('checkout') {
        echo 'checkout from git'
        git url: 'https://qrtt1@bitbucket.org/qrtt1/jenkinskata.git'
            branch: 'master'
    }

    dir ('project') {
        pwd()
        stage ('build') {
            sh """gradle clean build"""
        }
        stage ('test') {
            sh """gradle check"""
        }
        stage ('war') {
            sh """gradle war"""
        }
        stage ('archive') {
            step([$class: 'ArtifactArchiver', artifacts: "build/**/*.war", fingerprint: true])
        }
    }
}
