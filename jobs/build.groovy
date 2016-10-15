node {
    stage ('checkout') {
        echo 'checkout from git'
        git url: 'git@github.com:qrtt1/JCConf2016_JenkinsPipeline.git'
            branch: 'demo'
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
